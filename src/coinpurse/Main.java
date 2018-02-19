package coinpurse;

import java.util.ResourceBundle;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author Varit Assavavisidchai
 */
public class Main {

	public static void init() {
		
		ResourceBundle bundle = ResourceBundle.getBundle( "purse" );
    	String factoryclass = bundle.getString( "MoneyFactory" ); 
    	System.out.println("Factory class name is "+factoryclass);
    	MoneyFactory factory = null;
    	try {
    	 factory = (MoneyFactory)Class.forName(factoryclass).newInstance();
    	}
    	catch (ClassCastException cce) {
    	 //the object could not be cast to type MoneyFactory
    	 System.out.println(factoryclass+" is not type MoneyFactory");
    	}
    	catch (Exception ex) {
    	 // any other exception means we could not create an object
    	 System.out.println("Error creating MoneyFactory "+ex.getMessage() );
    	}
    	// if no factory then quit
    	if (factory == null) System.exit(1);

    	
	}
	
    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
        // 1. create a Purse
//    	Purse purse = new Purse(10);
        // 2. create a ConsoleDialog with a reference to the Purse object
//    	ConsoleDialog ui = new ConsoleDialog(purse);
        // 3. run the ConsoleDialog
//    	ui.run();
    	Main.init();
    	MoneyFactory factory = MoneyFactory.getInstance();
		Purse p = new Purse(5);
//		p.insert(factory.createMoney(0.250));
		p.insert(factory.createMoney(1));
		p.insert(factory.createMoney(50));
		p.insert(factory.createMoney(0.5));
		p.insert(factory.createMoney(20));
		for (Valuable v : p.getMoney()) {
			System.out.println(v);
		}
		System.out.println("====================================");
		for (Valuable v : p.getMoney()) {
			System.out.println(v.getCurrency());
		}
    }
}
