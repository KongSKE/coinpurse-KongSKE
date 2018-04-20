package coinpurse;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This Class is for test Purse and Coin class.
 * 
 * @author Varit Assavavisidchai
 *
 */
public class MoneyUtil {
	/**
	 * Return the larger argument, based on sort order, using the objects' own
	 * compareTo method for comparing.
	 * 
	 * @param args
	 *            one or more Comparable objects to compare.
	 * @return the argument that would be last if sorted the elements.
	 * @throws IllegalArgumentException
	 *             if no arguments given.
	 */
	public static <E extends Comparable<E>> E max(E... args) throws IllegalArgumentException {
		E ans = null;
		for (int i = 0; i < args.length; i++) {
			if (i + 1 == args.length) {
				return ans;
			}
			if (args[i].compareTo(args[i + 1]) > 0) {
				ans = args[i];
			} else if (args[i].compareTo(args[i + 1]) < 0) {
				ans = args[i + 1];
			} else {
				ans = args[i + 1];
			}
		}
		return ans;
	}

	/**
	 * Create List of money in the same currency
	 * 
	 * @param coins
	 * @param currency
	 * @return List of Coins that contains only the coins form coins(the
	 *         parameter) that have same currency as the currency parameter.
	 */
	public static <E extends Valuable>List filterByCurrency(List<E> money, String currency) {
		List<E> v = new ArrayList<E>();
		for (E coin : money) {
			if (coin.getCurrency().equals(currency)) {
				v.add(coin);
			}
		}
		return v;
	}

	/**
	 * Sort a list coins and print the result
	 * 
	 * @param coins
	 */
	public static void sortMoney(List<? extends Valuable> money) {
		Collections.sort(money);
	}

	/**
	 * Print coins
	 * 
	 * @param coins
	 */
	public static void printSort(List<? extends Valuable> money) {
		System.out.println(money);
	}

	/**
	 * Run the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<BankNote> list = new ArrayList<BankNote>();
		list.add(new BankNote(10.0, "USD"));
		list.add(new BankNote(500.0, "Baht"));
		MoneyUtil.sortMoney(list);
		MoneyUtil.printSort(list);
		
		List<Coin> coins = Arrays.asList(new Coin(5, "Baht"), new Coin(0.1, "Ringgit"), new Coin(5, "Cent"));
		List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht");
		System.out.println(result);
	}
}
