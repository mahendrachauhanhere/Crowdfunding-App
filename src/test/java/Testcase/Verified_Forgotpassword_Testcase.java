package Testcase;

import org.testng.annotations.Test;
import ObjectFile.Home_page2;
import Utils.TestBase;

public class Verified_Forgotpassword_Testcase extends TestBase {

	@Test(priority = 4)
	public void Verified_Forgot_Testcase() throws InterruptedException {
		test = extent.createTest("Forgot password Page Verify");
		logger.info("Verifying that the user is able to successfully open the Forgot password page");
		Home_page2 page = new Home_page2(driver);
		page.Forgotpasswords();
	}
}