package TestCases;

import Config.TestBase;
import ExtentReportListener.ExtentManager;
import Listeners.CustomListeners;
import Pages.twitLoginPage;
import Utils.TestUtil;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.*;
import java.lang.reflect.Method;

@Listeners({CustomListeners.class})
public class TC3_twitLoginChrome  extends TestBase
{
    public static twitLoginPage twtLoginPg ;
    public static TestBase init ;
    public static TestBase extentTestbase;
    public static ExtentTest test;
    public static ExtentTest parentTest;
    public static ExtentTest childTest;

    @BeforeMethod
    public void setup(Method method) {
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
    @Test(priority = 1,testName ="TC3_twitLoginChrome--TestNGDescription :-- Log into twitter account")
    public void twitterLogin_Chrome() throws Throwable
    {
        twtLoginPg.loginToTwitterAccount("9967887510","Tcs@1983");
        ExtentManager.getTest().assignCategory("Regression");
    }
    @Test(priority = 2,testName ="TC3_twitLoginChrome--TestNGDescription :-- Navigate to twitter profile page" )
    public void navigateToProfile_Chrome() throws Throwable {
        twtLoginPg.navigateToProfile();
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
