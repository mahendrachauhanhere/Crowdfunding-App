package Testcase;

import org.testng.annotations.Test;

import ObjectFile.Backend;
import Utils.TestBase;

public class Verified_Sign_In_Backend extends TestBase {

	@Test
	public void Backend_Login() throws InterruptedException {
		Backend Backendpage = new Backend(driver);
		Backendpage.Verified_Backend_Login();
	}
}