package desafio_07;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Sorteo.
 */
public class Sorteo {

	/** The Constant MAX. */
	private static final int MAX = 75;
	
	/** The Constant MIN. */
	private static final int MIN = 1;
	
	/** The pausa. */
	private int pausa; 
	
	/** The bombo. */
	private List<Integer> bombo = new ArrayList<>();
	
	/** The r. */
	private Random R = new Random();
	
	/**
	 * Instantiates a new sorteo.
	 *
	 * @param segundos the segundos
	 */
	public Sorteo(int segundos) {
		for (int i = MIN; i <= MAX; i++) {
			bombo.add(i);
		}
		this.pausa = segundos * 1000;
	}
	
	/**
	 * Realiza el sorteo extrayendo números aleatorios del bombo y mostrando cada uno con una pausa.
	 * 
	 * <p>Mientras el bombo no esté vacío, se extrae un número aleatorio, se imprime en pantalla 
	 * y se detiene brevemente la ejecución simulando el tiempo de espera del sorteo.</p>
	 * 
	 * <p>Si el hilo es interrumpido durante la pausa, se captura la excepción y se muestra un mensaje de "BINGOO!!".</p>
	 */
	public void sorteo() {
		try {
			while (!bombo.isEmpty()) {
				int num = bombo.remove(numAlazar());
				System.out.println(num + "  ");
				Thread.sleep(pausa);
			}
		} catch (InterruptedException e) {
			System.out.println("BINGOO!!");
			//e.printStackTrace();
		}
	}

	/**
	 * Num alazar.
	 *
	 * @return the int
	 */
	private int numAlazar() {
		return R.nextInt(bombo.size());
	}
}
