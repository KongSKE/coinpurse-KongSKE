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
		p.insert(new Coin(5, "A"));
		p.insert(new Coin(10, "A"));
		p.insert(new Coin(1, "A"));
		p.insert(new Coin(5, "A"));
		p.insert(new Coin(5, "B"));
		p.insert(new Coin(5, "E"));
		p.insert(new Coin(5, "B"));
		p.insert(new Coin(5, "E"));
		p.withdraw(10);
		System.out.println(p.getBalance());
		BankNote bn = new BankNote(10 , "a");
		Purse t = new Purse(5);
		t.insert(bn);
		System.out.print("getBalance: ");
		System.out.println(t.getBalance());
		System.out.println(bn.getValue());
	}

}
