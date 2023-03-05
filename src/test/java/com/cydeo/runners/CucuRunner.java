package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)// this class has to have access to other projects; pass the path of the futures directory;
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
        },
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = false,
        tags = "@smoke"
//        tags = "@student"// only one scenario executed;
//        tags = "@todayIsSunnyDay"// only one scenario executed;
//        tags = "@librarian or @admin "// both of them are executed once checked the condition matches;
//        tags = " @employee and @admin"
//        tags = "@Regression and not @student"
        //tags = "@employee and not @admin"
)

public class CucuRunner {


}
