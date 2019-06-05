package com.myob.util;

/***
 * @author- Alekhya Ejjina
 * @created- 2 June 2019
 * Application Constants
 ***/

public class PayConstants {

	public static final String welcomeMessage = "Welcome to MYOB Payroll System";
	
	public static final String ERROR_FILE_NOT_FOUND = "Input file not found. Please check the path specified.";
	
	public static final String ERROR_UNSUPPORTED_FORMAT = "Invalid file format. Please upload a valid CSV file (*.csv)";
	
	public static final String OUTPUT_FILE = "C:/dev/myob/PayGenerator/output/empPayDetails_";
	
	public static final String[] OUTPUT_FILE_HEADER = {"name","pay","period","gross income","income tax","net income","super"};
	
	public static final String INPUT_FILE_FIRST_NAME = "first name";
	
	public static final String CSV_EXTENSION = ".csv";
	
}
