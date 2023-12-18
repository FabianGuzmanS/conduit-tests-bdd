package co.com.conduit.website.userinterface.zonapublica;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterPage {

  public static final Target TXT_USERNAME =
    Target.the("Campo Username")
      .located(By.xpath("//input[@formcontrolname = 'username']"));

  public static final Target TXT_EMAIL =
    Target.the("Campo Email")
      .located(By.xpath("//input[@formcontrolname = 'email']"));

  public static final Target TXT_PASSWORD =
    Target.the("Campo contraseña")
      .located(By.xpath("//input[@formcontrolname = 'password']"));

  public static final Target BTN_SIGNUP =
    Target.the("Botón Sign up")
      .located(By.xpath("//button[contains(text(),'Sign up')]"));
}
