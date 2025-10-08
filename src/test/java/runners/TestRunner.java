package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "utils"},
        tags = "@Recruitment", // Solo ejecuta escenarios con esta etiqueta
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)

public class TestRunner {
}
