package com.AluraChallenges.ConversorDeMonedas.Main;

import com.AluraChallenges.ConversorDeMonedas.Models.ConseguirCambio;
import com.AluraChallenges.ConversorDeMonedas.Models.Menu;
import com.AluraChallenges.ConversorDeMonedas.Models.Moneda;
import com.google.gson.Gson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConseguirCambio consulta = new ConseguirCambio();
        Menu menu = new Menu();
        int opcion;

        do {
            menu.mostrarMenu();
            System.out.println("Escoja una opción para la moneda de origen: ");
            opcion = Integer.parseInt(lectura.nextLine());
            String tipoDeMonedaOrigen = obtenerMoneda(opcion);
            System.out.println("Ha elegido: " + tipoDeMonedaOrigen);

            if (tipoDeMonedaOrigen != null) {
                System.out.println("Escriba la cantidad de " + tipoDeMonedaOrigen +" que desea convertir:");
                double cantidad = Double.parseDouble(lectura.nextLine());

                System.out.println("Escoja una opción de conversión para " + tipoDeMonedaOrigen +" $"+ cantidad + ": ");
                opcion = Integer.parseInt(lectura.nextLine());
                String tipoDeMonedaDestino = obtenerMoneda(opcion);

                if (tipoDeMonedaDestino != null) {
                    realizarConversion(consulta, tipoDeMonedaOrigen, tipoDeMonedaDestino, cantidad);
                } else {
                    System.out.println("Opción de moneda de destino no válida.");
                }

                System.out.println("¿Desea realizar otra conversión? (1: Sí, 0: No)");
                opcion = Integer.parseInt(lectura.nextLine());

            } else if (opcion == 0) {
                break;
            } else {
                System.out.println("Opción de moneda de origen no válida.");
            }
        } while (opcion != 0);

        menu.mostrarSalida();
        lectura.close();
    }

    private static String obtenerMoneda(int opcion) {
        return switch (opcion) {
            case 1 -> "USD";
            case 2 -> "MXN";
            case 3 -> "AUD";
            case 4 -> "GBP";
            case 5 -> "EUR";
            default -> null;
        };
    }

    private static void realizarConversion(ConseguirCambio consulta, String tipoDeMonedaOrigen, String tipoDeMonedaDestino, double cantidad) {
        Moneda moneda = consulta.buscarMoneda(tipoDeMonedaOrigen);
        Double tasaCambioOrigen = moneda.conversion_rates().get(tipoDeMonedaOrigen);
        Double tasaCambioDestino = moneda.conversion_rates().get(tipoDeMonedaDestino);

        if (tasaCambioDestino != null) {
            double conversion = ConseguirCambio.convertirMoneda(tasaCambioOrigen, tasaCambioDestino, cantidad);
            System.out.println(cantidad + " " + tipoDeMonedaOrigen + " equivale a " + conversion + " " + tipoDeMonedaDestino);
        } else {
            System.out.println("El tipo de cambio especificado no está disponible.");
        }
    }
}
