package com.qa.automationexercises.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private WebDriver driver;
	private Properties prop = new Properties();
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static WebDriver getThreadLocalDriver() {
		return tlDriver.get();
	}

	public WebDriver driverSetup(Properties prop) {
		driver = null;
		String browserName = prop.getProperty("browser");
		OptionsFactory options = new OptionsFactory(prop);

		System.out.println("You have entered: " + browserName + ". Initialization started.");

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(options.getChromeOptions()));
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver(options.getFirefoxOptions()));
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
			break;
		default:
			System.out.println("Please enter a correct browser name.");
		}
		getThreadLocalDriver().manage().deleteAllCookies();
		getThreadLocalDriver().manage().window().maximize();
		getThreadLocalDriver().get(prop.getProperty("url"));

		return getThreadLocalDriver();
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
