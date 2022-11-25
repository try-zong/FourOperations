package com.example.demo.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Nums;



@Controller
public class calculateController {
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/calculate")
	@ResponseBody
	public 	String test( @RequestBody @Validated Nums nums,BindingResult rs) {
		String result  ="输入不正确,请重新输入!";
		if(rs.hasErrors()) {
			
			return result;
		}
		BigDecimal num1=new BigDecimal(nums.getNum1());
		BigDecimal num2=new BigDecimal(nums.getNum2());
		String operator = nums.getOperator();
		BigDecimal re = BigDecimal.ZERO;
		switch(operator){
        case "+":
            re = num1.add(num2);
            break;
        case "-":
        	re = num1.subtract(num2);
            break;
        case "*":
        	re = num1.multiply(num2);
            break;
        case "/":
            try{
                if(num2.compareTo(BigDecimal.ZERO)!=0){
                    re = num1.divide(num2,10,RoundingMode.HALF_UP);
                }else{
                	result ="除数不能为0，请重新输入！";
                    return result;
                }}catch(Exception e){
                    e.printStackTrace();
                }
                break;
         }
		result =String.valueOf(re);
		return result;
	}
}
