// Análisis: Este programa controla un sistema de recoleccion de datos de jugadores en rondas
// Descripción del programa: Permite que los jugadores registren datos y hace el onteo de la pumtuacion y el numero de rondas por jugador,
// Ademas es capaz de reconocer el jugador con mayor puntuacion
// Entradas:
// Salidas:
// Ejemplo:
package ui;

import java.util.Scanner;

public class Atlas2 {
    public static Scanner input = new Scanner(System.in);

    public static void main(String args[]) {
        int numJugadores = obtenerNumero("jugadores", 1, 10);
        int rondas = obtenerNumero("rondas", 1, 5);
        String[] jugadores = asignarJugadores(numJugadores);
        int[] puntajes = asignarPuntajes(numJugadores, rondas, jugadores);
        
        // Mostrar resultados
        System.out.println("Resultados finales");
        
        int maxPuntaje = 0;
        for (int puntaje : puntajes) {
            if (puntaje > maxPuntaje) {
                maxPuntaje = puntaje;
            }
        }
        
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println(jugadores[i] + " / Puntaje total: " + puntajes[i]);
        }
        
        System.out.println("\nJugador(es) con la mayor puntuación:");
        for (int i = 0; i < jugadores.length; i++) {
            if (puntajes[i] == maxPuntaje) {
                System.out.println(jugadores[i] + " con " + maxPuntaje + " puntos");
            }
        }

        mostrarResultados(jugadores, puntajes, rondas);
    }

    /**
     * Solicita al usuario un número dentro de un rango específico.
     * @param tipo Tipo de dato a solicitar (jugadores o rondas).
     * @param min Valor mínimo permitido.
     * @param max Valor máximo permitido.
     * @return Número ingresado válido.
     */
    public static int obtenerNumero(String tipo, int min, int max) {
        int num;
        do {
            System.out.println("Ingrese la cantidad de " + tipo + " (" + min + " - " + max + ")");
            num = input.nextInt();
            if (num < min || num > max) {
                System.out.println("Invalido. Inténtelo de nuevo.");
            }
        } while (num < min || num > max);
        return num;
    }

    /**
     * Genera un arreglo con los nombres de los jugadores.
     * @param n cantidad de jugadores
     * @return arreglo con los nombres de los jugadores
     */
    public static String[] asignarJugadores(int n) {
        String[] jugadores = new String[n];
        for (int i = 0; i < n; i++) {
            jugadores[i] = "Jugador" + (i + 1);
        }
        return jugadores;
    }

    /**
     * Solicita al usuario los puntajes de cada jugador en cada ronda y los almacena en un arreglo.
     * @param numJugadores cantidad de jugadores
     * @param rondas cantidad de rondas
     * @param jugadores arreglo con los nombres de los jugadores
     * @return arreglo con los puntajes totales de cada jugador
     */
    public static int[] asignarPuntajes(int numJugadores, int rondas, String[] jugadores) {
        int[] puntajes = new int[numJugadores];
        for (int i = 0; i < numJugadores; i++) {
            int totalPuntaje = 0;
            for (int j = 0; j < rondas; j++) {
                int puntaje;
                do {
                    System.out.println("Ingrese el puntaje de " + jugadores[i] + " en la ronda " + (j + 1) + " (0 - 100)");
                    puntaje = input.nextInt();
                    if (puntaje < 0 || puntaje > 100) {
                        System.out.println("Invalido. Inténtelo de nuevo.");
                    }
                } while (puntaje < 0 || puntaje > 100);
                totalPuntaje += puntaje;
            }
            puntajes[i] = totalPuntaje;
        }
        return puntajes;
    }

    // Método para mostrar los resultados finales
    public static void mostrarResultados(String[] jugadores, int[] puntajes, int rondas) {
        System.out.println("Resultados finales:");
        for (int i = 0; i < jugadores.length; i++) {
            double promedio = (double) puntajes[i] / rondas; 
            System.out.printf("%s / Puntaje total: %d / Promedio: %.2f%n", jugadores[i], puntajes[i], promedio);
        }
    }

}