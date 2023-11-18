package advancedConcepts;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandle {

	public static void main(String[] args) {
		
		//interview questions like 
		//1.close all the child window except parent window?using for loop ,tranfer control driver.switchTo().window(list.get(i));,driver.close();
		//2.close all the window? using quit();
		//3.close only the parent window?transfer the control and driver.close();
		//4.difference between windowhandle and windowHandles?
		//5.difference between close and quit?
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Phones",Keys.ENTER);
		
	List<WebElement> prices =	driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	for (WebElement item : prices) {
		System.out.println(item.getText());
	}
		
		System.out.println(driver.getTitle());
		
		String windowhandle = driver.getWindowHandle();
		System.out.println(windowhandle);
		
		prices.get(3).click();
		System.out.println(driver.getTitle());
		
		System.out.println("**********************");
		Set<String> multipleWindow = driver.getWindowHandles();
		for (String windows : multipleWindow) {
			System.out.println(windows);
		}
		
		List<String> windowList = new ArrayList<String>(multipleWindow);
		driver.switchTo().window(windowList.get(1));
		
		System.out.println(driver.getTitle());
		//senario 1 switch to main choose another price and close the main page
		driver.switchTo().window(windowList.get(0));
		System.out.println(driver.getTitle());
		
		prices.get(5).click();
		Set<String> scenarioOne = driver.getWindowHandles();
		System.out.println(scenarioOne.size());
		List<String> scenarioOneList = new ArrayList<String>(scenarioOne);
		//arrayindexOutOFBound exception in java
		driver.switchTo().window(scenarioOneList.get(2));
		System.out.println(driver.getTitle());
		driver.switchTo().window(scenarioOneList.get(0));
		System.out.println("Driver closing the main");
		// this will close particular window
		//if you try to close already closed window you will get NoSuchWindowException 
		driver.close();
		// this will close all the window 
		driver.quit();

	}

}
