package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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


    //creating a utility method for ExplicitWait so that we don't have to repeat the lines;
    public static void waitForInvisibilityOf(WebElement webElement){

        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }
}
