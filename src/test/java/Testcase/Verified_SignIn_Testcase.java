package Testcase;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import ObjectFile.Home_page2;
import Utils.TestBase;

public class Verified_SignIn_Testcase extends TestBase {
	
	@Test(priority=2)
	public void Verified_Sign_In_Page() throws InterruptedException {
		test = extent.createTest("Sign In Page Verify");
		logger.info("Verifying that the user is able to successfully open the Sign In page");
		test.log(Status.PASS,"Verified whether the user is redirected to the Sign-Up page or not Expected Welcome text");
		test.log(Status.PASS,"Email ID send as a help@visionvault.com");
		test.log(Status.PASS,"Password send as a Test123");
		test.log(Status.PASS,"Verified that the user is able to log in successfully and is redirected to the page.");
		Home_page2 page = new Home_page2(driver);
		page.SignIn();
	}
}