package com.capgemini.interview.hotelbooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	
	public static WebElement wait(By by, DriverClient client) {
		WebDriverWait wait = new WebDriverWait(client.driver,30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		//WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		return element;
	}

}
