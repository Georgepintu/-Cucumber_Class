package testNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeWork {

	WebDriver driver;
	Actions action;

	// Elements list
	By USER_NAME = By.xpath("//input[@id='username']");
	By PASSWORD = By.xpath("//input[@type='password']");
	By SIGNIN = By.xpath("//button[@name='login']");
	By DASHBOARD = By.xpath("//h2[text()=' Dashboard ']");
	By CUSTOMER = By.xpath("//span[text()='Customers']");
	By ADD_CUSTOMER = By.linkText("Add Customer");
	By CONTACTS = By.xpath("//h2[text()=' Contacts ']");
	By FULL_NAME = By.xpath("//input[@id='account']");
	By COMPANY = By.xpath("//select[@id='cid']");
	By EMAIL = By.xpath("//input[@id='email']");
	By PHONE = By.xpath("//input[@id='phone']");
	By ADDRESS = By.xpath("//input[@id='address']");
	By CITY = By.xpath("//input[@id='city']");
	By STATE = By.xpath("//input[@id='state']");
	By ZIP = By.xpath("//input[@id='zip']");
	By COUNTRY = By.xpath("//span[@id='select2-country-container']");
	By COUNTRY_SELECT = By.xpath("//span[@class='select2-search select2-search--dropdown']/child::input");
	By TAG = By.xpath("//ul[@class='select2-selection__rendered']");
	By TAG_TEXTBOX = By.xpath("//input[@role='textbox']");
	By SUBMIT_BUTTON = By.xpath("//button[@id='submit']");
	By CUSTOMER_NAME = By.xpath("//h5[text()='George Adhikary']");
	By LIST_CUSTOMER = By.linkText("List Customers");
	By SEARCH_NEW_CUSTOMER = By.xpath("//input[@id='foo_filter']");
	By VALIDATE_CUSTOMER = By.linkText("George Adhikary");

	// Test Data
	String username = "demo@techfios.com";
	String password = "abc123";
	String fullName = "George Adhikary";
	String email = "georgepintu@gmail.com";
	String phone = "3476914842";
	String address = "New York";
	String city = "Queens";
	String state = "New York";
	String tag_name = "Enrico";
	String zip = "10423";
	String country = "Bangladesh";
	

	@BeforeTest
	public void init() {

		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@Test
	public void login() throws InterruptedException {
		driver.findElement(USER_NAME).sendKeys(username);
		driver.findElement(PASSWORD).sendKeys(password);
		driver.findElement(SIGNIN).click();
		Assert.assertEquals(driver.findElement(DASHBOARD).getText(), "Dashboard", "Tomar Hoy Nai");

		driver.findElement(CUSTOMER).click();
		driver.findElement(ADD_CUSTOMER).click();
		Assert.assertEquals(driver.findElement(CONTACTS).getText(), "Contacts", "Wrong Page");

		driver.findElement(FULL_NAME).sendKeys(fullName);
		driver.findElement(COMPANY).click();
		Select sel = new Select(driver.findElement(COMPANY));
		sel.selectByVisibleText("Uber");
		driver.findElement(EMAIL).sendKeys(email);
		driver.findElement(PHONE).sendKeys(phone);
		driver.findElement(ADDRESS).sendKeys(address);
		driver.findElement(CITY).sendKeys(city);
		driver.findElement(STATE).sendKeys(state);
		driver.findElement(ZIP).sendKeys(zip);
		driver.findElement(COUNTRY).click();
		driver.findElement(COUNTRY_SELECT).sendKeys(country);
		action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(TAG).click();
		driver.findElement(TAG_TEXTBOX).sendKeys(tag_name);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(SUBMIT_BUTTON).click();
		Assert.assertEquals(driver.findElement(CUSTOMER_NAME).getText(), fullName, "U r not right page");
		driver.findElement(LIST_CUSTOMER).click();
		driver.findElement(SEARCH_NEW_CUSTOMER).sendKeys(fullName);
		Assert.assertEquals(driver.findElement(VALIDATE_CUSTOMER).getText(), fullName, "Page Not Found");
		System.out.println("The New Customer is: " + fullName);
		Thread.sleep(5000);
		
	}
	
	//@AfterMethod
	public void burndown() {
		driver.close();
		driver.quit();
		
	}

}
