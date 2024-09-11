package Testcase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ObjectFile.Home_page;
import Utils.TestBase;

public class Verified_Home_Testcase extends TestBase {
	
	public Home_page loginpage;
	
	@Test (priority=1)
	public void Verified_Home_Page() throws InterruptedException {
		loginpage = new Home_page(driver);
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
		
		loginpage.scrolltop.click();
		Thread.sleep(5000);
	}
	
	@Test(priority=2)
	public void Verified_Sign_Up_Page() throws InterruptedException
	{
		loginpage.HomebuttonclickSignin.click();
		Thread.sleep(5000);
		loginpage.Signinsubmitbtn.click();
		Thread.sleep(5000);
		
		WebElement Email = driver.findElement(By.xpath("//p[text()='Email can't be empty !']"));
		String actualEmail= Email.getText();
		String expectedEmail = "Email can't be empty !";
		
		WebElement Password = driver.findElement(By.xpath("//p[text()='Password can't be empty !']"));
		String actualPassword= Password.getText();
		String expectedPassword= "Password can't be empty !";
		
		System.out.println("User click without enter input detail, Verified validation message :  "+" Verified Email : "  + expectedEmail + " Verified Password : " + expectedPassword);
	
		Assert.assertEquals(actualEmail, expectedEmail, "Verified Email validation message does not match!");
		Assert.assertEquals(actualPassword, expectedPassword, "Verified Email validation message does not match!");
		Thread.sleep(3000);
		loginpage.Signinemail.sendKeys("Testuser@");
		Thread.sleep(4000);
		loginpage.Signinepassword.sendKeys("Admin");
		
		loginpage.Signinsubmitbtn.click();
		Thread.sleep(5000);

		loginpage.Signinemail.sendKeys(Keys.CONTROL + "a");
		loginpage.Signinepassword.sendKeys(Keys.BACK_SPACE);
	   // loginpage.Signinemail.clear();
	    Thread.sleep(5000);
	    //loginpage.Signinepassword.clear();
	    //Thread.sleep(5000);
	    loginpage.Signinemail.sendKeys("Testuser@yopmail.com");
	    Thread.sleep(5000);
		loginpage.Signinepassword.sendKeys("Admin@123");
		Thread.sleep(5000);
		loginpage.Signinsubmitbtn.click();
		Thread.sleep(4000);
		
//		WebElement errorofinvalidMessage = driver.findElement(By.xpath("(//div[@id=\"notistack-snackbar\"])"));
//		Thread.sleep(4000);
//        if (errorofinvalidMessage.isDisplayed())
//        {
//            System.out.println("Test Case Passed: Error message displayed for invalid credentials: " + errorofinvalidMessage.getText());
//        }
//        else
//        {
//            System.out.println("Enter valid login credentials");
//        }
	}
	
	@Test(priority=3)
	public void Verified_Sign_In_Page() throws InterruptedException
	{
		Thread.sleep(4000);
		loginpage.Signin.click();
		Thread.sleep(4000);
		loginpage.SignUpsubmitbutton.click();
		Thread.sleep(4000);
		
		WebElement FirstName = driver.findElement(By.xpath("//p[text()=\"First Name can't be empty !\"]"));
		String actualFirstName = FirstName.getText();
		String expectedFirstName= "First Name can't be empty !";
		System.out.println("User click without enter input detail, Verified validation message for Sign Up Page : "  + expectedFirstName);
		Assert.assertEquals(actualFirstName, expectedFirstName, "Verified Email validation message does not match!");

		Thread.sleep(4000);
		loginpage.FirstName.sendKeys("Mahendra");
		Thread.sleep(4000);
		loginpage.LastNamesignup.sendKeys("chauhan");
		Thread.sleep(4000);
		loginpage.Emailsignup.sendKeys("mahednraqa@yopmail.com");
		Thread.sleep(4000);
		loginpage.Phonesignup.sendKeys("9632587410");
		Thread.sleep(4000);
		loginpage.Passwordsignup.sendKeys("Admin@123");
		Thread.sleep(5000);
		loginpage.SignUpsubmitbutton.click();
		Thread.sleep(3000);
	    WebElement SignUperrorMessage = driver.findElement(By.xpath("//div[@id=\"notistack-snackbar\"]"));
	    if (SignUperrorMessage.isDisplayed())
	    {
	            System.out.println("Test Case Fail an Error message of : " + SignUperrorMessage.getText());
	    }
	    else
	    {
	        	System.out.println("The user successfully has been sign up");
	    }
	    Assert.assertEquals(SignUperrorMessage + "Verified Text", SignUperrorMessage);
	}
}