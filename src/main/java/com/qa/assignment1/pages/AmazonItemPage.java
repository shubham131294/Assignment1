package com.qa.assignment1.pages;

import org.openqa.selenium.By;

import com.qa.assignment1.base.TestBase;

public class AmazonItemPage extends TestBase{
	
	// Elements
	private By itemPrice = By.id("priceblock_ourprice");
	
	// Methods
	public double fetchItemPrice() {
		
		String priceString = driver.findElement(itemPrice).getText();
		double price = Double.parseDouble(priceString.substring(2).replaceAll(",", ""));
		
		return price;
		
	}
	
}
