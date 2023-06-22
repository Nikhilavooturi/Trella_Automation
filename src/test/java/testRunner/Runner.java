package testRunner;

import classes.OpenBrowser;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;


@RunWith(Cucumber.class)
@CucumberOptions(features="features",glue={"stepDefinition"}, plugin = {"json:target/cucumber-reports/cucumber.json"})
public class Runner
{
    @AfterSuite
    public void closeBrowser() {
        OpenBrowser.driver.quit();
    }
}
