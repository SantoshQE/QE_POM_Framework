package TestCases;

import Config.TestBase;
import ExtentReportListener.ExtentManager;
import Pages.twitLoginPage;
import org.testng.annotations.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import com.aventstack.extentreports.ExtentTest;
import Listeners.CustomListeners;
import TestCases.ReflectionToDataDrive;
import static TestCases.TC3_twitLoginChrome.twtLoginPg;

@Listeners({CustomListeners.class})
public class DatadrivenTest extends TestBase
{
    public static ReflectionToDataDrive ReflectDD;
    public static ExtentTest test;

    @BeforeMethod(description = "This is used to pass testname,description to extent report")
    public void setup(Method method)
    {
        String testMethodName = method.getName();
        String descriptiveTestName = method.getAnnotation(Test.class).testName();
        test = ExtentManager.startTest(descriptiveTestName, ExtentManager.getLabel(method.getDeclaringClass().getName()));
    }
    @BeforeTest(description="BeforeTest")
    public void startUp() throws Exception
    {
        ReflectDD = new ReflectionToDataDrive("DatadrivenTest");
        ReflectDD.dataDriveTest("DatadrivenTest");
    }
    @Test(priority = 1,testName ="TC3_twitLoginChrome--TestNGDescription :-- Log into twitter account")
    public void twitterLogin_Chrome() throws Throwable
    {
        TestBase.open_Browser("Chrome");
        System.out.println("twitterLogin_Chrome");
        ExtentManager.getTest().assignCategory("Regression");
    }
    @Test(priority = 2,testName ="TC3_twitLoginChrome--TestNGDescription :-- Navigate to twitter profile page" )
    public void navigateToProfile_Chrome() throws Throwable {
        System.out.println("navigateToProfile_Chrome");
        ExtentManager.getTest().assignCategory("Regression");
    }
     @AfterTest(description="AfterTest")
    public void testDown()
    {
        System.out.println("testDown..");
        if(driver!=null)
        {
            driver.close();
        }
    }
}
