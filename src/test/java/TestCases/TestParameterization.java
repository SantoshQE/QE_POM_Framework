package TestCases;

import org.testng.annotations.Test;

import java.util.Hashtable;

public class TestParameterization
{
    @Test(dataProviderClass = Utils.TestUtil.class, dataProvider="getDataSuite")
    public void testData(Hashtable<String,String> data){
         System.out.println(data.get("TestCaseName"));
    }
}
