package TestCases;

import Config.TestBase;
import ExtentReportListener.ExtentManager;
import org.testng.annotations.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import com.aventstack.extentreports.ExtentTest;
import Listeners.CustomListeners;

@Listeners({CustomListeners.class})
public class DatadrivenTest extends TestBase
{
    public String a;
    public static ReflectionToDataDrive ReflectDD;
    public static ExtentTest test;

/*    public DatadrivenTest(String a)
    {
        this.a= a;
    }*/
    @BeforeMethod
    public void setup(Method method) {
        String testMethodName = method.getName();
        String descriptiveTestName = method.getAnnotation(Test.class).testName();
        test = ExtentManager.startTest(descriptiveTestName, ExtentManager.getLabel(method.getDeclaringClass().getName()));
    }
    @BeforeTest(description="BeforeTest")
    public void startUp() throws Exception
    {
        System.out.println(this.getClass().getName());
        System.out.println("Inside @BeforeTest --launchBrowser_Chrome ");
        TestBase.open_Browser("Chrome");
        ReflectDD = new ReflectionToDataDrive(driver);
        System.out.println("StartUp ..."+a);
        //ReflectDD.readClass("TestCases.DatadrivenTest");
      //  System.out.println( ReflectDD.readClass("DatadrivenTest"));
        ReflectDD.countAnnotations("DatadrivenTest");
    }
    @Test(priority=1,testName ="TestStep1")
    public void TestStep1()
    {
        System.out.println("Total rows in testdata is : "+ReflectDD.getRowCountReflectDD("TestData"));
        System.out.println("TestStep..1"+a);
    }
    @Test(priority = 2,testName ="TestStep2")
    public void TestStep2()
    {
        System.out.println("TestStep..2"+a);
    }
    @Test(priority = 3,testName ="TestStep3")
    public void TestStep3()
    {
        System.out.println("TestStep..3"+a);
    }
    @Test(priority = 4,testName ="TestStep4")
    public void TestStep4()
    {
        System.out.println("TestStep1..4"+a);
    }
 /*   @AfterTest(description="AfterTest")
    public void testDown()
    {
        System.out.println("testDown..");
        if(driver!=null)
        {
            driver.close();
        }
    }*/
}
