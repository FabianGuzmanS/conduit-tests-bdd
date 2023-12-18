package co.com.conduit.website.userinterface.zonapublica;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

  public static final Target TXT_EMAIL =
    Target.the("Campo de texto email")
      .located(By.xpath("//input[@formcontrolname='email']"));

  public static final Target TXT_PASSWORD =
    Target.the("Campo de texto contraseña/password")
      .located(By.xpath("//input[@formcontrolname='password']"));

  public static final Target BTN_SIGNIN =
    Target.the("Botón Sign in")
      .located(By.xpath("//button[contains(text(),'Sign in')]"));
}
