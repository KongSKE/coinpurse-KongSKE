package coinpurse;

/**
 * Creat thai money
 * 
 * @author Varit Assavavisidchai
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {

	/**
	 * create thai money
	 * 
	 * @param value
	 * @return money of thailand.
	 */
	@Override
	public Valuable createMoney(double value) {
		String baht = "Baht";
		String satang = "Satang";
		Valuable v;
		if (value == 0.25 || value == 0.5) {
			return v = new Coin(value, satang);
		}
		if (value == 1 || value == 2 || value == 5 || value == 10) {
			return v = new Coin(value, baht);
		}
		if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) {
			return v = new BankNote(value, baht);
		}
		throw new IllegalArgumentException("Sorry, there are not type of this money.");
	}
}
