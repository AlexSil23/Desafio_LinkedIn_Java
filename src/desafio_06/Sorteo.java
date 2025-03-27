package desafio_06;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

// TODO: Auto-generated Javadoc
/**
 * The Class Boleto.
 * @author Alexander Silvera
 */
public class Sorteo {

	/** The max boleto. */
	private final int MAX_NUMERO = 50;
	
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
	public Sorteo() {
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
	 * Valida el boleto comparándolo con el sorteo y determina el premio correspondiente.
	 * 
	 * <p>El método cuenta los aciertos del boleto y verifica si tiene reintegro. 
	 * Luego, asigna un premio según las reglas predefinidas.</p>
	 * 
	 * @param sorteo El objeto {@code Sorteo} que contiene los números ganadores y el reintegro.
	 * @return El premio correspondiente basado en los aciertos y el reintegro.
	 */
	public Premios validar(Sorteo sorteo) {
	    Premios premio = switch (aciertos(sorteo)) {
        case NUM     -> reintegro(sorteo) ? Premios.PLENO     : Premios.SEIS_SIN;
        case NUM - 1 -> reintegro(sorteo) ? Premios.CINCO_CON : Premios.CINCO_SIN;
        case NUM - 2 -> reintegro(sorteo) ? Premios.CUATRO_CON : Premios.CUATRO_SIN;
        case NUM - 3 -> reintegro(sorteo) ? Premios.TRES_CON  : Premios.TRES_SIN;
        default      -> reintegro(sorteo) ? Premios.REINTEGRO : Premios.NADA;
    };
		return premio; 
	}
	
	/**
	 * Verifica si el número de reintegro del boleto coincide con el del sorteo.
	 * 
	 * <p>Compara el valor de {@code numReintegro} del boleto con el número de reintegro 
	 * del sorteo para determinar si hay coincidencia.</p>
	 * 
	 * @param sorteo El objeto {@code Sorteo} que contiene el número de reintegro ganador.
	 * @return {@code true} si el número de reintegro coincide, {@code false} en caso contrario.
	 */
	private boolean reintegro(Sorteo sorteo) {
		return this.numReintegro == sorteo.getNumReintegro();
	}

	/**
	 * Calcula la cantidad de aciertos del boleto comparándolo con los números ganadores del sorteo.
	 * 
	 * <p>El método filtra los números del boleto que están presentes en el sorteo y cuenta cuántos coinciden.</p>
	 * 
	 * @param sorteo El objeto {@code Sorteo} que contiene los números ganadores.
	 * @return La cantidad de números coincidentes entre el boleto y el sorteo.
	 */
	private int aciertos(Sorteo sorteo) {
		return (int) this.numero.stream().filter(sorteo.getBoleto()::contains).count();
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
		return "N: " + numero + ", R: " + numReintegro ;
	}
}
