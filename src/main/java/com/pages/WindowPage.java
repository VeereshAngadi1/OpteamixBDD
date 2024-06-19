package com.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WindowPage {
	public static WebDriver driver;

	// locators
	private By click1 = By.xpath("//a[@id='opentab']");
	private By childtext = By.xpath("//div[@class='cont']//span[contains(text(),'info@qaclickacademy.com')]");

	// constructor
	public WindowPage(WebDriver driver) {
		WindowPage.driver = driver;
	}

	// Verify click
	public void verifyClick() throws InterruptedException {

		// get the parent window handle
		String parentwindow1 = driver.getWindowHandle();
		System.out.println(parentwindow1);
		
		Thread.sleep(3000);
		driver.findElement(click1).click();


		// To get all window handles
		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);

		// Iterate among the windows
		Iterator<String> iterator = windowhandles.iterator();
		while (iterator.hasNext()) {
			String childWindow = iterator.next();
			if (!parentwindow1.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
			}
		}

	}
	
	public String gettext() {
		return driver.findElement(childtext).getText();
	}

}
