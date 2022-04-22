package testclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import testEngine.Engine;
import utilities.ExcelRead;

public class TestCase1 {

	static WebDriver driver;

	public static void openBrowser() {
		if (ExcelRead.TestData.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();	
		}
	}
	public static void launchURL() {
		driver.get(ExcelRead.TestData);
	}
	public static void enterUsername() {
		WebElement username = driver.findElement(Engine.Locator);
		username.sendKeys(ExcelRead.TestData);

	}
	public static void enterPassword(){
		WebElement password = driver.findElement(Engine.Locator);
		password.sendKeys(ExcelRead.TestData);
	}
	public static void btnLogin() {
		WebElement loginbtn = driver.findElement(Engine.Locator);
		loginbtn.click();
	}
	public static void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
