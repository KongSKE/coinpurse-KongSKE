package coinpurse;
 /**
  * This class provide the value, currency, getValue, and getCurrency for subclass 
  * @author Varit Assavavisidchai 
  *
  */
public class Money implements Valuable{

	protected double value = 0;
	protected String currency = "";

	/**
	 * Create money with value and currency
	 * 
	 * @param value
	 * @param currency
	 */
	public Money(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * get a value of coin
	 * @return value of coin
	 */
	public double getValue() {
		return value;
	}

	/**
	 * get a currency
	 * @return currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Check the coin that are equal or not
	 * 
	 * @param type of that object
	 * @return true when they have same currency.
	 */
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(obj.getClass() != this.getClass()){
			return false;
		}
		Valuable other = (Valuable) obj;
		if(this.getCurrency().equalsIgnoreCase(other.getCurrency()) && this.getValue() == other.getValue()){
			return true;
		}
		return false;
	}

	/**
	 * Compare between money (+1 = ">", -1 = "<", 0 = "=")
	 * 
	 * @param Valuable o
	 * @return result of comparison
	 */
	@Override
	public int compareTo(Valuable o) {
		if (this.currency.equalsIgnoreCase(o.getCurrency())) {
			return Double.compare(this.getValue(), o.getValue());
		}
		return this.getCurrency().compareToIgnoreCase(o.getCurrency());
	}

}