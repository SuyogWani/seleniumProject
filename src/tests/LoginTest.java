package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.SignIn;
import utilities.Utility;

public class LoginTest {
	private WebDriver driver;
	private Utility config = new Utility("src/config.properties");
	private SignIn signin;
	
	@BeforeTest
	public void setUp() {
		driver = new FirefoxDriver();
		signin = new SignIn(driver, config.getProp("URL"));
	}
	
	@Test
	public void test() {
		signin.loginUser(config.getProp("userName"), config.getProp("password"));
	}
	
	
}
