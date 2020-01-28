package com.qa.assignment1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.qa.assignment1.base.TestBase;

public class AmazonHomePage extends TestBase{
	
	// Page Elements (using private for encapsulation)
	private By searchBarLocator = By.id("twotabsearchtextbox");
	
	private By itemLink = By.xpath("//div[@class = 's-result-list s-search-results sg-row']//following::a[@class = 'a-link-normal a-text-normal'][1]");
	
	// Methods
	public void searchItem(String item) {
		
		WebElement searchBarElement = driver.findElement(searchBarLocator);
		searchBarElement.sendKeys(item);
		searchBarElement.sendKeys(Keys.RETURN);
		
	}
	
	public AmazonItemPage clickOnItem() {

		WebElement link = driver.findElement(itemLink);
		
		((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", link,  "target", "_self");
		
		link.click();
		
		return new AmazonItemPage();
		
	}
	
}
