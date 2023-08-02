package com.qa.automationexercises.constants;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Constants {
	public static String AMEXERCISES_LOGO_TEXT = "Website for automation practice";
	public static List<String> AMEXERCISES_HEADER_TEXT = Arrays.asList("Cart", "Home", "Test Cases");
	public static List<String> AMEXERCISES_LOGIN_TEXT = Arrays.asList("Login to your account", "New User Signup!");
	
	public static String AMEXERCISES_BOOK = "./src/test/resources/testdata/Automation Exercises Book.xls";
	
	public static Duration DEFAULT_TIMEOUT = Duration.ofSeconds(7);
	
}
