package desafio_17;

import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * The Class BuscarConOrden.
 */
public class BuscarConOrden {


	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int[] lista = {9, 3, 2, 7, 8};
		Arrays.sort(lista);
		System.out.println(busquedaBinaria(lista, 7));
		System.out.println(busquedaBinaria(lista, 1));
	}
	
	/**
	 * Busqueda binaria.
	 *
	 * @param lista the lista
	 * @param elem the elem
	 * @return true, if successful
	 */
	public static boolean busquedaBinaria(int[] lista, int elem) {
		return busquedaBinariaAux(lista, elem, 0, lista.length-1);
	}
	
	/**
	 * Busqueda binaria aux.
	 *
	 * @param lista the lista
	 * @param elem the elem
	 * @param ini the ini
	 * @param fin the fin
	 * @return true, if successful
	 */
	private static boolean busquedaBinariaAux(
			int[] lista, int elem, int ini, int fin) {
		int centro = Math.floorDiv(fin - ini, 2) + ini;
		int valorCentral = lista[centro];
		if (valorCentral == elem) {
			return true;
		}
		if (fin - ini <= 1) {
			return false;
		}
		if (elem > valorCentral) {
			return busquedaBinariaAux(lista, elem, centro, fin);
		}
		return busquedaBinariaAux(lista, elem, ini, centro);
	}
}
