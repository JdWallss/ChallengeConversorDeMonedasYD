package com.AluraChallenges.ConversorDeMonedas.Models;
    public class Menu {
        private final String subMenu = """
                *****************************************************************
                         <     \uD83D\uDCB1Conversor de Moneda\uD83D\uDCB1    >
                *****************************************************************
               
                Instrucciones:
                            
                A. Elegir una opción para convertir (1 a 5)
                B. Ingresar un valor a convertir
                C. Para salir del sistema presiona cero (0)
                            
                ************************************************************************
                            
                1   -   Dólar [$USD]
                            
                2   -   Peso mexicano [$MXN]
                            
                3   -   Dólar australiano [$AUD]
                            
                4   -   Libra esterlina [$GBP]
                            
                5   -   Euro [€ EUR]
                            
                **************************************************************************
                """;
        private final String salida = """
                **************************************************************************
                *************   ¡Muchas gracias por utilizar nuestro conversor!  *********
                ***************************  ¡Hasta pronto!💸  ***************************
                """;

        public void mostrarMenu() {
            System.out.println(subMenu);
        }

        public void mostrarSalida() {
            System.out.println(salida);
        }
    }
