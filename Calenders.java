package Testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Apputils;

public class Calenders extends Apputils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		utils.Apputils.launchapp("http://flights.qedgetech.com/");
	    driver.findElement(By.name("email")).sendKeys("letmecode111@gmail.com");
	    driver.findElement(By.name("password")).sendKeys("Letmecode@111");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.id("search-date")).click();
		String flydate ="12/august/2024";
	      String [] temp=	flydate.split("/");
	       String date    = temp[0];
	       String month =temp[1];
	       String year = temp[2];
	     String cylinder=  driver.findElement(By.className("ui-datepicker-year")).getText();
	       
	        while (!cylinder.equals(year)) {
				driver.findElement(By.linkText("Next")).click();
			   cylinder=  driver.findElement(By.className("ui-datepicker-year")).getText();

			}
	       
	 String monthlist=driver.findElement(By.className("ui-datepicker-month")).getText();
	  //driver.findElement(By.linkText("Next")).click();
		while (!monthlist.equalsIgnoreCase(month)) {
			driver.findElement(By.linkText("Next")).click();
			 monthlist=driver.findElement(By.className("ui-datepicker-month")).getText();
			
		}
		    WebElement dtable= driver.findElement(By.className("ui-datepicker-calendar"));
   	List<WebElement> rows =dtable.findElements(By.tagName("tr"));
     List<WebElement> clns;	
	for(int i=1;i<rows.size();i++)
	{   clns= rows.get(i).findElements(By.tagName("td"));
	for(int j=0;j<clns.size();j++)
	{
		 if (clns.get(j).getText().equals(date));
		clns.get(j).click();
	}
	} 
		
	
	}
}

