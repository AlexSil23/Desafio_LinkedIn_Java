package desafio_04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Sorteo.
 * @author Alexander Silvera
 */
public class Sorteo {
	
	/** The min num. */
	private final int MIN_NUM = 0;
	
	/** The max num. */
	private final int MAX_NUM = 99999;
	
	/** The r. */
	private final Random R = new Random();
	
	/** The dig. */
	private final int DIG= (int) Math.floor(Math.log10(MAX_NUM)+1);
	
	/** The bombo numeros. */
	private List<Integer> bomboNumeros = new ArrayList<>();
	
	/** The bombo premios. */
	private List<Premios> bomboPremios = new ArrayList<>();
	
	/** The tabla premios. */
	private Map<Integer, Premios> tablaPremios = new HashMap<>();
	
	/**
	 * Instantiates a new sorteo.
	 */
	public Sorteo() {
		for (int i = MIN_NUM; i <= MAX_NUM; i++) {
			bomboNumeros.add(i);
		}
		for(Premios premio : Premios.values()) {
			for (int j = 0; j < premio.getNumPremios(); j++) {
				bomboPremios.add(premio);
			}
		}
	}
	
	/**
	 * Realiza el sorteo asignando premios a números aleatorios.
	 * 
	 * <p>Este método extrae aleatoriamente un premio del {@code bomboPremios} 
	 * y lo asocia a un número aleatorio extraído del {@code bomboNumeros}. 
	 * La asignación se almacena en {@code tablaPremios} hasta que el bombo de premios esté vacío.</p>
	 *
	 * <p>Se garantiza que cada número tendrá un premio único hasta que todos los premios se asignen.</p>
	 */
	public void sorteo() {
		while(!bomboPremios.isEmpty()) {
			Premios p = bomboPremios.remove(R.nextInt(bomboPremios.size()));
			int num = bomboNumeros.remove(R.nextInt(bomboNumeros.size()));
			tablaPremios.put(num, p);
		}
	}
	
	/**
	 * Imprime la tabla de premios ordenada por número.
	 * 
	 * <p>Si la tabla de premios está vacía, muestra un mensaje indicando que el sorteo aún no se ha realizado.</p>
	 * 
	 * <p>La impresión se realiza en orden ascendente de los números, formateando cada línea con el método {@code formatoLinea()}.</p>
	 */
	public void imprimirTablaPorNum() {
		System.out.println("Tabla ordenada por número: ");
		if(tablaPremios.isEmpty()) {
			System.out.println("Sorteo pendiente... ");
		}
		tablaPremios.keySet().stream().sorted()
		.forEach(k -> System.out.println(formatoLinea(k, tablaPremios.get(k))));
	}
	
	/**
	 * Imprime la tabla de premios ordenada por premio.
	 * 
	 * <p>Si la tabla de premios está vacía, muestra un mensaje indicando que el sorteo aún no se ha realizado.</p>
	 * 
	 * <p>La impresión se realiza ordenando los premios alfabéticamente o según el criterio 
	 * de comparación definido en la clase {@code Premios}.</p>
	 */
	public void imprimirTablaPorPremio() {
		System.out.println("Tabla ordenada por premios: ");
		if(tablaPremios.isEmpty()) {
			System.out.println("Sorteo pendiente... ");
		}
		tablaPremios.entrySet().stream()
		.sorted(Comparator.comparing(Entry::getValue))
        .forEach(v -> System.out.println(formatoLinea(v)));
	}
	
	/**
	 * Formatea una línea de texto con el número y el premio correspondiente.
	 * 
	 * <p>El número se representa con ceros a la izquierda hasta alcanzar el ancho definido por {@code DIG}.</p>
	 * <p>El premio se muestra en euros, obteniendo su valor con {@code premio.getPremioPorEuro()}.</p>
	 * 
	 * @param num    Número asociado al premio.
	 * @param premio Objeto {@code Premios} que contiene la cantidad del premio.
	 * @return Una cadena formateada en el formato "000X: Y €", donde X es el número y Y el premio.
	 */
	private String formatoLinea(Integer num, Premios premio) {
		return String.format("%0" + DIG + "d", num) + ": " + premio.getPremioPorEuro() + " €";
	}

	/**
	 * Formato linea.
	 *
	 * @param entry the entry
	 * @return the string
	 */
	private String formatoLinea(Entry<Integer, Premios> entry) {
		return formatoLinea(entry.getKey(), entry.getValue());
	}
}
