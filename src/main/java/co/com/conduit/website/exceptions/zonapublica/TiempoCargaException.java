package co.com.conduit.website.exceptions.zonapublica;

public class TiempoCargaException extends AssertionError{
  public static final String TIEMPO_CARGA = "El sitio web no responde";

  public TiempoCargaException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
