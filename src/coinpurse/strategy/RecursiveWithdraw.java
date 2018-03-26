package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.MoneyUtil;
import coinpurse.Valuable;

/**
 * RecursiveWithdraw can withdraw money correctly.
 * @author Varit Assavavisidchai
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy{
	/**
	 * Find and return items from a collection whose total value equals the
	 * requested amount.
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {

		MoneyUtil.filterByCurrency(money, amount.getCurrency());
		return withdrawHelper(amount.getValue(), money);
	}

	/**
	 * Make program can withdraw amount of money correctly by recursion.
	 * 
	 * @param amount
	 * @param money
	 * @return amount can withdraw.
	 */
	public List<Valuable> withdrawHelper(double amount, List<Valuable> money) {
		if (amount == 0)
			return new ArrayList<Valuable>();

		if (money.isEmpty())
			return null;

		if (amount == 0)
			return new ArrayList<Valuable>();
		List<Valuable> left = withdrawHelper(amount - money.get(0).getValue(), money.subList(1, money.size()));
		List<Valuable> right = withdrawHelper(amount, money.subList(1, money.size()));
		if (left != null) {
			left.add(money.get(0));
			return left;
		}
		return right;
	}


}
