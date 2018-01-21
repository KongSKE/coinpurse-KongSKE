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
	 * 
	 * @param coins
	 * @param currency
	 * @return List of Coins that contains only the coins form coins(the parameter) that have same currency as the currency parameter.
	 */
	public static List<Coin> filterByCurrency(List<Coin> coins, String currency) {
		List<Coin> c = new ArrayList<Coin>();
		for (Coin coin : coins) {
			if(coin.getCurrenccy().equals(currency)) {
				c.add(coin);
			}
		}
		return c;
	}
	
	/**
	 * Sort a list coins and print the result
	 * @param coins
	 */
	public static void sortCoins(List<Coin> coins) {
		Collections.sort(coins);
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
	}
	
}
