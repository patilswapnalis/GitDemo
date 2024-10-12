package TestingSelenium.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestingSelenium.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	
	WebDriver driver;
	
	public  LandingPage(WebDriver driver)
	{
		//intialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail=driver.findElement(By.id("userEmail"));//.sendKeys("viratkohlivamika@gmail.com");
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;

	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public void loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
	}
	

	

	

}
