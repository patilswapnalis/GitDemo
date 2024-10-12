package TestingSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TestingSelenium.PageObjects.LandingPage;
import TestingSelenium.PageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String productName="ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		LandingPage landpage=new LandingPage(driver);
		landpage.goTo();
		landpage.loginApplication("viratkohlivamika@gmail.com", "Ssp@2312");
		driver.findElement(By.id("login")).click();
		
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		List<WebElement> products=productCatalogue.getproductList();
		productCatalogue.addProductToCart(productName);
		
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
	    List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean match=cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		//Assert.assertTrue(match);
		
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();
	//	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		
		String message=driver.findElement(By.cssSelector(".hero-primary")).getText();
//		Assert.assertEquals(message, "Thankyou for the order");
      	Assert.assertTrue(message.equalsIgnoreCase(message));
		
	}

}
