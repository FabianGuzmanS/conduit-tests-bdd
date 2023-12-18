#language: es
Característica:Registrarse en el website conduit
  Yo como nuevo usuario del sitio web
  Quiero registrarme en la plataforma
  Para usar las funcionalidades que brinda

  Antecedentes:
    Dado que el usuario se encuentra en la pagina de registro "SIGN_UP"

  @RegistroNuevoUsuarioExitoso
  Esquema del escenario: Registro exitoso de nuevo usuario
    Cuando envia la informacion requerida
      | username   | email   | password   |
      | <username> | <email> | <password> |
    Entonces deberia visualizar el nombre de usuario "<username>" ingresado
    Y deberia tener acceso a las funciones de Conduit
    Ejemplos:
      | username        | email                     | password  |
      ##@externaldata@C:/TestData/testDataConduit.xlsx@1_registro_nuevo_usuario
      | usuarioPrueba15 | usuarioPrueba15@gmail.com | prueba123 |

  @RegistroFallidoCredencialesExistentes
  Esquema del escenario: Registro fallido de usuario con credenciales existentes
    Cuando envia la informacion requerida
      | username   | email   | password   |
      | <username> | <email> | <password> |
    Entonces debera ser notificado con el mensaje "<mensaje>" que las credenciales ya existen
    Ejemplos:
      | username        | email                      | password  | mensaje                                                        |
    ##@externaldata@C:/TestData/testDataConduit.xlsx@2_registro_username_existente
      | usuarioPrueba2  | usuarioPrueba2@gmail.com   | prueba123 | email has already been taken , username has already been taken |
      | usuarioPrueba2  | usuarioPrueba16@prueba.com | prueba123 | username has already been taken                                |
      | usuarioPrueba16 | usuarioPrueba2@gmail.com   | prueba123 | email has already been taken                                   |

  @RegistroFallidoDatosIncompletos
  Esquema del escenario: Registro fallido de usuario con datos incompletos
    Cuando diligencia la informacion requerida incompleta
      | username   | email   | password   |
      | <username> | <email> | <password> |
    Entonces no debe permitir enviar la informacion
    Ejemplos:
      | username       | email                    | password  |
      ##@externaldata@C:/TestData/testDataConduit.xlsx@3_registro_incompleto
      | usuarioPrueba1 | [blank]                  | prueba123 |
      | usuarioPrueba1 | usuarioPrueba1@gmail.com | [blank]   |