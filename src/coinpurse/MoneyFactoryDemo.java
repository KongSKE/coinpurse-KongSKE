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
		p.insert(mf.createMoney("ten"));
		p.insert(mf.createMoney(7));
		p.insert(mf.createMoney(30));
		p.insert(mf.createMoney(20));
		p.insert(mf.createMoney(20.1));
		p.withdraw(20);
		for ( Valuable money : p.getMoney()) {
			System.out.println(money.toString());
		}
		System.out.print("My Balance: ");
		System.out.println(p.getBalance());
	}
}
