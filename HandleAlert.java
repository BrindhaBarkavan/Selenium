package AdvancedConcepts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//simple alert handling
		//finding the element using xpath
		driver.findElement(By.xpath("//span[text()='Show']")).click();
		//transferring driver control to alert since alert is abstract method you should use Alert interface
		Alert alert1= driver.switchTo().alert();
		//getting the text from the alert
		System.out.println(alert1.getText());
		alert1.accept();
		
		//Confirmation alert handling
		//finding the element using xpath
		driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
		//transferring control of driver to alert 
		System.out.println(alert1.getText());
		alert1.accept();
		System.out.println(driver.findElement(By.id("result")).getText());
		driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
		System.out.println(alert1.getText());
		alert1.dismiss();
		
		//prompt alert handling
		driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
		alert1.sendKeys("Ishan");
		alert1.accept();
		System.out.println(driver.findElement(By.id("confirm_result")).getText());
		
		//sweet alert handling
		//finding the element using the xpath
		driver.findElement(By.xpath("(//span[text()='Show'])[3]")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='ui-dialog-content ui-widget-content']/p")).getText());
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();

		//sweet model dialog handling
		//finding the element using the xpath
		driver.findElement(By.xpath("(//span[text()='Show'])[4]")).click();
		System.out.println(driver.findElement(By.xpath("(//div[@class='ui-dialog-content ui-widget-content']/p)[2]")).getText());
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[2]")).click();
		
	}

}
