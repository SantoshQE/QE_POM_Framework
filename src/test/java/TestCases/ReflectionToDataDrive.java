package TestCases;

import Config.TestBase;
import Utils.ExcelReader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReflectionToDataDrive // extends TestBase
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

            Steps:
            Get Total number of itertions
            Create a for loop to iterate throught the itrations --starting from datarow = 1...
                    First run @BeforeTest
                    Then run @BeforeTest -- on @Test(priority1)
                    Then run @BeforeTest -- on @Test(priority2)
                    .
                    .
                   Then run @BeforeTest -- on @Test(priority..n)
                   Once all the @Tests are run followed by the @BeforeTest method
                   Then run @AfterTestMethod
            End of 1 datarow ---
            Continue the loop above till all the datarows are processed..


     */
    public static ExcelReader ExL;
    public static String TestCasePkgName = "TestCases";
    public static Class<? extends Class> TestCaseClassName;
    private Class<? extends Class> TestCaseClassInstance;
    HashMap<Integer, String> ReflectMap = new HashMap<>();
    public static int rowCount;
    static StringBuilder sb;
    //  public static WebDriver driver = TestBase.getDriver();
    // public static WebDriver driver=TestBase.getDriver();
    public static String className;
    public static Object objClass;
    private Object TestMethodName;
    private Object Method = TestMethodName;

    public ReflectionToDataDrive(String className) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        String DataPath =  System.getProperty("user.dir")+"/src/main/resources/TestData/TestData.xlsx";
        ExL = new ExcelReader(DataPath);
        System.out.println(ExL);
        //   this.driver = driver;
        readClass(className);
        //objClass = TestCaseClassName.getConstructor().newInstance();
        System.out.println(getObject());
    }
    public Object getObject() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
    {
        objClass = TestCaseClassName.getConstructor().newInstance();
        return objClass;
    }

    public int getRowCountReflectDD(String sheetName)
    {
        rowCount = ExL.getRowCount(sheetName);
        return rowCount;
    }
    public Class<? extends Class> readClass(String className) throws IllegalAccessException, InstantiationException
    {
        // Get Class using reflection
        TestCaseClassName = null;
        try {
            TestCaseClassName = (Class<? extends Class>) Class.forName(TestCasePkgName+"."+className);
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return TestCaseClassName;
    }
    public void dataDriveTest(String className) throws Exception
    {
        int totalDataRows = getRowCountReflectDD("TestData");
        int runIteration = 0;
        System.out.println(TestCaseClassName.getName());
        for (int rowNum = 1; rowNum <= totalDataRows; rowNum++)
        {
            String TCName = ExL.getCellData("TestData", "TestCaseName", rowNum);
            String RunMode = ExL.getCellData("TestData", "RunMode", rowNum);
            if ((TestCaseClassName.getName().contains(TCName)) && RunMode.equals("Y")) {
                System.out.println("TestCase Name matched with the name in TestData sheet");
                //count total number of run iterations
                runIteration = runIteration + 1;
            }
        }
        System.out.println("Total data row iterations are : " + runIteration);
        for (int dataIter = 1; dataIter <= runIteration; dataIter++)
        {
            TestCaseClassInstance = readClass(className);
            Method[] methods = TestCaseClassInstance.getDeclaredMethods();
            //load all the methods with @Test annotation in a HashMap
            for (int testIter = 0; testIter < methods.length; testIter++) {
                if (methods[testIter].getAnnotation(Test.class) != null) // @Test Annotated method
                {
                    System.out.println(methods[testIter].getAnnotation(Test.class).priority());
                    int runPriority = methods[testIter].getAnnotation(Test.class).priority();
                    ReflectMap.put(runPriority, methods[testIter].getName());
                }
            }
            //Find method with BeforeTest Annotation first and execute that method first
            for (int beforeTestIter = 0; beforeTestIter < methods.length; beforeTestIter++) {
                System.out.println("public method: " + methods[beforeTestIter]);
                if (methods[beforeTestIter].getAnnotation(BeforeTest.class) != null)    // @BeforeTest Annotated method
                {
                    System.out.println(methods[beforeTestIter].getAnnotation(BeforeTest.class).description());
                    Method beforeTestMName = TestCaseClassName.getDeclaredMethod(methods[beforeTestIter].getName());
                    //beforeTestMName.invoke(objClass);
                    if (ReflectionToDataDrive.objClass != null) {
                        break;
                    } else {
                        Object invokeReturnObj = beforeTestMName.invoke(objClass);
                    }
                                    Object invokeReturnObj = beforeTestMName.invoke(objClass);
                                    if ( invokeReturnObj != null)
                                    {
                                        break;
                                    }
                }
            }
            //Iterate through the hashmap and run the @Test methods in sequence as per priority i.e. @Test(priority=1,2,...n)
            for (Integer key : ReflectMap.keySet()) {
                System.out.println("Method Priority is : " + key + "   for method named : " + ReflectMap.get(key));
                String methodName = ReflectMap.get(key);
                Method TestMethodName = TestCaseClassName.getDeclaredMethod(methodName);
                if (TestMethodName.isAnnotationPresent(Test.class)) {
                    System.out.println("Priority of the method from hashmap is  :  " + (key));
                    //Find method with @BeforeMethod Test then pass the methodname from @Test annotated method to @BeforeMethod
                    for (int beforeMethodIter = 0; beforeMethodIter < methods.length; beforeMethodIter++) {
                        System.out.println("public method: " + methods[beforeMethodIter]);
                        if (methods[beforeMethodIter].getAnnotation(BeforeMethod.class) != null)    // @AfterTest Annotated method
                        {
                            System.out.println(methods[beforeMethodIter].getAnnotation(BeforeMethod.class).description());
                            // Method beforeMethodMName = TestCaseClassName.getDeclaredMethod(methods[beforeMethodIter].getName(),methods[beforeMethodIter].getClass());

                            Class<?>[] parameterTypes = {java.lang.reflect.Method.class};
                            Method beforeMethodMName = TestCaseClassName.getDeclaredMethod(methods[beforeMethodIter].getName(), parameterTypes);
                            // Method beforeMethodMName = TestCaseClassName.getMethod("setup");
                            //  System.out.println(methods[beforeMethodIter].getAnnotation(BeforeTest.class).getClass());
                            int paramCount = TestCaseClassName.getDeclaredMethods()[beforeMethodIter].getGenericParameterTypes().length;
                            Object argArray[] = new Object[paramCount];
                            sb = new StringBuilder(32);
                            for (int ptn = 0; ptn < paramCount; ptn++) {
                                String fPList = TestCaseClassName.getDeclaredMethods()[beforeMethodIter].getParameterTypes()[ptn].toString();
                                String finalParamList = fPList.replace("class", "").trim();
                                System.out.println(finalParamList);
                                argArray[ptn] = finalParamList;
                                beforeMethodMName.invoke(objClass, TestMethodName);
                                break;
                            }
                            TestMethodName.invoke(objClass);    //then execute the @Test Method
                            break;
                        }
                    }
                }
            }
            //Find method with AfterTest Annotation at the end and execute that method
            for (int afterTestIter = 0; afterTestIter < methods.length; afterTestIter++)
            {
                System.out.println("public method: " + methods[afterTestIter]);
                if (methods[afterTestIter].getAnnotation(AfterTest.class) != null)    // @AfterTest Annotated method
                {
                    System.out.println(methods[afterTestIter].getAnnotation(AfterTest.class).description());
                    Method afterTestMName = TestCaseClassName.getDeclaredMethod(methods[afterTestIter].getName());
                    afterTestMName.invoke(objClass);
                    break;
                }
            }
        }
    }
}

