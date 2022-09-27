package Exercises;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LowToHigh {

	public static void main(String[] args) {
		// TODO Sort the list by price low to high then verify sorted list
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32 (1)/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Log in to SwagLabs
		String user = "standard_user";
		String pass = "secret_sauce";
		driver.findElement(By.id("user-name")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("login-button")).click();
		//Click the sort list element
		WebElement sortElement = driver.findElement(By.cssSelector("select[class='product_sort_container']"));
		Select sortDropdown = new Select(sortElement);
		sortDropdown.selectByIndex(2);
		//Iterate through product list and grab the price and store in an array
		ArrayList<Float> prices = new ArrayList<Float>();
		List<WebElement> priceElements = driver.findElements(By.cssSelector("div[class='inventory_item_price']"));
		for(int i = 0; i < priceElements.size();i++) {
			prices.add(Float.parseFloat(driver.findElements(By.cssSelector("div[class='inventory_item_price']")).get(i).getText().replace("$", "")));
		}
		//Copy the list, sort the list ascending, and compare lists to ensure prices are sorted low to high
		ArrayList<Float> sortedPrices = new ArrayList<Float>(prices);
		Collections.sort(sortedPrices);
		Assert.assertEquals(prices, sortedPrices);
	}

}
