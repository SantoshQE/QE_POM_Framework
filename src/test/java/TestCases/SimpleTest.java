package TestCases;

import Config.TestBase;
import ExtentReportListener.ExtentManager;
import Pages.twitLoginPage;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.*;
import Listeners.CustomListeners;

import java.lang.reflect.Method;

@Listeners({CustomListeners.class})
public class SimpleTest extends TestBase
{
    private String param = "";
    public static twitLoginPage twtLoginPg ;
    public static TestBase init ;
    public static TestBase extentTestbase;
    public static ExtentTest test;
    public static ExtentTest parentTest;
    public static ExtentTest childTest;

    public SimpleTest(String param)
    {
        this.param = param;
    }

/*
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before SimpleTest class executed.");
    }
*/
    @BeforeMethod
    public void setup(Method method) {
        System.out.println(method);
        String testMethodName = method.getName();
        String descriptiveTestName = method.getAnnotation(Test.class).testName();
        test = ExtentManager.startTest(descriptiveTestName, ExtentManager.getLabel(method.getDeclaringClass().getName()));
    }
    @BeforeTest()
    public void launchBrowser_Chrome()
    {
        System.out.println(this.getClass().getName());
        System.out.println("Inside @BeforeTest --launchBrowser_Chrome ");
        TestBase.open_Browser("Chrome");
        twtLoginPg = new twitLoginPage(driver);
        twtLoginPg.launchTwitterLoginPg("https://twitter.com/login?lang=en");
    }
    @Test(priority = 1,testName = "Method1")
    public void testMethod1() {
        System.out.println("testMethod1 parameter value is: " + param);
    }
    @Test(priority = 2,testName = "Method2")
    public void testMethod2() {
        System.out.println("testMethod2 parameter value is: " + param);
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
