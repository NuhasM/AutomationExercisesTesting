package com.qa.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.automationexercise.base.SkeletonTest;
import com.qa.automationexercises.utils.ExcelUtilities;

public class RegistrationPageTests extends SkeletonTest {

	@BeforeMethod
	public void setupRegister() {
		lp = hp.clickLoginButton();
	}

	@DataProvider
	public Object[][] formData() {
		return ExcelUtilities.getTestData("registration");
	}

	@Test(dataProvider = "formData") // all registrants in US, hardcoded value
	public void fillFormsTest(String name, String email, String title, String password, String day, String month,
			String year, String firstName, String lastName, String company, String address, String address2,
			String state, String city, String zip, String phNumber) {

		rp = lp.fillLoginSignupFields(name, email);
		rp.topFormFill(title, password, day, month, year);
		rp.bottomFormFill("United States", firstName, lastName, company, address, address2, state, city, zip, phNumber);
		rp.clickRegister();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/account_created");
		rp.postRegContinue();
		hp.clickLogoutButton();
	}

}
