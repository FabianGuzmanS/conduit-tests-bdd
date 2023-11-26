package co.com.conduit.website.tasks.comunes;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.conduit.website.userinterface.zonapublica.HomePage.LNK_SIGNUP;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarOpcion implements Task {

  @Override
  @Step("{0} selecciona una opción")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
      Click.on(LNK_SIGNUP));
  }

  public static SeleccionarOpcion enLaBarraDeNavegacion(){
    return instrumented(SeleccionarOpcion.class);
  }
}
