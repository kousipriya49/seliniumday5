package DAY5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TASK2 {
	public static void main(String arg[])
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver;
	ChromeOptions co=new ChromeOptions();
	co.addArguments("--remote-allow-origins=*");
	driver=new ChromeDriver(co);
	driver.get("https:/jqueryui.com/droppable/");
	driver.switchTo().frame(0);
	WebElement drag=driver.findElement(By.id("draggable"));
	WebElement drop=driver.findElement(By.id("droppable"));
	Actions act=new Actions(driver);
	act.dragAndDrop(drag, drop).build().perform();
	driver.switchTo().defaultContent();
	
	
}

}
