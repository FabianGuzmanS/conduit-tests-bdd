package co.com.conduit.website.exceptions.zonapublica;

public class CredencialesInvalidasException extends AssertionError{
  public static final String CREDENCIALES_INVALIDAS = "Las credenciales enviadas son invalidas";

  public CredencialesInvalidasException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }

}
