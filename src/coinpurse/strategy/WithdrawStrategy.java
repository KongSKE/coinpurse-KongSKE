package coinpurse.strategy;

import java.util.List;

import coinpurse.Valuable;
/**
 * 
 * @author Varit Assavavisidchai
 *
 */
public interface WithdrawStrategy {

	//witdraw money in list
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money);
}
