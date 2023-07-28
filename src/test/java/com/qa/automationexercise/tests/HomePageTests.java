package com.qa.automationexercise.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.automationexercise.base.SkeletonTest;
import com.qa.automationexercises.constants.Constants;

public class HomePageTests extends SkeletonTest {

	@Test
	public void logoTest() {
		String logoText = hp.getLogoText();
		Assert.assertEquals(logoText, Constants.AMEXERCISES_LOGO_TEXT);
		System.out.println("If you see this message, logo verification has passed.");
	}
	
	@Test
	public void headerTest() {
		List<String> headerText = hp.getHeaderOptions();
		Assert.assertTrue(headerText.containsAll(Constants.AMEXERCISES_HEADER_TEXT));
		System.out.println("If you see this message, header verification has passed.");
	}
	
	@Test(priority = 1)
	public void loginPageTest() {
		lp = hp.clickLoginButton();
		Assert.assertTrue(driver.getCurrentUrl().equals("https://automationexercise.com/login"));
		System.out.println("If you see this message, you have successfully navigated to the login/registration page.");
	}

}
