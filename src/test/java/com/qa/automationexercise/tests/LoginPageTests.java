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

	@Test(priority = 0)
	public void loginPageTest() {
		List<String> pageFormText = lp.loginPageVerification();
		Assert.assertTrue(pageFormText.containsAll(Constants.AMEXERCISES_LOGIN_TEXT));
	}

	@Test(priority = 100)
	public void signupButtonTest() {
		lp.fillLoginSignupFields("Name Here", "EmailHere@email.com");
		Assert.assertTrue(driver.getCurrentUrl().equals("https://automationexercise.com/signup"));
	}

	@Test(priority = 2)
	public void negativeLoginTest() {
		boolean login = lp.negativeLoginAsUser("IncorrectEmail@123.com", "IncorrectPassword"); // hardcoded wrong values
		Assert.assertEquals(login, true);
	}

}
