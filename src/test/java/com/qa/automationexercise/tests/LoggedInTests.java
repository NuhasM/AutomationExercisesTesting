package com.qa.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.automationexercise.base.SkeletonTest;

public class LoggedInTests extends SkeletonTest {

	@BeforeTest
	public void setupLogin() {
		lp = hp.clickLoginButton();
		lhp = lp.positiveLoginAsUser(prop.getProperty("dummyEmail"), prop.getProperty("dummyPassword"));
	}

	@Test
	public void loginVerifiedTest() {
		Assert.assertEquals(lhp.verifyLoggedIn(), true);
	}

}
