package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class BaseTest {

	
	    public WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get(ConfigReader.get("url"));
	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        //driver.get("https://craftyfy-frontend.vercel.app/");
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}
	
	
	

