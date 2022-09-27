package Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUpPracticeForm {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32 (1)/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		// Enter first name and last name
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Julian");
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Coleman");
		// Select Gender
		driver.findElement(By.id("sex-0")).click();
		// Select years of experience
		driver.findElement(By.id("exp-3")).click();
		// Enter Date
		driver.findElement(By.id("datepicker")).sendKeys("9/22/2022");
		// Select Profession
		driver.findElement(By.xpath("//input[@id='profession-1']")).click();
		// Select automation tools you are familiar with
		driver.findElement(By.id("tool-2")).click();
		// Select Continent
		WebElement staticDropdown = driver.findElement(By.id("continents"));
		Select continentDropdown = new Select(staticDropdown);
		continentDropdown.selectByIndex(5);
		// Select Multiple commands from a multi select image
		WebElement staticDropdown2 = driver.findElement(By.id("selenium_commands"));
		Select commandsDropdown = new Select(staticDropdown2);
		commandsDropdown.selectByVisibleText("Wait Commands");
		commandsDropdown.selectByVisibleText("Navigation Commands");
		// Upload image
		WebElement imageElement = driver.findElement(By.className("input-file"));
		imageElement.sendKeys("C:\\Users\\xXJul\\Pictures/huey.png");
		// Click Submit
		driver.findElement(By.cssSelector("button[id='submit']")).click();
	}

}
