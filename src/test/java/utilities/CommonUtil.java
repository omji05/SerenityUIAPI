package utilities;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.function.Function;

public class CommonUtil extends PageObject {

    public String getTestConfig(String key){
        Properties prop=new Properties();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/testConfig.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(key);

    }

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);
    public List<Map<String, String>> getDataFromExcel(String fileName, String sheetName){
        ExcelUtil excelUtil=new ExcelUtil();
        String path=System.getProperty("user.dir")+getTestConfig("testDataPath")+fileName;
        try {
            return excelUtil.getData(path,"Sheet1");
        } catch (IOException e) {
            //logger to log message of exception
            throw new RuntimeException(e);
        }
    }

    public void isDropDownPopulated(WebElement element, String expectedvalue) {
        Select select = new Select(element);
        WebElement option = select.getFirstSelectedOption();
        String actualvalue = option.getText().trim();
        Assert.assertEquals(expectedvalue, actualvalue);
        LOGGER.info("Same value is populating as expected");
    }

    public void isFieldBlank(WebElement element, String FieldName) {
        boolean flag = element.getAttribute("value").isEmpty();
        Assert.assertTrue(FieldName + " Field is not balnk", flag);
        LOGGER.info(FieldName + " is blank");
    }

    public void verifyIsFieldNonEditable(WebElement element, String FieldName) {
        String attribute = element.getAttribute("readonly");
        LOGGER.info(attribute);
        Assert.assertNotNull(FieldName + " is editable", attribute);
        LOGGER.info(FieldName + " is non editable");

    }

    public void verifyDropdownValue(WebElement element, int drpdwncount) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        int count = options.size();
        if (count == 1) {
            Assert.assertEquals("Dropdown options are available", count, 1);
            LOGGER.info("Dropdown options are not available without Business Code");
        } else {
            if (count > 1) {
                LOGGER.info("All Dropdown options are available after selecting Business code");
            } else {
                LOGGER.info("All Dropdown options are not available after selecting Business code");
            }
        }
        String value1 = select.getFirstSelectedOption().getAttribute("value");
        LOGGER.info(value1);
    }

    public void clearText(WebElement element) {
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }

    public void enterText(WebElement element, String text) {

        element.sendKeys(text);
    }

    public void verifyEnteredText(WebElement element, String expvalue) {

        clearText(element);
        enterText(element, expvalue);
        //wait(2000);
        String actvalue = element.getAttribute("value");
        Assert.assertEquals("Entered text is not same", expvalue, actvalue);
        LOGGER.info("Entered text is as expecetd: " + actvalue);


    }

    public void verifyTextLength(WebElement element, String value, int expsize) {
        element.sendKeys(value);

        int actsize = element.getAttribute("value").length();

        Assert.assertEquals("User is able to enter more than max length", expsize, actsize);
        LOGGER.info("Max character functionality is working fine");
    }

    public int getCurrentYear() {
        try {
            int year = Calendar.getInstance().get(Calendar.YEAR);
            return year;
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
            return 0;
        }

    }

    public String getCurrentDateToSet() {

        try {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

            Date date = new Date();
            String date1 = dateFormat.format(date);

            return date1;
        }catch(Exception e){
            LOGGER.info(e.getMessage());
            return null;
        }
    }

    public void waitForPageLoad() {

        Wait<WebDriver> wait = new WebDriverWait(getDriver(), Duration.ofSeconds(120));
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("CurrentWind`ow State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }
    public void checkPageIsReady() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            return;
        }
        for (int i = 0; i < 10000; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }

    }

    public String getRequiredDate(int incrementDays) {
        try {
            DateFormat dateformat;

            Calendar calender = Calendar.getInstance();
            dateformat = new SimpleDateFormat("MM/dd/yyyy");
            calender.add(Calendar.DAY_OF_MONTH, incrementDays);
            Date tomorrow = calender.getTime();
            String formattedDate = dateformat.format(tomorrow);
            return formattedDate;
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
            return null;
        }

    }

    public String decode(String encoded) {
        byte[] actualByte = Base64.getDecoder()
                .decode(encoded);

        String actualString = new String(actualByte);
        return actualString;
    }

}
