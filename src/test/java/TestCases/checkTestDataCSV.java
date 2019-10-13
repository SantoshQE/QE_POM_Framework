package TestCases;

import Config.TestBase;
import Utils.TestUtil;
import com.csvreader.CsvReader;
import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class checkTestDataCSV extends TestBase
{
    public static int TCCount =0;
    public static void main(String[] args) {
        try {
         //   CSVReader testcases = new CSVReader(new FileReader(System.getProperty("user.dir")+"/src/main/resources/TestData/TestData.csv"));
            CsvReader testcases = new CsvReader((System.getProperty("user.dir")+"/src/main/resources/TestData/TestData.csv"));
            testcases.readHeaders();
            //get total numbers of header column
            int numberOfHeaders=testcases.getHeaderCount();
            //print header column
            for(int i=0;i<numberOfHeaders;i++)
            {
                System.out.print(testcases.getHeader(i)+",  ");
            }
            System.out.println();
            while (testcases.readRecord())
            {
                String TestCaseName = testcases.get("TestCaseName");
                String RunMode = testcases.get("RunMode");
                String Browser = testcases.get("Browser");
                System.out.println(TestCaseName +",   " + RunMode +",   "+Browser );
                String TCName = TestCaseName;
                if(TestCaseName.equalsIgnoreCase("TC3_twitLoginChrome"))
                {
                    TCCount = TCCount+1;

                }
                        //  " + TestModule +",  " + TestType +",    " + TestSteps +",   " + Action +",  " + TestResult+",   "+Note);
            }
            System.out.println("TestCaseName count is : "+TCCount);
            testcases.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
   // public static void main(String args[]) throws IOException, InterruptedException {
      //  TestUtil.readTestData();
/*        CSVReader reader = new CSVReader(new FileReader(System.getProperty("user.dir")+"/src/main/resources/TestData/TestData.csv"));

        // Read all data at once
        //employeeDetails stores the values current line
        String[] employeeDetails = null;
        //List for holding all the rows
        List<String[]> rows = new ArrayList<String[]>();
        rows = reader.readAll();
        //Read individual row from List of rows
        for(String[] row : rows)
        {
            System.out.println(Arrays.toString(row));

        }*/
/*        while((cell=reader.readNext())!=null)
        {
            for(int i = 0; i<cell.length; i++)
            {
                System.out.println(cell[i]);
            }
        }*/
  //  }
    // Print Data.


}
