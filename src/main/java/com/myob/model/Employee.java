package com.myob.model;

/***
 * @author- Alekhya Ejjina
 * @created- 2 June 2019 
 ***/

public class Employee {

	private String firstName;
	private String lastName;
	private int salary;
	private int grossMonthlyIncome;
	private int netMonthlyIncome;
	private int incomeTax;
	private int superAnnuation;
	private int superAnnuationRate;
	private String payMonth;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getGrossMonthlyIncome() {
		return grossMonthlyIncome;
	}
	public void setGrossMonthlyIncome(int grossMonthlyIncome) {
		this.grossMonthlyIncome = grossMonthlyIncome;
	}
	public int getNetMonthlyIncome() {
		return netMonthlyIncome;
	}
	public void setNetMonthlyIncome(int netMonthlyIncome) {
		this.netMonthlyIncome = netMonthlyIncome;
	}
	public int getIncomeTax() {
		return incomeTax;
	}
	public void setIncomeTax(int incomeTax) {
		this.incomeTax = incomeTax;
	}
	public int getSuperAnnuationRate() {
		return superAnnuationRate;
	}
	public void setSuperAnnuationRate(int superAnnuation) {
		this.superAnnuationRate = superAnnuation;
	}
	public String getPayMonth() {
		return payMonth;
	}
	public void setPayMonth(String month) {
		this.payMonth = month;
	}
	public int getSuperAnnuation() {
		return superAnnuation;
	}
	public void setSuperAnnuation(int superAnnuation) {
		this.superAnnuation = superAnnuation;
	}
	
}
