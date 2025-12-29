package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage {

		    WebDriver driver;

	    By collection = By.xpath("//p[text()='COLLECTION']");
	    By about = By.xpath("//p[text()='ABOUT']");
	    By contact = By.xpath("//p[text()='CONTACT']");

	    public NavigationPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void clickCollection() {
	        driver.findElement(collection).click();
	    }

	    public void clickAbout() {
	        driver.findElement(about).click();
	    }

	    public void clickContact() {
	        driver.findElement(contact).click();
	    }
	}

	
	

