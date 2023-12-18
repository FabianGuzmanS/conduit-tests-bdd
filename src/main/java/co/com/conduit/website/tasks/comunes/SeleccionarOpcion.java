package co.com.conduit.website.tasks.comunes;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.conduit.website.userinterface.comunes.Transversales.LNK_GENERIC_OPTION;
import static co.com.conduit.website.utils.transversal.Menus.getMenuOpcion;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarOpcion implements Task {

  private String menu;

  public SeleccionarOpcion(String menu){
    this.menu = menu;
  }

  @Override
  @Step("{0} selecciona una opción")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
      Click.on(LNK_GENERIC_OPTION.of(getMenuOpcion(menu)))
    );
  }

  public static SeleccionarOpcion enLaBarraDeNavegacion(String menu){
    return instrumented(SeleccionarOpcion.class, menu);
  }
}
