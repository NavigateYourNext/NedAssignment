package za.co.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/BookAppointmentFeature.feature"}
        ,glue = {"za.co.stepdefinition"}
)
public class TestRunner {
}
