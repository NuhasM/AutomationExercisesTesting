package com.qa.automationexercise.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.automationexercises.utils.WebElementUtilities;

public class HomePage {
	private WebDriver driver;
	private WebElementUtilities webUtil;

	// private by's
	private By logo = By.xpath("//div/a/img[@alt='Website for automation practice']");
	private By headerOptions = By.cssSelector(".nav.navbar-nav li");
	private By signupLoginBtn = By.linkText("Signup / Login");
	private By productsBtn = By.linkText(" Products");
	private By contactUsBtn = By.linkText(" Contact us");
	private By testCaseBtn = By.linkText(" Test Cases");

	// constructor (public, needs driver, sets up utils, )
	public HomePage(WebDriver driver) {
		this.driver = driver;
		webUtil = new WebElementUtilities(driver);
	}

	// methods
	public String getLogoText() {
		WebElement eleLogo = webUtil.getElement(logo);
		String strLogoText = eleLogo.getAttribute("alt");
		return strLogoText;
	}
	
	public List<String> getHeaderOptions() {
		List<WebElement> headerList = new ArrayList<>();
		headerList = webUtil.getElements(headerOptions);
		List<String> strHeaderList = new ArrayList<>();
		for(WebElement e : headerList) {
			strHeaderList.add(e.getText().trim());
		}
		return strHeaderList;
	}
	
	public LoginPage clickLoginButton() {
		WebElement button = webUtil.getElement(signupLoginBtn);
		button.click();
		return new LoginPage(driver);
	}

}
