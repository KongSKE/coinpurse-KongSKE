package coinpurse;

/**
 * Create malaysia money
 * 
 * @author Varit Assavavisidchai
 *
 */
public class MalayMoneyFactory extends MoneyFactory {
	
	/**
	 * create malaysia money
	 */
	@Override
	public Valuable createMoney(double value) {
		String sen = "Sen";
		String ringgit = "Ringgit";
		Valuable v;
		if (value == 0.05 || value == 0.1 || value == 0.2 || value == 0.5) {
			return v = new Coin(value, ringgit);
		}
		if (value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100) {
			return v = new BankNote(value, ringgit);
		}
		throw new IllegalArgumentException("Sorry, there are not type of this money.");
	}
}
