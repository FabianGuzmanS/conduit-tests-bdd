package co.com.conduit.website.utils.transversal;

public enum Menus {
  SIGN_UP("Sign up"),
  SIGN_IN("Sign in");

  private String menu;

  Menus(String menu) {
    this.menu = menu;
  }

  public String getMenu(){
    return menu;
  }

  public static String getMenuOpcion(String menuEnum) {
    for (Menus menu : Menus.values()) {
      if(menu.name().equalsIgnoreCase(menuEnum)) {
        return menu.getMenu();
      }
    }
    throw new IllegalArgumentException("Nombre de menú no valido o existente: " + menuEnum);
  }
}
