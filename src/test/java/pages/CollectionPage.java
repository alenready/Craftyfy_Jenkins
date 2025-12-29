package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class CollectionPage {

	
		
	    WebDriver driver;
	    WebDriverWait wait;

	    // Constructor
	    public CollectionPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    //  Product image (first product)
	    By productImage = By.cssSelector("img.hover\\:scale-110");

	    //  Color button (Red)
	    By redColorButton = By.xpath("//button[text()='Red']");

	    //  Add to Cart button
	    By addToCartButton = By.xpath("//button[contains(text(),'ADD TO CART')]");

	    //  Cart count icon
	    By cartCount = By.cssSelector("p.aspect-square");

	    // ================= ACTION METHODS =================

	    public void clickProduct() {
	        wait.until(ExpectedConditions.elementToBeClickable(productImage)).click();
	    }

	    public void selectRedColor() {
	        wait.until(ExpectedConditions.elementToBeClickable(redColorButton)).click();
	    }

	    public void clickAddToCart() {
	        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
	    }

	    public boolean isCartCountVisible() {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartCount))
	                   .isDisplayed();
	    }
	}

