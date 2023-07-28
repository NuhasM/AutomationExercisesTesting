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
	private By loginBtn = By.linkText("Login");
	private By signupBtn = By.xpath("//div/form[@action='/signup']/button");
	private By signUpForms = By.xpath("//div/form[@action='/signup']/input[contains(@data-qa, 'signup')]");

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

	// method that fills signup form (signup form has two fields)
	public void fillLoginSignupFields(String... fieldValues) {
		List<WebElement> signupFields = webUtil.getElements(signUpForms);

		if (fieldValues.length != signupFields.size()) {
			throw new IllegalArgumentException("Values do not match fields in form.");
		} else {
			for (int i = 0; i < signupFields.size(); i++) {
				signupFields.get(i).sendKeys(fieldValues[i]);
			}
		}
	}

	// method that clicks on signup button
	public RegistrationPage clickSignupButton() {
		webUtil.getElement(signupBtn).click();
		return new RegistrationPage(driver);
	}

}
