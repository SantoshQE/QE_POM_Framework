package TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDataDriven
{
    @BeforeMethod()
    public void beforeMethod()
    {
        System.out.println("inside before method ....");
    }
    @BeforeTest()
    public void startUp()
    {
        System.out.println(this.getClass().getName());
    }
    @Test
    public void test1()
    {
        System.out.println("Inside test1...");
    }
}
