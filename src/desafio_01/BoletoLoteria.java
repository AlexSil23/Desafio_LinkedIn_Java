package desafio_01;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

// TODO: Auto-generated Javadoc
/**
 * The Class BoletoLoteria.
 * @author Alexander Silvera
 */
public class BoletoLoteria {
	/*Generar un boleto de lotería simple
	 * 5 números aleatorios 
	 * entre 10 y 50*/

	/** The Constant MAX. */
	private static final int MAX = 50;
	
	/** The Constant MIN. */
	private static final int MIN = 1;
	
	/** The Constant num. */
	private static final int NUM = 5;
	
	/** The r. */
	private static Random R = new Random();
	
	/**
	 * Genera un boleto con números aleatorios únicos dentro de un rango especificado.
	 * 
	 * <p>El boleto generado es un {@code TreeSet<Integer>}, lo que garantiza que los 
	 * números estarán ordenados de menor a mayor y sin duplicados.</p>
	 *
	 * @return un {@code Set<Integer>} con los números generados de forma aleatoria y ordenada.
	 */
	public static Set<Integer> generarBoleto() {
		Set<Integer> boleto = new TreeSet<Integer>();
		while (boleto.size() < NUM) {
			boleto.add(R.nextInt(MAX - MIN + 1) + MIN);
		}
		return boleto;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		Set<Integer> b1 = generarBoleto();
		System.out.println(b1.toString());
		
		System.out.println("Generamos 100 boletos.");
		for (int i = 0; i < 100; i++) {
			Set<Integer> b2 = generarBoleto();
			System.out.println(b2.toString());
		}
	}
}
