package co.com.conduit.website.exceptions.zonapublica;

public class InformacionRegistradaException extends AssertionError {

  public static final String CREDENCIALES_REGISTRADAS = "La información enviada, ya se encuentra registrada";

  public InformacionRegistradaException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
