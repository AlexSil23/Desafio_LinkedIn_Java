package desafio_03;

import java.util.LinkedHashSet;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class Tablero.
 * @author Alexander Silvera
 */
public class Tablero {

	/** The filas. */
	private Set<FilaBingo> filas = new LinkedHashSet<>();
	
	/**
	 * Instantiates a new tablero.
	 */
	public Tablero() {
		for (LetraBingo letra : LetraBingo.values()) {
			filas.add(new FilaBingo(letra));			
		}
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		String txt = "";
		for (FilaBingo filaBingo : filas) {
			txt += filaBingo.toString() + "\n";
		}
		return  txt;
	}
}
