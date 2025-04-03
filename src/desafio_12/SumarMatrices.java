package desafio_12;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class SumarMatrices.
 * @author Alexander Silvera
 */
public class SumarMatrices {
	
	/** The r. */
	static Random R = new Random();

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		// Se generan aleatoriamente el número de filas y columnas (entre 1 y 20)
		int fila = R.nextInt(20) + 1;
		int columna = R.nextInt(20) + 1;
		int[][] matriz1 = new int[fila][columna];
		int[][] matriz2 = new int[fila][columna];
		
		//Cargar las dos matrices
		matriz1=cargarMatriz(matriz1);
		matriz2=cargarMatriz(matriz2);
		// Pintar las dos matrices 
		pintarMatriz(matriz1);
		pintarMatriz(matriz2);
		//Sumar e imprimir la matriz
		int[][] suma = sumar(matriz1, matriz2);
		pintarMatriz(suma);

	}

	/**
	 * Rellena una matriz dada con valores aleatorios entre 0 y 99.
	 * 
	 * @param matriz La matriz que se va a rellenar con números aleatorios.
	 * @return La misma matriz proporcionada, pero con valores aleatorios generados.
	 */
	private static int[][] cargarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = R.nextInt(100) ; 
            }
        }
		return matriz;
	}

	/**
	 * Suma dos matrices de las mismas dimensiones.
	 * 
	 * @param m1 La primera matriz a sumar.
	 * @param m2 La segunda matriz a sumar.
	 * @return Una nueva matriz que representa la suma de las dos matrices dadas.
	 * @throws IllegalArgumentException Si las matrices no tienen las mismas dimensiones.
	 */
	private static int[][] sumar(int[][] m1, int[][] m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length) {
			throw new IllegalArgumentException("Las dos matrices a sumar deben tener las mismas dimensiones");
		}
		int[][] suma = new int[m1.length][m1[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				suma[i][j] = m1[i][j] + m2[i][j];
			}
		}
		return suma;
	}

	/**
	 * Método que imprime una matriz en la consola.
	 * 
	 * @param matriz La matriz que se va a imprimir.
	 */
	private static void pintarMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
            	// Formato 3 dígitos
            	System.out.print(String.format("%03d ", matriz[i][j]));
            }
            System.out.println();
        }
		System.out.println();
	}
}
