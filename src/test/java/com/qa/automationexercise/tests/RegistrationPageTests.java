package com.qa.automationexercise.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.automationexercise.base.SkeletonTest;
import com.qa.automationexercises.utils.ExcelUtilities;

public class RegistrationPageTests extends SkeletonTest {

	@BeforeClass
	public void setupRegister() {
		lp = hp.clickLoginButton();
	}

//	@DataProvider
//	public Object[][] topFormData() {
//		return ExcelUtilities.getTestData("topform");
//	}
//
//	@DataProvider
//	public Object[][] bottomFormData() {
//		return ExcelUtilities.getTestData("bottomform");
//	}

	@Test(priority = 0)
	public void fillTopFormsTest(String... strings) {
		lp.fillLoginSignupFields("Rean", "yadayada@gmail.com");
		rp = lp.clickSignupButton();
		rp.topFormFill("mr", "hydra", "password", "June", "1988", "27");
	}

	@Test(priority = 1)
	public void fillBottomFormsTest(String... strings) {
		rp.bottomFormFill("United States", "Hydra", "Lol", "Thors", "Random Street 123", "Fl 3", "NY", "Trista",
				"11001", "123-456-7890");
	}

}
