package desafio_05;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class App.
 * @author Alexander Silvera
 */
public class App {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		Sorteo s1 = new Sorteo();
		System.out.println(s1.toString());
		
		Sorteo s2 = new Sorteo();
		System.out.println("Boleto: "+ s2.getSorteo());
		
		List<Integer> aux = ValidarBoleto.validarBoleto(s1.getSorteo(), s2.getSorteo());
		System.out.println("Lista de número en común: "+ aux);
		
		long numComun = ValidarBoleto.numerosComun(s1.getSorteo(), s2.getSorteo());
		System.out.println("Números en común: " + numComun);

	}
}
