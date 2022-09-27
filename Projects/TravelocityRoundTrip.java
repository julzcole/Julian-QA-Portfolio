import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TravelocityRoundTrip {

	public static void main(String[] args) {
		// A script to automate searching for a round trip flight on travelocity

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32 (1)/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.travelocity.com/Flights");

		WebElement leavingFrom = driver.findElement(By.cssSelector("button[aria-label='Leaving from']"));
		WebElement leavingFromField = driver.findElement(By.id("location-field-leg1-origin"));
		WebElement goingTo = driver.findElement(By.cssSelector("button[aria-label='Going to']"));
		WebElement goingToField = driver.findElement(By.id("location-field-leg1-destination"));

		// Selecting Orlando MCO as the departure location
		leavingFrom.click();
		leavingFromField.click();
		leavingFromField.sendKeys("Orlando (MCO - Orlando Intl.)");
		leavingFromField.sendKeys(Keys.ENTER);

		// Selecting New York LGA as the destination
		goingTo.click();
		goingToField.click();
		goingToField.sendKeys("New York (LGA - LaGuardia)");
		goingToField.sendKeys(Keys.ENTER);

		// Click date element

		driver.findElement(By.cssSelector("button[id='d1-btn']")).click();

		// Find Departure Date on Date Element by iteration
		while (driver.findElements(By.cssSelector("button[aria-label='Nov 19, 2022']")).isEmpty()) {
			driver.findElement(By.cssSelector("div[class='uitk-calendar'] button:nth-child(2)")).click();
			System.out.println(driver.findElements(By.cssSelector("button[aria-label='Nov 19, 2022']")));
		}

		int count = driver.findElements(By.className("uitk-date-picker-day")).size();

		// Iterate through day list and select needed day
		for (int i = 0; i < count; i++) {

			String neededValue1 = driver.findElement(By.cssSelector("button[aria-label='Nov 19, 2022']"))
					.getAttribute("aria-label");
			String value1 = driver.findElements(By.className("uitk-date-picker-day")).get(i).getAttribute("aria-label");
			System.out.println(value1);
			if (value1.equals(neededValue1)) {
				driver.findElements(By.className("uitk-date-picker-day")).get(i).click();
				break;
			}
		// Repeat for departure date

		while (driver.findElements(By.cssSelector("button[aria-label='Dec 19, 2022']")).isEmpty()) {
				driver.findElement(By.cssSelector("div[class='uitk-calendar'] button:nth-child(2)")).click();
				System.out.println(driver.findElements(By.cssSelector("button[aria-label='Dec 19, 2022']")));
			}

		}
		int count2 = driver.findElements(By.className("uitk-date-picker-day")).size();

		for (int i = 0; i < count2; i++) {

			String neededValue2 = driver.findElement(By.cssSelector("button[aria-label='Dec 19, 2022']"))
					.getAttribute("aria-label");
			String value2 = driver.findElements(By.className("uitk-date-picker-day")).get(i).getAttribute("aria-label");
			System.out.println(value2);
			if (value2.equals(neededValue2)) {
				driver.findElements(By.className("uitk-date-picker-day")).get(i).click();
				break;
			}
			// Close date picker and search for flights
			driver.findElement(By.cssSelector("button[data-stid='apply-date-picker']")).click();
			driver.findElement(By.cssSelector("button[data-testid='submit-button']")).click();
		}

	}
}
