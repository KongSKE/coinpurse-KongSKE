package coinpurse;
/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Varit Assavavisidchai
 *
 */
public class Coin extends Money {
	/**
	 * Create a coin with value and currency
	 * 
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
		super(value,currency);
	}
	
	/**
	 * Description about amount of coin
	 * 
	 * @return Description about amount of Coin. 
	 */
	public String toString() {
		return super.getValue()+" "+super.getCurrency();
	}
}
