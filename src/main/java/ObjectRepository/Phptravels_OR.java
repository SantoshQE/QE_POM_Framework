package ObjectRepository;

public  class Phptravels_OR
{
    public static final String PhpTravelSite="https://phptravels.com/demo/";
    //Xpaths
    //PhpTravels_LoginPage
    public static final String phpTravels_btnLogin ="//*[@id='ShopifyMainNav']//input[@value='Login']";
    public static final String phpTravels_UserName ="inputEmail";
    public static final String phpTravels_Pwd ="inputPassword";
    public static final String phpTravels_CaptchCheckBox ="#recaptcha-anchor > div.recaptcha-checkbox-border";
    public static final String phpTravels_btnLogin2 ="login";
    public static final String phpTravels_btnLogout ="//a[@href='/logout.php' and @class='btn'']";
    //Admin Objects
    public static final String phpTravels_AdminUserName ="email";
    public static final String phpTravels_AdminPwd ="password";
    public static final String phpTravels_btnAdminLogin = "//button[@class='btn btn-primary btn-block ladda-button fadeIn animated']";
    public static final String phpTravels_AdminLogout ="//*[@id='logout']/a/strong";
    //Admin Home Page Objects
    public static final String phpTravels_AdminDashboard ="//*[@id='social-sidebar-menu']//a[@href='https://www.phptravels.net/admin']";
    public static final String phpTravels_AdminUpdates ="//*[@id='social-sidebar-menu']//a[@href='https://www.phptravels.net/admin/updates/']";
    public static final String phpTravels_AdminModules="//*[@id='social-sidebar-menu']//a[@href='https://www.phptravels.net/admin/settings/modules/']";
    public static final String phpTravels_AdminGeneral="//*[@id='social-sidebar-menu']/li[4]/a";
    public static final String phpTravels_AdminAccounts="//*[@id='social-sidebar-menu']//a[@href='#ACCOUNTS']";
    public static final String phpTravels_AdminCMS="//*[@id='social-sidebar-menu']//span[contains(text(),'CMS')]";
    public static final String phpTravels_AdminCustomers="//*[@id='ACCOUNTS']//a[@href='https://www.phptravels.net/admin/accounts/customers/']";
    public static final String phpTravels_AdminAcctAdmin="//*[@id='ACCOUNTS']//a[@href='https://www.phptravels.net/admin/accounts/admins/']";
    public static final String phpTravels_AdminSuppliers="//*[@id='ACCOUNTS']//a[@href='https://www.phptravels.net/admin/accounts/suppliers/']";
    public static final String phpTravels_AdminGuestCustomer="//*[@id='ACCOUNTS']//a[@href='https://www.phptravels.net/admin/accounts/guest/']";
    public static final String phpTravels_btnAddCustomer="//*[@id='content']//button[@class='btn btn-success' and @type='submit']";
    //Add Customer
    public static final String phpTravels_AddCust_FName="fname";
    public static final String phpTravels_AddCust_LName="//*[@id='content']//input[@name='lname']";
    public static final String phpTravels_AddCust_Email="//*[@id='content']//input[@name='email']";
    public static final String phpTravels_AddCust_Pwd="//*[@id='content']//input[@name='password']";
    public static final String phpTravels_AddCust_Mobile="//*[@id='content']//input[@name='mobile']";
    public static final String phpTravels_AddCust_Country="//*[@id='s2id_autogen1']//span[@class='select2-chosen']";
   // public static final String phpTravels_AddCust_Country2="//*[@id='select2-drop']/div/input";
    public static final String phpTravels_AddCust_Country2="//*[@id='content']/form/div/div[2]/div/div[6]/div/select";
    public static final String phpTravels_AddCust_Address1="//*[@id='content']//input[@name='address1']";
    public static final String phpTravels_AddCust_Address2="//*[@id='content']//input[@name='address2']";
    public static final String phpTravels_AddCust_Status="//*[@id='content']//select[@name='status']";
    public static final String phpTravels_AddCust_btnSubmit="//*[@id='content']//button[@class='btn btn-primary']";
    public static final String phpTravels_AddCust_tblCustomer="//table[@class='xcrud-list table table-striped table-hover']";
}
