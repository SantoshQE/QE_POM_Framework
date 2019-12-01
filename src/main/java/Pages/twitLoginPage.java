package Pages;

import Config.TestBase;
import ObjectRepository.Twitter_OR;
import Utils.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class twitLoginPage
{
    public static WebDriver driver;
    @BeforeTest
    public void setUp()
    {
       TestBase t = new TestBase();
    }
    public twitLoginPage(WebDriver driver)
    {
        TestBase t = new TestBase();
        this.driver = t.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath =  Twitter_OR.twit_username )
    public WebElement  twit_username;
    @FindBy(xpath =  Twitter_OR.twit_password )
    public WebElement  twit_password;
    @FindBy(xpath =  Twitter_OR.twit_BtnLogin )

    public WebElement  twit_BtnLogin;
    @FindBy(xpath =  Twitter_OR.twit_BrowsePicLink )
    public WebElement  twit_BrowsePicLink;
    @FindBy(xpath =  Twitter_OR.twit_EditMediaApplyBtn )
    public WebElement  twit_EditMediaApplyBtn;
    @FindBy(xpath =  Twitter_OR.twit_HomeLink )
    public WebElement  twit_HomeLink;
    @FindBy(xpath =  Twitter_OR.twit_ExploreLink )
    public WebElement  twit_ExploreLink;
    @FindBy(xpath =  Twitter_OR.twit_NotificationsLink )
    public WebElement  twit_NotificationsLink;
    @FindBy(xpath =  Twitter_OR.twit_MessagesLink )
    public WebElement  twit_MessagesLink;
    @FindBy(xpath =  Twitter_OR.twit_BookmarksLink )
    public WebElement  twit_BookmarksLink;
    @FindBy(xpath =  Twitter_OR.twit_ListsLink )
    public WebElement  twit_ListsLink;
    @FindBy(xpath =  Twitter_OR.twit_ProfileLink )
    public WebElement  twit_ProfileLink;
    @FindBy(xpath =  Twitter_OR.twit_MoreLink )
    public WebElement  twit_MoreLink;
    @FindBy(xpath =  Twitter_OR.twit_EditProfileLink )
    public WebElement  twit_EditProfileLink;
    @FindBy(xpath =  Twitter_OR.TwitterSite )
    public WebElement TwitterSite;

    public void launchTwitterLoginPg(String uRL)
    {
        driver.get(uRL);
        try
        {
            Assert.assertTrue(driver.getTitle().contains("Twitter"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
   // @Step("navigateToProfile - twitLoginPage")
    public void navigateToProfile()
    {
      //  ExtentRp.logger = ExtentRp.extent.createTest("Navigate To Profile Link Check");
        TestUtil.highLightElement(driver,twit_ProfileLink);
     //   ExtentRp.logger.createNode("Profile Link is Present");
        //Assert.assertTrue(twit_ProfileLink.isDisplayed());
     //   ExtentRp.logger.createNode("Profile Link is NOT Present");
        try
        {
            Assert.assertTrue(twit_ProfileLink.isDisplayed());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        twit_ProfileLink.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }
   //@Step("loginToTwitterAccount - twitLoginPage with username : {0} and password : {1}")
    public void loginToTwitterAccount(String userName,String pwd)
    {
       // ExtentRp.logger = ExtentRp.extent.createTest("To verify Google Logo");
        TestUtil.highLightElement(driver,twit_username);
        twit_username.sendKeys(userName);
        TestUtil.highLightElement(driver,twit_password);
        twit_password.sendKeys(pwd);
        TestUtil.highLightElement(driver,twit_BtnLogin);
        twit_BtnLogin.click();
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        try
        {
            Assert.assertTrue(twit_HomeLink.isDisplayed());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

       // ExtentRp.logger.createNode("loginToTwitterAccount");


    }
}
