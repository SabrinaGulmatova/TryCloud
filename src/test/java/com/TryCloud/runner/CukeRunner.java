package com.TryCloud.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions                     //This option is giving everything from the cucumber

        (
                plugin = {"pretty",
                        "html:target/cucumber-report.html",
                        "rerun:target/rerun.txt" ,
                        "me.jvt.cucumber.report.PrettyReports:target/cucumber"//we will create rerun under target folder and name it rerun.txt
                },
                features = "src/test/resources/features",//features/googleSearch.feature
                glue = "com/TryCloud/step_definition", // glue is mean the implementation of
                //step_definition folder
                dryRun = false, // To check if anything unimplemented in the project
                //default is already false
                tags = "@feature" ,  //Help us to know which annotation we need to run by giving tags name ex: @smoke @regression
                publish = true

        )
public class CukeRunner {
}
