package ObjectFile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Home_page {
	public WebDriver driver;

	public Home_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//button[@type=\"button\"])[8]")
	public WebElement HomebuttonclickSignin;

	@FindBy(xpath = "//span[text()='Sign up']")
	public WebElement Signin;
	
	@FindBy(xpath = "(//button[@type=\"button\"])[13]")
	public WebElement scrolltop;

	@FindBy(xpath = "(//input[@type=\"text\"])[1]")
	public WebElement FirstName;
	
	@FindBy(xpath = "(//span[text()=\"Sign up\"])")
	public WebElement SignUp;
	
	@FindBy(xpath = "(//button[@type=\"button\"])[2]")
	public WebElement SignUpsubmitbutton;
	
	
	@FindBy(xpath = "(//button[text()=\"Sign In\"])")
	public WebElement Signinsubmitbtn;
	
	@FindBy(xpath = "(//input[@type=\"email\"])")
	public WebElement Signinemail;
	
	@FindBy(xpath = "(//input[@type=\"password\"])")
	public WebElement Signinepassword;
	
	@FindBy(xpath = "(//input[@type=\"password\"])")
	public WebElement signup;
	
	@FindBy(xpath = "(//input[@type=\"text\"])[1]")
	public WebElement FirstNamesignup;
	
	@FindBy(xpath = "(//input[@type=\"text\"])[2]")
	public WebElement LastNamesignup;
	
	@FindBy(xpath = "(//input[@type=\"email\"])")
	public WebElement Emailsignup;
	
	@FindBy(xpath = "(//input[@type=\"text\"])[3]")
	public WebElement Phonesignup;
	
	@FindBy(xpath = "(//input[@type=\"password\"])")
	public WebElement Passwordsignup;	
	
	
	public void homePage() throws InterruptedException
	{
		Thread.sleep(5000);
		String Actual_Title = driver.getTitle();
		String Expected_Title = "Crowd Funding";
		Assert.assertEquals(Actual_Title, Expected_Title);

		WebElement mobileNumberElement = driver.findElement(By.xpath("//h6[text()='+91 9874563210']"));
		WebElement emailIdElement = driver.findElement(By.xpath("//h6[text()='help@visionvault.com']"));

		String actualMobileNumber = mobileNumberElement.getText();
		String actualEmailId = emailIdElement.getText();

		String expectedMobileNumber = "+91 9874563210";
		String expectedEmailId = "help@visionvault.com";

		System.out.println("Verifying that the user is able to successfully open the home page");
		System.out.println("Verified Title : " + Actual_Title);
		System.out.println("Verified Email ID : " + actualEmailId);
		System.out.println("Verified Mobile Number : " + actualMobileNumber);

		Assert.assertEquals(actualMobileNumber, expectedMobileNumber, "Mobile number does not match!");
		Assert.assertEquals(actualEmailId, expectedEmailId, "Email ID does not match!");

		//Locate the element you want to scroll down
		WebElement down  = driver.findElement(By.xpath("(//button[@type=\"button\"])[12]")); // Adjust the locator as needed
		JavascriptExecutor jsdown = (JavascriptExecutor) driver;
		jsdown.executeScript("arguments[0].scrollIntoView(true);", down);
		
		WebElement Newsletter = driver.findElement(By.xpath("//h4[text()='Our Newsletter']"));
		String actualNewsletter= Newsletter.getText();
		String expectedNewsletter = "Our Newsletter";
		System.out.println("Verified Footer Title Text : " + expectedNewsletter);
		Assert.assertEquals(actualNewsletter, expectedNewsletter, "News letter does not match!");
		
	
		Thread.sleep(5000);
	}
	
	
}