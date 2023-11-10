package AdvancedConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/frame.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//switching control into frames
		driver.switchTo().frame(0);
		driver.findElement(By.id("Click")).click();
		
		//driver control transfer to main document page
		driver.switchTo().defaultContent();
		
		//access the second frame using index id or by name and clicking button
		driver.switchTo().frame(2);
		driver.switchTo().frame("frame2");
		driver.findElement(By.id("Click")).click();
		
		//driver control transfer to main document page
		driver.switchTo().defaultContent();
		
		//handling frame using web element 
		WebElement elementFrame = driver.findElement(By.xpath("(//iframe)[2]"));
		driver.switchTo().frame(elementFrame);
		driver.findElement(By.id("Click")).click();
		System.out.println(driver.findElement(By.id("Click")).getText());
	}

}
