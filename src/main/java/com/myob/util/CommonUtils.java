package com.myob.util;

import org.apache.log4j.Logger;

/***
 * @author- Alekhya Ejjina
 * @created- 2 June 2019 
 ***/

public class CommonUtils {

	public static final Logger log4j = Logger.getLogger(CommonUtils.class);
	
	/* Below are the income tax rates for 2017-18 effective from 1 July 2017.
	 * Need to change the numbers if there are any amendments in the future
	 * 
	 *  Taxable Income			Tax applicable
	 *  0 - $18,200 			Nil
	 *  $18,201 - $37,000		19c for each $1 over $18,200
	 *  $37,001 - $87,000		$3572 + 32.5c for each $1 over $37,000 
	 *  $87,001 - 180,000		$19,822 + 37c for each $1 over $87,000
	 *  $180,001 and over		$54,232 + 45c for each $1 over 180,000
	 *  
	 *  */
	public static int calculateIncomeTax(int annualSalary) {
		log4j.debug("In calculateIncomeTax : salary - " + annualSalary);
		double incomeTax = 0;
		
		if(annualSalary > 18200 && annualSalary <= 37000) {
			incomeTax = (annualSalary - 18200) * 0.19;
		} else if(annualSalary > 37000 && annualSalary <= 87000) {
			incomeTax = 3572 + (annualSalary - 37000) * 0.325;
		} else if(annualSalary > 87000 && annualSalary <= 180000) {
			incomeTax = 19822 + (annualSalary - 87000) * 0.37;
		} else if(annualSalary > 180000) {
			incomeTax = 54232 + (annualSalary - 180000) * 0.45;
		}
		//Monthly Tax
		incomeTax = Math.round(incomeTax / 12);
		
		log4j.debug("Calculated Income tax : " + incomeTax);
		return (int)incomeTax;
	}
	
	public static boolean isValidFileFormat(String inputFile) {
		log4j.debug("in isValidInputFile method");
		
		String extension = null;
		int i = inputFile.lastIndexOf(".");
		if (i > 0) {
		    extension = inputFile.substring(i+1);
		} else {
			return false;
		}
		
		if("csv".equalsIgnoreCase(extension)) {
			return true;
		} else {
			return false;
		}
	}
}
