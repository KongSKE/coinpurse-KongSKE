package coinpurse;
/**
 * An interface for objects having a monetary value and currency
 * @author Varit Assavavisidchai
 *
 */
public interface Valuable {
	/**
	 * Get the monetary value of this object, in its own currency.
	 * @return the value of this object
	 */
	
	/**
	 * Get the value of this object.
	 * 
	 * @return value of this object.
	 */
	public double getValue();
	
	/**
	 * Get the currency of this object
	 * 
	 * @return currency of his object
	 */
	public String getCurrency();
}
