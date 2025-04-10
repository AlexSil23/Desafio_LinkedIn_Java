package desafio_16;

// TODO: Auto-generated Javadoc
/**
 * The Class BuscarSinOrden.
 */
public class BuscarSinOrden {
	

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int[] lista = {9, 3, 2, 7, 8};
		System.out.println(buscar(lista, 7));
		System.out.println(buscarWhile(lista, 7));
		System.out.println(buscar(lista, 1));
		System.out.println(buscarWhile(lista, 1));
	}
	
	/**
	 * Buscar.
	 *
	 * @param lista the lista
	 * @param valor the valor
	 * @return true, if successful
	 */
	public static boolean buscar(int[] lista, int valor) {
		for (int n : lista) {
			if (n == valor) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Buscar while.
	 *
	 * @param lista the lista
	 * @param valor the valor
	 * @return true, if successful
	 */
	public static boolean buscarWhile(int[] lista, int valor) {
		boolean encontrado = false;
		int i = 0;
		while (!encontrado && i < lista.length) {
			encontrado = lista[i] == valor;
			i++;
		}
		return encontrado;
	}

}