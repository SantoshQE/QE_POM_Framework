package TestCases;

import Config.TestBase;
import Utils.ExcelReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReflectionToDataDrive extends TestBase
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
    HashMap<Integer, String> ReflectMap = new HashMap<>();
    public static int rowCount;
    static StringBuilder sb;
  //  public static WebDriver driver = TestBase.getDriver();
    public static WebDriver driver;
    public ReflectionToDataDrive(WebDriver driver)
    {
        String DataPath =  System.getProperty("user.dir")+"/src/main/resources/TestData/TestData.xlsx";
        ExL = new ExcelReader(DataPath);
        System.out.println(ExL);
        this.driver = driver;
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return TestCaseClassName;
    }
    public void countAnnotations(String className) throws Exception
    {
        TestCaseClassInstance = readClass(className);
        Method[] methods = TestCaseClassInstance.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++)
        {
            System.out.println("public method: " + methods[i]);
            if(methods[i].getAnnotation(AfterTest.class) != null)    // @AfterTest Annotated method
            {
                System.out.println(methods[i].getAnnotation(AfterTest.class).description());
            }
            if(methods[i].getAnnotation(BeforeTest.class) != null)   // @BeforeTest Annotated method
            {
                System.out.println(methods[i].getAnnotation(BeforeTest.class).description());

            }
            if(methods[i].getAnnotation(Test.class) != null) // @Test Annotated method
            {
                System.out.println(methods[i].getAnnotation(Test.class).priority());
                int runPriority = methods[i].getAnnotation(Test.class).priority();
                ReflectMap.put(runPriority,methods[i].getName());
            }
        }
        //Return number of rows from testdata sheet matching the testcase class name and invoke the methods
        rowCount = ExL.getRowCount("TestData");
        int dataIter = 0;
        for( dataIter =1;dataIter<= rowCount;dataIter++)
        {
            for (Integer key : ReflectMap.keySet())
                {
                    System.out.println("Method Priority is : "+key+"   for method named : "+ReflectMap.get(key));
                    Object objClass = TestCaseClassName.getConstructor().newInstance();
                    String methodName = ReflectMap.get(key);
                    Method TestMethodName = TestCaseClassName.getDeclaredMethod(methodName);
                    if(TestMethodName.isAnnotationPresent(Test.class))
                    {
                        TestMethodName.invoke(objClass, null);
                    }
                }
        }

/*        for (Integer key : ReflectMap.keySet())
        {
            System.out.println("Method Priority is : "+key+"   for method named : "+ReflectMap.get(key));
            Object objClass = TestCaseClassName.getConstructor().newInstance();
            String methodName = ReflectMap.get(key);
            Method TestMethodName = TestCaseClassName.getDeclaredMethod(methodName);
            if(TestMethodName.isAnnotationPresent(Test.class))
            {
                TestMethodName.invoke(objClass, null);
            }
        }*/
     //  driver.close();


    }
/*    public static void runAllAnnotatedWith(Class<? extends Annotation> annotation) throws Exception
    {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath())
                .setScanners(new MethodAnnotationsScanner()));
        Set<Method> methods = reflections.getMethodsAnnotatedWith(annotation);

        for (Method m : methods)
        {
            m.invoke(null);
        }
    }*/
}

