package coinpurse;

/**
 * This class is create each country money.
 * @author Varit Assavavisidchai
 *
 */
public abstract class MoneyFactory {

	private static MoneyFactory factory = null;
	private long serialNumber = 1_000_000;
	private long next = serialNumber++;

	/**
	 * Constructor
	 */
	protected MoneyFactory() {

	}

	/**
	 * Singleton
	 * 
	 * @return type of factory
	 */
	public static MoneyFactory getInstance() {
		return factory;
	}

	/**
	 * Create coins and banknotes according to the table of currency values
	 * above
	 * 
	 * @param value
	 * @return money
	 */
	public abstract Valuable createMoney(double value);

	/**
	 * It parses the String parameter as a double and calls the abstract
	 * createMoney(double) method. If the String does not contain a number,
	 * throw IllegalArgumentException
	 * 
	 * @param value
	 * @return money
	 */
	public Valuable createMoney(String value) {
		double v = 0;
		try {
			v = Double.parseDouble(value);
		} catch (IllegalArgumentException e) {
			System.out.println("value of string is not a number.");
		}
		return createMoney(v);

	}

	/**
	 * Set type of money 
	 * @param mf
	 */
	public static void setFactory(MoneyFactory mf) {
		factory = mf;
	}

}
