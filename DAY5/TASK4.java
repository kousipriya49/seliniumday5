package DAY5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TASK4 {
	public static void main(String arg[])
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver;
	ChromeOptions co=new ChromeOptions();
	co.addArguments("--remote-allow-origins=*");
	driver=new ChromeDriver(co);
	driver.get("https://www.abhibus.com/bus-ticket-booking ");
	WebElement dept=driver.findElement(By.name("source"));
	dept.sendKeys("Coimbatore",Keys.ENTER);
	WebElement des=driver.findElement(By.name("destination"));
	des.sendKeys("Madurai",Keys.ENTER);
	WebElement date=driver.findElement(By.id("datepicker1"));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0]. setAttribute('value','04/09/2003')",date);
	
}
}
