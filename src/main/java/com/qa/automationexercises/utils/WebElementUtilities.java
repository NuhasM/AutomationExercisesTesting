package com.qa.automationexercises.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementUtilities {
	private WebDriver driver;

	public WebElementUtilities(WebDriver driver) {
		this.driver = driver;
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
	
	public List<String> getElementsAsString(By locator){
		List<WebElement> tempElements = getElements(locator);
		List<String> listAsStrings = new ArrayList<>();
		for(WebElement e:tempElements) {
			listAsStrings.add(e.getText());
		}
		return listAsStrings;
	}

}
