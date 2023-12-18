package co.com.conduit.website.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class CredencialesAutenticacion {
  private String email;
  private String password;

  public static List<CredencialesAutenticacion> setData(DataTable credencialesDatatable){
      List<CredencialesAutenticacion> credenciales = new ArrayList<>();
      List<Map<String,String>> filas = credencialesDatatable.asMaps();
      for (Map<String, String> mapa : filas ){
        credenciales.add(new ObjectMapper().convertValue(mapa, CredencialesAutenticacion.class));
      }
      return credenciales;
    }
}
