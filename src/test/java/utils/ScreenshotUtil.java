package utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

		

	    public static String takeScreenshot(WebDriver driver, String testName) {

	        // Create timestamp (to avoid overwrite)
	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	        //  Screenshot file name
	        String screenshotName = testName + "_" + timestamp + ".png";

	        // Destination folder
	        String destinationPath = "E:\\SDET_2025\\Craftfy\\CraftyfyAutomation\\target\\Screenshot" + screenshotName;

	        //  Take screenshot
	        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	        try {
	            FileUtils.copyFile(source, new File(destinationPath));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        //  Return path (useful for reports later)
	        return destinationPath;
	    }
	}


