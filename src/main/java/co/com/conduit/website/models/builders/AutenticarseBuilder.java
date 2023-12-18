package co.com.conduit.website.models.builders;

import co.com.conduit.website.tasks.zonapublica.Autenticarse;
import lombok.Data;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@Data
public class AutenticarseBuilder {

  private String email;
  private String password;

  public AutenticarseBuilder email(String email) {
    this.email = email;
    return this;
  }

  public AutenticarseBuilder yPassword(String password) {
    this.password = password;
    return this;
  }

  public Autenticarse enElFormulario() {
    return instrumented(Autenticarse.class, email, password);
  }
}
