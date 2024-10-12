package TestingSelenium.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestingSelenium.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	
	WebDriver driver;
	
	public  ProductCatalogue(WebDriver driver)
	{
	   super(driver);
	   this.driver=driver;	
	   PageFactory.initElements(driver, this);
	}

	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	

	By productsBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	
	
	public List<WebElement> getproductList()
	{
		 waitForElemetToAppear(productsBy);
		return products;
	}

	public WebElement getProductByName(String productName)
	{
		WebElement prod=products.stream().filter(product -> product.findElement(By.cssSelector("b"))
				.getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		return prod;
	}

	public void addProductToCart(String productName) 
	{
		waitForElemetToAppear(productsBy);
		WebElement prod=getProductByName(productName);
		
		waitForOverlayToDisappear();
		prod.findElement(addToCart).click();
		waitForElemetToAppear(toastMessage);
		 
		// Wait for spinner to disappear
		 waitForElementToDisappear(spinner);	
	
	}


	


	

}
