package frog;

/**
 * A DrinkOrder is sent from a BarPatron to a BarManager
 * @author Dan McNeilly
 *
 */
public class DrinkOrder {
	
	public String drink;
	public double amount;
	public BarPatron customer;
	
	/**
	 * DrinkOrder Constructor
	 * 
	 * @param bev the drink
	 * @param amt the cost
	 * @param cust person who ordered
	 */
	public DrinkOrder(String bev, double amt, BarPatron cust){
		drink = bev;
		amount = amt;
		customer = cust;
	}

}

