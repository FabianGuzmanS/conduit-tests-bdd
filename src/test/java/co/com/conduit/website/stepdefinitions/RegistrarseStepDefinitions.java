package co.com.conduit.website.stepdefinitions;

import co.com.conduit.website.exceptions.zonapublica.InformacionRegistradaException;
import co.com.conduit.website.questions.zonaprivada.ElNombreDeUsuario;
import co.com.conduit.website.questions.zonaprivada.LasFunciones;
import co.com.conduit.website.questions.zonapublica.ElBotonSignUp;
import co.com.conduit.website.questions.zonapublica.ElMensajeDeError;
import co.com.conduit.website.tasks.comunes.SeleccionarOpcion;
import co.com.conduit.website.tasks.zonapublica.DiligenciarRegistro;
import co.com.conduit.website.tasks.zonapublica.Registrarse;
import co.com.conduit.website.utils.transversal.CargarDatos;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static co.com.conduit.website.exceptions.zonapublica.InformacionRegistradaException.CREDENCIALES_REGISTRADAS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.*;

public class RegistrarseStepDefinitions {

  @Dado("que el usuario se encuentra en la pagina de registro {string}")
  public void queElUsuarioSeEncuentraEnLaPaginaDeRegistro(String menu) {
    theActorInTheSpotlight().wasAbleTo(SeleccionarOpcion.enLaBarraDeNavegacion(menu));
  }

  @Cuando("envia la informacion requerida")
  public void enviaLaInformacionRequerida(List<Map<String, String>> informacion) {
    theActorInTheSpotlight().attemptsTo(CargarDatos.conLaSiguiente(informacion));
    theActorInTheSpotlight().attemptsTo(Registrarse.enElSitioWeb());
  }

  @Entonces("deberia visualizar el nombre de usuario {string} ingresado")
  public void deberiaVisualizarSuNombreDeUsuario(String username) {
    theActorInTheSpotlight()
      .should(
        seeThat(ElNombreDeUsuario.mostradoEnPantalla(username), equalTo(username))
          .orComplainWith(InformacionRegistradaException.class, CREDENCIALES_REGISTRADAS));
  }

  @Y("deberia tener acceso a las funciones de Conduit")
  public void deberiaTenerAccesoALasFuncionesDeConduit() {
    theActorInTheSpotlight()
      .should(
        seeThat(LasFunciones.deLaCuentaSonVisibles(), is(true)));
  }

  @Entonces("debera ser notificado con el mensaje {string} que las credenciales ya existen")
  public void deberaSerNotificadoQueLasCredencialesYaExisten(String mensajes) {
    List<String> mensajesList = Arrays.asList(mensajes.trim().replace(" , ", ",").split(","));
    theActorInTheSpotlight()
      .should(
        seeThat(ElMensajeDeError.notificado(), equalTo(mensajesList)));
  }

  @Cuando("diligencia la informacion requerida incompleta")
  public void diligenciaLaInformacionRequeridaIncompleta(List<Map<String, String>> informacion) {
    theActorInTheSpotlight().attemptsTo(CargarDatos.conLaSiguiente(informacion));
    theActorInTheSpotlight().attemptsTo(DiligenciarRegistro.conDatosIncompletos());
  }

  @Entonces("no debe permitir enviar la informacion")
  public void noDebePermitirEnviarLaInformacion() {
    theActorInTheSpotlight()
      .should(
        seeThat(ElBotonSignUp.estaDeshabilitado(), equalTo(true)));
  }
}
