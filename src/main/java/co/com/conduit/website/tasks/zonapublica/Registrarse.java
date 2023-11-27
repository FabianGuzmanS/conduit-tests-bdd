package co.com.conduit.website.tasks.zonapublica;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;

import static co.com.conduit.website.models.DatosPrueba.obtener;
import static co.com.conduit.website.userinterface.zonapublica.RegisterPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Registrarse implements Task {
  @Override
  @Step("{0} envia el formulario de registro diligenciado")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
      Enter.theValue(obtener("username")).into(TXT_USERNAME),
      Enter.theValue(obtener("email")).into(TXT_EMAIL),
      Enter.theValue(obtener("password")).into(TXT_PASSWORD),
      Click.on(BTN_SIGNUP)
    );
  }

  public static Registrarse enElSitioWeb(){
    return instrumented(Registrarse.class);
  }
}
