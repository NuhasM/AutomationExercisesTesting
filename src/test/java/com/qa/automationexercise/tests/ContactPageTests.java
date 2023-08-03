package com.qa.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.automationexercise.base.SkeletonTest;

public class ContactPageTests extends SkeletonTest {

	@BeforeTest
	public void navigateToContact() {
		cp = hp.navigateToContactUs();
	}

	@Test
	public void verifyContactElements() {
		Assert.assertTrue(cp.contactPageElementVerification());
	}

}
