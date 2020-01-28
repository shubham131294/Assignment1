package com.qa.assignment1.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.qa.assignment1.base.TestBase;
import com.qa.assignment1.pages.AmazonHomePage;
import com.qa.assignment1.pages.AmazonItemPage;
import com.qa.assignment1.pages.FlipkartHomePage;
import com.qa.assignment1.pages.FlipkartItemPage;

public class CompareAmazon_Flipkart extends TestBase{

	AmazonHomePage amazonHomePage;
	AmazonItemPage amazonItemPage;
	FlipkartHomePage flipkartHomePage;
	FlipkartItemPage flipkartItemPage;
	double amazonItemPrice;
	double flipkartItemPrice;
	String itemName = "iPhone XR (64GB) - Yellow";

	public CompareAmazon_Flipkart() {
		super();
	}

	@BeforeGroups("Amazon") 
	public void setUpAmazon() {
		initialization();
		amazonHomePage = new AmazonHomePage();
		
		// Opening URL
		driver.get(prop.getProperty("amazon_url"));
	}
	
	@BeforeGroups("Flipkart") 
	public void setUpFlipkart() {
		initialization();
		flipkartHomePage = new FlipkartHomePage();
		
		// Opening URL
		driver.get(prop.getProperty("flipkart_url"));
	}

	@Test(groups= {"Amazon"}, priority = 0)
	public void amazonPrice() {
		amazonHomePage.searchItem(itemName);
		amazonItemPage = amazonHomePage.clickOnItem();
		amazonItemPrice = amazonItemPage.fetchItemPrice();
	}
	
	@Test(groups= {"Flipkart"}, priority = 1)
	public void flipkartPrice() {
		flipkartHomePage.searchItem(itemName);
		flipkartItemPage = flipkartHomePage.clickOnItem();
		flipkartItemPrice = flipkartItemPage.fetchItemPrice();
	}
	
	@Test (priority = 2)
	public void comparePrice() {
		
		System.out.println("Amazon iPhone Price: " + amazonItemPrice);
		System.out.println("Flipkart iPhone Price: " + flipkartItemPrice);
		
		if(amazonItemPrice < flipkartItemPrice)
			System.out.println("Amazon price is lesser");
		else
			System.out.println("Flipkart price is lesser");
		
	}

	@AfterMethod
	public void tearDown() {

		// quit is for quitting all tabs and windows
		driver.quit();

	}
}
