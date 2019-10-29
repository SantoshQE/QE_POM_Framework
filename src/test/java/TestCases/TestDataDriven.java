package TestCases;

import Config.TestBase;
import ExtentReportListener.ExtentManager;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestDataDriven extends TestBase
{
    public static ExtentTest test;
    @BeforeMethod()
    public void beforeMethod(Method method)
    {
        System.out.println("inside BeforeMethod ....");
        String testMethodName = method.getName();
        String descriptiveTestName = method.getAnnotation(Test.class).testName();
        test = ExtentManager.startTest(descriptiveTestName, ExtentManager.getLabel(method.getDeclaringClass().getName()));
    }




    @BeforeTest()
    public void startUp()
    {
        System.out.println(this.getClass().getName());
        System.out.println("inside BeforeTest ....");
        //testBase_startUp( "Chrome","https://www.google.com");
    }
    @Test(priority = 2,testName="test1")
    public void test1()
    {
        System.out.println("Inside test1...");
    }
}
