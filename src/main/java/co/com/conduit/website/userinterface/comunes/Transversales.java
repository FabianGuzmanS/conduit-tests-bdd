package co.com.conduit.website.userinterface.comunes;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Transversales {

  public static final Target LNK_GENERIC_OPTION =
    Target.the("Link generico opcion navbar")
      .locatedBy("//a[text() = ' {0} ']");

  public static final Target LBL_ERROR_MESSAGES =
    Target.the("Mensajes de error")
      .located(By.xpath("//ul[@class = 'error-messages']/li"));
}
