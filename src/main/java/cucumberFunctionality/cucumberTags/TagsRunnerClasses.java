package cucumberFunctionality.cucumberTags;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src//main//java//cucumberFunctionality//cucumberTags//tagsFeatureFile.feature",
        glue = {"cucumberFunctionality" , "cucumberTags" , "TagsStepDefinition"},
        dryRun = false,
        strict = true,
        //plugin = {"pretty" , "html:test-output/tagsReportHtml.html" , "json:json-output/tagsReportJson.json" , "junit:junit-output/tagsReportXml.xml"},
        monochrome = true
        //tags = {"not @google"}
        //tags = {"@google or @facebook"}
        //tags = {"not @google" , "not @renewbuy"}
        //tags = {"(@google or @youtube) and (not @facebook or not @renewbuy)"}
)


public class TagsRunnerClasses {
}
