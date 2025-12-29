package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickLoginIcon() {

        WebElement loginIcon = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector("div.group img.w-5.cursor-pointer")
            )
        );

        loginIcon.click();
    }
}


