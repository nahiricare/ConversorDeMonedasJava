# **💱 Conversor de Monedas en Java**

¡Bienvenido al Conversor de Monedas! 
Este es un proyecto desarrollado como parte del desafío de Alura Latam en el programa Oracle Next Education. La aplicación permite realizar conversiones de divisas en tiempo real utilizando una API externa.

## **🚀 Funcionalidades**

Consulta en tiempo real: Utiliza la API de _ExchangeRate-API_ para obtener las tasas más actualizadas.

Soporte multi-moneda: Permite elegir entre las principales monedas de la región (ARS, BRL, COP, BOB, CLP, USD).

Interfaz por consola: Un menú interactivo y amigable para el usuario.

Formateo de datos: Muestra los resultados con precisión decimal y sin notación científica confusa.

## **🛠️ Tecnologías utilizadas**

_Java 17+_ (o la versión que estés usando).

_Gson 2.13.2:_ Para la manipulación y deserialización de datos JSON.

_HttpClient:_ Para realizar peticiones HTTP de forma asíncrona y moderna.

_Records:_ Para una estructura de datos inmutable y limpia.

## **📋 Estructura del Proyecto**

El código se divide en paquetes siguiendo buenas prácticas de separación de **responsabilidades:**

_modelos:_ Contiene el Record Moneda.

_calculos:_ Contiene la lógica de conexión (ConsultaMoneda) y la lógica matemática (GeneradorDeCalculos).

_Main:_ Clase principal que gestiona la interacción con el usuario.

## **⚙️ Cómo ejecutar el proyecto**

Clona el repositorio.

Importa el proyecto en tu IDE favorito (Recomendado: IntelliJ IDEA).

Asegúrate de tener la librería Gson agregada a tus dependencias.

En la clase ConsultaMoneda, reemplaza el espacio de la API Key con tu propia clave.

Ejecuta la clase Main.

