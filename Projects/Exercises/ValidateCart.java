package Exercises;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ValidateCart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32 (1)/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		Actions a = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://automationpractice.com/index.php");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,500)");
		
		//Store the products you want to add to the cart into a variable
		ArrayList<String> itemsNeededArr = new ArrayList<String>();
		itemsNeededArr.add("Blouse");
		itemsNeededArr.add("Faded Short Sleeve T-shirts");
		
		List<WebElement> productList = driver.findElements(By.cssSelector("h5[itemprop='name']"));
		
		//Iterate through products and add the desired items to the cart
		for(int i = 0; i < productList.size(); i++) {
				String productName = productList.get(i).getText();
				List<WebElement> addCart = driver.findElements(By.xpath("//a[@title='Add to cart']"));
				List<WebElement> images = driver.findElements(By.xpath("//img[@class='replace-2x img-responsive']"));
				
				if (itemsNeededArr.contains(productName)) {
					System.out.println(productName);
					a.moveToElement(images.get(i)).moveToElement(addCart.get(i)).click().build().perform();
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@title='Continue shopping']")));
					driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
				}
		}
		driver.findElement(By.cssSelector("a[title='View my shopping cart'")).click();
		List<WebElement> cartList = driver.findElements(By.xpath("//p[@class='product-name']/a"));
		//Iterate through the cart and add the items in the cart to a list
		ArrayList<String> itemsInCart = new ArrayList<String>();
		for(int k = 0; k < cartList.size(); k++){
			
			String cartListitem = driver.findElements(By.xpath("//p[@class='product-name']/a")).get(k).getText();
			itemsInCart.add(cartListitem);
		}
		//Assert that all of the needed items are in the cart
		Assert.assertTrue(itemsInCart.containsAll(itemsNeededArr));
	}

}
