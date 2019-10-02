package TestCases;

import Config.TestBase;
import ExtentReportListener.ExtentManager;
import Pages.twitLoginPage;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.*;
import Listeners.CustomListeners;

import java.lang.reflect.Method;

@Listeners({CustomListeners.class})
public class TC4_twitLoginIE extends TestBase
{
    public static twitLoginPage twtLoginPg;
    public static TestBase init ;
    public static TestBase extentTestbase;
    public static ExtentTest test;
    public static ExtentTest parentTest;
    public static ExtentTest childTest;
/*    public TC4_twitLoginIE(ExtentTest extentTestbase)
    {
        this.extentTestbase = extentTestbase;
    }*/
    @BeforeMethod
    public void setup(Method method)
    {
        String testMethodName = method.getName(); //This will be:verifySaveButtonEnabled
        String descriptiveTestName = method.getAnnotation(Test.class).testName(); //This will be: 'Verify if the save button is enabled'
        test = ExtentManager.startTest(descriptiveTestName, ExtentManager.getLabel(method.getDeclaringClass().getName()));
    }
    @BeforeTest
    public void launchBrowser_IE()
    {
        TestBase.open_Browser("IE");
        twtLoginPg = new twitLoginPage(driver);
        twtLoginPg.launchTwitterLoginPg("https://twitter.com/login?lang=en");
    }
    @Test(priority = 1,testName ="TC3_twitLoginChrome--TestNGDescription :-- Log into twitter account" )
    public void twitterLogin_IE() throws Throwable
    {
     //   init.test.assignCategory("Regression");
        twtLoginPg.loginToTwitterAccount("9967887510","Tcs@19831");
       // extentTestbase.assignCategory("Smoke");
    }
    @Test(priority = 2,testName ="TC3_twitLoginChrome--TestNGDescription :-- Navigate to twitter profile page")
    public void navigateToProfile_IE() throws Throwable
    {
     //   init.test.assignCategory("Regression");
      //  extentTestbase.assignCategory("Smoke");
        twtLoginPg.navigateToProfile();
    }
    @AfterTest()
    public void tearDown_IE()
    {
        driver.close();
        //extentTest.assignCategory("Smoke");
    }
}
