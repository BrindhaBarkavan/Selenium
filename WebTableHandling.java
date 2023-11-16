package advancedConcepts;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandling {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/table.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//find the table and stored as a webelement
		WebElement table = driver.findElement(By.xpath("//div[@class='ui-datatable-scrollable-body']/table"));
		
		//no of rows count
		List<WebElement> noOfRows = table.findElements(By.tagName("tr"));
		
		System.out.println(noOfRows.size());
		
		//using the rows webelement defined above finding the size of the columns
		List<WebElement> noOfCols = noOfRows.get(0).findElements(By.tagName("th"));
		
		System.out.println(noOfCols.size());
		
		System.out.println("*************************************");
		
		//printing the whole column details
		for (WebElement cols : noOfCols) {
			System.out.println(cols.getText());
		}
		
		System.out.println("*************************************");
		
		//printing the whole column and rows details
		for (WebElement rows : noOfRows) {
			System.out.println(rows.getText());
		}
		
		System.out.println("**************************");
		
		//printing the second row and third element
		String oneColumn = driver.findElement(By.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr[2]/td[3]")).getText();
		System.out.println(oneColumn);
		
		System.out.println("**************************");
		
		//printing the second  4 row 
		List<WebElement> singleColumn = driver.findElements(By.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr[4]/td"));
		for (WebElement item : singleColumn) {
			System.out.println(item.getText());
		}
		
		driver.close();

	}

}
