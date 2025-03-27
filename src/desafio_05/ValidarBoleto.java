package desafio_05;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidarBoleto.
 * @author Alexander Silvera
 */
public class ValidarBoleto {

	/**
	 * Valida un boleto de lotería comparándolo con los números ganadores del sorteo.
	 * 
	 * <p>El método filtra los números del boleto que coinciden con los del sorteo 
	 * y los devuelve en una lista.</p>
	 * 
	 * @param sorteo  Conjunto de números ganadores del sorteo.
	 * @param boleto  Conjunto de números seleccionados en el boleto.
	 * @return Una lista de números que coinciden entre el boleto y el sorteo.
	 */
	public static List<Integer> validarBoleto(Set<Integer> sorteo, Set<Integer> boleto) {
		 List<Integer> list = boleto.stream()
                 .filter(sorteo::contains)
                 .collect(Collectors.toList());
		 return list;
	}
	
	/**
	 * Cuenta la cantidad de números en común entre un boleto y los números ganadores del sorteo.
	 * 
	 * <p>El método recorre los números del boleto y cuenta cuántos de ellos están 
	 * en el conjunto del sorteo.</p>
	 * 
	 * @param sorteo  Conjunto de números ganadores del sorteo.
	 * @param boleto  Conjunto de números seleccionados en el boleto.
	 * @return La cantidad de números que coinciden entre el boleto y el sorteo.
	 */
	public static long numerosComun(Set<Integer> sorteo, Set<Integer> boleto) {
		return boleto.stream().filter(sorteo::contains).count();
	}
}
