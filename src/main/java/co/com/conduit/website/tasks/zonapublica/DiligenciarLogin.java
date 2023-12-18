package co.com.conduit.website.tasks.zonapublica;

import co.com.conduit.website.models.CredencialesAutenticacion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.conduit.website.userinterface.zonapublica.LoginPage.TXT_EMAIL;
import static co.com.conduit.website.userinterface.zonapublica.LoginPage.TXT_PASSWORD;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DiligenciarLogin implements Task {

  private CredencialesAutenticacion credencialesAutenticacion;

  public DiligenciarLogin(CredencialesAutenticacion credencialesAutenticacion){
    this.credencialesAutenticacion = credencialesAutenticacion;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
      Enter.theValue(credencialesAutenticacion.getEmail()).into(TXT_EMAIL),
      Enter.theValue(credencialesAutenticacion.getPassword()).into(TXT_PASSWORD)
    );
  }

  public static DiligenciarLogin conLasCredencialesIncompletas(CredencialesAutenticacion credenciales){
    return instrumented(DiligenciarLogin.class, credenciales);
  }
}
