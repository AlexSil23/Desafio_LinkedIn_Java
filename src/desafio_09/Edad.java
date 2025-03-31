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
     * Método para obtener la fecha de nacimiento del usuario y calcular la edad.
     */
    public void calcularEdad() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese tu fecha de nacimiento (" + PATRON + "):");
            while (!flag) {
                String cumple = scanner.nextLine();
                flag = esPatronValido(cumple);
            }
        }
    }

    /**
     * Método para verificar si la fecha cumple con el patrón especificado.
     *
     * @param cumple Fecha de nacimiento ingresada por el usuario.
     * @return true si la fecha es válida según el patrón, false de lo contrario.
     */
    private boolean esPatronValido(String cumple) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(PATRON);
            LocalDate fecha = LocalDate.parse(cumple, dtf);
            LocalDate ahora = LocalDate.now();
            Period edad = Period.between(fecha, ahora);
            mostrarEdad(edad);
            return true;
        } catch (DateTimeParseException e) {
            System.err.println(String.format("La fecha indicada ('%s') no sigue el patrón esperado ('%s').",
                    cumple, PATRON));
            return false;
        }
    }

    /**
     * Método para mostrar la edad calculada y un mensaje adicional según la cercanía del cumpleaños.
     *
     * @param edad Periodo de tiempo representando la diferencia de años, meses y días.
     */
    private void mostrarEdad(Period edad) {
        System.out.printf("Edad: %d años, %d meses y %d días\n", edad.getYears(), edad.getMonths(), edad.getDays());
        switch (edad.getMonths()) {
            case 0:
                if (edad.getDays() == 0) {
                    System.out.println("¡FELICIDADES! ¡Hoy es tu cumpleaños!");
                } else {
                    System.out.println("¡Felicidades! Tu cumpleaños ha sido hace poco...");
                }
                break;
            case 11:
                System.out.println("¡Felicidades! Tu cumpleaños se acerca...");
                break;           
        }
    }
}