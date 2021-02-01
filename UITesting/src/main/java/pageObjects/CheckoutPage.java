package pageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

	public WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}
	By addToCartBtn = By.cssSelector("//div[@class='product-action']/button");
	By cartIcon=By.cssSelector("a.cart-icon");
	By Checkoutbtn=By.xpath("//div[@class='action-block']/button");
	By promoText=By.cssSelector("input.promoCode");
	By promoBtn=By.cssSelector("button.promoBtn");
	By promoInfo=By.cssSelector("span.promoInfo");
	public WebElement getCartIcon() {
		return driver.findElement(cartIcon);
	}
	public WebElement getCheckoutbtn() {
		return driver.findElement(Checkoutbtn);
	}
	public WebElement getPromoText() {
		return driver.findElement(promoText);
	}
	public WebElement getPromoBtn() {
		return driver.findElement(promoBtn);
	}
	public WebElement getPromoInfo() {
		return driver.findElement(promoInfo);
	}


	public void addItems(WebDriver driver, String[] itemsNeeded)
	{
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		System.out.println(products);
		for (int i = 0; i < products.size(); i++)
		{
			String[] name = products.get(i).getText().split("-");

			String formattedName = name[0].trim();

			// format it to get actual vegetable name

			// convert array into array list for easy search

			// check whether name you extracted is present in arrayList or not-

			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			System.out.println(itemsNeededList);

			if (itemsNeededList.contains(formattedName))

			{
				j++;
				CheckoutPage obj = new CheckoutPage(driver);
				//click on Add to cart
				//obj.getAddtoCartBtn().get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length)

				{
					break;

				}

			}

		}

	}

}
