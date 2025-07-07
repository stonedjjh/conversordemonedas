# 💎 Stone Exchange - Conversor de Monedas en Java

Bienvenido a **Stone Exchange**, una aplicación de consola desarrollada en Java para convertir montos entre diferentes monedas utilizando datos en tiempo real a través de la API de Exchange Rate.

---

## 📄 Descripción

Stone Exchange es un proyecto desarrollado como parte de un desafío de backend con Java en Alura Latam. El objetivo principal es practicar el **consumo de APIs**, **manipulación de archivos**, **manejo de excepciones** y **programación orientada a objetos**.

La aplicación permite:

- **Listar monedas disponibles** para conversión.
- **Consultar información básica** de una moneda (código, nombre, país).
- **Realizar conversiones** de montos entre monedas diferentes.
- **Registrar un historial** con las conversiones realizadas, con marca de tiempo.
- **Visualizar y reiniciar** el historial de conversiones.

---

## 🛠️ Tecnologías Usadas

- **Java 17+** (`HttpClient`, `java.time`, `try-with-resources`).
- **API Exchange Rate** ([https://www.exchangerate-api.com](https://www.exchangerate-api.com)).
- **Gson** para manejo de JSON.
- **Manejo de archivos** con `FileWriter` y `FileReader`.
- **Orientación a objetos** y buenas prácticas básicas.

---

## 🚀 Cómo Ejecutar el Proyecto

1.  **Clonar el repositorio** y abrir el proyecto en IntelliJ IDEA o tu IDE preferido.
2.  **Obtener una API Key gratuita** en [Exchange Rate API](https://www.exchangerate-api.com) y exportarla en tu entorno como variable `EXCHANGE_RATE_API_KEY`.
3.  **Ejecutar la clase principal** `conversor.monedas.principal.Principal`.
4.  **Interactuar con el menú** en consola para listar monedas, consultar monedas, hacer conversiones, ver o reiniciar el historial, o salir.

---

## 🗺️ Estructura Principal del Proyecto

-   `ConexionApi`: Gestiona el consumo de la API para obtener tasas de conversión.
-   `Moneda` y `Monedas`: Modelan las monedas y su carga desde archivo.
-   `Archivo`: Maneja la persistencia del historial de conversiones en un archivo de texto (`log.txt`).
-   `Momento`: Se encarga de generar marcas de tiempo para las entradas del historial.
-   `Principal`: Contiene el menú principal y orquesta la lógica de interacción con el usuario.

---

## ✨ Funcionalidades Extras

-   Registro detallado del historial con **marca de tiempo** y detalles de la conversión.
-   Posibilidad de **reiniciar el historial** de conversiones.
-   **Ampliable a más monedas** simplemente modificando el archivo `monedas.txt`.

---

## ⚠️ Consideraciones

-   La aplicación maneja **errores básicos**, pero no es a prueba de todo tipo de entradas inválidas.
-   La **clave de API** se debe mantener privada y configurarse en la variable de entorno (`EXCHANGE_RATE_API_KEY`).
-   El archivo `log.txt` se encuentra en la **raíz del proyecto** y contiene el historial de conversiones.

---

## 👨‍💻 Autor

Daniel Jimenez - Proyecto personal desarrollado para el desafío de Alura Latam.

---

## 📝 Licencia

Este proyecto es para fines educativos y personales.

---

¡Gracias por usar Stone Exchange! 🚀