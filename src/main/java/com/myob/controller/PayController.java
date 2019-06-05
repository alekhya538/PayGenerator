package com.myob.controller;

/***
 * @author- Alekhya Ejjina
 * @created- 31 May 2019
 * 
 * Controller that handles incoming requests based on URL pattern
 ***/

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.myob.model.Employee;
import com.myob.service.PayService;

@Controller
public class PayController {	
	public static Logger log4j = Logger.getLogger(PayController.class);
	
	@Autowired
	public PayService payService;
		 
	@RequestMapping("/generatePayslips")
	public ModelAndView readEmployeeDetailsFromCSV(@RequestParam(value = "inputFile", required = true) String inputFile) {
		log4j.debug("Enter PayController - readEmployeeDetailsFromCSV method");
		
		//calculate employee pay details
		List<Employee> employeeList = payService.generatePayDetails(inputFile);
	
		//Target view to show pay details - showPayDetails.jsp
		ModelAndView mv = new ModelAndView("showPayDetails");
		mv.addObject("employeeList", employeeList);
		return mv;
	}
}

