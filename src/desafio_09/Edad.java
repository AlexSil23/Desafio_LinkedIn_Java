package desafio_09;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Edad.
 * @author Alexander Silvera
 */
public class Edad {

	/** The Constant PATRON. */
	private static final String PATRON = "dd/MM/yyyy";
	
	/** The flag. */
	private boolean flag;

	/**
	 * Instantiates a new edad.
	 */
	public Edad() {

	}

	/**
	 * Edad.
	 */
	public void edad() {
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("Ingrese tu fecha de nacimiento (" + PATRON + "):");
			while (!flag) {
				String cumple = s.nextLine();
				flag = esPatronValido(cumple);
			}
		}
	}

	/**
	 * Es patron valido.
	 *
	 * @param cumple the cumple
	 * @return true, if successful
	 */
	private boolean esPatronValido(String cumple) {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(PATRON);
			LocalDate fecha = LocalDate.parse(cumple, dtf);
			LocalDate ahora = LocalDate.now();
			Period edad = Period.between(fecha, ahora);
			mensaje(edad);
			return true;
		} catch (DateTimeParseException e) {
			System.err.println(String.format("La fecha indicada ('%s') " + "no sigue el patrón esperado ('%s').",
					cumple, PATRON));
			return false;
		}
	}

	/**
	 * Mensaje.
	 *
	 * @param edad the edad
	 */
	private void mensaje(Period edad) {
		System.out.println(
				String.format("Edad: %d años, %d meses y %d días", edad.getYears(), edad.getMonths(), edad.getDays()));
		switch (edad.getMonths()) {
		case 0 -> {
			if (edad.getDays() == 0) {
				System.out.println("¡FELICIDADES! ¡Hoy es tu cumpleaños!");
			} else {
				System.out.println("¡Felicidades! Tu cumpleaños ha sido hace poco...");
			}
		}
		case 11 -> System.out.println("¡Felicidades! Tu cumpleaños se acerca...");

		}
	}
}
