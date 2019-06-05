package com.myob.service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.myob.model.Employee;
import com.myob.util.CommonUtils;
import com.myob.util.PayConstants;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

/***
 * @author- Alekhya Ejjina
 * @created- 2 June 2019
 * Service Class 
 ***/

public class PayService {
	
	public static Logger log4j = Logger.getLogger(PayService.class);
	
	public List<Employee> empPayDetails;
	
	/* All Calculations for employee income are done in this method */
	public List<Employee> generatePayDetails(String inputFile) {
			log4j.debug("Entered generatePayslips method");
		
			try {
				empPayDetails = new ArrayList<Employee>();
				CSVReader csvReader = new CSVReader(new FileReader(inputFile));
				// Reading Records One by One in a String array
	            String[] nextRecord;
				while ((nextRecord = csvReader.readNext()) != null) {
					//Skip the header
					if(Arrays.asList(nextRecord).contains(PayConstants.INPUT_FILE_FIRST_NAME)) {
						continue;
					}
					
					//Create Employee model object
					Employee emp = new Employee();
					emp.setFirstName(nextRecord[0]);
					emp.setLastName(nextRecord[1]);
					emp.setSalary(Integer.parseInt(nextRecord[2]));
					emp.setSuperAnnuationRate(Integer.parseInt(nextRecord[3].replaceAll("%", "")));
					emp.setPayMonth(nextRecord[4]);
					
					/* Calculation 1 : Gross Monthly Income is Annual Salary divided by 12 */
					int grossMonthly = emp.getSalary()/12;
					emp.setGrossMonthlyIncome(grossMonthly);
					
					/* Calculation 2 : Monthly Income Tax */
					int incomeTax = CommonUtils.calculateIncomeTax(emp.getSalary());
					emp.setIncomeTax(incomeTax);
					
					/* Calculation 3 : Net Income = Gross Income - Income tax */
					emp.setNetMonthlyIncome(grossMonthly - incomeTax);
					
					/* Calculation 4 : Super = Gross Income * super rate(%) */
					int superRate = Math.round(grossMonthly * emp.getSuperAnnuationRate() / 100);
					emp.setSuperAnnuation(superRate);
					
					//Add to the final list
					empPayDetails.add(emp);
			    }
			} catch(IOException ie) {
				log4j.error("An IOException occurred in PayService class - "+ie.getMessage());
			}
			
		//Create Output CSV		writeToCSV(empPayDetails);
		
		return empPayDetails;
	}
	
	/* Using OpenCSV library, this method creates a new csv file and writes all data to it. */
	public void writeToCSV(List<Employee> empPayDetails) {
		File outputFile = new File(PayConstants.OUTPUT_FILE + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + PayConstants.CSV_EXTENSION);
		
		try { 
	        // create FileWriter object with file as parameter 
	        FileWriter outputfile = new FileWriter(outputFile); 
	  
	        // create CSVWriter object filewriter object as parameter 
	        CSVWriter writer = new CSVWriter(outputfile); 
	        writer.writeNext(PayConstants.OUTPUT_FILE_HEADER);
	        
	        //Iterating on employee details list and creating List of String Arrays (for OpenCSV)
	        Iterator itr = empPayDetails.iterator();
	        List<String[]> outputList = new ArrayList<String[]>();
	        while(itr.hasNext()) {
	        	Employee emp = (Employee) itr.next();
	        	outputList.add(new String[]{emp.getFirstName()+" "+emp.getLastName(), emp.getPayMonth(), emp.getGrossMonthlyIncome()+"",
	        			                    emp.getIncomeTax()+"", emp.getNetMonthlyIncome()+"", emp.getSuperAnnuation()+""});
	        }	        
	        //Write all data to Output file
	        writer.writeAll(outputList);
	        
	        // closing writer connection 
	        writer.close(); 
	    } 
	    catch (IOException e) { 
	        log4j.error("An IO exception occurred while generating output csv - " + e.getMessage());
	    } 
		
	}

}
