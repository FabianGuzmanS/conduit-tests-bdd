package co.com.conduit.website.userinterface.zonaprivada;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePageZP {

  public static final Target LNK_USERNAME =
    Target.the("Link username")
      .locatedBy("//a[text() = ' {0} ']");
}
