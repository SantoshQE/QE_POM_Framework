package TestCases;

import Config.TestBase;
import ExtentReportListener.ExtentManager;
import Listeners.CustomListeners;
import Pages.twitLoginPage;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Listeners({CustomListeners.class})
public class TC4_SampleFlowStudy extends TestBase
{
    public static twitLoginPage twtLoginPg ;
    public static TestBase init ;
    public static TestBase extentTestbase;
    public static ExtentTest test;
    public static ExtentTest parentTest;
    public static ExtentTest childTest;
    public static ReflectionToDataDrive ReflectDD;

/*
    static
    {
        try {
            ReflectDD = new ReflectionToDataDrive("DatadrivenTest");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            ReflectDD.dataDriveTest("DatadrivenTest");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/

    @BeforeMethod
    public void setup(Method method)
    {
        System.out.println(method);
        String testMethodName = method.getName();
        String descriptiveTestName = method.getAnnotation(Test.class).testName();
        test = ExtentManager.startTest(descriptiveTestName, ExtentManager.getLabel(method.getDeclaringClass().getName()));
    }
    @BeforeTest()
    public void launchBrowser_Chrome() throws Exception {
        System.out.println(this.getClass().getName());
        System.out.println("Inside @BeforeTest --launchBrowser_Chrome ");
         ReflectDD = new ReflectionToDataDrive("TC4_SampleFlowStudy");
         ReflectDD.dataDriveTest("TC4_SampleFlowStudy");
    }
    @Test(priority = 1,testName ="TC3_twitLoginChrome--TestNGDescription :-- Log into twitter account")
    public void twitterLogin_Chrome() throws Throwable
    {
        TestBase.open_Browser("Chrome");
        System.out.println("Test Step1 -- Log into twitter account");
        ExtentManager.getTest().assignCategory("Regression");
    }
    @Test(priority = 2,testName ="TC3_twitLoginChrome--TestNGDescription :-- Navigate to twitter profile page" )
    public void navigateToProfile_Chrome() throws Throwable {
        System.out.println("Test Step2 -- Navigate to twitter profile page");
        ExtentManager.getTest().assignCategory("Regression");
    }
    @AfterTest()
    public void tearDown_Chrome()
    {
        if(driver!=null)
        {
            driver.close();
        }
    }
}
