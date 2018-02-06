package coinpurse;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

/**
 * This Class is for test Purse and Coin class.
 * @author Varit Assavavisidchai
 *
 */
public class MoneyUtil {
	/**
	 * Create List of money in the same currency
	 * 
	 * @param coins
	 * @param currency
	 * @return List of Coins that contains only the coins form coins(the parameter) that have same currency as the currency parameter.
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> money, String currency) {
		List<Valuable> v = new ArrayList<Valuable>();
		for (Valuable coin : money) {
			if(coin.getCurrency().equals(currency)) {
				v.add(coin);
			}
		}
		return v;
	}
	
	/**
	 * Sort a list coins and print the result
	 * @param coins
	 */
	public static void sortCoins(List<Coin> coins) {
		Collections.sort(coins);
	}
	
	/**
	 * Print coins
	 * @param coins
	 */
	public static void printCoins(List<Coin> coins){
		System.out.println(coins);
	}
	
	/**
	 * Run the program.
	 * @param args
	 */
	public static void main(String[] args) {
		List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin(10.0, "Baht"));
		coins.add(new Coin(0.5, "Baht"));
		coins.add(new Coin(2.0, "Baht"));
		coins.add(new Coin(1.0, "Baht"));
		System.out.println(coins);
		sortCoins(coins);
		printCoins(coins);
	}
}
