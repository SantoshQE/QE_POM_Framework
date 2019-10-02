package Pages;

import ObjectRepository.Phptravels_OR;
import Utils.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

//import org.junit.Assert;

public class phpTravelsLoginPage
{
    public static WebDriver driver;
    public phpTravelsLoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = Phptravels_OR.phpTravels_btnLogin )
    public WebElement phpTravels_btnLogin;
    @FindBy(id = Phptravels_OR.phpTravels_UserName )
    public WebElement phpTravels_UserName;
    @FindBy(id = Phptravels_OR.phpTravels_Pwd )
    public WebElement phpTravels_Pwd;
    @FindBy(css = Phptravels_OR.phpTravels_CaptchCheckBox )
    public WebElement phpTravels_CaptchCheckBox;
    @FindBy(id = Phptravels_OR.phpTravels_btnLogin2 )
    public WebElement phpTravels_btnLogin2;
    @FindBy(xpath = Phptravels_OR.phpTravels_btnLogout )
    public WebElement phpTravels_btnLogout;
    @FindBy(name = Phptravels_OR.phpTravels_AdminUserName )
    public WebElement phpTravels_AdminUserName;
    @FindBy(name = Phptravels_OR.phpTravels_AdminPwd )
    public WebElement phpTravels_AdminPwd;
    @FindBy(xpath = Phptravels_OR.phpTravels_btnAdminLogin )
    public WebElement phpTravels_btnAdminLogin;
   @FindBy(xpath = Phptravels_OR.phpTravels_AdminLogout )
    public WebElement phpTravels_AdminLogout;
    @FindBy(xpath = Phptravels_OR.phpTravels_AdminDashboard )
    public WebElement phpTravels_AdminDashboard;
    @FindBy(xpath = Phptravels_OR.phpTravels_AdminUpdates )
    public WebElement phpTravels_AdminUpdates;

    public void launchPhpTravelSite(String uRL)
    {
        driver.get(uRL);
    }
    public void phpTravelsLogin(String userName, String pwd)
    {
      //  phpTravels_btnLogin.click();
        phpTravels_UserName.sendKeys(userName);
        phpTravels_Pwd.sendKeys(pwd);
        System.out.println(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        phpTravels_CaptchCheckBox.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        phpTravels_btnLogin2.click();
    }
    public void phpTravelsAdminLogin(String userName, String pwd)
    {
        TestUtil.highLightElement(driver,phpTravels_AdminUserName);
        phpTravels_AdminUserName.sendKeys(userName);
        TestUtil.highLightElement(driver,phpTravels_AdminPwd);
        phpTravels_AdminPwd.sendKeys(pwd);
       // System.out.println(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        TestUtil.highLightElement(driver,phpTravels_btnAdminLogin);
        phpTravels_btnAdminLogin.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void phpTravelsLoginSuccessCheck() throws Throwable
    {
        try
        {
            boolean logoutDisplayed = phpTravels_btnLogout.isDisplayed();
            TestUtil.highLightElement(driver,phpTravels_AdminDashboard);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            phpTravels_AdminDashboard.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        catch (Exception exp)
        {
            throw exp;
        }
    }
    public void phpTravelsAdminLoginSucessCheck() throws Throwable
    {
        try
        {
            TestUtil.highLightElement(driver,phpTravels_AdminLogout);
            boolean logoutDisplayed = phpTravels_AdminLogout.isDisplayed();
           // Assert.assertNotNull("logout object search returned null",logoutDisplayed);
            TestUtil.highLightElement(driver,phpTravels_AdminUpdates);
            phpTravels_AdminUpdates.click();
        }
        catch (Exception exp)
        {
            throw exp;
        }
    }
}
