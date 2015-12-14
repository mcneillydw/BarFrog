package frog;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This creates the class builds the bar managers profile. 
 * @author Dan McNeilly
 */

public class BarManager extends User {
	
	public InfoToSave info;
	
	private myWallet barWallet = new myWallet();
	public Bar bar;
	
	static ArrayList<DrinkOrder> orders = new ArrayList<DrinkOrder>();
	
	/**
	 * Barmanager constructor
	 */
	
	public BarManager(){
		this.bar = new Bar();
	}
	/**
	 * Connects a bar to a bar manager
	 */
	
	public BarManager(Bar bar){
		this.bar = bar;
	}
	
	/**
	 * Edits the bar information for the bartender, gives 
	 * them the opportunity to edit the bar description.
	 * 
	 * @param bar is the bar that its referring to.
	 */

	public void editBarInfo(Bar bar) {
		Scanner edit = new Scanner (System.in);
		System.out.println("Enter a new bar name: ");
		String newName = edit.next();
		bar.barName = newName;
		
		System.out.println("Enter a bar address: ");
		String newAddr = edit.next();
		bar.barAddress = newAddr;
		
		System.out.println("Enter a new bar description: ");
		String descr = edit.next();
		bar.barDescription = descr;
		
		System.out.println("Bar name: " + bar.barName);
		System.out.println("Bar description:" + bar.barDescription);
		System.out.println("Bar address: " + bar.barAddress);
		
	}
	
	/**
	 * This looks up the money collected by the bartender.
	 * 
	 *  @param cust attaches the customer to specific bartab
	 *  @param orders a list of drink orders
	 */

	public void closeTab(BarPatron cust, ArrayList<DrinkOrder> orders) {
		//this.orders = orders;
		//info.saveOrders(orders);
		myWallet custWallet = cust.getWallet();
		for(int i=0;i<orders.size();i++){
			try{
				custWallet.payMoney(orders.get(i).amount);
			}
			catch(NumberFormatException e){
				System.out.println("order amount is not formatted properly");
			}
			
			System.out.println("Charging " + orders.get(i).amount + " for " + orders.get(i).drink + "...");
			System.out.println("Your new balance is: " + custWallet.getBalance());
			
		}
	}
	
	/**
	 * Creates the menu for the barmananager to access.  
	 * Giving him multiple options of editing his info, 
	 * the bar info, or accessing the ,money collected for drinks.
	 * 
	 * @param wallet  The wallet for the bartender
	 */
	
	public void mgrMenu(myWallet wallet){
		Scanner in = new Scanner (System.in);

		System.out.println("what would you like to do? (Please enter corresponding number) ");
		System.out.println("1. Edit profile info ");
		System.out.println("2. Edit Bar Info ");
		System.out.println("3. Access Bar Wallet ");
		System.out.println("4. Log Out ");
	
		boolean r = true;
		while (r){
		try { 
			if (!in.hasNext("[12345]")) {
				throw new IllegalArgumentException("That's not an option! You are logged out.");
			}
		}
		catch (IllegalArgumentException e){
			System.err.println("IllegalArgumentException: " + e.getMessage());
		}
		}
	
		int choice = in.nextInt();
		r = false;
		/**
		 * This choice is for the barmanager to edit his or her profile.
		 */
		
		if (choice == 1){
			editProfile(name, ccNum, zip, Email);
			System.out.println("Returning to main menu...");
			System.out.println();
			mgrMenu(wallet);
			}
		/**
		 * This choice is for the barmanager to edit the bar info.
		 */
		else if (choice == 2){
			editBarInfo(bar);
			System.out.println("Returning to menu...");
			System.out.println();
			mgrMenu(wallet);
			}
		/**
		 * This choice is for the barmanager to get their balance.
		 */
		
		else if (choice == 3){
			System.out.println("Balance: " + wallet.getBalance());
			System.out.println("Returning to main menu...");
			System.out.println();
			mgrMenu(wallet);
		}
		
		/**
		 * This choice is for the barmanager to log out.
		 */
		else if (choice == 4){
			Barfrog frog = new Barfrog();
			frog.main(null);
		}
		else {
			System.out.println("Please enter a correct number. ");
			mgrMenu(wallet);
		}
	}
	
	/**
	 * An arraylist of orders.
	 * 
	 * @return retrieves the order list. 
	 */
	
	public static ArrayList<DrinkOrder> getOrders(){
		return orders;
	}	
	
	public void setOrders(ArrayList<DrinkOrder> orders){
		this.orders = orders;
	}
	/**
	 * This method gets the bar wallet.
	 * 
	 * @return the barwallet.
	 */
	
	public myWallet getWallet(){
		return barWallet;
	}

}