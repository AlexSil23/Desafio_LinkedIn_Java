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
	 * Llena el array proporcionado con números enteros aleatorios entre 0 y 99 (inclusive).
	 * 
	 * Este método modifica directamente el array recibido como parámetro, asignando
	 * un número aleatorio en cada posición.
	 *
	 * @param array El array de enteros que se desea llenar con valores aleatorios.
	 * @return El mismo array recibido, con todos sus elementos reemplazados por números aleatorios.
	 */
	private static int[] cargarArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = R.nextInt(100);
		}
		return array;
	}

	/**
	 * Imprime en consola los elementos de un array en una sola línea,
	 * utilizando un formato de dos dígitos por número (rellenando con ceros a la izquierda si es necesario).
	 * 
	 * Por ejemplo, el número 7 se imprimirá como "07".
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
	 * Calcula y devuelve la media (promedio entero) de los elementos de un array de enteros.
	 * 
	 * Si el array está vacío o es nulo, devuelve 0.
	 *
	 * @param array El array de enteros del cual se desea calcular la media.
	 * @return La media aritmética entera de los valores del array, o 0 si el array está vacío o nulo.
	 */
	private static int mediaInt(int[] array) {
		if(isEmpty(array)) {
			return 0;
		}
		int media = 0;
		for (int i = 0; i < array.length; i++) {
			media += array[i];
		}
		return media / array.length;
	}

	/**
	 * Calcula y devuelve la media (promedio) en formato decimal de los elementos de un array de enteros.
	 * 
	 * Si el array está vacío o es nulo, devuelve 0.0.
	 *
	 * @param array El array de enteros del cual se desea calcular la media.
	 * @return La media aritmética como valor decimal de los elementos del array, o 0.0 si el array está vacío o nulo.
	 */
	private static double mediaDouble(int[] array) {
		if(isEmpty(array)) {
			return 0;
		}
		double media = 0;
		for (int i = 0; i < array.length; i++) {
			media += array[i];
		}
		return media / array.length;
	}

	/**
	 * Calcula y devuelve la media (promedio) en formato decimal de los elementos de un array de enteros,
	 * utilizando la API de streams de Java.
	 * 
	 * Si el array está vacío o es nulo, devuelve 0.0.
	 *
	 * @param array El array de enteros del cual se desea calcular la media.
	 * @return La media aritmética como valor decimal de los elementos del array, o 0.0 si el array está vacío o nulo.
	 */
	private static double mediaStreams(int[] array) {
		if(isEmpty(array)) {
			return 0;
		}
		OptionalDouble media = Arrays.stream(array).average();
		return media.getAsDouble();		
	}

	/**
	 * Verifica si un array de enteros está vacío.
	 * 
	 * Un array se considera vacío si tiene longitud cero. Este método no verifica si el array es nulo.
	 *
	 * @param array El array de enteros a comprobar.
	 * @return {@code true} si el array tiene longitud cero, {@code false} en caso contrario.
	 */
	private static boolean isEmpty(int[] array) {
		 return array == null || array.length == 0;
	}
}
