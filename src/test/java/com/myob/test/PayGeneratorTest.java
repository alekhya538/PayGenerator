package com.myob.test;

import static org.junit.Assert.*;
import org.junit.*;
import com.myob.util.CommonUtils;

public class PayGeneratorTest {

	@Test
	public void testFileFormatValidation() {
		assertTrue(CommonUtils.isValidFileFormat("C:/myob-test/PayGenerator/input/employeeList.csv"));
	}
	
	@Test
	public void testIncomeTax() {
		assertEquals(922,CommonUtils.calculateIncomeTax(60050));
		assertEquals(2669,CommonUtils.calculateIncomeTax(120000));
	}
	
}
