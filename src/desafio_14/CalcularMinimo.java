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
	 * Cargar array.
	 *
	 * @param array the array
	 * @return the int[]
	 */
	private static int[] cargarArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = R.nextInt(100);
		}
		return array;
	}

	/**
	 * Pintar matriz.
	 *
	 * @param array the array
	 */
	private static void pintarMatriz(int[] array) {
		for (int i = 0; i < array.length; i++) {
			// Formato 2 dígitos
			System.out.print(String.format("%02d ", array[i]));
		}
	}

	/**
	 * Minimo.
	 *
	 * @param array the array
	 * @return the int
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
