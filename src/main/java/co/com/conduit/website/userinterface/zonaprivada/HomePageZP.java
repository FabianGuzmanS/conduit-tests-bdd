package co.com.conduit.website.userinterface.zonaprivada;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePageZP {

  public static final Target LNK_USERNAME =
    Target.the("Link username")
      .locatedBy("//a[text() = ' {0} ']");

  public static final Target LNK_NEWARTICLE =
    Target.the("Link botón New Article")
      .located(By.xpath("//a[contains(text(),'New Article')]"));

  public static final Target LNK_SETTINGS =
    Target.the("Link botón Configuraciones")
      .located(By.xpath("//a[contains(text(), 'Settings')]"));
}
