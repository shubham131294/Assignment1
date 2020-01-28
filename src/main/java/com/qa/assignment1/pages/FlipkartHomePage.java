package com.qa.assignment1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.qa.assignment1.base.TestBase;

public class FlipkartHomePage extends TestBase {

	// Elements
	private By loginClose = By.xpath("//button[@class = '_2AkmmA _29YdH8']");

	private By searchBarLocator = By.name("q");

	private By itemLink = By.xpath("//div[@class = '_1HmYoV _35HD7C']//following::a[@class = '_31qSD5'][1]");

	public void searchItem(String itemName) {

		driver.findElement(loginClose).click();
		WebElement searchBarElement = driver.findElement(searchBarLocator);
		searchBarElement.sendKeys(itemName);
		searchBarElement.sendKeys(Keys.RETURN);

	}

	public FlipkartItemPage clickOnItem() {

		WebElement link = driver.findElement(itemLink);

		((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", link,  "target", "_self");

		link.click();

		return new FlipkartItemPage();
	}

}
