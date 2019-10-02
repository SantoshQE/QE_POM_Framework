package Listeners;

import Config.TestBase;
import ExtentReportListener.ExtentManager;
import Utils.TestUtil;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.*;

import java.io.IOException;
import java.lang.reflect.Method;
/*import TestUtil.MonitoringMail;
import com.w2a.utilities.TestConfig;*/

public class CustomListeners extends TestBase implements ITestListener,ISuiteListener {
    public 	String messageBody;
    public static TestUtil TUtil;
    public static String screenshotPath;
    public static ExtentTest extentTestbase;
    // private ExtentTest test;
   @Override
   public void onTestSuccess(ITestResult arg0)
   {
       ExtentManager.getTest().info(MarkupHelper.createLabel(arg0.getMethod().getQualifiedName(), ExtentColor.INDIGO));
       System.out.println("Entered the onTestSuccess method...");
       ExtentManager.getTest().log(Status.PASS, "Test passed for Test Method "+arg0.getName().toUpperCase());
       try
       {
           screenshotPath = TestUtil.captureScreenshotBASE64(arg0.getName().toUpperCase().toString());
       } catch (IOException | InterruptedException e)
       {
           e.printStackTrace();
       }
       ExtentManager.getTest().log(Status.INFO, "Please refer below Snapshot for TestMethod : " + arg0.getName().toUpperCase());
       ExtentManager.getTest().log(Status.INFO, " "+ExtentManager.getTest().addScreenCaptureFromBase64String(screenshotPath.toString()));
       //report.flush();
   }
    @Override
    public void onTestFailure(ITestResult arg0)
    {
        ExtentManager.getTest().info(MarkupHelper.createLabel(arg0.getMethod().getQualifiedName(), ExtentColor.RED));
        System.out.println("Entered the onTestFailure method...");
        ExtentManager.getTest().log(Status.FAIL, "Test Failed");
        System.setProperty("org.uncommons.reportng.escape-output","false");
        try {
            screenshotPath = TestUtil.captureScreenshotBASE64(arg0.getName().toUpperCase().toString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        ExtentManager.getTest().log(Status.FAIL, arg0.getName().toUpperCase()+" Failed with exception : "+arg0.getThrowable().getMessage().substring(0,arg0.getThrowable().getMessage().toString().indexOf("For documentation on this error")));
        // System.out.println(screenshotPath);
        ExtentManager.getTest().log(Status.FAIL, "Please refer below Snapshot: " + ExtentManager.getTest().addScreenCaptureFromBase64String(screenshotPath.toString()));
        // report.flush();
    }
    @Override
    public void onFinish(ITestContext arg0)
    {
        System.out.println("Entered the onFinish -- ITestContext -- method...");
        ExtentManager.endTest();
        ExtentManager.getInstance().flush();
    }
    @Override
    public void onFinish(ISuite arg0) {
        System.out.println("Entered the onFinish -- ISuite -- method...");
/*        MonitoringMail mail = new MonitoringMail();
        try {
            messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
                    + ":8080/job/DataDrivenLiveProject/Extent_Reports/";
        } catch (UnknownHostException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        //  report.flush();
        report.flush();
    }
    @Override
    public void onStart(ITestContext arg0)
    {
        System.out.println("Entered the onStart -- ITestContext -- method...");
      //  extentTestbase = report.createTest(arg0.getName().toUpperCase());
        // TODO Auto-generated method stub
    }
    @Override
    public void onStart(ISuite arg0) {
        System.out.println("Entered the onStart -- ISuite -- method...");
        // TODO Auto-generated method stub
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        System.out.println("Entered the onTestFailedButWithinSuccessPercentage method...");
        // TODO Auto-generated method stub
    }
    //@Override
    public void onTestStart(ITestResult arg0, Method method) {
        System.out.println("Entered the onTestStart method...");
        ExtentManager.startTest(arg0.getMethod().getMethodName(), ExtentManager.getLabel(method.getDeclaringClass().getName()));
        // extentTest = report.createTest(arg0.getName().toUpperCase());
    }
    @Override
    public void onTestSkipped(ITestResult arg0)
    {
        System.out.println("Entered the onTestSkipped method...");
        extentTestbase.log(Status.SKIP, arg0.getName().toUpperCase()+" Skipped the test");
      //  report.endTest(test);
       // report.flush();
    }
}
