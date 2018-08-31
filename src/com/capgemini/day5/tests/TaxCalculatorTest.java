package com.capgemini.day5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.capgemini.day5.domain.MyCalculator1;
import com.capgemini.day5.domain.TaxCalculator;
import com.capgemini.day5.exception.CountryNotValidException;
import com.capgemini.day5.exception.EmployeeNameInvalidException;
import com.capgemini.day5.exception.TaxNotEligibleException;

class TaxCalculatorTest
{

	@Test
	void testCountryNotValidException() {
		Exception e;
		e=assertThrows(Exception.class,() -> TaxCalculator.calculateTax("Ron",false,340000));
		assertEquals("The employee should be an indian citizen for calculating tax", e.getMessage());
	}
	@Test
	void testCalculateTaxWithIneligible()
	{
		Exception e;
		e=assertThrows(Exception.class,() -> TaxCalculator.calculateTax("Tim",true,1000));
		assertEquals("Employee does not need to pay the tax", e.getMessage());
	}
	@Test
	void testCalculateTaxWithValidInputs() throws EmployeeNameInvalidException, TaxNotEligibleException, CountryNotValidException
	{
		assertEquals(3300,TaxCalculator.calculateTax("Jack",true,55000));
	}
	@Test
	void testCalculateInvalidName()
	{
		Exception e;
		e=assertThrows(Exception.class,() -> TaxCalculator.calculateTax("",true,30000));
		assertEquals("Employee name cannot be empty", e.getMessage());
	}

}
