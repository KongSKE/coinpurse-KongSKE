package coinpurse.strategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import coinpurse.BankNote;
import coinpurse.Coin;
import coinpurse.Money;
import coinpurse.Purse;
import coinpurse.Valuable;

//@RunWith(Suite.class)
//@SuiteClasses({})
public class WithdrawTest {
	private WithdrawStrategy strategy;
	private static final double TOL = 1.0E-6;
	private static final String CURRENCY = "BTC";
	private List<Valuable> amount = new ArrayList<Valuable>();
	private List<Valuable> withdraw;
	/**
	 * Code to run before each test. Setup the "test fixture"
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception{
		strategy = new GreedyWithdraw();
	}
	
	private Money makeCoin(double value) {
		if (value >= 20) {
			return new BankNote(value, CURRENCY);
		}
		return new Coin(value, CURRENCY);
	}
	
	@Test
	public void testWithdrawEverything() {
		Purse p = new Purse(10);
		p.insert(makeCoin(5));
		p.insert(makeCoin(20));
		assertTrue(p.insert(makeCoin(50)));
		
	}
	
	@Test
	public void testWithdrawZero() {
		Purse p = new Purse(10);
		Money coin1 = makeCoin(5);
		Money coin2 = makeCoin(10);
		Money coin3 = makeCoin(1);
		assertTrue(p.insert(coin1));
		assertTrue(p.insert(coin2));
		assertTrue(p.insert(coin3));
		p.withdraw(coin1);
		assertEquals(11, p.getBalance(), TOL);
	}
	
	@Test
	public void testImpossibleWithdraw() {

		withdraw = strategy.withdraw(new Coin(2, "Baht"), amount);
		assertNull(withdraw);
	}

	@Test
	public void testWithdrawMoreThanAmount() {
		withdraw = strategy.withdraw(new Coin(127, "Baht"), amount);
		assertNull(withdraw);
	}

	@Test
	public void testDifferentCurrency() {
		withdraw = strategy.withdraw(new Coin(126, "Ringgit"), amount);
		assertNotEquals(amount, withdraw);
	}

	@Test
	public void testMinusWithdraw() {
		withdraw = strategy.withdraw(new Coin(-1, "Baht"), amount);
		assertNull(withdraw);
	}
}
