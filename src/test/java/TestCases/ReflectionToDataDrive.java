package TestCases;

import Utils.ExcelReader;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionToDataDrive
{
    /*
            Create a new class --> call it in @BeforeTest in each test case
            Each test case will initilize this new class
            This class once intilized will read excel sheet

            TCName|RunMode|BrowserType
            TC1|Y|Chrome

            TCName in TestData Excel should be exactly same as Test case className
            The code logic will return number of rows with Runmode =  Y
            For Ex: if runmode = 2 for class TC1 then the iterations count would be = 2
            This code will work on java reflection Api

     */
    public static ExcelReader ExL;
    public static String TestCasePkgName = "TestCases";
    public static Class<? extends Class> TestCaseClassName;
    private Class<? extends Class> TestCaseClassInstance;
    static StringBuilder sb;

    public ReflectionToDataDrive()
    {
        String DataPath =  System.getProperty("user.dir")+"/src/main/resources/TestData/TestData.xlsx";
        ExL = new ExcelReader(DataPath);
        System.out.println(ExL);
    }

    public int getRowCountReflectDD(String sheetName)
    {
        int rowCount = ExL.getRowCount(sheetName);
        return  rowCount;
    }


  public static void main(String args[])
    {
       // ReflectionToDataDrive reflectDD = new ReflectionToDataDrive();
        System.out.println(ExL);
    }
    public Class<? extends Class> readClass(String className) throws IllegalAccessException, InstantiationException
    {
        // Get Class using reflection
        TestCaseClassName = null;
        try {
            TestCaseClassName = (Class<? extends Class>) Class.forName(TestCasePkgName+"."+className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       //System.out.println(TestCaseClassName.getCanonicalName()); // print
        //Object objKeywordName = TestCaseClassName.newInstance();
        return TestCaseClassName;
    }
    public void countAnnotations(String className) throws IllegalAccessException, InstantiationException {
        TestCaseClassInstance = readClass(className);
        //Object objKeywordName = TestCaseClassName.newInstance();
      // int TotalMethods   = TestCaseClassName.getDeclaredMethods().length;
     //   System.out.println("Total Methods in TestCase are --: >> "+TotalMethods);
        Method[] methods = TestCaseClassInstance.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++)
        {
            System.out.println("public method: " + methods[i]);
        }
        Object objKeywordName = TestCaseClassInstance.newInstance();
        int TotalMethods   = TestCaseClassInstance.getDeclaredMethods().length;
        //@TEST BLOCK :						//THIS LOOP IS TO FIND THE EXACT METHOD NAME IN THE CLASS AND EXECUTE THE @Test BLOCK

    /*    for(int mn=0;mn<=TotalMethods;mn++)
        {
            //code to get parameters
            String strMethodParam ,strParamFinal = null ;
            Parameter[] param = TestCaseClassInstance.getDeclaredMethods()[mn].getParameters();

            String methodName   = TestCaseClassInstance.getDeclaredMethods()[mn].getName();
            if(methodName.equals("") || methodName.equals(null) )
            {
                break;
            }
            else {
                if(TestCaseClassInstance.getDeclaredMethods()[mn].getParameterTypes().length > 0 )
                {
                    //Code to prepare a string for parameter list-->THIS BLOCK WILL TAKE CARE OF METHOD WITH PARAMETERS DYNAMICALLY
                    System.out.println("Inside method with parameters");
                    Method setNameMethod = objKeywordName.getClass().getMethod(methodName.toString(),TestCaseClassInstance.getDeclaredMethods()[mn].getParameterTypes());
                    String keywordname = methodName.toString();
                    if(strMethodName.equals(keywordname))
                    {
                        System.out.println(setNameMethod.toString());
                        // setNameMethod.invoke(objKeywordName,"TC1",1,"TS","dsds" );     // EXECUTE THE METHOD
                        int paramCount = TestCaseClassInstance.getDeclaredMethods()[mn].getGenericParameterTypes().length;
                        Object argArray[] = new Object[paramCount];
                        sb = new StringBuilder(32);
                        for(int ptn=0;ptn<paramCount;ptn++)
                        {
                            //System.out.println(KeywordNameClass.getDeclaredMethods()[mn].getGenericParameterTypes()[ptn].toString());
                            String fPList = TestCaseClassInstance.getDeclaredMethods()[mn].getParameterTypes()[ptn].toString();
                            String finalParamList = fPList.replace("class", "").trim();
                            if(finalParamList.equalsIgnoreCase("java.lang.String"))
                            {
                                sb.append("java.lang.String.class").append(" , ");
                                argArray[ptn] =CellValTCSheet ;
                                // + r.nextInt((10 - 1) + 1) + 1 ;
                            }
                            else if(finalParamList.equalsIgnoreCase("int"))
                            {
                                sb.append(1).append(" , ");
                                argArray[ptn] = testDataRow ;
                            }
                        }
                        setNameMethod.invoke(objKeywordName,argArray);
                        break;
                    }
                }
                else
                {
                    Method setNameMethod = objKeywordName.getClass().getMethod(methodName,null);
                    String keywordname = methodName.toString();
                    if(strMethodName.equals(keywordname))
                    {
                        System.out.println(setNameMethod.toString());
                        setNameMethod.invoke(objKeywordName);     // EXECUTE THE METHOD
                        break;
                    }
                }
            }
        }*/
    }
}

