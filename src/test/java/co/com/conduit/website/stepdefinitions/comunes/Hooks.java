package co.com.conduit.website.stepdefinitions.comunes;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.conduit.website.utils.constantes.Constantes.ACTOR;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class Hooks {

  private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class);

  @BeforeAll
  public static void setUpBrowser() {
    switch (SystemEnvironmentVariables.createEnvironmentVariables().getProperty("webdriver.driver")) {
      case "chrome":
        WebDriverManager.chromedriver().setup();
        break;
      case "ie":
      case "iexplorer":
        WebDriverManager.iedriver().setup();
        break;
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        break;
      default:
        WebDriverManager.chromedriver().setup();
        break;
    }
  }

  @Before
  public void setUp() {
    setTheStage(new OnlineCast());
    theActorCalled(ACTOR);
    if (SystemEnvironmentVariables.createEnvironmentVariables().getProperty("environment") != null) {
      String environmentVariable = getEnvironment();
      LOGGER.info("Ambiente en que corre el proceso. $Environment: " +  environmentVariable);
      switch (environmentVariable) {
        case "qa":
          String environmentQa = SystemEnvironmentVariables.createEnvironmentVariables().getProperty("environments.qa.webdriver.base.url");
          theActorInTheSpotlight().wasAbleTo(Open.url(environmentQa));
          break;
        case "dev":
          String environmentDev = SystemEnvironmentVariables.createEnvironmentVariables().getProperty("environments.dev.webdriver.base.url");
          theActorInTheSpotlight().wasAbleTo(Open.url(environmentDev));
          break;
        case "prod":
          String environmentProd = SystemEnvironmentVariables.createEnvironmentVariables().getProperty("environments.prod.webdriver.base.url");
          theActorInTheSpotlight().wasAbleTo(Open.url(environmentProd));
          break;
      }
    } else {
      String environmentDefault = SystemEnvironmentVariables.createEnvironmentVariables().getProperty("environments.default.webdriver.base.url");
      theActorInTheSpotlight().wasAbleTo(Open.url(environmentDefault));
    }
  }

  private String getEnvironment(){
    EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    return environmentVariables.getProperty("environment");
  }
}
