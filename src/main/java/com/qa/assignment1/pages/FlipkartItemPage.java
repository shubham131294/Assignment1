package com.qa.assignment1.pages;

import org.openqa.selenium.By;

import com.qa.assignment1.base.TestBase;

public class FlipkartItemPage extends TestBase{

	// Elements
		private By itemPrice = By.xpath("//div[@class = '_1vC4OE _3qQ9m1']");
		
		// Methods
		public double fetchItemPrice() {
			
			String priceString = driver.findElement(itemPrice).getText();
			double price = Double.parseDouble(priceString.substring(1).replaceAll(",", ""));
			
			return price;
			
		}

}
