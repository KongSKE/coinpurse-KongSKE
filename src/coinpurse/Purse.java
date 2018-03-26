package coinpurse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.sun.xml.internal.bind.v2.TODO;

import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.WithdrawStrategy;

// You will use Collections.sort() to sort the coins

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author Varit Assavavisidchai
 */
public class Purse {
	/** Collection of objects in the purse. */
	List<Valuable> money = new ArrayList<Valuable>();
	// Initialize WithdrawStrategy
	private WithdrawStrategy strategy;
	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		this.strategy = new GreedyWithdraw();
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double total = 0.0;
		for (Valuable v : money) {
			total = total + v.getValue();
		}
		return total;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		return this.count() == this.getCapacity();
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Valuable v) {
		// if the purse is already full then can't insert anything.
		if (!isFull() && v.getValue() > 0) {
			money.add(v);
			return true;
		}
		return false;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested. Withdraw the amount, using only item that have the same
	 * currency as the parameter.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(Valuable amount) {
		/*
		 * See lab sheet for outline of a solution, or devise your own solution.
		 * The idea is to be greedy. Try to withdraw the largest coins possible.
		 * Each time you choose a coin as a candidate for withdraw, add it to a
		 * temporary list and decrease the amount (remainder) to withdraw.
		 * 
		 * If you reach a point where amountNeededToWithdraw == 0 then you found
		 * a solution! Now, use the temporary list to remove coins from the
		 * money list, and return the temporary list (as an array).
		 */

		// Did we get the full amount?
		// This code assumes you decrease amount each time you remove a coin.
		// Your code might use some other variable for the remaining amount to
		// withdraw.

		if (amount.getValue() == 0) {
			return null;
		}

		if (this.getBalance() < amount.getValue()) {
			return null;
		}
		List<Valuable> result = strategy.withdraw(amount, money);
		Valuable[] array = new Valuable[result.size()];
		if (result != null) {
			for (Valuable v : result) {
				money.remove(v);
			}
			result.toArray(array);
			return array;
		}
		return null;

		// Success.
		// Remove the coins you want to withdraw from purse,
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.
	}

	/**
	 * Withdraw amount using the default currency.
	 * 
	 * @param amount
	 * @return withdraw amount using the default currency, which is "Bath".
	 */
	public Valuable[] withdraw(double amount) {
		Money money = new Money(amount, "Baht");
		return withdraw(money);
	}

	public List<Valuable> getMoney() {
		return money;
	}

	/**
	 * 
	 */
	public void setWithdrawStrategy(WithdrawStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 * 
	 * @return description of the purse contents.
	 */
	public String toString() {
		return "capacity: " + getCapacity() + " Balanced: " + getBalance();
	}
}