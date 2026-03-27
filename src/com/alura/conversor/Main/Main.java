package com.alura.conversor.Main;

// Import de clases de otros paquetes
import com.alura.conversor.calculos.ConsultaMoneda;
import com.alura.conversor.calculos.GeneradorDeCalculos;
import com.alura.conversor.modelos.Moneda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

           // Primero creamos el objeto Scanner una sola vez para todos los ingresos.
            Scanner lectura = new Scanner(System.in);

            //Instancia una nueva consulta (vinculado a ConsultaMoneda)
            ConsultaMoneda consulta = new ConsultaMoneda();



        System.out.println("****************************************");
        System.out.println("Bienvenido al conversor de monedas");
        System.out.println("****************************************");
        System.out.println("Conversiones disponibles:");
        System.out.println("ARS - Peso argentino");
        System.out.println("BOB - Boliviano boliviano");
        System.out.println("BRL - Real brasileño");
        System.out.println("COP - Peso colombiano");
        System.out.println("USD - Dólar estadounidense");

        System.out.println("Por favor ingrese el código (3 letras) de la moneda de origen (moneda que desea cambiar): ");

        // Usamos el objeto para leer y guardar lo ingresado en un String
        String base_code = lectura.nextLine().toUpperCase();

        //Solicitamos el ingreso del total a cambiar
        System.out.println("Por favor, ingrese el monto que desea cambiar");

        //Uso .nextLine para leer toda la linea como un texto y luego transformar a número para evitar errores.
        //La clase GeneradorDeCalculos toma Cantidad para hacer los calculos matematicos.
        double cantidad = Double.parseDouble(lectura.nextLine());


        System.out.println("Por favor ingrese el código (3 letras) de la moneda de destino (moneda que desea obtener): ");

        // Usamos el objeto para leer y guardar lo ingresado en un String
        String target_code = lectura.nextLine().toUpperCase();


        // Llama al metodo buscarMoneda (de la clase ConsultaMoneda) pasando los códigos segun el ISO4217 (estándar internacional que define códigos de tres letras para identificar cada moneda del mundo)
        Moneda moneda = consulta.buscarMoneda(base_code, target_code);

            System.out.printf("La tasa de cambio es: %.6f %n", moneda.conversion_rate());


            //Instanciamos el GeneradorDeCaluculos para la parte matemática
            GeneradorDeCalculos generador = new GeneradorDeCalculos();
            //Generamos el calculo matemático
            double resultado = generador.convertir(cantidad, moneda);
            System.out.printf("Usted obtendrá %.2f %s%n", resultado, target_code);

        }


    }


    /***
     * Flujo lógico del programa:
     * 1) Main le pide a ConsultaMoneda los datos de la API.
     * 2) ConsultaMoneda devuelve un objeto Moneda (record) lleno de info.
     * 3) Main le entrega ese objeto a GeneradorDeCalculos para que haga la matemática.
     *
     * **/
