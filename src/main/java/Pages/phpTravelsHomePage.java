package Pages;

import ObjectRepository.Phptravels_OR;
import Utils.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import cucumber.api.DataTable;

//import cucumber.api.DataTable;

public class phpTravelsHomePage
{
    public static WebDriver driver;
    private Object String;

    public phpTravelsHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = Phptravels_OR.phpTravels_AdminLogout )
    public WebElement phpTravels_AdminLogout;
    @FindBy(xpath = Phptravels_OR.phpTravels_AdminUpdates )
    public WebElement phpTravels_AdminUpdates;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AdminDashboard )
    public WebElement phpTravels_AdminDashboard;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AdminModules )
    public WebElement phpTravels_AdminModules;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AdminGeneral )
    public WebElement phpTravels_AdminGeneral;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AdminAccounts )
    public WebElement phpTravels_AdminAccounts;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AdminCMS )
    public WebElement phpTravels_AdminCMS;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AdminCustomers )
    public WebElement phpTravels_AdminCustomers;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AdminAcctAdmin )
    public WebElement phpTravels_AdminAcctAdmin;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AdminSuppliers )
    public WebElement phpTravels_AdminSuppliers;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AdminGuestCustomer )
    public WebElement phpTravels_AdminGuestCustomer;
    @FindBy(xpath =  Phptravels_OR.phpTravels_btnAddCustomer )
    public WebElement phpTravels_btnAddCustomer;
    @FindBy(name =  Phptravels_OR.phpTravels_AddCust_FName )
    public WebElement phpTravels_AddCust_FName;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AddCust_LName )
    public WebElement phpTravels_AddCust_LName;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AddCust_Email )
    public WebElement phpTravels_AddCust_Email;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AddCust_Pwd )
    public WebElement phpTravels_AddCust_Pwd;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AddCust_Mobile )
    public WebElement phpTravels_AddCust_Mobile;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AddCust_Country )
    public WebElement phpTravels_AddCust_Country;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AddCust_Country2 )
    public WebElement phpTravels_AddCust_Country2;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AddCust_Address1 )
    public WebElement phpTravels_AddCust_Address1;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AddCust_Address2 )
    public WebElement phpTravels_AddCust_Address2;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AddCust_Status )
    public WebElement phpTravels_AddCust_Status;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AddCust_btnSubmit )
    public WebElement phpTravels_AddCust_btnSubmit;
    @FindBy(xpath =  Phptravels_OR.phpTravels_AddCust_tblCustomer )
    public WebElement phpTravels_AddCust_tblCustomer;

    public void navigateToDashboard()
    {
        phpTravels_AdminUpdates.click();
    }
    public void navigateToUpdates()
    {
        phpTravels_AdminUpdates.click();
    }
    public void navigateToModules()
    {
        phpTravels_AdminModules.click();
    }
    public void navigateToGeneral()
    {
        phpTravels_AdminGeneral.click();
    }
    public void navigateToAccounts()
    {
        TestUtil.highLightElement(driver,phpTravels_AdminAccounts);
        phpTravels_AdminAccounts.click();
    }
    public void navigateToCustomers()
    {
        navigateToAccounts();
        TestUtil.highLightElement(driver,phpTravels_AdminCustomers);
        phpTravels_AdminCustomers.click();
    }
   /* public void addNewCustomer(DataTable dt) throws InterruptedException {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for(int i=0; i<list.size(); i++)
        {
            Utilities.highLightElement(driver,phpTravels_AddCust_FName);
            phpTravels_AddCust_FName.sendKeys(list.get(i).get("FirstName"));
            Utilities.highLightElement(driver,phpTravels_AddCust_LName);
            phpTravels_AddCust_LName.sendKeys(list.get(i).get("LastName"));
            Utilities.highLightElement(driver,phpTravels_AddCust_Email);
            phpTravels_AddCust_Email.sendKeys(list.get(i).get("EmailID"));
            Utilities.highLightElement(driver,phpTravels_AddCust_Pwd);
            phpTravels_AddCust_Pwd.sendKeys(list.get(i).get("Password"));
            Utilities.highLightElement(driver,phpTravels_AddCust_Mobile);
            phpTravels_AddCust_Mobile.sendKeys(list.get(i).get("MobNumber"));
            Utilities.highLightElement(driver,phpTravels_AddCust_Country);
            phpTravels_AddCust_Country.click();
            phpTravels_AddCust_Country2.sendKeys(list.get(i).get("Country"));
            Select select2 = new Select(phpTravels_AddCust_Country2);
            select2.selectByVisibleText(list.get(i).get("Country"));
            Thread.sleep(1000);
            Utilities.highLightElement(driver,phpTravels_AddCust_Address1);
            phpTravels_AddCust_Address1.sendKeys(list.get(i).get("Add1"));
            Utilities.highLightElement(driver,phpTravels_AddCust_Address2);
            phpTravels_AddCust_Address2.sendKeys(list.get(i).get("Add2"));
            Utilities.highLightElement(driver,phpTravels_AddCust_btnSubmit);
            phpTravels_AddCust_btnSubmit.click();
            driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        }
    }*/



}
