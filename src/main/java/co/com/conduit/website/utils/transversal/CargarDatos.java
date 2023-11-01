package co.com.conduit.website.utils.transversal;

import co.com.conduit.website.models.DatosPrueba;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CargarDatos implements Task {

  private List<Map<String, String>> datosPrueba;

  //Constructor
  public CargarDatos(List<Map<String, String>> datosPrueba) {
    this.datosPrueba = datosPrueba;
  }

  @Override
  @Step("{0} carga los datos genericos para la prueba")
  public <T extends Actor> void performAs(T actor) {
    if (!datosPrueba.isEmpty()) {
      Set<Map.Entry<String, String>> setMapaAux = datosPrueba.get(0).entrySet();
      Map<String, String> mapAuxiliar =
        setMapaAux.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
      if (DatosPrueba.getMap() == null) {
        DatosPrueba.setMap(mapAuxiliar);
      } else {
        DatosPrueba.getMap().putAll(mapAuxiliar);
      }
    }
  }

  public static CargarDatos conLaSiguiente(List<Map<String, String>> informacion) {
    return instrumented(CargarDatos.class, informacion);
  }
}
