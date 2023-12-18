package co.com.conduit.website.questions.zonapublica;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Disabled;

import static co.com.conduit.website.userinterface.zonapublica.LoginPage.BTN_SIGNIN;

public class ElBotonSignIn implements Question<Boolean> {

  @Override
  public Boolean answeredBy(Actor actor) {
    return Disabled.of(BTN_SIGNIN).answeredBy(actor);
  }

  public static ElBotonSignIn estaDeshabilitado(){
    return new ElBotonSignIn();
  }
}
