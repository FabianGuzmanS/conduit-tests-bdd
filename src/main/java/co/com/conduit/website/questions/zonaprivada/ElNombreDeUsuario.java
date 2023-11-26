package co.com.conduit.website.questions.zonaprivada;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.conduit.website.models.DatosPrueba.obtener;
import static co.com.conduit.website.userinterface.zonaprivada.HomePageZP.LNK_USERNAME;

public class ElNombreDeUsuario implements Question<String> {
  @Override
  public String answeredBy(Actor actor) {
    return Text.of(LNK_USERNAME.of(obtener("username"))).answeredBy(actor);
  }

  public static ElNombreDeUsuario mostrado(){
    return new ElNombreDeUsuario();
  }
}
