package liveguru99;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ECommerceWebsite {

	WebDriver driver;
	@BeforeTest
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver111\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test
	public void listPage() {
		//Go to http://live.guru99.com/
		driver.get("http://live.techpanda.org/");
		
		//Click on Mobile Menu
		WebElement mobile = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
		mobile.click();
		
		//In the list of all Mobile, read the cost of Sony Xperia Mobile, Note this Value
		WebElement sonyXperiaCost = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]"));
		String value = sonyXperiaCost.getText();
		System.out.println(value);
		
		//Click on Sony Xperia Mobile
		WebElement sonyXperiamobile = driver.findElement(By.xpath("(//a[@title='Sony Xperia'][normalize-space()='Sony Xperia'])[1]"));
		sonyXperiamobile.click();
		
		//Read the Sony Xperia Mobile value from Detail page
		WebElement cost = driver.findElement(By.xpath("//span[@class='price']"));
		String price = cost.getText();
		System.out.println(price);
		
	}
	
	
    @Test
	public void emptyCart() {
		//Go to http://live.guru99.com/
		driver.get("http://live.techpanda.org/");
		
		//Click on Mobile Menu
		WebElement mobile = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
	    mobile.click();
	    
	    //In the list of all Mobile, click on "ADD TO CART" for Sony Xperia mobile
	    WebElement sonyXperiamobile = driver.findElement(By.xpath("(//a[@title='Sony Xperia'][normalize-space()='Sony Xperia'])[1]"));
		sonyXperiamobile.click();
	    driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]")).click();
	    
	    //Change "QTY" value to 1000 and click "UPDATE" button
	    WebElement qty = driver.findElement(By.xpath("//input[@title='Qty']"));
	    qty.click();
	    qty.clear();
	    qty.sendKeys("1000");
	    WebElement update = driver.findElement(By.xpath("//button[@title='Update']//span//span[contains(text(),'Update')]"));
	    update.click();
	    
	    //Verify the error message
	    Assert.assertTrue(true,"The maximum quantity allowed for purchase is 500.");
	    
	    //Then Click on "EMPTY CART" link in the footer of list of all mobiles
	    WebElement emptycart = driver.findElement(By.xpath("//span[contains(text(),'Empty Cart')]"));
	    emptycart.click();
	    
	    //Verify Cart is empty
	    Assert.assertTrue(true,"Shopping Cart is Empty");
	}
	
	@Test
	public void popUpWindow() {
		//Go to http://live.guru99.com/
		driver.get("http://live.techpanda.org/");
				
		//Click on Mobile Menu
		WebElement mobile = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
	    mobile.click();
	    
	    //In Mobile Product List, Click on "Add to Compare" for 2 Mobiles
	    WebElement comp1 = driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[2]//a[1]"));
	    comp1.click();
	    WebElement comp2 = driver.findElement(By.xpath("//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]"));
	    comp2.click();
	    
	    //Click on Compare button
	    WebElement compare = driver.findElement(By.xpath("//button[@title='Compare']//span//span[contains(text(),'Compare')]"));
	    compare.click();
	    
	    //Verify the popup window 
	    Assert.assertTrue(true,"http://live.techpanda.org/index.php/catalog/product_compare/index/");
	  
	}
	
	@Test
	public void createAccount() {
		//Go to http://live.guru99.com/
		driver.get("http://live.techpanda.org/");
		
		//Click on My Account link
		driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']")).click();
		driver.findElement(By.xpath("//div[@id='header-account']//a[@title='My Account'][normalize-space()='My Account']")).click();
		
		//Click Create Account Link and fill new Use information 
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		WebElement firstname = driver.findElement(By.id("firstname"));
		firstname.click();
		firstname.sendKeys("sid");
		WebElement middlename = driver.findElement(By.id("middlename"));
		middlename.click();
		middlename.sendKeys("vijay");
		WebElement lastname = driver.findElement(By.id("lastname"));
		lastname.click();
		lastname.sendKeys("bharde");
		WebElement emailaddress = driver.findElement(By.id("email_address"));
		emailaddress.click();
		emailaddress.sendKeys("siddh6@gmail.com");
		WebElement pass = driver.findElement(By.id("password"));
		pass.click();
		pass.sendKeys("vijay@08");
		WebElement confpass = driver.findElement(By.id("confirmation"));
		confpass.click();
		confpass.sendKeys("vijay@08");
		
		//Click  Register 
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		
		//Verify Registration is done
		Assert.assertTrue(true,"Thank you for registering with Main Website Store.");
		
	}
	
	@Test
	public void wishList() {
		//Go to http://live.guru99.com/
		driver.get("http://live.techpanda.org/index.php/mobile.html");
		
		//Go to TV Menu
		driver.findElement(By.xpath("//a[normalize-space()='TV']")).click();
		
		//Add Product in your wishlist
		driver.get("http://live.techpanda.org/index.php/tv/lg-lcd.html");
		driver.findElement(By.xpath("//a[normalize-space()='Add to Wishlist']")).click();
		WebElement email = driver.findElement(By.id("email"));
		email.click();
		email.sendKeys("sidbharde01@gmail.com");
		WebElement password = driver.findElement(By.id("pass"));
		password.click();
		password.sendKeys("vijay@09");
		driver.findElement(By.id("send2")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]")).click();
		
		//In Next page enter Email and a message and click SHARE WISHLIST
		WebElement emailinfo = driver.findElement(By.id("email_address"));
		emailinfo.click();
		emailinfo.sendKeys("sidbharde01@gmail.com");
		WebElement message = driver.findElement(By.id("message"));
		message.click();
		message.sendKeys("Hi!");
		driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
		
		//Check Wishlist is shared
		Assert.assertTrue(true,"Your Wishlist has been shared.");
		  
	}
	
	
	public void close() {
		driver.close();
	}
}
