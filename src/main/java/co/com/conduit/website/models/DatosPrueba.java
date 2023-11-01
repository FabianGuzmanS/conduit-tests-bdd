package co.com.conduit.website.models;

import java.util.Map;

public class DatosPrueba {
  private static Map<String, String> map;

  //Constructor vacio
  public DatosPrueba() {
  }

  //Métodos Get y Set
  public static Map<String, String> getMap() {
    return map;
  }

  public static void setMap(Map<String, String> datosPrueba) {
    map = datosPrueba;
  }

  public static String obtener(String dato) {
    return (String) getMap().get(dato);
  }
}
