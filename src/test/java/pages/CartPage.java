package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//
//public class CartPage {
//
//	
//	    WebDriver driver;
//
//	    public CartPage(WebDriver driver) {
//	        this.driver = driver;
//	    }
//
//	    // Cart count badge
//	    By cartBadge = By.cssSelector("p.aspect-square");
//
//	    public boolean isItemAddedToCart() {
//	        return driver.findElement(cartBadge).isDisplayed();
//	    }
//	}


public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ================= LOCATORS =================

    // Cart icon (to open cart)
    By cartIcon = By.cssSelector("p.aspect-square");

    // Product row inside cart
    By cartItem = By.cssSelector("div.flex.items-center");

    // Increase quantity (+)
    By increaseQtyBtn = By.xpath("//button[contains(text(),'+')]");

    // Decrease quantity (-)
    By decreaseQtyBtn = By.xpath("//button[contains(text(),'-')]");

    // Quantity text
    By quantityText = By.cssSelector("span.font-light");

    // Remove item button
    By removeBtn = By.xpath("//button[contains(text(),'Remove')]");

    // Empty cart message
    By emptyCartMsg = By.xpath("//*[contains(text(),'Your cart is empty')]");

    // ================= ACTION METHODS =================

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    public boolean isItemVisibleInCart() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem))
                   .isDisplayed();
    }

    public int getQuantity() {
        String qty = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityText))
                         .getText();
        return Integer.parseInt(qty);
    }

    public void increaseQuantity() {
        wait.until(ExpectedConditions.elementToBeClickable(increaseQtyBtn)).click();
    }

    public void decreaseQuantity() {
        wait.until(ExpectedConditions.elementToBeClickable(decreaseQtyBtn)).click();
    }

    public void removeItem() {
        wait.until(ExpectedConditions.elementToBeClickable(removeBtn)).click();
    }

    public boolean isCartEmpty() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMsg))
                   .isDisplayed();
    }

	
}
