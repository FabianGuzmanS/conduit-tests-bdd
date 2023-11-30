#language: es
Característica:Registrarse en el website conduit
  Yo como nuevo usuario del sitio web
  Quiero registrarme en la plataforma
  Para usar las funcionalidades que brinda

  Antecedentes:
    Dado que el usuario se encuentra en la pagina de registro

  @RegistroNuevoUsuarioExitoso
  Esquema del escenario: Registro exitoso de nuevo usuario
    Cuando envia la informacion requerida
      | username   | email   | password   |
      | <username> | <email> | <password> |
    Entonces debera visualizar la pantalla de inicio zona privada con el nombre de usuario "<username>"
    Ejemplos:
      | username       | email                    | password  |
      ##@externaldata@C:/TestData/testDataConduit.xlsx@registro_nuevo_usuario
   |usuarioPrueba5   |usuarioPrueba5@gmail.com   |prueba123|

  @RegistroFallidoCredencialesExistentes
  Esquema del escenario: Registro fallido de usuario con credenciales existentes
    Cuando envia la informacion requerida
      | username   | email   | password   |
      | <username> | <email> | <password> |
    Entonces debera ser notificado con el mensaje "<mensaje>" que las credenciales ya existen
    Ejemplos:
      | username       | email                   | password  | mensaje                                                        |
    ##@externaldata@C:/TestData/testDataConduit.xlsx@registro_username_existente
   |usuarioPrueba2   |usuarioPrueba2@gmail.com   |prueba123   |email has already been taken , username has already been taken|
   |usuarioPrueba2   |usuarioPrueba6@prueba.com   |prueba123   |username has already been taken|
   |usuarioPrueba6   |usuarioPrueba2@gmail.com   |prueba123   |email has already been taken|

  @RegistroFallidoDatosIncompletos
  Esquema del escenario: Registro fallido de usuario con datos incompletos
    Cuando diligencia la informacion requerida incompleta
      | username   | email   | password   |
      | <username> | <email> | <password> |
    Entonces no debe permitir enviar la informacion
    Ejemplos:
      | username     | email                  | password |
      ##@externaldata@C:/TestData/testDataConduit.xlsx@registro_incompleto
   |usuarioPrueba1   |[blank]   |prueba123|
   |usuarioPrueba1   |usuarioPrueba1@gmail.com   |[blank]|
