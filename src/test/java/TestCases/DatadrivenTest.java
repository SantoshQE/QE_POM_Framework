package TestCases;

import Config.TestBase;
import ExtentReportListener.ExtentManager;
import org.testng.annotations.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import com.aventstack.extentreports.ExtentTest;
import Listeners.CustomListeners;
import TestCases.ReflectionToDataDrive;

@Listeners({CustomListeners.class})
public class DatadrivenTest extends TestBase
{
    public static ReflectionToDataDrive ReflectDD;
    public static ExtentTest test;

/*    public DatadrivenTest() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
*//*        ReflectDD = new ReflectionToDataDrive("DatadrivenTest");
        ReflectDD.readClass("DatadrivenTest");*//*
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
        ReflectDD = new ReflectionToDataDrive("DatadrivenTest");
        //ReflectDD.readClass("DatadrivenTest");
        System.out.println("StartUp ...");
/*        //ReflectDD.readClass("TestCases.DatadrivenTest");
      //  System.out.println( ReflectDD.readClass("DatadrivenTest")); */
        ReflectDD.dataDriveTest("DatadrivenTest");
    }
    @Test(priority=1,testName ="TestStep1")
    public void LaunchApplication()
    {
        System.out.println(this.getClass().getName());
        System.out.println("Inside @BeforeTest --launchBrowser_Chrome ");
        TestBase.open_Browser("Chrome");
    }
    @Test(priority=2,testName ="TestStep1")
    public void TestStep1()
    {
        System.out.println("Total rows in testdata is : "+ReflectDD.getRowCountReflectDD("TestData"));
        System.out.println("TestStep..1");
    }

     @AfterTest(description="AfterTest")
    public void testDown()
    {
        System.out.println("testDown..");
        if(driver!=null)
        {
            driver.close();
        }
    }
}
