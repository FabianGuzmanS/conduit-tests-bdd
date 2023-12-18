package co.com.conduit.website.tasks.zonapublica;

import co.com.conduit.website.models.builders.AutenticarseBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.conduit.website.userinterface.zonapublica.LoginPage.*;

public class Autenticarse implements Task {

  private String email;
  private String password;

  public Autenticarse (String email, String password){
    this.email = email;
    this.password = password;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
      Enter.theValue(email).into(TXT_EMAIL),
      Enter.theValue(password).into(TXT_PASSWORD),
      Click.on(BTN_SIGNIN)
    );
  }

  public static AutenticarseBuilder con(){
    return new AutenticarseBuilder();
  }
}
