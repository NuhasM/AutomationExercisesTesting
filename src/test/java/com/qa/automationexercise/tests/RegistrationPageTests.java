package com.qa.automationexercise.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.automationexercise.base.SkeletonTest;

public class RegistrationPageTests extends SkeletonTest {

	@BeforeClass
	public void setupRegister() {
		lp = hp.clickLoginButton();
	}

	@Test(priority = 0) // topFormFill will not need name because name will be pre-entered from
						// LoginSignupFields
	public void fillTopFormsTest() {
		lp.fillLoginSignupFields("namehere", "amsdnajs@gmail.com");
		rp = lp.clickSignupButton();
		rp.topFormFill("mr", "hydra", "password", "June", "1988", 27);
	}

	@Test(priority = 1)
	public void fillBottomFormsTest() {
		rp.bottomFormFill("United States", "Hydra", "Lol", "Thors", "Random Street 123", "Fl 3", "NY", "Trista",
				"11001", "123-456-7890");
	}

}
