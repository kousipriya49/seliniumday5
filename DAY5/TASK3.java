package DAY5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TASK3 {
	public static void main(String arg[])
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver;
	ChromeOptions co=new ChromeOptions();
	co.addArguments("--remote-allow-origins=*");
	driver=new ChromeDriver(co);
	driver.get("https://demo.guru99.com/test/delete_customer.php");
	WebElement id=driver.findElement(By.name("cusid"));
	WebElement submit=driver.findElement(By.name("submit"));
	id.sendKeys("987");
	submit.click();
	Alert a1=driver.switchTo().alert();
	a1.dismiss();
	id.clear();

	id.sendKeys("321");
	submit.click();
	Alert a2=driver.switchTo().alert();
	a2.accept();
	
	
	Alert a3=driver.switchTo().alert();
	String txt=a3.getText();
	a3.accept();
	System.out.print(txt);
	
	}
}
