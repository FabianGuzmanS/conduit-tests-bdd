# Proyecto conduit tests bdd

---
## Información general
Proyecto de automatización para pruebas web, con patrón de diseño screenplay.

### Comandos de ejecución
* Para la ejecución de todo el proyecto:

  ```gradle clean test aggregate -Denvironment=qa```

* Para la ejecución por runner:

  ```gradle clean test --tests "co.com.conduit.website.runners.nombreRunner" -Denvironment=qa aggregate```