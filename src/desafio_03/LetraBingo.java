package desafio_03;

// TODO: Auto-generated Javadoc
/**
 * The Enum LetraBingo.
 * @author Alexander Silvera
 */
public enum LetraBingo {

	/** The b. */
	B(5,1,15), 
	
	/** The i. */
	I(5,16,30), 
	
	/** The n. */
	N(4,31,45), 
	
	/** The g. */
	G(5,46,60), 
	
	/** The o. */
	O(5,61,75);
	
	/** The cap. */
	private int cap;
	
	/** The max. */
	private int max;
	
	/** The min. */
	private int min;
	
	/**
	 * Instantiates a new letra bingo.
	 *
	 * @param cap the cap
	 * @param min the min
	 * @param max the max
	 */
	private LetraBingo(int cap, int min, int max) {
		this.cap = cap;
		this.min = min;
		this.max = max;
	}

	/**
	 * Gets the letra.
	 *
	 * @return the letra
	 */
	public String getLetra() {
		return this.name();
	}
	
	/**
	 * Gets the cap.
	 *
	 * @return the cap
	 */
	public int getCap() {
		return cap;
	}

	/**
	 * Gets the max.
	 *
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * Gets the min.
	 *
	 * @return the min
	 */
	public int getMin() {
		return min;
	}
}
