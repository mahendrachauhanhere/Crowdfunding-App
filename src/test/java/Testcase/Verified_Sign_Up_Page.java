package Testcase;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import ObjectFile.Home_page2;
import Utils.TestBase;

public class Verified_Sign_Up_Page extends TestBase {
	
	@Test(priority=3)
	public void Verified_SignUp_Page() throws InterruptedException {
		test = extent.createTest("Sign Up Page Verify");
		logger.info("Verifying that the user is able to successfully open the Sign Up page");
		test.log(Status.PASS,"Verifying that the user is able to successfully open the Sign Up page");
		test.log(Status.PASS,"Verified whether the user is redirected to the Sign-Up page and Expected 'Sign Up' text");
		test.log(Status.PASS,"First name 'Mahendra' Last name 'Chauhan' EmailID 'Mahendrac@yopmail.com' Phone '9913119043' and Password 'Test@123'");
		test.log(Status.PASS,"Verified the validation messages on the Sign-Up page.");
		Home_page2 page = new Home_page2(driver);
		page.SignUp();
	}
}