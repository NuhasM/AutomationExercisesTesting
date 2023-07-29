package com.qa.automationexercise.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.automationexercise.base.SkeletonTest;

public class RegistrationPageTests extends SkeletonTest {

	@BeforeClass
	public void setupRegister() {
		lp = hp.clickLoginButton();
	}

	@Test
	public void fillTopFormsTest() {
		lp.fillLoginSignupFields("namehere", "amsdnajs@gmail.com");
		rp = lp.clickSignupButton();
		rp.topFormFill("password", "June", "1988", 27);
	}
	
	//bottom form please

}
