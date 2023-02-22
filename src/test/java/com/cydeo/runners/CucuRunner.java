package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)// this class has to have access to other projects; pass the path of the futures directory;
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = false,
        //tags = "@student"// only one scenario executed;
        //tags = "@todayIsSunnyDay"// only one scenario executed;
        tags = "@librarian or @admin "// both of them are executed once checked the condition matches;

)

public class CucuRunner {


}
