package desafio_11;

import java.util.Random;

/**
 * Clase que genera una matriz con dimensiones aleatorias y la rellena con números aleatorios.
 * @author Alexander Silvera
 */
public class RellenarMatriz {

    /**
     * Método principal que ejecuta el programa.
     * Genera una matriz de tamaño aleatorio y la rellena con valores aleatorios.
     */
    public static void main(String[] args) {

        Random R = new Random();

        // Se generan aleatoriamente el número de filas y columnas (entre 1 y 20)
        int fila = R.nextInt(20) + 1;
        int columna = R.nextInt(20) + 1;
        int[][] matriz = new int[fila][columna];

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                matriz[i][j] = R.nextInt(100) ; 
            }
        }
        pintarMatriz(matriz);
    }

    /**
     * Método que imprime una matriz en la consola.
     * 
     * @param matriz La matriz que se va a imprimir.
     */
    private static void pintarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
            	// Formato 2 dígitos
            	System.out.print(String.format("%02d ", matriz[i][j]));
            }
            System.out.println();
        }
    }
}