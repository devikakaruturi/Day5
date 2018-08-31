package com.capgemini.day5.domain;

import com.capgemini.day5.exception.CountryNotValidException;
import com.capgemini.day5.exception.EmployeeNameInvalidException;
import com.capgemini.day5.exception.TaxNotEligibleException;

public class TaxCalculator {
	
	public static double calculateTax(String empName,boolean isindian,double empSal) throws EmployeeNameInvalidException, TaxNotEligibleException, CountryNotValidException 
	{
		double taxAmount=0;
		if(isindian == true)
		{
			if(empSal > 100000 )
			{
				taxAmount=empSal *8/100 ;
				System.out.println("Tax Amount:"+taxAmount);
			}
			else if(empSal>50000 && empSal<100000)
			{
				taxAmount =empSal *6/100; 
				System.out.println("Tax Amount:"+taxAmount);
			}
			else if(empSal>30000 && empSal<50000)
			{
				taxAmount =empSal *5/100; 
				System.out.println("Tax Amount:"+taxAmount);
			}
			else if(empSal>10000 && empSal<30000)
			{
				taxAmount =empSal *4/100; 
				System.out.println("Tax Amount:"+taxAmount);
			}
			else if(empName =="" || empName==null)
			{
				throw new EmployeeNameInvalidException("Employee name cannot be empty");
			}
			else if(empSal < 10000)
			{
				throw new TaxNotEligibleException("Employee does not need to pay the tax");
			}
		}
		else
		{
			throw new CountryNotValidException("The employee should be an indian citizen for calculating tax");
		}
		return taxAmount;
	}
	
	
}
