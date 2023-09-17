package cucumberFunctionality.dataTableInCucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src//main//java//cucumberFunctionality//dataTableInCucumber//dataTable.feature",
        glue = {"cucumberFunctionality" , "dataTableInCucumber" , "DataTableStepDefinition"},
        dryRun = false,
        strict = true,
        //plugin = {"pretty" , "html:test-output/dataTableHTML.html" , "json:json-output/dataTableJSON.json" , "junit:junit-output/dataTableXML.xml"},
        monochrome = true
)
public class DataTableRunnerClass {
}
