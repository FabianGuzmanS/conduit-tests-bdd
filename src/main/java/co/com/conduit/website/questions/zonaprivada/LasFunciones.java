package co.com.conduit.website.questions.zonaprivada;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;


import static co.com.conduit.website.userinterface.zonaprivada.HomePageZP.LNK_NEWARTICLE;
import static co.com.conduit.website.userinterface.zonaprivada.HomePageZP.LNK_SETTINGS;

public class LasFunciones implements Question<Boolean> {
  @Override
  public Boolean answeredBy(Actor actor) {
    Visibility.of(LNK_NEWARTICLE).answeredBy(actor);
    Visibility.of(LNK_SETTINGS).answeredBy(actor);
    return true;
  }

  public static LasFunciones deLaCuentaSonVisibles() {
    return new LasFunciones();
  }
}
