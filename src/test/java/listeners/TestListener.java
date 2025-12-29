package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utils.ScreenshotUtil;

	


	public class TestListener implements ITestListener {

	    @Override
	    public void onTestFailure(ITestResult result) {

	        // Get test class instance
	        Object testClass = result.getInstance();
	        BaseTest baseTest = (BaseTest) testClass;

	        // Capture screenshot
	        String screenshotPath = ScreenshotUtil.takeScreenshot(
	                baseTest.driver,
	                result.getMethod().getMethodName()
	        );

	      //  System.out.println("Screenshot saved at: " + "E:\\SDET_2025\\Craftfy\\CraftyfyAutomation\\target\\Screenshot");
	        System.out.println("Screenshot saved at: " + "E:\\SDET_2025\\Craftyfy_Project\\target\\Screenshot");
	        
	        
	    }

	    @Override
	    public void onTestStart(ITestResult result) {}

	    @Override
	    public void onTestSuccess(ITestResult result) {}

	    @Override
	    public void onTestSkipped(ITestResult result) {}

	    @Override
	    public void onStart(ITestContext context) {}

	    @Override
	    public void onFinish(ITestContext context) {}
	}


