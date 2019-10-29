package TestCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DatadrivenTest
{
    public String a;
    public static ReflectionToDataDrive ReflectDD;

    public DatadrivenTest(String a)
    {
        this.a= a;
    }

    @BeforeTest
    public void startUp() throws InstantiationException, IllegalAccessException {
        ReflectDD = new ReflectionToDataDrive();
        System.out.println("StartUp ..."+a);
        //ReflectDD.readClass("TestCases.DatadrivenTest");
        System.out.println( ReflectDD.readClass("DatadrivenTest"));
        ReflectDD.countAnnotations("DatadrivenTest");
    }

    @Test(priority=1)
    public void TestStep1()
    {
        System.out.println("Total rows in testdata is : "+ReflectDD.getRowCountReflectDD("TestData"));
        System.out.println("TestStep..1"+a);
    }
    @Test(priority = 2)
    public void TestStep2()
    {
        System.out.println("TestStep..2"+a);
    }
    @Test(priority = 3)
    public void TestStep3()
    {
        System.out.println("TestStep..3"+a);
    }
    @Test(priority = 4)
    public void TestStep4()
    {
        System.out.println("TestStep1..4"+a);
    }
}
