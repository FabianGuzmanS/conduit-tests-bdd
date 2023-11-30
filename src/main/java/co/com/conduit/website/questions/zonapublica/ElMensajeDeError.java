package co.com.conduit.website.questions.zonapublica;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import static co.com.conduit.website.userinterface.zonapublica.RegisterPage.LBL_ERROR_MESSAGES;

public class ElMensajeDeError implements Question<List<String>> {
  @Override
  public List<String> answeredBy(Actor actor) {
    return Text.ofEach(LBL_ERROR_MESSAGES).answeredBy(actor).stream().toList();
    //return LBL_ERROR_MESSAGES.resolveAllFor(actor).texts();
  }

  public static ElMensajeDeError notificado(){
    return new ElMensajeDeError();
  }
}
