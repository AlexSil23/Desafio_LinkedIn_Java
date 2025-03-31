package desafio_10;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// TODO: Auto-generated Javadoc
/**
 * The Class ContadorLetras.
 * @author Alexander Silvera
 */
public class ContadorLetras {

	/** The texto. */
	private String texto;
	
	/** The flag. */
	private boolean flag;
	
	/**
	 * Contador letras.
	 */
	public void contadorLetras() {
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("Ingrese una fase:");
			while (!flag) {
				texto = s.nextLine();
				flag = isTextoValido(texto);
			}
		}
	}

	/**
	 * Checks if is texto valido.
	 *
	 * @param dato the dato
	 * @return true, if is texto valido
	 */
	private boolean isTextoValido(String dato) {
		dato = dato.replace(" ", "");
		Map<Character, Integer> contador = new TreeMap<>();
		for (char letra : dato.toCharArray()) {
			Integer cont = contador.get(letra);
			if (cont == null) {
				cont = 0;
			}
			contador.put(letra, ++cont);
		}
		System.out.println(contador);

		return true;
	}
}
