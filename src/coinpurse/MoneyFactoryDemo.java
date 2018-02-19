package coinpurse;

import java.util.List;

/**
 * Test MoneyFactory
 * 
 * @author Varit Assavavisidchai
 *
 */
public class MoneyFactoryDemo {
	
	/**
	 * Run Console
	 * @param args
	 */
	public static void main(String[] args) {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory mf = MoneyFactory.getInstance();
		Purse p = new Purse(10);

		System.out.println("1)Singleton Test");
		MoneyFactory mfTest = MoneyFactory.getInstance();
		System.out.println(mf == mfTest);
		System.out.println("____________________________");
		System.out.println("2)All method Test");
		p.insert(mf.createMoney(500));
		p.insert(mf.createMoney(5));
		p.insert(mf.createMoney(0.5));
		p.insert(mf.createMoney(10));
		p.withdraw(100);
		for ( Valuable money : p.getMoney()) {
			System.out.println(money.toString());
		}
		System.out.print("My Balance: ");
		System.out.println(p.getBalance());
	}
}
