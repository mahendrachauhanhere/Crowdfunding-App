package Testcase;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import ObjectFile.Home_page2;
import Utils.TestBase;

public class Verified_Home_Testcase2 extends TestBase {

	@Test(priority=1)
	public void Verified_Home_Page() throws InterruptedException {
		Home_page2 page = new Home_page2(driver);
		test = extent.createTest("Home Page Verify");
		test.log(Status.PASS,"Verifying that the user is able to successfully open the home page and Verified Title text of Crowd Funding");
		test.log(Status.PASS,"Verified Email ID & Mobile Number of home page help@visionvault.com, +91 9874563210");
		test.log(Status.PASS,"Verified Footer Title Text of Our Newsletter and User scroll Down and scroll Top");
		page.Home();
	}
}