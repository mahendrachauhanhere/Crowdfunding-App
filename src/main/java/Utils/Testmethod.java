package Utils;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testmethod {

	public WebDriver driver;

	WebDriverWait wait;

	public Testmethod(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(17));
	}

	public WebElement waitVisibilityOfElement(By by) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}

	public void click(By elememt) {
		waitVisibilityOfElement(elememt).click();

	}

	public void setValue(By elememt, String text) {
		waitVisibilityOfElement(elememt).sendKeys(text);
	}
	
	public void cleartext(By elememt, String text) {
		waitVisibilityOfElement(elememt).clear();
	}

}