package com.example.demo.model;

import javax.validation.constraints.Digits;

public class Nums {
	@Digits(integer=10,fraction=10)
	private String num1;
	private String operator;
	@Digits(integer=10,fraction=10)
	private String num2;
	
	public String getNum1() {
		return num1;
	}
	public void setNum1(String num1) {
		this.num1 = num1;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getNum2() {
		return num2;
	}
	public void setNum2(String num2) {
		this.num2 = num2;
	}
}
