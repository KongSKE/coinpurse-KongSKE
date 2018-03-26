package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

/**
 * GreedyWithdraw
 * @author Varit Assavavisidchai
 *
 */
public class GreedyWithdraw implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		Comparator<Valuable> comp = new ValueComparator();
		java.util.Collections.sort(money, comp);
		java.util.Collections.reverse(money);
		if (amount.getValue() == 0) {
			return null;
		}
		double pay = amount.getValue();
		List<Valuable> templist = new ArrayList<Valuable>();
		if (amount.getValue() != 0) {
			for (Valuable v : money) {
				if (pay >= v.getValue() && v.getCurrency().equals(amount.getCurrency())) {
					pay -= v.getValue();
					templist.add(v);
				}
			}
		}
		if (pay == 0)
			return templist;
		return null;
	}

}
