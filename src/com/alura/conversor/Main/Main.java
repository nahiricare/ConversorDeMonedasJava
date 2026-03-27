// Import de clases de otros paquetes
import com.alura.conversor.calculos.ConsultaMoneda;
import com.alura.conversor.calculos.GeneradorDeCalculos;
import com.alura.conversor.modelos.Moneda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public static void main(String[] args) {
    //Iniciamos el scanner para leer los datos ingresados
    Scanner lectura = new Scanner(System.in);
    // Instanciamos una nueva consulta
    ConsultaMoneda consulta = new ConsultaMoneda();
    // Instanciamos el generador de calculos matematicos
    GeneradorDeCalculos generador = new GeneradorDeCalculos();
    //Generamos una lista para guardar el historial
    List<String> historial = new ArrayList<>();

    // un bucle para que no se cierre el sistema despues de cada consulta
    while (true) {
        System.out.println("****************************************");
        System.out.println("Bienvenido al conversor de monedas");
        System.out.println("Escriba 'SALIR' para terminar y generar el reporte.");
        System.out.println("****************************************");

        System.out.println("Ingrese la moneda de origen (ej: USD):");
        String base_code = lectura.nextLine().toUpperCase();

        if (base_code.equals("SALIR")) {
            break; // Rompe el bucle y va a la línea 56 (escritura de archivo)
        }

        System.out.println("Ingrese el monto a cambiar:");
        double cantidad = Double.parseDouble(lectura.nextLine());

        System.out.println("Ingrese la moneda de destino (ej: ARS):");
        String target_code = lectura.nextLine().toUpperCase();

        try {
            // Hacemos la consulta y el cálculo
            Moneda moneda = consulta.buscarMoneda(base_code, target_code);
            double resultado = generador.convertir(cantidad, moneda);

            // Formateamos el mensaje
            String mensaje = String.format("%s - Convertido %.2f [%s] a >>> %.2f [%s] (Tasa: %.6f)",
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),
                    cantidad, base_code, resultado, target_code, moneda.conversion_rate());

            System.out.println("\n" + mensaje + "\n");

            // Lo agregamos a la lista
            historial.add(mensaje);

        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //por fuera del bucle armamos el documento
    if (!historial.isEmpty()) {
        try (java.io.FileWriter escritura = new java.io.FileWriter("historial_conversiones.txt")) {
            escritura.write("--- REPORTE DE CONVERSIONES ---\n");
            for (String registro : historial) {
                escritura.write(registro + "\n");
            }
            System.out.println("✅ Se ha generado el archivo 'historial_conversiones.txt' con éxito.");
        } catch (java.io.IOException e) {
            System.out.println("❌ No se pudo guardar el historial: " + e.getMessage());
        }
    }
    System.out.println("¡Gracias por usar el conversor!");
}


    /***
     * Flujo lógico del programa:
     * 1) Main le pide a ConsultaMoneda los datos de la API.
     * 2) ConsultaMoneda devuelve un objeto Moneda (record) lleno de info.
     * 3) Main le entrega ese objeto a GeneradorDeCalculos para que haga la matemática.
     *
     * **/
