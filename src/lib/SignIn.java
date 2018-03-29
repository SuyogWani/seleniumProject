package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Utility;

public class SignIn {
	private WebDriver selenium;
	private Utility locator;
	private WebDriverWait wait;
	
	public SignIn(WebDriver selenium, String url) {
		locator = new Utility("src/locators/locators.properties");
		this.selenium = selenium;
		wait = new WebDriverWait(selenium, 10);
		selenium.get(url);
	}
	
	public void loginUser(String userName, String password) {
		/*if(!selenium.findElement(By.xpath(locator.getProp("signInButton"))).isDisplayed()) {
			System.out.println("First sign page is not displayed");
		}*/
		
		if(!selenium.getTitle().equals("Gmail")) {
			throw new IllegalStateException("Sign Page is not found");
		}
		
		selenium.findElement(By.cssSelector(locator.getProp("emailText"))).sendKeys(userName);
		selenium.findElement(By.cssSelector(locator.getProp("nextButton"))).click();
		
		WebElement passwordText = wait.until(ExpectedConditions.visibilityOf(selenium.findElement(By.name(locator.getProp("passwordText")))));
		passwordText.sendKeys(password);
		selenium.findElement(By.cssSelector(locator.getProp("passwordNextButton"))).click();
	}
}
