package week1.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookLogin {
	public static void main(String[] args) {
		
		//Initializing Chrome Driver
		ChromeDriver driver = new ChromeDriver();
		
		//getting the facebook login page
		driver.get("https://en-gb.facebook.com/");
		
		//maximizing the window
		driver.manage().window().maximize();
		
		//implicit wait until 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Clicking on the Create new account button
		driver.findElement(By.linkText("Create new account")).click(); 
		
		//entering the first name
		driver.findElement(By.name("firstname")).sendKeys("Ishan");
		
		//entering the surname
		driver.findElement(By.name("lastname")).sendKeys("Advik");
		
		//entering mobile number
		driver.findElement(By.name("reg_email__")).sendKeys("987654321");
		
		//entering the password
		driver.findElement(By.id("password_step_input")).sendKeys("Ishibhu@1");
		
		//entering dateofbirth date
		WebElement dateDropDown = driver.findElement(By.name("birthday_day"));
		Select date = new Select(dateDropDown);
		date.selectByValue("17");
		
		//entering dateofbirth month
		WebElement monthDropDown = driver.findElement(By.name("birthday_month"));
		Select month = new Select(monthDropDown);
		month.selectByVisibleText("Jun");
		
		//entering dateofbirth year
		WebElement yearDropDown = driver.findElement(By.name("birthday_year"));
		Select year = new Select(yearDropDown);
		year.selectByIndex(1);
		
		//selecting female as a gender preference
		driver.findElement(By.xpath("//input[@value='1']")).click();
		
		//closing window
		driver.close();
	}

}
