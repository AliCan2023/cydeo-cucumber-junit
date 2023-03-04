package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.*;

public class BrowserUtilities {

    public static void sleep(int second) {
        second *= 1000;

        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            // throw new RuntimeException(e);
        }

    }
      /*
    This method will accept int(in seconds) and execute Thread.sleep
    for given duration
//Method info:
//• Name: switchWindowAndVerify
//• Return type: void
//• Arg1: WebDriver
//• Arg2: String expectedInUrl: for verify if the url contains given string.
    // If condition matches, it will break the loop.
//• Arg3: String expectedTitle: to be compared against actualTitle.
       */

    public static void switchWindowAndVerify(String expectedInURL, String expectedInTitle){
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String eachHandle : allWindowHandles) {
            Driver.getDriver().switchTo().window(eachHandle);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());
            // System.out.println("eachHandle = " + eachHandle);

            if (Driver.getDriver().getCurrentUrl().contains(expectedInURL)){
                break;
            }
        }
        // 5. Assert:Title contains expectedTitle;
        String actualTitle = Driver.getDriver().getTitle();
        //String expectedInTitle="Etsy";

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    /*
    This method accepts  a String "expectedTitle" and Asserts if it is true;
     */
    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);

    }

    /**
     * This method will accept a String as expected value and verify actual URL CONTAINS the value.
     * @param expectedInURL
     */

    public static void verifyURLContains(String expectedInURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }

    /**
     * This method accepts dropdown as a WebElement
     * and return all the options' text as a list of string;
     * @param dropdownElement
     * @return List<String> actualOptionsAsString
     */
    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){
        Select select = new Select(dropdownElement);
        //List of all actual  Options as webElements;
        List<WebElement> actualOptionsAsWebElement=  select.getOptions();

        //create a list of String and pass all actual webElement options' string into new list;
        List<String> actualOptionsAsString = new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElement) {

            actualOptionsAsString.add(each.getText());
        }
        return actualOptionsAsString;
    }


    public static void clickRadioButton(List<WebElement> radioButtons,String attributeValue){


        for (WebElement each : radioButtons) {
            if (each.getAttribute("value").equals(attributeValue)){
                each.click();
            }
        }

    }


    //creating a utility method for ExplicitWait so that we don't have to repeat the lines;
    public static void waitForInvisibilityOf(WebElement webElement){

        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }
}
