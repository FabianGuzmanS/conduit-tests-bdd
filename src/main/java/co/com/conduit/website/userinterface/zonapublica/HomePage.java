package co.com.conduit.website.userinterface.zonapublica;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

  public static final Target LNK_HOME =
    Target.the("Link home")
      .located(By.xpath("//a[text() = ' Home ']"));

  public static final Target LNK_SIGNUP =
    Target.the("Link sign up")
      .located(By.xpath("//a[text() = ' Sign up ']"));

  public static final Target LNK_SIGNIN =
    Target.the("Link sign in")
      .located(By.xpath("//a[text() = ' Sign in ']"));
}
