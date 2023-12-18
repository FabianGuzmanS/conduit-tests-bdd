package co.com.conduit.website.stepdefinitions;

import co.com.conduit.website.exceptions.zonapublica.CredencialesInvalidasException;
import co.com.conduit.website.exceptions.zonapublica.TiempoCargaException;
import co.com.conduit.website.models.CredencialesAutenticacion;
import co.com.conduit.website.questions.zonaprivada.ElNombreDeUsuario;
import co.com.conduit.website.questions.zonaprivada.LasFunciones;
import co.com.conduit.website.questions.zonapublica.ElBotonSignIn;
import co.com.conduit.website.questions.zonapublica.ElMensajeDeError;
import co.com.conduit.website.tasks.comunes.SeleccionarOpcion;
import co.com.conduit.website.tasks.zonapublica.Autenticarse;
import co.com.conduit.website.tasks.zonapublica.DiligenciarLogin;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import java.util.Arrays;
import java.util.List;

import static co.com.conduit.website.exceptions.zonapublica.CredencialesInvalidasException.CREDENCIALES_INVALIDAS;
import static co.com.conduit.website.exceptions.zonapublica.TiempoCargaException.TIEMPO_CARGA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class LoginStepDefinitions {

  @Dado("que el usuario se encuentra en la pagina de inicio de sesion {string}")
  public void queElUsuarioSeEncuentraEnLaPaginaDeInicioDeSesion(String menu) {
    theActorInTheSpotlight().wasAbleTo(SeleccionarOpcion.enLaBarraDeNavegacion(menu));
  }

  @Cuando("se autentica con sus credenciales correctas")
  public void seAutenticaConSusCredencialesCorrectas(DataTable credenciales) {
    theActorInTheSpotlight()
      .attemptsTo(Autenticarse
        .con()
        .email(CredencialesAutenticacion.setData(credenciales).get(0).getEmail())
        .yPassword(CredencialesAutenticacion.setData(credenciales).get(0).getPassword())
        .enElFormulario());
  }

  @Entonces("deberia visualizar su nombre de usuario {string}")
  public void deberiaVisualizarSuNombreDeUsuario(String username) {
    theActorInTheSpotlight()
      .should(
        seeThat(ElNombreDeUsuario.mostradoEnPantalla(username), equalTo(username))
          .orComplainWith(CredencialesInvalidasException.class, CREDENCIALES_INVALIDAS)
          .orComplainWith(TiempoCargaException.class, TIEMPO_CARGA));
  }

  @Y("deberia visualizar las funciones de Conduit de su cuenta")
  public void deberiaVisualizarLasFuncionesDeConduitDeSuCuenta() {
    theActorInTheSpotlight()
      .should(
        seeThat(LasFunciones.deLaCuentaSonVisibles(), is(true)));
  }

  @Cuando("diligencia la informacion de autenticacion incompleta")
  public void diligenciaLaInformacionDeAutenticacionIncompleta(DataTable credenciales) {
    theActorInTheSpotlight()
      .attemptsTo(
        DiligenciarLogin.conLasCredencialesIncompletas(CredencialesAutenticacion.setData(credenciales).get(0)));
  }

  @Entonces("no deberia permitir iniciar sesion")
  public void noDeberiaPermitirIniciarSesion() {
    theActorInTheSpotlight()
      .should(seeThat(ElBotonSignIn.estaDeshabilitado(), equalTo(true)));
  }

  @Cuando("se autentica con credenciales incorrectas")
  public void seAutenticaConCredencialesIncorrectas(DataTable credenciales) {
    theActorInTheSpotlight()
      .attemptsTo(
        Autenticarse
          .con()
          .email(CredencialesAutenticacion.setData(credenciales).get(0).getEmail())
          .yPassword(CredencialesAutenticacion.setData(credenciales).get(0).getPassword())
          .enElFormulario()
      );
  }

  @Entonces("deberia ser notificado con el mensaje {string}")
  public void deberiaSerNotificadoConElMensaje(String mensaje) {
    List<String> mensajesList = Arrays.asList(mensaje.trim().replace(" , ", ",").split(","));
    theActorInTheSpotlight()
      .should(seeThat(
        ElMensajeDeError.notificado(), equalTo(mensajesList)
      ));
  }
}
