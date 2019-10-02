package Utils;

import java.lang.reflect.Field;

/*
Purpose : To help convert the OR in POM style format or ex

If OR object name = phpTravels_btnLogin Then
 @FindBy(xpath = Phptravels_OR.phpTravels_btnLogin )
    public WebElement phpTravels_btnLogin;
End IF
 */
public class convertORToPOMStyle
{
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        convertToPOM("Twitter_OR","ObjectRepository.Twitter_OR");
    }
    public static void convertToPOM(String ORClassName,String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class class1 = Class.forName(className);
        Object object1 = class1.newInstance();
        Field[] getfields = class1.getDeclaredFields();
        for (int i = 0; i < getfields.length; i++)
        {
            String findByFirstLine = "@FindBy(xpath = "+" "+ORClassName+"."+getfields[i].getName()+" "+")";
            String findBySecondLine = "public WebElement "+" "+getfields[i].getName();
            String FinalPOM = findByFirstLine + "\n"+findBySecondLine+";";
            System.out.println(FinalPOM);
        }
    }
}

