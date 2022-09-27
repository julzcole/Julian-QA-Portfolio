package GOAT;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoatGetPrices {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32 (1)/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.goat.com/");
		
		WebElement searchBox1 = driver.findElement(By.cssSelector("button[data-qa='search_placeholder']"));
		List<String> productNames = new ArrayList<String>();
		String[] itemsNeeded = {"Tom Sachs x NikeCraft Mars Yard 2.0", "Thom Browne Tennis Sneaker"};
		List itemsNeededList = Arrays.asList(itemsNeeded);
		//Search for item
		searchBox1.click();
		WebElement searchBox2 = driver.findElement(By.cssSelector("input[name='search']"));
		searchBox2.sendKeys("Thom Browne");
		searchBox2.sendKeys(Keys.ENTER);
		List<WebElement> products = driver.findElements(By.xpath("//div[@data-qa='grid_cell_product']"));
		for(int i = 0; i < products.size(); i++){
			String product = driver.findElements(By.xpath("//div[@data-qa='grid_cell_product_name']")).get(i).getText();
			if(itemsNeededList.contains(product)){
				String price = driver.findElements(By.xpath("//div[@data-qa='grid_cell_product_price']/span")).get(i).getText();
				System.out.println("Product: " + product + " Price: " + price);
			}
		}
		
	}

}
