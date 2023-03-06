package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
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
    /*
    We make WebDriver private, because we want to close access from outside the class.
    We make it static because we will use it in a static method.
     */
    //private static WebDriver driver;// value is null by default

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    /*
    this code is commonly used in Selenium test automation to create a thread-safe and reusable pool of WebDriver objects.
    By using an InheritableThreadLocal object, the code ensures that each thread has its own WebDriver instance,
    which can be reused across multiple test cases. This helps to improve the performance and stability of the test suite.
     */

    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */

    public static WebDriver getDriver() {

        if (driverPool.get() == null) {
            String browserType = ConfigurationReader.getProperty("browser");
            /*
            Depending on the browserType that will return from configuration.properties file
            switch statement will determine the case, and open the matching browser;
             */
            switch (browserType){
                case "chrome":

                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "remote-chrome":
                    // assign your grid server address
                    String gridAdress = "54.89.242.106"; // put your own Linux grid IP here
                    try {
                        URL url = new URL("http://"+gridAdress+":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url,desiredCapabilities));
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "saucelab-chrome":
                    try{
                        URL url = new URL("https://oauth-sdetoscar-844c8:66e7117f-390e-4556-8105-07af96a01f7a@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url,desiredCapabilities));
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    }catch (MalformedURLException e){
                        e.printStackTrace();
                    }

                    break;
                case "saucelab-edge":
                    EdgeOptions browserOptions = new EdgeOptions();
                    browserOptions.setCapability("platformName", "Windows 11");
                    browserOptions.setCapability("browserVersion", "latest");
                    Map<String, Object> sauceOptions = new HashMap<>();
                    sauceOptions.put("build", "<your build id>");
                    sauceOptions.put("name", "<your test name>");
                    browserOptions.setCapability("sauce:options", sauceOptions);

                    URL url = null;
                    try {
                        url = new URL("https://oauth-sdetoscar-844c8:66e7117f-390e-4556-8105-07af96a01f7a@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                        driverPool.set(new RemoteWebDriver(url,browserOptions));
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;

            }

        }

        return driverPool.get();

    }

    /*
    This method makes sure our driver value is always null after using quit() method;
     */
    public static void  closeDriver(){
        if (driverPool.get() != null){
            driverPool.get().quit();// This line terminates the existing session but the value is not even be null;
            driverPool=null;// keeps the driver alive but not active by doing so creates new session ID;
        }

    }

}
