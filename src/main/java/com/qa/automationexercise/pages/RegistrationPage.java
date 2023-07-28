package com.qa.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.automationexercises.utils.WebElementUtilities;

public class RegistrationPage {

	private WebDriver driver;
	private WebElementUtilities webUtil;

	private By titleSelection = By.xpath("//div/span/input[contains(@id, 'id_gender')]"); // 0th index Mr, 1st index Mrs
	private By name = By.id("name"); // already filled from prior form
	private By email = By.id("email"); // already filled from prior form
	private By password = By.id("password");
	private By daySelect = By.id("days");
	private By monthSelect = By.id("months");
	private By yearSelect = By.id("years");
	private By newsletterBox = By.id("newsletter");
	private By offersBox = By.id("optin");
	private By addressInfoFields = By.xpath("//div//p[contains(@class, 'form-group')]/input"); // 9 fields, excelsheet+dataprovider
	private By countrySelect = By.id("country");
	private By createAccountBtn = By.linkText("Create Account");

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		webUtil = new WebElementUtilities(driver);
	}
	
	// change name later, forms that are not address related - make a SelectUtility later
	public void topFormFill(String... stringValue) {
		webUtil.getElement(password).sendKeys(stringValue[0]);
		WebElement eleDay = webUtil.getElement(daySelect);
		WebElement eleMonth = webUtil.getElement(yearSelect);
		WebElement eleYear = webUtil.getElement(monthSelect);
		Select daySelect = new Select(eleDay);
		daySelect.selectByValue(stringValue[1]);
		Select monthSelect = new Select(eleMonth);
		monthSelect.selectByValue(stringValue[2]);
		Select yearSelect = new Select(eleYear);
		yearSelect.selectByValue(stringValue[3]);
	}

}
