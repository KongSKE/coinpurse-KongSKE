package coinpurse;
/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Varit Assavavisidchai
 *
 */
public class Coin implements Comparable<Coin>{
	double value = 0;
	String currency = "";
	
	/**
	 * 
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
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
	public String getCurrenccy() {
		return currency;
	}
	
	/**
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
		Coin other = (Coin) obj;
		if(this.getCurrenccy().equalsIgnoreCase(other.getCurrenccy()) && this.getValue() == other.getValue()){
			return true;
		}
		return false;
	}
	
	@Override
	/**
	 * Compare between 2 coin. If < return -1, > return 1, Equally return 0. 
	 * @return result of comparison
	 */
	public int compareTo(Coin coin) {
		if(this.getValue()-coin.getValue()<0){
			return -1;
		}
		if(this.getValue()-coin.getValue()>0){
			return +1;
		}
		if(this.getValue()-coin.getValue()==0){
			return 0;
		}
		return 0;
	}
	
	/**
	 * @return Describtion about amount of Coin. 
	 */
	public String toString() {
		return value+" "+currency;
	}
}
