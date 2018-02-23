package coinpurse;
/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Varit Assavavisidchai
 *
 */
public class Coin extends Money {
	
	private String output;
	
	/**
	 * Create a coin with value and currency
	 * 
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
		super(value,currency);
		this.output = currency;
	}
	
	public Coin(double value, String currency, String output) {
		super(value, currency);
		this.output = output;
	}
	
	/**
	 * Description about amount of coin
	 * 
	 * @return Description about amount of Coin. 
	 */
	public String toString() {
		if(!currency.equalsIgnoreCase(output)) {
			return super.getClass()+" "+output;
		}
		return super.getValue()+" "+super.getCurrency();
	}
}
