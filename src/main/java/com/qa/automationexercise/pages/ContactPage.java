package com.qa.automationexercise.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.automationexercises.utils.WebElementUtilities;

public class ContactPage {
	private WebDriver driver;
	private WebElementUtilities webUtil;

	private By getInTouch = By.xpath("//div/h2[contains(text(), 'Get In Touch')]");
	private By contactForms = By.cssSelector(".form-control"); // 5 elements

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		webUtil = new WebElementUtilities(driver);
	}

	public boolean contactPageElementVerification() {
		boolean flag = false;
		WebElement ele_getInTouch = webUtil.getElement(getInTouch);
		if (ele_getInTouch.isDisplayed()) {
			flag = true;
		}
		return flag;
	}

	// 4 Message Fields - 1 File Field
//	public void contactFormFieldsFill(String... formValues) {
//		List<WebElement> ele_Forms = webUtil.getElements(contactForms);
//		for (int i = 0; i < ele_Forms.size(); i++) {
//			if (i < 4) {
//				ele_Forms.get(i).sendKeys("temp");
//			}
//			if (i == 4) {
//				ele_Forms.get(i).sendKeys("attachmentPath"); // hardcoded file? Shouldn't matter.
//			}
//		}
//	}

}
