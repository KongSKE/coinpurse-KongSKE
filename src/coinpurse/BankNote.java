package coinpurse;

/**
 * BankNote different from Coin only it has serialNumber and each BankNote
 * has a unique serial Number.
 * @author Varit Assavavisidchai
 *
 */
public class BankNote extends Money {
	private static long nextSerialNumber = 1_000_000;
	private long serialNumber = 1_000_000;
	/**
	 * Create a bankNote with value and currency
	 * 
	 * @param value
	 * @param currency
	 */
	public BankNote(double value ,String currency) {
		super(value, currency);
		this.serialNumber = nextSerialNumber++;
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
	 * Description of BankNote
	 * 
	 * @return Description of BankNote.
	 */
	public String toString() {
		return super.getValue()+"-"+super.getCurrency()+" note ["+serialNumber+"]";
	}
}