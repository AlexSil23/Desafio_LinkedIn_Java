package desafio_13;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class MultiplicarMatrices.
 * @author Alexander Silvera
 */
public class MultiplicarMatrices {

	/** The r. */
	static Random R = new Random();
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		int fila = R.nextInt(10) + 1;
		int columna = R.nextInt(10) + 1;
		int[][] matriz1 = new int[fila][columna];
		int[][] matriz2 = new int[columna][fila];
		
		//Cargar las dos matrices
		matriz1=cargarMatriz(matriz1);
		matriz2=cargarMatriz(matriz2);
		// Pintar las dos matrices 
		pintarMatriz(matriz1);
		pintarMatriz(matriz2);
		int[][] producto = multiplicar(matriz1, matriz2);
		pintarMatriz(producto);

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
	 * Multiplica dos matrices de dimensiones compatibles.
	 * 
	 * La multiplicación de matrices es posible si el número de columnas de la primera matriz
	 * es igual al número de filas de la segunda matriz. El resultado será una nueva matriz 
	 * cuyo número de filas es el mismo que la primera matriz y el número de columnas es 
	 * el mismo que la segunda matriz.
	 * 
	 * @param m1 La primera matriz (de tamaño f1 x c1).
	 * @param m2 La segunda matriz (de tamaño f2 x c2).
	 * @return Una nueva matriz que representa el producto de m1 por m2.
	 * @throws IllegalArgumentException Si las matrices no tienen dimensiones compatibles 
	 *         para la multiplicación (es decir, si el número de columnas de la primera matriz
	 *         no es igual al número de filas de la segunda matriz).
	 */
	private static int[][] multiplicar(int[][] m1, int[][] m2) {
		int f1 = m1.length;
		int c1 = m1[0].length;
		int f2 = m2.length;
		int c2 = m2[0].length;
		
		if (c1 != f2) {
			throw new IllegalArgumentException(
				"El número de columnas de la primera matriz debe coincidir con el número de filas de la segunda");
		}
		int[][] producto = new int[f1][c2];
		for (int i = 0; i < f1; i ++) {
			for (int j = 0; j < c2; j++) {
				int prod = 0;
				for (int k = 0; k < c1; k++) {
					prod += m1[i][k] * m2[k][j]; 
				}
				producto[i][j] = prod;
			}
		}
		return producto;
	}

	/**
	 * Método que imprime una matriz en la consola.
	 * 
	 * @param matriz La matriz que se va a imprimir.
	 */
	private static void pintarMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
            	// Formato 5 dígitos
            	System.out.print(String.format("%05d ", matriz[i][j]));
            }
            System.out.println();
        }
		System.out.println();
	}
}
