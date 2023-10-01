package week1.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Chrome Driver initialisation
		ChromeDriver driver = new ChromeDriver();
		
		//loading the URL 
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//to maximize the window
		driver.manage().window().maximize();
		
		//entering the username
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		
		//entering the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//clicking the login button
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//clicking on the link CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//clicking on the accountant tab
		driver.findElement(By.linkText("Accounts")).click();
		
		//clicking on Create account tab
		driver.findElement(By.linkText("Create Account")).click();
		
		//Entering Account Name
		driver.findElement(By.id("accountName")).sendKeys("Bran@123");
		
		//entering description as Selenium Automation Tester
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		
		//select ComputerSoftware option as the industry dropdown
		WebElement industryDropDown = driver.findElement(By.name("industryEnumId"));
		Select  industry = new Select(industryDropDown);
		industry.selectByIndex(2);
		
		//selecting S-Corporation option as a ownership dropdown using SelectByVisibleText
		WebElement ownershipDropDown = driver.findElement(By.name("ownershipEnumId"));
		Select ownership = new Select(ownershipDropDown);
		ownership.selectByVisibleText("S-Corporation");
		
		//Selecting Employee option as the source dropdown using Select by value
		WebElement sourceDropDown = driver.findElement(By.id("dataSourceId"));
		Select source = new Select(sourceDropDown);
		source.selectByValue("LEAD_EMPLOYEE");
		
		//Selecting eCommerce Site Internal Campign option as the marketing campaign using SelectByIndex.
		WebElement marketingCampaign = driver.findElement(By.id("marketingCampaignId"));
		Select marketing = new Select(marketingCampaign);
		marketing.selectByIndex(5);
		
		//Selecting Texas option as the state dropdown using SelectByValue
		WebElement stateDropDown = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select state = new Select(stateDropDown);
		state.selectByValue("TX");
		
		//Clicking the Create Account Button
		driver.findElement(By.className("smallSubmit")).click();
		
		//closing the browser window
		driver.close();
		
	}

}
