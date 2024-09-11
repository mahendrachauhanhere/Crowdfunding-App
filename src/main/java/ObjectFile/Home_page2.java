package ObjectFile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utils.Testmethod;

public class Home_page2 extends Testmethod {

	public Home_page2(WebDriver driver) {
		super(driver);
	}

	
			
	By HomebuttonclickSignin = By.xpath("(//button[@type='button'])[8]");
	By clickSigninbutton = By.xpath("(//button[@type='button'])[2]");
	By scrolltop = By.xpath("(//button[@type=\"button\"])[13]");
	By Emailsignin = By.xpath("(//input[@type=\"email\"])");
	By Passwordsignin = By.xpath("(//input[@type=\"password\"])");

	By SignupURLclick = By.xpath("//span[text()=\"Sign up\"]");
	
	By SignupURLclickforgot = By.xpath("(//span[text()='Sign in'])");

	
	By FirstName = By.xpath("(//input[@type='text'])[1]");
	By LastName = By.xpath("(//input[@type='text'])[2]");
	By Emailsignup = By.xpath("(//input[@type='email'])");
	By Phonesignup = By.xpath("(//input[@type='text'])[3]");
	By Passwordsignup = By.xpath("(//input[@type='password'])");

	By ForgotpasswordURL = By.xpath("//h6[text()='Forgot Password ?']");
	By ForgotSigninbutton = By.xpath("(//button[@type='button'])[8]");
	By Emailforgot = By.xpath("(//input[@type='email'])");

	By Forgotsubmitbtn = By.xpath("(//button[@type='submit'])");
	
	By Forgotggle = By.xpath("(//button[@type=\"button\"])[1]");

	
	public void Home() throws InterruptedException {
		Thread.sleep(2000);
		String ActualTitle = driver.getTitle();
		Thread.sleep(2000);
		String ExpectedTitle = "Crowd Funding";
		Thread.sleep(2000);
		Assert.assertEquals(ActualTitle, ExpectedTitle, "Title does not match the expected Title.!");

		Thread.sleep(2000);
		WebElement mobileNumberElement = driver.findElement(By.xpath("//h6[text()='+91 9874563210']"));
		WebElement emailIdElement = driver.findElement(By.xpath("//h6[text()='help@visionvault.com']"));

		String actualMobileNumber = mobileNumberElement.getText();
		Thread.sleep(2000);
		String actualEmailId = emailIdElement.getText();
		Thread.sleep(2000);

		String expectedMobileNumber = "+91 9874563210";
		String expectedEmailId = "help@visionvault.com";

		System.out.println("Verifying that the user is able to successfully open the home page");
		System.out.println("Verified Title : " + ActualTitle);
		System.out.println("Verified Email ID : " + actualEmailId);
		System.out.println("Verified Mobile Number : " + actualMobileNumber);

		Assert.assertEquals(actualMobileNumber, expectedMobileNumber, "Mobile number does not match!");
		Assert.assertEquals(actualEmailId, expectedEmailId, "Email ID does not match!");

		// Locate the element you want to scroll down
		WebElement down = driver.findElement(By.xpath("(//button[@type=\"button\"])[12]")); // Adjust the locator as
																							// needed
		JavascriptExecutor jsdown = (JavascriptExecutor) driver;
		jsdown.executeScript("arguments[0].scrollIntoView(true);", down);

		WebElement Newsletter = driver.findElement(By.xpath("//h4[text()='Our Newsletter']"));
		String actualNewsletter = Newsletter.getText();
		String expectedNewsletter = "Our Newsletter";
		System.out.println("Verified Footer Title Text for user scroll Down : " + expectedNewsletter);
		Assert.assertEquals(actualNewsletter, expectedNewsletter, "News letter does not match!");
		Thread.sleep(5000);
		click(scrolltop);

	}

	public void SignIn() throws InterruptedException {
		Thread.sleep(1000);
		click(HomebuttonclickSignin);
		//Thread.sleep(1000);
		click(clickSigninbutton);
		//Thread.sleep(1000);
		WebElement Welcome  = driver.findElement(By.xpath("(//h4[text()='Welcome Back'])"));
		String actualWelcome  = Welcome .getText();
		String expectedWelcome = "Welcome Back";
		System.out.println("Verified whether the user is redirected to the Sign-Up page or not : "  + expectedWelcome);
		Assert.assertEquals(actualWelcome, expectedWelcome, "Verified message does not match!");
		//Thread.sleep(1000);
		WebElement Email = driver.findElement(By.xpath("(//p[text()=\"Email can't be empty !\"])"));
		//Thread.sleep(1000);
		String actualEmail= Email.getText();
		//Thread.sleep(1000);
		String expectedEmail = "Email can't be empty !";
		//Thread.sleep(1000);
		WebElement Password = driver.findElement(By.xpath("(//p[text()=\"Password can't be empty !\"])"));
		//Thread.sleep(1000);
		String actualPassword= Password.getText();
		//Thread.sleep(1000);
		String expectedPassword= "Password can't be empty !";
		//Thread.sleep(3000);
		System.out.println("User click without enter input detail, Verified validation message :  "+" Verified Email : "  + expectedEmail + " Verified Password : " + expectedPassword);
		//Thread.sleep(1000);
		Assert.assertEquals(actualEmail, expectedEmail, "Verified Email validation message does not match!");
		Assert.assertEquals(actualPassword, expectedPassword, "Verified Email validation message does not match!");
		Thread.sleep(1000);
		setValue(Emailsignin, "Testerqa@yopmail.com");
		Thread.sleep(1000);
		setValue(Passwordsignin, "Admin@123");
		Thread.sleep(1000);
		click(Forgotggle);
		Thread.sleep(1000);
		click(Forgotggle);
		click(clickSigninbutton);
		Thread.sleep(1000);
		
		/*
		 * WebElement errorMessage =
		 * driver.findElement(By.xpath("//div[@class=\"notistack-CollapseWrapper\"]"));
		 * Thread.sleep(5000); if (errorMessage.isDisplayed()) {
		 * System.out.println("The test case failed due to invalid credentials: " +
		 * errorMessage.getText()); } else { System.out.
		 * println("Test Case Passed: The user was able to log in successfully."); }
		 */

	}

	public void SignUp() throws InterruptedException {
		click(SignupURLclick);
		Thread.sleep(1000);
		click(clickSigninbutton);
		Thread.sleep(1000);
		setValue(FirstName, "Mahendra");
		Thread.sleep(1000);
		setValue(LastName, "Chauhan");
		Thread.sleep(1000);
		setValue(Emailsignup, "Mahendrac@yopmail.com");
		Thread.sleep(1000);
		setValue(Phonesignup, "9913119043");
		Thread.sleep(1000);
		setValue(Passwordsignup, "Test@123");
		Thread.sleep(2000);
		click(clickSigninbutton);
	}

	public void Forgotpasswords() throws InterruptedException {
		Thread.sleep(1000);
		click(SignupURLclickforgot);
		Thread.sleep(1000);
		click(ForgotpasswordURL);
		Thread.sleep(1000);
		setValue(Emailforgot, "Mahendrac@yopmail.com");
		Thread.sleep(1000);
		click(Forgotsubmitbtn);
		Thread.sleep(2000);
	}
}