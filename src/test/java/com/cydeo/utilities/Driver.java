package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

   /*
        creating a private constructor to prevent a class from being instantiated by any other class.
    */

    private Driver() {
    }

    /*
   Making it private means that it can only be accessed within the same class;
   Making it static means that there is only one instance of this field shared among all objects of this class.
   In other words, it is a class level variable and only one copy is created for the whole class.
   In this case, the WebDriver instance is being made private and static so that it can be used by all the methods in the same class,
    and there is only one instance of it that is shared across all the objects of the class.
    */
    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            String browserType = ConfigurationReader.getProperty("browser");
            /*
            Depending on the browserType that will return from configuration.properties file
            switch statement will determine the case, and open the matching browser;
             */
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }
        }
        return driver;
    }

    /*
    This method makes sure our driver value is always null after using quit() method;
     */
    public static void  closeDriver(){
        if (driver != null){
            driver.quit();// This line terminates the existing session but the value is not even be null;
            driver=null;// keeps the driver alive but not active by doing so creates new session ID;
        }

    }

}
