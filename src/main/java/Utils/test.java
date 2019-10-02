package Utils;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class test {

    public static void main(String args[])  throws FileNotFoundException,InterruptedException, IOException
    {
        try
        {
            CSVReader reader = new CSVReader(new FileReader(System.getProperty("user.dir") + "/src/main/resources/TestData/TestData.csv"));
            String[] cell;
            while ((cell = reader.readNext()) != null)
            {
                if (cell != null)
                {
                    System.out.println(Arrays.toString(cell));
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("CSV read complete");
    }
}
