package desafio_14;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class CalcularMinimo.
 * @author Alexander Silvera
 */
public class CalcularMinimo {

	/** The r. */
	private static Random R = new Random();

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		int[] lista = new int[R.nextInt(10)];
		lista = cargarArray(lista);
		
		pintarMatriz(lista);
		
		System.out.println();
		System.out.println(String.format("%02d ",minimo(lista)));
	}

	/**
	 * Carga un array dado con números aleatorios entre 0 y 99.
	 * 
	 * @param array El array que se desea llenar con números aleatorios.
	 * @return El mismo array después de ser cargado con números aleatorios.
	 */
	private static int[] cargarArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = R.nextInt(100);
		}
		return array;
	}

	/**
	 * Imprime en consola los elementos de un array en una sola línea,
	 * mostrando cada número con formato de dos dígitos (rellenando con ceros si es necesario).
	 *
	 * @param array El array de enteros que se desea imprimir.
	 */
	private static void pintarMatriz(int[] array) {
		for (int i = 0; i < array.length; i++) {
			// Formato 2 dígitos
			System.out.print(String.format("%02d ", array[i]));
		}
	}

	/**
	 * Calcula y devuelve el valor mínimo contenido en un array de enteros.
	 *
	 * @param array El array de enteros del cual se desea obtener el valor mínimo.
	 * @return El menor valor encontrado en el array.
	 */
	private static int minimo(int[] array) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

}
