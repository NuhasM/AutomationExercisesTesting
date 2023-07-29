package com.qa.automationexercises.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private WebDriver driver;
	private Properties prop = new Properties();

	public WebDriver driverSetup(Properties prop) {
		driver = null;
		String browserName = prop.getProperty("browser");

		System.out.println("You have entered: " + browserName + ". Initialization started.");

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addExtensions(new File("./src/test/resources/browseraddons/extension_1_51_0_0.crx"));
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Please enter a correct browser name.");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

		return driver;
	}

	public Properties configSetup() {
		try (FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties")) {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
