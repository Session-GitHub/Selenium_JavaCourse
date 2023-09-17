package cucumberFunctionality.scenarioOutline;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src//main//java//cucumberFunctionality//scenarioOutline//scenarioOutline.feature",
        glue = {"cucumberFunctionality" , "scenarioOutline" , "ScenarioOutlineStepDefinition"},
        dryRun = false,
        strict = true,
        //plugin = {"pretty" , "html:test-output/scenarioOutlineReport.html" , "json:json-output/scenarioOutlineReport.json" , "junit:junit-output/scenarioOutlineReport.xml"},
        monochrome = true
)

public class ScenarioOutlineRunnerClass {
}
