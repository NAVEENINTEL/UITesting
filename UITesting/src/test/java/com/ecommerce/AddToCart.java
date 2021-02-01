package com.ecommerce;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import pageObjects.CheckoutPage;
import resources.ExtentReporterNG;
import resources.base;

public class AddToCart{
	static ExtentReports extent;
	public static void main(String[] args) throws InterruptedException, IOException {
		
		extent=base.startTest();
		ExtentTest test= extent.createTest("AddToCart");
		base b=new base();
		WebDriver driver = b.initializeDriver();
		CheckoutPage obj=new CheckoutPage(driver);
		String msg="";
		String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait w =new WebDriverWait(driver,5);
//		Thread.sleep(3000);
		
		//Adding Items to cart
		obj.addItems(driver,itemsNeeded);
		//click on CartIcon
		b.getScreenShotPath("Added Items in Kart and Clicking on KartIcon",test,obj.getCartIcon(),"cartIcon", driver);
		obj.getCartIcon().click();
		
		//Click on Proceed to checkout button and navigate to Checkout page
		b.getScreenShotPath("Clicking on Proceed to Check out button",test,obj.getCheckoutbtn(),"Checkout", driver);
		obj.getCheckoutbtn().click();
		test.pass("Clicked on Proceed to checkout button");
		
		//Entering Promo code in Text Field and click on Apply Button
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		b.getScreenShotPath("Checking Promo Input text field is present",test,obj.getPromoText(),"Promoinput", driver);
		obj.getPromoText().sendKeys("rahulshettyacademy");
		test.pass("Promo code entered");
		b.getScreenShotPath("Clicking on Apply button",test,obj.getPromoBtn(),"promoBtn", driver);
		obj.getPromoBtn().click();
		test.pass("Successfully Clicked on Apply button");
		//Get Promo info  after applying promo
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
//		System.out.println(obj.getPromoInfo().getText());
		test.pass(obj.getPromoInfo().getText()+"message displayed");
		b.getScreenShotPath("Successfully Promo code applied",test,obj.getPromoInfo(),"promoinfo", driver);

		driver.close();
		extent.flush();
		}

	

}
