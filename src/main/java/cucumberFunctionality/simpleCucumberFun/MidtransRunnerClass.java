package cucumberFunctionality.simpleCucumberFun;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (

        features = "src//main//java//cucumberFunctionality//simpleCucumberFun//midtransFeatureFile.feature",
        glue = {"cucumberFunctionality" , "simpleCucumberFun" , "MidtransStepDefinition"},
        dryRun = false,
        strict = true,
        plugin = {"pretty", "html:test-output/simpleTestHTML.html", "json:json_output/simpleTestJson.json", "junit:junit_xml/simpleTestXml.xml"},
        monochrome = true
)

public class MidtransRunnerClass {
}
