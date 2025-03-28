package desafio_08;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Fecha.
 * @author Alexander Silvera
 */
public class Fecha {

	/** The ahora. */
	private String ahora;
	
	/** The patron. */
	private String patron;
	
	/** The flag. */
	private boolean flag;

	/**
	 * Instantiates a new fecha.
	 */
	public Fecha() {
		formato();
	}
	
	 /**
     * Solicita al usuario un formato de fecha y lo valida.
     * Si el formato es correcto, muestra la fecha actual con dicho formato.
     * En caso de error, solicita nuevamente el formato hasta que sea válido.
     */
	private void formato() {
		System.out.println("Indica el formato de fecha deseado: ");
		try (Scanner scanner = new Scanner(System.in)) {
			while (!flag) {
				patron = scanner.nextLine();
				flag = esPatronValido(patron);
			}
		}
	}

    /**
     * Valida si el formato de fecha ingresado es correcto.
     *
     * @param patron El patrón de formato de fecha introducido por el usuario.
     * @return true si el patrón es válido, false en caso contrario.
     */
	private boolean esPatronValido(String patron) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(patron);
			ahora = sdf.format(new Date());
			System.out.println("Fecha actual: " + ahora);
			return true;
		} catch (IllegalArgumentException iae) {
			System.err.println(String.format("El patrón indicado '%s' no es válido.", patron));
			return false;
		}
	}
}
