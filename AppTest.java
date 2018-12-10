package myCompany.OrdinaSiteTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	WebDriver driver;

	@Test(priority = 1)
	public void TestHome() throws InterruptedException {
		
		
		System.setProperty("webdriver.gecko.driver", "F:\\Job Search\\Testing\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get("https://www.ordina.be/");
		Thread.sleep(2000);

	}
	
	@Test(priority = 2)
	public void TestLanguageChange() throws InterruptedException, IOException {
		
		driver.findElement(By.xpath("//*[@id='language-toggle']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='menu-item-216']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("catapultCookie")).click();
		Thread.sleep(2000);
		//driver.quit();
	}
	
	
	@Test(priority = 3)
	public void TestJobsPage() throws InterruptedException {
		
		driver.findElement(By.linkText("Jobs")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void TestJobsSerach() throws InterruptedException {
		
		driver.findElement(By.id("vacancy-search-field")).sendKeys("Test Engineer");
		Thread.sleep(2000);
		driver.findElement(By.id("vacancy-search-field")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Actions builder = new Actions(driver);
		builder.click(driver.findElement(By.partialLinkText("Test engineer"))).build().perform();
	}
}
