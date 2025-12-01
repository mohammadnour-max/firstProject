package firstproject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	String myWebsite = "https://www.saucedemo.com/";
	
	WebDriver driver= new EdgeDriver();
	
	String userName = "standard_user";
	
	String password = "secret_sauce";
	
	String firstName="Mohammad Nour"; 
	
	String lastName="Marie";
	
	String postalCode="2004";
	
	
	@BeforeMethod
	public void beforeTest() throws InterruptedException {
	   // Thread.sleep(3000);
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
	   // Thread.sleep(3000);
	}

	
	@BeforeTest
	public void mySetUp() throws InterruptedException {
		
		driver.get(myWebsite);
		
		driver.manage().window().maximize();
		
		// Wait 3 seconds for every test maximum
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	
	//login test
	@Test(priority = 1)
    public void login() {
		WebElement UserName=driver.findElement(By.id("user-name"));
		WebElement Password=driver.findElement(By.id("password"));
		WebElement buttonLogin=driver.findElement(By.id("login-button"));
		
		UserName.sendKeys(userName);
		Password.sendKeys(password);
		buttonLogin.click();
		
			
	}
	
	// check button add to cart all item and remove all item and add
	@Test (priority = 2 ,invocationCount = 3 )
      public void CheckAddAndRemoveButtons()  {
		addTocart();
		removeItem();
		
		
	}
	
	@Test (priority = 3  )
    public void addToCartButtons()  {
		addTocart();
		
		
		
	}
	
	// checkout test
	@Test(priority=4)
	public void checkout()  {
         
		
		driver.navigate().to("https://www.saucedemo.com/cart.html");

		WebElement checkoutButton =driver.findElement(By.id("checkout"));
		checkoutButton.click();
		
		WebElement firstNameElement =driver.findElement(By.id("first-name"));
		WebElement lastNameElement =driver.findElement(By.id("last-name"));
		WebElement postalCodeElement=driver.findElement(By.id("postal-code"));
		WebElement continueButton=driver.findElement(By.id("continue"));
		
		firstNameElement.sendKeys(firstName);
		lastNameElement.sendKeys(lastName);
		postalCodeElement.sendKeys(postalCode);
		continueButton.click();
		
		WebElement finishButton=driver.findElement(By.id("finish"));
		finishButton.click();
		
		
	}
	
	// back home and logout
	@Test(priority = 5)
	public void backHomeAndLogout() throws InterruptedException {
		// Button for Back Home and clicked
		WebElement backHomeButton=driver.findElement(By.id("back-to-products"));
		backHomeButton.click();

		// Button for list and clicked 
		WebElement listButton=driver.findElement(By.id("react-burger-menu-btn"));
		listButton.click();
		Thread.sleep(1000);
		// Button for logout and clicked 
		WebElement logoutButton=driver.findElement(By.id("logout_sidebar_link"));
		logoutButton.click();
		
	}
	
	
	
	@AfterTest
    public void AfterMyTest() {
     driver.close();		
	}
	
	//method for add for all 
	
	  public void addTocart() {
		
	  
		//Add to cart button dynamic for all buttons (add to cart) 
		
	  List <WebElement> addToCartButtons=driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory")) ;// Buttons add الاشي المشترك بين كل ال  
	    
    for(int i=0;i<addToCartButtons.size();i++) {
	      
      addToCartButtons.get(i).click();
 
       }

    
    }
    
	//method for remove all
	  
    public void removeItem() {
	   
	   List <WebElement> removeItemButtons=driver.findElements(By.className("btn_secondary")); // Buttons remove الاشي المشترك بين كل ال
	   
	   for(int i=0;i<removeItemButtons.size();i++) {
		   
		   removeItemButtons.get(i).click();
	   }
	  
 }
	
}
