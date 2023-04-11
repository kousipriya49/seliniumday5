package DAY5;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TASK5 {
	public static void main(String arg[])
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver;
	ChromeOptions co=new ChromeOptions();
	co.addArguments("--remote-allow-origins=*");
	driver=new ChromeDriver(co);
	
	driver.get("https://google.com");
	driver.manage().window().maximize();
	
	driver.findElement(By.name("q")).sendKeys("Apple");
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	String parent=driver.getWindowHandle();
	System.out.println(parent);
	System.out.println(driver.getTitle());
	
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://google.com");
	driver.manage().window().maximize();
	driver.findElement(By.name("q")).sendKeys("Selenium");
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://google.com");
	driver.manage().window().maximize();
	driver.findElement(By.name("q")).sendKeys("Cucumber");
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	
	Set<String>s=driver.getWindowHandles();
	Iterator<String>it=s.iterator();
	while(it.hasNext())
	{
		String child=it.next();
		if(parent.equals(child))
		{
			continue;
		}
		else
		{
			driver.switchTo().window(child);
			System.out.println(driver.switchTo().window(child).getWindowHandle());
			System.out.println(driver.switchTo().window(child).getTitle());
		}
	}
	
	
	
	
	
	}
}
