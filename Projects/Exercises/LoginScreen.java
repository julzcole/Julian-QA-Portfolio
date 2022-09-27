package Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginScreen {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32 (1)/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		//Get a random username from the accepted usernames list
		String pass = "secret_sauce";
		Random rand = new Random();
		String[] usernameElement = driver.findElement(By.xpath("//div[@id='login_credentials']")).getText().split(":")[1].split("\n");
		List<String> usernames = Arrays.asList(usernameElement);
		System.out.println(usernames);
		String randomUser = usernames.get(rand.nextInt(usernameElement.length));
	
		//Log in with random valid user and password
		driver.findElement(By.id("user-name")).sendKeys(randomUser);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("login-button")).click();
		
		//Sort the product list
	}

}
