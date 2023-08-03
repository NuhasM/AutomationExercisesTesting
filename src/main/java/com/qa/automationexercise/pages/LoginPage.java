package com.qa.automationexercise.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.automationexercises.utils.WebElementUtilities;

public class LoginPage {

	private WebDriver driver;
	private WebElementUtilities webUtil;

	private By loginForm = By.xpath("//div[@class='login-form']/h2");
	private By signupForm = By.xpath("//div[@class='signup-form']/h2");
	private By loginBtn = By.xpath("//button[@data-qa='login-button']");
	private By signupBtn = By.xpath("//div/form[@action='/signup']/button");
	private By signupFields = By.xpath("//div/form[@action='/signup']/input[contains(@data-qa, 'signup')]");
	private By loginFields = By.xpath("//form[@action='/login']/input[contains(@data-qa, 'login')]");
	private By incorrectLoginText = By.xpath("//p[contains(text(), 'incorrect')]");
	private By userExists = By.xpath("//div/form/p[contains(text(), 'already exist')]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		webUtil = new WebElementUtilities(driver);
	}

	// method that gets form header text and returns it as arraylist
	public List<String> loginPageVerification() {
		String strLogin = webUtil.getElementAsString(loginForm);
		String strSignup = webUtil.getElementAsString(signupForm);
		List<String> loginPageForms = Arrays.asList(strLogin, strSignup);
		return loginPageForms;
	}

	// method that fills signup form (signup form has two fields) and clicks on sign
	// up
	public RegistrationPage fillLoginSignupFields(String... fieldValues) {
		List<WebElement> ele_signupFields = webUtil.getElements(signupFields);

		if (fieldValues.length != ele_signupFields.size()) {
			throw new IllegalArgumentException("Values do not match fields in form.");
		} else {
			for (int i = 0; i < ele_signupFields.size(); i++) {
				ele_signupFields.get(i).sendKeys(fieldValues[i]);
			}
		}
		webUtil.getElement(signupBtn).click();
		return new RegistrationPage(driver);

	}

	// method that fills signup form with already created user
	public boolean negativeSignupFields(String... fieldValues) {
		List<WebElement> ele_signupFields = webUtil.getElements(signupFields);

		if (fieldValues.length != ele_signupFields.size()) {
			throw new IllegalArgumentException("Values do not match fields in form.");
		} else {
			for (int i = 0; i < ele_signupFields.size(); i++) {
				ele_signupFields.get(i).sendKeys(fieldValues[i]);
			}
		}
		webUtil.getElement(signupBtn).click();
		return webUtil.waitForElementPresent(userExists);
	}

	public boolean negativeLoginAsUser(String... fieldValues) {
		List<WebElement> ele_loginFields = webUtil.getElements(loginFields);
		if (fieldValues.length != ele_loginFields.size()) {
			System.out.println("Please pass the right arguments.");
		} else {
			for (int i = 0; i < fieldValues.length; i++) {
				ele_loginFields.get(i).sendKeys(fieldValues[i]);
			}
		}
		webUtil.getElement(loginBtn).click();
//		WebElement ele_incorrect = webUtil.getElement(incorrectLoginText); // might need a wait
		return webUtil.waitForElementPresent(incorrectLoginText);
	}

	public LoggedInHomePage positiveLoginAsUser(String... fieldValues) {
		List<WebElement> ele_loginFields = webUtil.getElements(loginFields);
		if (fieldValues.length != ele_loginFields.size()) {
			System.out.println("Please pass the right arguments.");
		} else {
			for (int i = 0; i < fieldValues.length; i++) {
				ele_loginFields.get(i).sendKeys(fieldValues[i]);
			}
		}
		webUtil.getElement(loginBtn).click();
		return new LoggedInHomePage(driver);
	}

}
