package co.com.conduit.website.tasks.zonapublica;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.conduit.website.models.DatosPrueba.obtener;
import static co.com.conduit.website.userinterface.zonapublica.RegisterPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DiligenciarRegistro implements Task {

  @Override
  @Step("{0} diligencia el formulario de registro")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
      Enter.theValue(obtener("username")).into(TXT_USERNAME),
      Enter.theValue(obtener("email")).into(TXT_EMAIL),
      Enter.theValue(obtener("password")).into(TXT_PASSWORD)
    );
  }

  public static DiligenciarRegistro conDatosIncompletos(){
    return instrumented(DiligenciarRegistro.class);
  }
}
