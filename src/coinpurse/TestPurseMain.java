package coinpurse;

/**
 * Test Class
 * @author Varit Assavavisidchai
 *
 */
public class TestPurseMain {
	
	/**
	 * Test insert, withdraw, getBalance
	 * @param args
	 */
	public static void main(String[] args) {
		Purse p = new Purse(10);
		p.insert(new BankNote(5, "A"));
		p.insert(new BankNote(10, "A"));
		p.insert(new Coin(1, "A"));
		p.insert(new BankNote(5, "A"));
		p.insert(new Coin(5, "B"));
		p.insert(new BankNote(5, "E"));
		p.insert(new BankNote(5, "B"));
		p.insert(new Coin(5, "E"));
		p.withdraw(10);
		System.out.println(p.getBalance());
	}

}
