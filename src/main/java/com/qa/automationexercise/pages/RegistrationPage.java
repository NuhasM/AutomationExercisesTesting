package com.qa.automationexercise.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	private By addressInfoFields = By.xpath("//div//p[contains(@class, 'form-group')]/input"); // 9 fields,
																								// excelsheet+dataprovider
	private By countrySelect = By.id("country");
	private By createAccountBtn = By.xpath("//button[@data-qa='create-account']");
	private By regConfirm = By.cssSelector(".btn.btn-primary");

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		webUtil = new WebElementUtilities(driver);
	}

	// make separate formfill with newsletter and offers
	public void topFormFill(String title, String pwText, String day, String month, String year) {
		List<WebElement> eleTitle = webUtil.getElements(titleSelection);
		switch (title.toLowerCase().trim()) {
		case "mr":
		case "mr.": {
			eleTitle.get(0).click();
			break;
		}
		case "ms":
		case "ms.": {
			eleTitle.get(1).click();
			break;
		}
		default:
			System.out.println("Please enter mr or ms, thank you.");
		}

//		double dayDouble = Double.parseDouble(day);
//		int dayInt = (int) dayDouble;
//		double yearDouble = Double.parseDouble(year);
//		int yearInt = (int) yearDouble;

		WebElement eleDay = webUtil.getElement(daySelect);
		WebElement eleMonth = webUtil.getElement(monthSelect);
		WebElement eleYear = webUtil.getElement(yearSelect);
		webUtil.getElement(password).sendKeys(pwText);
		webUtil.selectWithValue(eleDay, day);
		webUtil.selectWithText(eleMonth, month);
		webUtil.selectWithValue(eleYear, year);
	}

	// values takes 9 arguments, first name, last name, company, address, address2,
	// state,
	// city, zip, phone number
	public void bottomFormFill(String country, String... values) {
		webUtil.selectWithText(webUtil.getElement(countrySelect), country);

		List<WebElement> eleAddressFields = webUtil.getElements(addressInfoFields);
		for (int i = 0; i < eleAddressFields.size(); i++) {
			eleAddressFields.get(i).sendKeys(values[i]);
		}
	}

	public void clickRegister() {
		webUtil.getElement(createAccountBtn).click();
	}

	public LoggedInHomePage postRegContinue() {
		webUtil.getElement(regConfirm).click();
		return new LoggedInHomePage(driver);
	}
}
