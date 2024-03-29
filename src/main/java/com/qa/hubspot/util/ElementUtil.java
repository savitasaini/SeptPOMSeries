package com.qa.hubspot.util;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	
	public class ElementUtil {

		WebDriver driver;
		
		public ElementUtil(WebDriver driver){
			this.driver = driver;
		}
		/**
		 * This method is used to create the webElement on the basis of By locator
		 * @param locator
		 * @return
		 */
		
		public WebElement getElement(By locator){
			WebElement element= null;
			try{
		       element =driver.findElement(locator);
			}
			catch(Exception e){
				System.out.println("some exception occurred while clicking on the webelement....");
				System.out.println(e.getMessage());
			}
			return element;		
		}
		public void waitforElementPresent(By locator ,int timeOut){
			WebDriverWait wait = new WebDriverWait(driver,timeOut);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		}
		
		public String waitforTitlePresent(String title,int timeOut){
			WebDriverWait wait = new WebDriverWait(driver,timeOut);
			wait.until(ExpectedConditions.titleContains(title));
			return driver.getTitle();
		}
		/**
		 * This method is used to click on element.
		 * @param locator
		 */
		public void doClick(By locator){
			try{
			getElement(locator).click();
			}
			catch(Exception e){
				System.out.println("some exception occurred while clicking on the webelement....");
				System.out.println(e.getMessage());
			}
		}
		public void doActionsClick(By locator){
			try{
				Actions action = new Actions(driver);
				action.click(getElement(locator)).build().perform();	
			getElement(locator).click();
			}
			catch(Exception e){
				System.out.println("some exception occurred while clicking on the webelement....");
				System.out.println(e.getMessage());
			}
		}
		/**
		 * This method is used to pass the values in a webelement.
		 * @param locator
		 * @param value
		 */
		public void doSendKeys(By locator,String value){
			try{
			getElement(locator).sendKeys(value);
			}
			catch(Exception e){
				System.out.println("some exception occurred while passing value to  the webelement....");
				System.out.println(e.getMessage());	
			}
		}
		public void doActionSendKeys(By locator,String value){
			try{
				Actions action = new Actions(driver);
				action.sendKeys(getElement(locator),value).build().perform();
			getElement(locator).sendKeys(value);
			}
			catch(Exception e){
				System.out.println("some exception occurred while passing value to  the webelement....");
				System.out.println(e.getMessage());	
			}
		}
		

		public String doGetText(By locator){
			try{
			return getElement(locator).getText();
			}
			catch(Exception e){
				System.out.println("some exception occurred while getting the text of the webelement....");
				System.out.println(e.getMessage());
		         return null;
		
			}
		}
		
		
		public boolean isElementDisplayed(By locator){
			try{			
			getElement(locator).isDisplayed();
			return true;
			}
		   catch(Exception e){
			   System.out.println("some exception occurred while checking the element is displayed....");
				System.out.println(e.getMessage());	
		      return false;
		
		
		
		
		
		

	
		}
	}

}