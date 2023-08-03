package com.qa.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.automationexercises.utils.WebElementUtilities;

public class LoggedInHomePage {

	private WebDriver driver;
	private WebElementUtilities webUtil;

	private By deleteBtn = By.linkText("Delete Account");
	private By logoutBtn = By.linkText("Logout");

	public LoggedInHomePage(WebDriver driver) {
		this.driver = driver;
		webUtil = new WebElementUtilities(driver);
	}

	public boolean verifyLoggedIn() {
		webUtil.waitForElementPresent(deleteBtn);
		WebElement delete = webUtil.getElement(deleteBtn);
		WebElement logout = webUtil.getElement(logoutBtn);
		if (delete.isDisplayed() && logout.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public LoginPage clickLogoutButton() {
		WebElement button = webUtil.getElement(logoutBtn);
		button.click();
		return new LoginPage(driver);
	}

	public HomePage clickDeleteAccount() {
		WebElement button = webUtil.getElement(deleteBtn);
		button.click();
		return new HomePage(driver);
	}

}
