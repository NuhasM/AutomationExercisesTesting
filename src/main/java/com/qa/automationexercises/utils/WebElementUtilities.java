package com.qa.automationexercises.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.automationexercises.constants.Constants;

public class WebElementUtilities {
	private WebDriver driver;
	private Select objSelect;
	private WebDriverWait wait;

	public WebElementUtilities(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Constants.DEFAULT_TIMEOUT);
	}

	public WebElement getElement(By locator) {
		return locator.findElement(driver);
	}

	public List<WebElement> getElements(By locator) {
		return locator.findElements(driver);
	}

	public String getElementAsString(By locator) {
		return getElement(locator).getText();
	}

	public List<String> getElementsAsString(By locator) {
		List<WebElement> tempElements = getElements(locator);
		List<String> listAsStrings = new ArrayList<>();
		for (WebElement e : tempElements) {
			listAsStrings.add(e.getText());
		}
		return listAsStrings;
	}

	public boolean waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	/***************************************************
	 * SELECT UTILITIES
	 *****************************/

	public void selectWithValue(WebElement element, String value) {
		objSelect = new Select(element);
		objSelect.selectByValue(value);
	}

	public void selectWithIndex(WebElement element, int index) {
		objSelect = new Select(element);
		objSelect.selectByIndex(index);
	}

	public void selectWithText(WebElement element, String text) {
		objSelect = new Select(element);
		objSelect.selectByVisibleText(text);
	}

	public List<String> selectAllOptions(WebElement element) {
		objSelect = new Select(element);
		List<WebElement> optionsList = objSelect.getOptions();
		List<String> strOptionsList = new ArrayList<>();
		for (WebElement e : optionsList) {
			strOptionsList.add(e.getText());
		}
		return strOptionsList;
	}

}
