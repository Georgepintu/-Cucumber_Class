package testNg;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Window_Handler {
WebDriver driver;
	
	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver", "Drivers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@Test
	public void windowHandle() {
		driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("Tesla");
		driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3/a")).click();
		System.out.println(driver.getTitle());
		
		//window handler
		Set<String> handles =driver.getWindowHandles();
		for(String i:handles) {
			driver.switchTo().window(i);
			System.out.println(i);
		}
		
		System.out.println(driver.getTitle());
		
	}
	
	
}
