package com.qa.automationexercise.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.automationexercise.base.SkeletonTest;
import com.qa.automationexercises.constants.Constants;

public class HomePageTests extends SkeletonTest {

//	@BeforeMethod // Not sure if this is needed, might want to go back to homepage before methods eventually
//	public void refreshHomePage() {
//		driver.navigate().to(prop.getProperty("url"));
//	}

	@Test
	public void logoPresenceTest() {
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
	public void gotoLoginPageTest() {
		lp = hp.clickLoginButton();
		Assert.assertTrue(driver.getCurrentUrl().equals("https://automationexercise.com/login"));
		System.out.println("If you see this message, you have successfully navigated to the login/registration page.");
	}

	@Test(priority = 2)
	public void positiveLoginTest() {
		lhp = lp.positiveLoginAsUser(prop.getProperty("dummyEmail"), prop.getProperty("dummyPassword"));
		Assert.assertEquals(lhp.verifyLoggedIn(), true);
		System.out.println("You are logged in");
	}

	@Test
	public void navigateToContactTest() {
		hp.navigateToContactUs();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/contact_us");
		System.out.println("You are on Contact Us page");
	}

}
