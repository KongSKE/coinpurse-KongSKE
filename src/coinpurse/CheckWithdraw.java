package coinpurse;

public class CheckWithdraw {
	public static void main(String[] args) {
		Purse p = new Purse(10);
		p.insert(new Coin(20, "Baht"));
		p.withdraw(1);
		System.out.println(p);
	}
}
