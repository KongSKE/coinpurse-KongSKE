package coinpurse;

/**
 * BankNote different from Coin only it has serialNumber and each BankNote
 * has a unique serial Number.
 * @author Varit Assavavisidchai
 *
 */
public class BankNote implements Valuable{
	private static long nextSerialNumber = 1_000_000;
	private String currency = "";
	private long serialNumber = 1_000_000;
	private double value = 0.0; 
	
	/**
	 * Create a bankNote with value and currency
	 * 
	 * @param value
	 * @param currency
	 */
	public BankNote(double value ,String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber++;
	}
	
	/**
	 * Get a value of this BankNote.
	 * 
	 * @return the value of this BankNote.
	 */
	public double getValue() {
		return this.value;
	}
	
	/**
	 * Get a currency of this BankNote
	 * 
	 * @return the currency
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * Get a serialNumber of this BankNote
	 * 
	 * @return serial number
	 */
	public long getSerial() {
		return this.serialNumber;
	}
	
	/**
	 * Check this object that is equal or not
	 * 
	 * @return true if object is a BankNote and has the same currency and value.
	 */
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj.getClass() != this.getClass()) {
			return false;
		}
		BankNote other = (BankNote) obj;
		if(this.getCurrency().equalsIgnoreCase(other.getCurrency()) && this.getValue() == other.getValue()){
			return true;
		}
		return false;
	}
	
	/**
	 * Description of BankNote
	 * 
	 * @return Description of BankNote.
	 */
	public String toString() {
		return value+"-"+currency+" note ["+serialNumber+"]";
	}
}