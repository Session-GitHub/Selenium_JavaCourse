package cucumberHooks;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src//test//java//cucumberHooks//hooksFeatureFile.feature",
        glue = {"cucumberHooks" , "HooksStepDefinitionFile"},
        dryRun = false,
        //plugin = {"pretty", "html:test-output/hooksHtml.html", "json:json_output/hooksJson.json", "junit:junit_xml/hooksXml.xml"},
        strict = true,
        monochrome = true
)

public class HooksRunnerClass {
}
