package coinpurse;

/**
 * BankNote different from Coin only it has serialNumber and each BankNote
 * has a unique serial Number.
 * @author Varit Assavavisidchai
 *
 */
public class BankNote implements Valuable{
	private static long nextSerialNumber = 1000000;
	private String currency = "";
	private long serialNumber = 1000000;
	private Double value = 0.0; 
	
	/**
	 * 
	 * @param value
	 * @param currency
	 */
	public BankNote(double value ,String currency) {
		this.value = value;
		this.currency = currency;
	}
	
	/**
	 * 
	 * @return the value of this BankNote.
	 */
	public double getValue() {
		return this.value;
	}
	
	/**
	 * 
	 * @return the currency
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * 
	 * @return serial number
	 */
	public long getSerial() {
		return this.serialNumber;
	}
	
	/**
	 * 
	 * @return true if obj is a BankNote and has the same currency and value.
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
	 * @return Description of BankNote.
	 */
	public String toString() {
		return value+"-"+currency+" note ["+serialNumber+"]";
	}
}