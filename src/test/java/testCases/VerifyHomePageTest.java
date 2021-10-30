package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Reusable.ReusableMethods;
import pajeObjects.HomePage;


public class VerifyHomePageTest extends Base{
	
	HomePage homePage = new HomePage();
	
	
	@Test(priority = -1)
	public void verifyHomePageOfApplication() throws InterruptedException
	{
		System.out.println("In verifyHomePageOfApplication method");
		closeHomePagPopUp();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(homePage.homePageTitle)));
		System.out.println("Home page verified");
	}
	
	@Test
	public void verifyAllDropDownsOfHomePage() throws InterruptedException
	{
		System.out.println("In verifyAllDropDownsOfHomePage method");
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(homePage.homePageTitle)));
		
		List<WebElement> allDrpdwnTxt = driver.findElements(homePage.AllDropDownText);
		System.out.println("size: "+allDrpdwnTxt.size());
		String [] drpdwnTxt = {"Input Forms","Date pickers","Table","Progress Bars","Alerts & Modals","List Box","Others"};
		for(int i =0; i<allDrpdwnTxt.size(); i++)
		{
			System.out.println("Dropdown text: "+allDrpdwnTxt.get(i).getText());
			Assert.assertTrue(drpdwnTxt[i].equals(allDrpdwnTxt.get(i).getText()), "The Drop down text does not match");
			
		}	
		System.out.println("verifyAllDropDownsOfHomePage last");
	}
	
	@Test
	public void abc()
	{
		
		System.out.println("In abc test");
	}

}
