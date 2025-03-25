package desafio_02;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

// TODO: Auto-generated Javadoc
/**
 * The Class Boleto.
 * @author Alexander Silvera
 */
public class Boleto {

	/** The max boleto. */
	private final int MAX_NUMERO = 49;
	
	/** The max reintegro. */
	private final int MAX_REINTEGRO = 10;
	
	/** The min. */
	private final int MIN = 1;
	
	/** The num. */
	private final int NUM = 6;
	
	/** The r. */
	private Random R = new Random();
	
	/** The boleto. */
	private Set<Integer> numero;
	
	/** The num reintegro. */
	private int numReintegro;
	
	/**
	 * Instantiates a new boleto.
	 */
	public Boleto() {
		this.numero = generarNumeros();
		this.numReintegro = generarReintegro();
	}
	
	/**
	 * Genera un número aleatorio para el reintegro dentro del rango permitido.
	 * 
	 * <p>El valor generado estará en el intervalo [MIN, MAX_REINTEGRO], 
	 * asegurando que sea un número válido dentro del rango especificado.</p>
	 *
	 * @return Un número entero aleatorio entre {@code MIN} y {@code MAX_REINTEGRO}, ambos inclusive.
	 */
	private int generarReintegro() {
		return numeroAleatorio(MAX_REINTEGRO);
	}

	/**
	 * Genera números aleatorios únicos dentro del rango definido.
	 * 
	 * <p>El número es representado por un {@code TreeSet<Integer>}, lo que garantiza 
	 * que los números estarán ordenados automáticamente y sin duplicados.</p>
	 *
	 * @return Un {@code Set<Integer>} con {@code NUM} números aleatorios únicos y ordenados.
	 */
	private Set<Integer> generarNumeros() {
		Set<Integer> aux = new TreeSet<>();
		while(aux.size() < NUM) {
			aux.add(numeroAleatorio(MAX_NUMERO));
		}
		return aux;
	}

	/**
	 * Genera un número aleatorio dentro del rango definido entre {@code MIN} y {@code max}.
	 * 
	 * <p>El número generado estará en el intervalo cerrado [MIN, max], 
	 * asegurando que el valor mínimo sea {@code MIN} y el máximo sea {@code max}.</p>
	 *
	 * @param max El valor máximo del rango permitido.
	 * @return Un número aleatorio entre {@code MIN} y {@code max}, ambos inclusive.
	 */
	private int numeroAleatorio(int max) {
		return R.nextInt(max - MIN + 1) + MIN;
	}

	/**
	 * Gets the boleto.
	 *
	 * @return the boleto
	 */
	public Set<Integer> getBoleto() {
		return numero;
	}
	
	/**
	 * Gets the num reintegro.
	 *
	 * @return the num reintegro
	 */
	public int getNumReintegro() {
		return numReintegro;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Número : " + numero + ", Reintegro : " + numReintegro ;
	}
}
