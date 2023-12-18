package co.com.conduit.website.runners;

import co.com.conduit.website.utils.excelData.BeforeSuite;
import co.com.conduit.website.utils.excelData.DataToFeature;
import co.com.conduit.website.utils.excelData.RunnerPersonalizado;
import io.cucumber.junit.CucumberOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
  features = "src/test/resources/features/login.feature",
  glue = "co.com.conduit.website.stepdefinitions",
  snippets = CucumberOptions.SnippetType.CAMELCASE
  //tags = "@LoginFallidoCredencialesIncorrectas"
)
public class LoginRunner {

  private LoginRunner() {
  }

  @BeforeSuite
  public static void test() throws IOException, InvalidFormatException {
    DataToFeature.overrideFeatureFiles("src/test/resources/features/login.feature");
  }
}
