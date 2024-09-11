package ObjectFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utils.Testmethod;

public class Backend extends Testmethod {

	public Backend(WebDriver driver) {
		super(driver);
	}

	By Backendemail = By.xpath("(//input[@type='text'])");
	By Backendpassword = By.xpath("(//input[@type='password'])");
	By Backendloginbutton = By.xpath("(//button[@type='submit'])");

	public void Verified_Backend_Login() throws InterruptedException {
		Thread.sleep(2000);
		String ActualTitle = driver.getTitle();
		Thread.sleep(2000);
		String ExpectedTitle = "Login | Minimal UI";
		Thread.sleep(2000);
		Assert.assertEquals(ActualTitle, ExpectedTitle, "Title does not match the expected Title.!");
		System.out.println("Verifying that the user is able to successfully open the Backend Login page");
		System.out.println("Verified Title : " + ExpectedTitle);
		Thread.sleep(1000);
		click(Backendloginbutton);
//		setValue(Backendemail, "testdummyuser");
//		Thread.sleep(2000);
//		cleartext(Backendemail, "testdummyuser");
//		click(Backendloginbutton);
//		Thread.sleep(2000);
		setValue(Backendemail, "apoorva@yopmail.com");
		Thread.sleep(2000);
		setValue(Backendpassword, "Ips@12345");
		Thread.sleep(2000);
		click(Backendloginbutton);
		Thread.sleep(1000);
		WebElement SignUperrorMessage = driver.findElement(By.xpath("//div[@id=\"notistack-snackbar\"]"));
		
	    if (SignUperrorMessage.isDisplayed())
	    {
	            System.out.println("Test Case pass an Error message of : " + SignUperrorMessage.getText());
	       
	    }
	    else
	    {
	    	Assert.assertEquals(SignUperrorMessage + "Verified Text", SignUperrorMessage);
	    }
	}
}