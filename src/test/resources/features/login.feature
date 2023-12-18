#language: es
Característica: Iniciar sesion en el website conduit
  Yo como usuario registrado en el sitio web Conduit
  Quiero iniciar sesión con mis credenciales
  Para acceder a las funciones de mi cuenta

  Antecedentes:
    Dado que el usuario se encuentra en la pagina de inicio de sesion "SIGN_IN"

  @LoginUsuarioExitoso
  Esquema del escenario: Login de usuario exitoso
    Cuando se autentica con sus credenciales correctas
      | email   | password   |
      | <email> | <password> |
    Entonces deberia visualizar su nombre de usuario "<username>"
    Y deberia visualizar las funciones de Conduit de su cuenta
    Ejemplos:
      | email                    | password  | username        |
      ##@externaldata@C:/TestData/testDataConduit.xlsx@4_autenticacion_exitosa
      | usuarioPrueba1@gmail.com | prueba123 | usuarioPrueba17 |

  @LoginFallidoCredencialesIncompletas
  Esquema del escenario: Login fallido con credenciales incompletas
    Cuando diligencia la informacion de autenticacion incompleta
      | email   | password   |
      | <email> | <password> |
    Entonces no deberia permitir iniciar sesion
    Ejemplos:
      | email                    | password  |
    ##@externaldata@C:/TestData/testDataConduit.xlsx@5_login_incompleto
      | usuarioPrueba1@gmail.com | [blank]   |
      | [blank]                  | prueba123 |

  @LoginFallidoCredencialesIncorrectas
  Esquema del escenario: Login fallido con credenciales incorretas
    Cuando se autentica con credenciales incorrectas
      | email   | password   |
      | <email> | <password> |
    Entonces deberia ser notificado con el mensaje "<mensaje>"
    Ejemplos:
      | email                    | password    | mensaje                      |
      ##@externaldata@C:/TestData/testDataConduit.xlsx@6_autenticacion_fallida
      | usuarioPrueba1@gmail.com | badPassword | email or password is invalid |
      | wrongTestUser@gmail.com  | prueba123   | email or password is invalid |
