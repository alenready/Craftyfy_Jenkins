package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.NavigationPage;

public class NavigationTest extends BaseTest {

	    @Test
	    public void verifyNavigationPages() {

	        NavigationPage nav = new NavigationPage(driver);

	        nav.clickCollection();
	        Assert.assertTrue(driver.getCurrentUrl().contains("collection"));

	        nav.clickAbout();
	        Assert.assertTrue(driver.getCurrentUrl().contains("about"));

	        nav.clickContact();
	        Assert.assertTrue(driver.getCurrentUrl().contains("contact"));
	    }
	}


