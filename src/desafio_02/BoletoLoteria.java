package desafio_02;

public class BoletoLoteria {
	/*Generar un boleto de lotería complejo
	 * 6 número entre 1 y 49 
	 * 1 número entre 1 y 10 (Reitegro)
	 * Objeto Java, atributos array de 6 num y 1 int (reintegro)
	 * */

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		System.out.println("Generamos 100 boletos.");
		for (int i = 0; i < 100; i++) {
			Boleto b1 = new Boleto();
			System.out.println(b1.toString());
		}
	}
}
