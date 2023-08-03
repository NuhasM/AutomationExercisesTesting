package com.qa.automationexercise.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.automationexercise.pages.HomePage;
import com.qa.automationexercise.pages.LoggedInHomePage;
import com.qa.automationexercise.pages.LoginPage;
import com.qa.automationexercise.pages.RegistrationPage;
import com.qa.automationexercises.factory.DriverFactory;

public class SkeletonTest {
	public WebDriver driver;
	public Properties prop;
	public DriverFactory df;

	protected HomePage hp;
	protected LoginPage lp;
	protected RegistrationPage rp;
	protected LoggedInHomePage lhp;

	@BeforeTest
	public void setupTests() {
		df = new DriverFactory();
		prop = df.configSetup();
		driver = df.driverSetup(prop);
		hp = new HomePage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
