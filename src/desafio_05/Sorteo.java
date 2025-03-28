package desafio_05;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

// TODO: Auto-generated Javadoc
/**
 * The Class Sorteo.
 * @author Alexander Silvera
 */
public class Sorteo {

	/** The min num. */
	private static final int MIN = 0;
	
	/** The max num. */
	private static final int MAX = 30;
	
	/** The num. */
	private static final int NUM = 5;
	
	/** The r. */
	private final Random R = new Random();
	
	/** The sorteo. */
	private Set<Integer> sorteo = new HashSet<>();
	
	/**
	 * Instantiates a new sorteo.
	 */
	public Sorteo() {
		this.sorteo = generarNumeros();		
	}
	
	/**
	 * Genera un conjunto de números aleatorios únicos.
	 * 
	 * <p>El método llena un {@code TreeSet} con números generados aleatoriamente hasta alcanzar 
	 * la cantidad definida por {@code NUM}. Como {@code TreeSet} no permite duplicados, 
	 * garantiza que todos los números generados sean únicos y estén ordenados automáticamente.</p>
	 * 
	 * @return Un conjunto ordenado de números aleatorios únicos.
	 */
	private Set<Integer> generarNumeros() {
		Set<Integer> aux = new TreeSet<>();
		while(aux.size() < NUM) {
			aux.add(numeroAleatorio(MAX));
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
	 * Gets the sorteo.
	 *
	 * @return the sorteo
	 */
	public Set<Integer> getSorteo() {
		return sorteo;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Sorteo: " + sorteo ;
	}
}
