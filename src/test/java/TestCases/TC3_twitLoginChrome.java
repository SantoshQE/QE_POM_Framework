package TestCases;

import Config.TestBase;
import ExtentReportListener.ExtentManager;
import Listeners.CustomListeners;
import Pages.twitLoginPage;
import com.aventstack.extentreports.ExtentTest;
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
    //private JUnitTestRunner ExtentManager;

    @BeforeMethod
    public void setup(Method method) {
        String testMethodName = method.getName(); //This will be:verifySaveButtonEnabled
        String descriptiveTestName = method.getAnnotation(Test.class).testName(); //This will be: 'Verify if the save button is enabled'
        test = ExtentManager.startTest(descriptiveTestName, ExtentManager.getLabel(method.getDeclaringClass().getName()));
    }
    @BeforeTest()
    public void launchBrowser_Chrome()
    {
        System.out.println("Inside @BeforeTest --launchBrowser_Chrome ");
        TestBase.open_Browser("Chrome");
        twtLoginPg = new twitLoginPage(driver);
        twtLoginPg.launchTwitterLoginPg("https://twitter.com/login?lang=en");
//        ExtentManager.getTest().log(Status.INFO,"launchBrowser_Chrome");
    // extentTestbase.assignCategory("Regression");
      //  init = new TestBase();
    }
    @Test(priority = 1,testName ="TC3_twitLoginChrome--TestNGDescription :-- Log into twitter account" )
    public void twitterLogin_Chrome() throws Throwable
    {
       // init.test.assignCategory("Smoke");
//        extentTest.assignCategory("Regression");
        //parentTest = report.createTest("Parent Test --twitterLogin_Chrome");
        //childTest = ExtentManager.getTest().createNode("Log into twitter application");
        //childTest = parentTest.createNode("Log into twitter application");
        //childTest.log(Status.PASS, MarkupHelper.createLabel("Twitter login successful", ExtentColor.BLUE));
        twtLoginPg.loginToTwitterAccount("9967887510","Tcs@1983");
       //extent = ExtentManager.getTest().assignCategory();
      //  ExtentManager.getTest().assignCategory("PositiveTests");

    }
    @Test(priority = 2,testName ="TC3_twitLoginChrome--TestNGDescription :-- Navigate to twitter profile page" )
    public void navigateToProfile_Chrome() throws Throwable {
       // init.test.assignCategory("Smoke");
     //   extentTest.assignCategory("Regression");
        twtLoginPg.navigateToProfile();
       // parentTest = report.createTest("Parent Test --navigateToProfile");
      //  childTest = parentTest.createNode("Navigate To profile Link");
       // childTest.log(Status.PASS, MarkupHelper.createLabel("Profile page navigate", ExtentColor.BLUE));
       // ExtentManager.getTest().assignCategory("PositiveTests");
    }
    @AfterTest()
    public void tearDown_Chrome()
    {
        //init.test.assignCategory("Smoke");
        driver.close();
       // extentTest.assignCategory("Regression");
      //  ExtentManager.getTest().log(Status.INFO,"tearDown_Chrome");
    }
}
