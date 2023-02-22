package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class VegetableTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Test Comment
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.findElement(By.xpath("//h4[text()='Cucumber - 1 Kg']/parent::div //div[@class='product-action']/button")).click();
		//driver.findElement(By.xpath("//h4[text()='Cucumber - 1 Kg']/following-sibling::div[@class='product-action']/button")).click();
		driver.findElement(By.xpath("//h4[text()='Cucumber - 1 Kg']/parent::div //button[text()='ADD TO CART']")).click();
		Thread.sleep(2000);
		
		//Navigate to Top Deals
		driver.findElement(By.linkText("Top Deals")).click();
		
		//Navigating to new Window opened for Top Deals
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		
		//Click on Page Size and select 20
		Select pageSize = new Select(driver.findElement(By.id("page-menu")));
		pageSize.selectByVisibleText("20");
		
		//Store all the veggies in an arraylist and then sort the same
		 List<WebElement> before = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));
		 ArrayList<String> beforeSort = new ArrayList<String>();
		 for (WebElement webElement : before) {
			 beforeSort.add(webElement.getText());
			
		}
		 
		 //Print the ArrayList before sorting
		 for (String string : beforeSort) {
			System.out.println(string);
		}
		 
		 //Check how ArrayList prints after sort
		 Collections.sort(beforeSort);
		
		 
		 //Check Print the ArrayList after sorting
		 for (String string : beforeSort) {
			System.out.println(string);
		}
		 
		// xpath for veg/fruit name "//span[text()='Veg/fruit name']"
		
		Thread.sleep(5000);
		driver.quit();

	}

}
