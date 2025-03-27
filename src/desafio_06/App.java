package desafio_06;

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
		System.out.println("Sorteo: " + s1);
		for (int i = 0; i < 10000; i++) {
			Sorteo apuesta = new Sorteo();
			Premios premio = apuesta.validar(s1);
			if (premio != Premios.NADA && premio != Premios.REINTEGRO) {
				System.out.println("Premio para " + apuesta + ": " + premio);
			}
		}
		Premios pleno = s1.validar(s1);
		System.out.println("Premio para " + s1 + ": " + pleno);
		
	}
}
