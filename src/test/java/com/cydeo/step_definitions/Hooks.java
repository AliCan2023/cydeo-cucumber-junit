package com.cydeo.step_definitions;


/*
- This class  allows us to pass pre,post conditions for each scenario and each step.
 */

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //@Before(order = 1)
    public void setupScenario() {
        System.out.println("====>Setting up browser using cucumber @Before");
    }

    //@Before(value = "@login", order = 2)
    public void setupScenarioForLogins() {
        System.out.println("====>This will only apply to scenarios with @login tag.");
    }

   // @Before(value = "@db", order = 0)
    public void setupForDatabaseScenarios() {
        System.out.println("=======>This will on ly apply to scenarios with @db tag.");

    }

    @After
    public void teardownScenario(Scenario scenario) {
        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }


       // Driver.closeDriver();

//        System.out.println("====> Closing browsers using cucumber @After ");
//        System.out.println("====>Scenario ended/Take screenshot if failed!");
    }

        @BeforeStep
        public void setupStep () {
            System.out.println("------> Applying setup using cucumber @BeforeStep------->");
        }

        @AfterStep
        public void afterStep () {
            System.out.println("======> Applying tearDown using @AfterStep====>");
        }


    }

