package desafio_04;

// TODO: Auto-generated Javadoc
/**
 * The Enum Premios.
 * @author Alexander Silvera
 */
public enum Premios {

	/** The gordo. */
	GORDO(20000,1),
	
	/** The segundo. */
	SEGUNDO(6250,1),
	
	/** The tercero. */
	TERCERO(2500,1),
	
	/** The cuarto. */
	CUARTO(1000,2),
	
	/** The quinto. */
	QUINTO(300,8),
	
	/** The pedrea. */
	PEDREA(5,18);
	
	/** The premio por euro. */
	private int premioPorEuro;
	
	/** The num premios. */
	private int numPremios;
	
	/**
	 * Instantiates a new premios.
	 *
	 * @param premioPorEuro the premio por euro
	 * @param numPremios the num premios
	 */
	private Premios(int premioPorEuro, int numPremios) {
		this.premioPorEuro = premioPorEuro;
		this.numPremios = numPremios;
	}

	/**
	 * Gets the premio por euro.
	 *
	 * @return the premio por euro
	 */
	public int getPremioPorEuro() {
		return premioPorEuro;
	}

	/**
	 * Gets the num premios.
	 *
	 * @return the num premios
	 */
	public int getNumPremios() {
		return numPremios;
	}
}
