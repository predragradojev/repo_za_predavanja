package p28_09_2021;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Zadatak1_domaci {
	private WebDriver driver;

	@Test
	private void Ratings() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.udemy.com/");
		WebDriverWait waiter = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[contains(@name, 'q')]")).sendKeys("Selenium");
		driver.findElement(By.xpath("//button[contains(@type, 'submit')]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//select[contains(@class, 'udlite-text-md')]")).sendKeys(Keys.ENTER);
		Select categorySelect = new Select(
				driver.findElement(By.xpath("//select[contains(@class, 'udlite-text-md')]")));
		Thread.sleep(2000);
		categorySelect.selectByIndex(3);
		Thread.sleep(4000);

		List<WebElement> rating = driver.findElements(By.xpath("//*[@data-purpose='rating-number']"));
		WebElement firstElement = rating.get(0);
		WebElement lastElement = rating.get(rating.size() - 1);

		System.out.println(firstElement.getText());
		System.out.println(lastElement.getText());

		double first = Double.parseDouble(firstElement.getText());
		double last = Double.parseDouble(lastElement.getText());

		Assert.assertTrue(first > last);
		System.out.println("First rating from the list is higher than last rating.");

	}

}
