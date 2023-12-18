package co.com.conduit.website.questions.zonapublica;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Disabled;

import static co.com.conduit.website.userinterface.zonapublica.RegisterPage.BTN_SIGNUP;

public class ElBotonSignUp implements Question<Boolean> {
  @Override
  public Boolean answeredBy(Actor actor) {
    return Disabled.of(BTN_SIGNUP).answeredBy(actor);
  }

  public static ElBotonSignUp estaDeshabilitado(){
    return new ElBotonSignUp();
  }
}
