package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)// this class has to have access to other projects; pass the path of the futures directory;
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions"


)

public class CucuRunner {
}
