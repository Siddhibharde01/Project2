package amazonAddToCart;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonAddToCart {

	WebDriver driver;
	@BeforeTest
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver111\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void addtocart() {
		driver.get("https://www.amazon.in/");
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.click();
		search.sendKeys("iphone14promax");
		WebElement Enter = driver.findElement(By.id("nav-search-submit-button"));
		Enter.click();
		driver.get("https://www.amazon.in/Apple-iPhone-256GB-Space-Black/dp/B0BDJFZ11C/ref=sr_1_1_sspa?crid=3BLKSGB2VQCFK&keywords=iphone%2B14%2Bpro%2Bmax&qid=1680949597&sprefix=iphone14promax%2Caps%2C325&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&th=1");
		WebElement addtocart = driver.findElement(By.id("add-to-cart-button"));
		addtocart.click();
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}
