package Utils;

import Config.TestBase;
import com.opencsv.CSVReader;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import java.util.Date;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;
    public static String TESTDATA_SHEET_PATH = "/YourDirectoryPath" + "/YourTestDataExclPath";
    static JavascriptExecutor js;
	public static String screenshotPath;
	public static String screenshotName;
    public static WebDriver driver;
    static CSVReader reader;

    static {
        try {
            reader = new CSVReader(new FileReader(System.getProperty("user.dir")+"/src/main/resources/TestData/TestData.csv"));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public TestUtil() throws FileNotFoundException {
    }

/*   public TestUtil(WebDriver driver)
    {
        super();
        this.driver = driver;
    }*/

    public static void highLightElement(WebDriver driver, WebElement element)
    {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        try
        {
            Thread.sleep(200);
        }
        catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
        js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
    }
	public static String captureScreenshot() throws IOException
    {
		File scrFile = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
        String destination = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName;
        File finalDestination = new File(destination);
        FileUtils.copyFile(scrFile, finalDestination);
        screenshotPath = destination;
        return screenshotPath;
		//FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/Screenshots/" + screenshotName));
	}
/*    public static String captureScreenshotBASE64(String TCName) throws IOException, InterruptedException
    {
        File scrFile = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
        Date d = new Date();
        screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
        String destination = System.getProperty("user.dir") + "\\Screenshots\\" + TCName+"_"+screenshotName;
        File finalDestination = new File(destination);
        FileUtils.copyFile(scrFile, finalDestination);
        Thread.sleep(2000);
        InputStream is = new FileInputStream(finalDestination);
        byte[] imageBytes = IOUtils.toByteArray(is);
        Thread.sleep(2000);
        String base64 = Base64.getEncoder().encodeToString(imageBytes);
        return base64;
        //Extent.log(LogStatus.INFO, "Snapshot below: " + extent.addBase64ScreenShot("data:image/png;base64,"+base64));
    }*/
    public static String captureScreenshotBASE64(String TCName) throws IOException, InterruptedException, AWTException
    {
        Date d = new Date();
        screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
        try{
            // Creating Robot class object
            Robot robotClassObject = new Robot();
            // Get screen size
            Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            // Capturing screenshot by providing size
            BufferedImage tmp = robotClassObject.createScreenCapture(screenSize);
            // Defining destination file path
            String path=System.getProperty("user.dir")+"/Screenshots/"+TCName+screenshotName;
            // To copy temp image in to permanent file
            ImageIO.write(tmp, "png",new File(path));
            //return path;
            File finalDestination = new File(path);
          // FileUtils.copyFile(new File(path), finalDestination);
            Thread.sleep(2000);
            InputStream is = new FileInputStream(finalDestination);
            byte[] imageBytes = IOUtils.toByteArray(is);
            //Thread.sleep(2000);
            String base64 = Base64.getEncoder().encodeToString(imageBytes);
            return base64;
        }catch(Exception e)
        {
            System.out.println("Some exception occured." + e.getMessage());
            return "";
        }
    }

    public String base64conversion(WebDriver driver) throws Exception
    {
        TakesScreenshot newScreen = (TakesScreenshot) driver;
        String scnShot = newScreen.getScreenshotAs(OutputType.BASE64);
        return "data:image/jpg;base64, " + scnShot ;
    }
/*	@DataProvider(name="dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];
		
		Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String,String>();
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;

	}*/

/*	public static boolean isTestRunnable(String testName, ExcelReader excel)
	{
		
		String sheetName="test_suite";
		int rows = excel.getRowCount(sheetName);
		
		
		for(int rNum=2; rNum<=rows; rNum++){
			
			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			
			if(testCase.equalsIgnoreCase(testName)){
				
				String runmode = excel.getCellData(sheetName, "Runmode", rNum);
				
				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
			
			
		}
		return false;
	}*/
public void switchToFrame() {
    driver.switchTo().frame("mainpanel");
}
    /*
        public static Object[][] getTestData(String sheetName) {
            FileInputStream file = null;
            try {
                file = new FileInputStream(TESTDATA_SHEET_PATH);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                book = WorkbookFactory.create(file);
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            sheet = book.getSheet(sheetName);
            Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
            // System.out.println(sheet.getLastRowNum() + "--------" +
            // sheet.getRow(0).getLastCellNum());
            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                    data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                    // System.out.println(data[i][k]);
                }
            }
            return data;
        }*/
    public static void takeScreenshotAtEndOfTest() throws IOException
    {
        File scrFile = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }
    public static void runTimeInfo(String messageType, String message) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        // Check for jQuery on the page, add it if need be
        js.executeScript("if (!window.jQuery) {"
                + "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
                + "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
                + "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
        Thread.sleep(5000);

        // Use jQuery to add jquery-growl to the page
        js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

        // Use jQuery to add jquery-growl styles to the page
        js.executeScript("$('head').append('<link rel=\"stylesheet\" "
                + "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
        Thread.sleep(5000);

        // jquery-growl w/ no frills
        js.executeScript("$.growl({ title: 'GET', message: '/' });");
//'"+color+"'"
        if (messageType.equals("error")) {
            js.executeScript("$.growl.error({ title: 'ERROR', message: '"+message+"' });");
        }else if(messageType.equals("info")){
            js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
        }else if(messageType.equals("warning")){
            js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
        }else
            System.out.println("no error message");
        // jquery-growl w/ colorized output
//		js.executeScript("$.growl.error({ title: 'ERROR', message: 'your error message goes here' });");
//		js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
//		js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
        Thread.sleep(5000);
    }
    public static void readTestData() throws FileNotFoundException,InterruptedException,IOException {

        String[] cell;
        while((cell=reader.readNext())!=null)
        {
            for(int i = 0; i<cell.length; i++)
            {
                System.out.println(cell[i]);
            }
        }
    }


}
