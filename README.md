# RentCar

Aplicación de escritorio para administrar clientes, vehículos y alquileres de RentCar, desarrollada en Java con JavaFX.

## Requisitos

- JDK 26 (el `pom.xml` configura `source` y `target` en 26)
- Maven

## Ejecución

En Windows, abre el proyecto en IntelliJ IDEA como proyecto Maven o ejecuta `mvnw.cmd javafx:run` desde la carpeta del proyecto.

## Pruebas unitarias

Las pruebas están separadas del código de la aplicación en `src/test/java`, organizadas por área: modelo, clientes, alquileres, liquidación e ingresos.

En Windows, ejecuta `mvnw.cmd test` desde la carpeta del proyecto. Para ejecutar también la aplicación, usa el comando de la sección anterior.

## Funcionalidades incluidas

- Registro de clientes y vehículos
- Creación de alquileres con modalidades y servicios adicionales
- Búsqueda de clientes por teléfono y verificación de número perfecto
- Consulta de ingresos por rango de fechas

Los datos actuales se mantienen en memoria durante la ejecución de la aplicación.
