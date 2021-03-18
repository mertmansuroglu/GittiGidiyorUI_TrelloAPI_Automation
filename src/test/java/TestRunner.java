import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import seleniumFramework.Base;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features", glue = {"StepDefinitions"})
class TestRunner extends Base {


}