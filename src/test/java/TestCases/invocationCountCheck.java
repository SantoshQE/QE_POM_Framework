package TestCases;

import org.testng.annotations.Test;

public class invocationCountCheck {


    @Test(invocationCount = 3)
    public void test1()
    {
        System.out.println("test1");
    }


}
