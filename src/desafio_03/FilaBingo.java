package desafio_03;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

// TODO: Auto-generated Javadoc
/**
 * The Class FilaBingo.
 * @author Alexander Silvera
 */
public class FilaBingo {

	/** The letra. */
	private LetraBingo letra;
	
	/** The numero. */
	private Set<Integer> numero;
	
	/** The r. */
	private Random R = new Random();
	
	/**
	 * Instantiates a new fila bingo.
	 *
	 * @param letra the letra
	 */
	public FilaBingo(LetraBingo letra) {
		this.letra = letra;
		this.numero = generarNumeros(letra);
	}

	/**
	 * Genera un conjunto de números aleatorios únicos dentro del rango especificado por la letra del bingo.
	 * 
	 * <p>El boleto es representado por un {@code TreeSet<Integer>}, lo que garantiza 
	 * que los números estarán ordenados automáticamente y sin duplicados.</p>
	 *
	 * @param letra Objeto {@code LetraBingo} que define los límites del rango de números.
	 * @return Un {@code Set<Integer>} con números aleatorios únicos dentro del rango de la letra del bingo.
	 */
	private Set<Integer> generarNumeros(LetraBingo letra) {
		Set <Integer> aux = new TreeSet<>();
		while(aux.size() < letra.getCap()) {
			aux.add(numeroAleatorio(letra.getMax(), letra.getMin()));
		}
		return aux;
	}

	/**
	 * Genera un número aleatorio dentro de un rango especificado.
	 * 
	 * <p>El número generado estará en el intervalo cerrado [{@code min}, {@code max}], 
	 * asegurando que el valor mínimo sea {@code min} y el máximo sea {@code max}.</p>
	 *
	 * @param max El valor máximo del rango permitido.
	 * @param min El valor mínimo del rango permitido.
	 * @return Un número aleatorio entre {@code min} y {@code max}, ambos inclusive.
	 */
	private Integer numeroAleatorio(int max, int min) {
		return R.nextInt(max - min + 1) + min;		 
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return  letra + " " + numero;
	}
}
