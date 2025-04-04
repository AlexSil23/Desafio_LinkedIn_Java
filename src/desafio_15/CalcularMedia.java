package desafio_15;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class CalcularMedia.
 * @author Alexander Silvera
 */
public class CalcularMedia {

	/** The r. */
	private static Random R = new Random();

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		int[] lista = new int[R.nextInt(10)+1];
		lista = cargarArray(lista);
		
		pintarMatriz(lista);
		System.out.println();
		System.out.println("Media del array, return Int: "+ mediaInt(lista));
		System.out.println("Media del array, return Double: "+mediaDouble(lista));
		System.out.println("Media del array, return Double con Stream: "+mediaStreams(lista));

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
	 * Media int.
	 *
	 * @param array the array
	 * @return the int
	 */
	private static int mediaInt(int[] array) {
		if(isEmpy(array)) {
			return 0;
		}
		int media = 0;
		for (int i = 0; i < array.length; i++) {
			media += array[i];
		}
		return media / array.length;
	}

	/**
	 * Media double.
	 *
	 * @param array the array
	 * @return the double
	 */
	private static double mediaDouble(int[] array) {
		if(isEmpy(array)) {
			return 0;
		}
		double media = 0;
		for (int i = 0; i < array.length; i++) {
			media += array[i];
		}
		return media / array.length;
	}

	/**
	 * Media streams.
	 *
	 * @param array the array
	 * @return the double
	 */
	private static double mediaStreams(int[] array) {
		if(isEmpy(array)) {
			return 0;
		}
		OptionalDouble media = Arrays.stream(array).average();
		return media.getAsDouble();		
	}

	/**
	 * Checks if is empy.
	 *
	 * @param array the array
	 * @return true, if is empy
	 */
	private static boolean isEmpy(int[] array) {
		if(array.length==0) {
			return true;
		}
		return false;
	}
}
