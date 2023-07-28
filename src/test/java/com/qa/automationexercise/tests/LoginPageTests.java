package com.qa.automationexercise.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.automationexercise.base.SkeletonTest;
import com.qa.automationexercises.constants.Constants;

public class LoginPageTests extends SkeletonTest {
	
	@BeforeClass
	public void loginPageStart() {
		lp = hp.clickLoginButton();
	}

	@Test
	public void loginPageTest() {
		List<String> pageFormText = lp.loginPageVerification();
		Assert.assertTrue(pageFormText.containsAll(Constants.AMEXERCISES_LOGIN_TEXT));
	}
	
	@Test
	public void signupButtonTest() {
		lp.fillLoginSignupFields("Name Here", "EmailHere@email.com");
		lp.clickSignupButton();
		Assert.assertTrue(driver.getCurrentUrl().equals("https://automationexercise.com/signup"));
	}

}
