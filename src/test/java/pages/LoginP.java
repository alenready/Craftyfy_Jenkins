package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class LoginP {
	
	
	
	    WebDriver driver;

	    // ================= LOCATORS =================

	    // Email input
	    By emailField = By.cssSelector("input[type='email']");

	    // Password input
	    By passwordField = By.cssSelector("input[type='password']");

	    // Sign In button
	    By signInButton = By.xpath("//button[text()='Sign In']");
	    
	 // Toast error message
	    By errorToast = By.cssSelector(".Toastify__toast--error");


	    // ================= CONSTRUCTOR =================

	    public LoginP(WebDriver driver) {
	        this.driver = driver;
	    }

	    // ================= ACTION METHODS =================

	    public void enterEmail(String email) {
	        driver.findElement(emailField).clear();
	        driver.findElement(emailField).sendKeys(email);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).clear();
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickSignIn() {
	        driver.findElement(signInButton).click();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.or(
	                ExpectedConditions.urlContains("collection"),
	                ExpectedConditions.urlContains("home")
	        ));
	    
	    }

	    public String getErrorMessage() {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        WebElement toast = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(errorToast)
	        );

	        return toast.getText();
	    }

	    public boolean isErrorMessageDisplayed() {
	        return driver.findElement(errorToast).isDisplayed();
	    }

	    
	    // One-step login action
	    public void login(String email, String password) {
	        enterEmail(email);
	        enterPassword(password);
	        clickSignIn();
	    }
	}



