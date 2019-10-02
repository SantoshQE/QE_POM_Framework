package Config;

import ExtentReportListener.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;*/

public class TestBase
{
    /*
     * WebDriver - done Properties - done Logs - log4j jar, .log,
     * log4j.properties, Logger ExtentReports DB Excel Mail ReportNG,
     * ExtentReports Jenkins
     *
     */
    public static WebDriver driver;
    public static Properties prop;
    public  static EventFiringWebDriver e_driver;
   // public static WebEventListener eventListener;
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public  static DesiredCapabilities DCap;
    public ExtentReports report = ExtentManager.getInstance();
   // public ExtentManager logger;
   // public static ExtentTest extentTestbase;

/*    public TestBase(WebDriver driver)
    {
        this.driver = driver;
    }*/
    public static WebDriver getDriver()
    {
        return driver;
    }

    public static void open_Browser(String browserName)
    {
        try {
            System.out.printf("Opening %s browser.\n", browserName);
/*            if ("firefox".equalsIgnoreCase(browserName)) {
                log.debug("inside FireFox driver initialization step");
                System.setProperty("webdriver.gecko.driver", "./Configuration File/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
              //  driver.get(uRL);
            } else */
            if ("chrome".equalsIgnoreCase(browserName))
            {
                log.debug("inside chrome driver initialization step");
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir").toString() + "/src/main/resources/ChromeDriver/Chrome76/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
              driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            }
            else if ("ie".equalsIgnoreCase(browserName))
            {
                log.debug("inside IE driver initialization step");
                InternetExplorerOptions options = new InternetExplorerOptions();
                options.introduceFlakinessByIgnoringSecurityDomains();
                options.requireWindowFocus();
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir").toString() +"/src/main/resources/IEDriver/IEDriverServer.exe");
                driver = new InternetExplorerDriver(options);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

/*
    //@Parameters("browser")
    public static void initialization(){
        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir").toString()+"/src/main/resources/ChromeDriver/Chrome76/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("FF")){
            System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");
            driver = new FirefoxDriver();
        }*/
    @AfterSuite
    public void tearDown()
    {
        if (driver != null)
        {
            driver.quit();
        }
        log.debug("test execution completed !!!");
       // report.flush();
    }
   // @BeforeClass
    public void initializeTestBaseSetup(String browserName)
    {
        try
        {
            open_Browser(browserName);
        } catch (Exception e)
        {
            System.out.println("Error....." + e.getStackTrace());
        }
    }
}





