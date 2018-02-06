package coinpurse;

import java.util.Comparator;
/**
 * 
 * @author Varit Assavavisidchai
 *
 */
public class ValueComparator implements Comparator<Valuable> {
	
	/**
	 * Compare two objects that implement Valuable.
	 * First compare them by currency, so that "Baht" < "Dollar".
	 * if both objects have the same currency, order them by value.
	 * @return result of comparison.
	 */
	public int compare(Valuable a, Valuable b) {
		if(a.getCurrency().equalsIgnoreCase(b.getCurrency())){
			if(a.getValue() - b.getValue() > 0) {
				return +1;
			}
			if(a.getValue() - b.getValue() < 0) {
				return -1;
			}
			return 0;
		}
		return a.getCurrency().compareToIgnoreCase(b.getCurrency());
	}
}