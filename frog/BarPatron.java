package frog;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

	/**
	 * This creates the class builds the bar patron account. 
	 * @author Dan McNeilly
	 */

public class BarPatron extends User {
	
	public String drinkOfChoice;
	int orderID = 0;


	 private myWallet wallet = new myWallet();
	BarPatron patron = this;

   /*	This places a drink order and records the order description.
    * 
    * @param manager sends the drink order to the appropriate bar mgr
    * @param drink sends the bar manager the drink ordered
    * @param amt sends the drink amount to the bar mgr and mywallet
	*
    */	
	public void placeOrder(BarManager mgr, String drink, Double amt) {
		DrinkOrder order = new DrinkOrder(drink, amt, this);
		mgr.orders.add(order);
		if (amt < 0){
			//This ensures the customer is paying for a drink and not just entering 0. 
			throw new IllegalArgumentException("You need to pay the correct amount.");
		}
		
	}
	 /**
		 * This method is for returning the wallet info.
		 * @return retrieves the appropriate wallet
		 */
	
	public myWallet getWallet(){
		return wallet;
	}
	
	 /**
	 * This method is supplies a menu to the customer to proceed with what he or she wants to do.
	 * @param mgr connects the actions of the user to the bar manager
	 * @param wallet connects the wallet to user
	 */
	
	public void custMenu(BarManager mgr, myWallet wallet){
		Scanner one = new Scanner (System.in);

		System.out.println("what would you like to do? (Please enter corresponding number) ");
		System.out.println("1. Edit profile info ");
		System.out.println("2. Order a drink ");
		System.out.println("3. Access myWallet ");
		System.out.println("4. Close my Tab");
		System.out.println("5. Log out");
		
		//This makes sure the customer is entering a valid selection.
		
		/*boolean r = true;
		while (r){
		try { 
			if (!one.hasNext("[12345]")) {
				throw new IllegalArgumentException("That's not an option! You are logged out.");
			}
		}
		catch (IllegalArgumentException e){
			System.err.println("IllegalArgumentException: " + e.getMessage());
		}
		}
	*/
		
		//r = false;
		 /**
		 * This choice is for the user to edit their profile
		 */	
		int choice = one.nextInt();
		
		if (choice == 1){
			editProfile(name, ccNum, zip, Email);
			SaveToFile();
			custMenu(mgr, wallet);
			}
		/**
		 * This choice is for the user to order a drink.
		 */
		else if (choice == 2){
			if (wallet.getBalance() >= 0)
			{
			System.out.println("What would you like to order? Format: drink,price(double)");
			System.out.println("Test example: budlight,3.00");
			String order = one.next();
			System.out.println(order);
			String[] orderInfo = order.split(",");
			String drink = orderInfo[0];
			double amt = Double.parseDouble(orderInfo[1]);
			placeOrder(mgr, drink, amt);
			System.out.println("Order placed for: " + drink);
			custMenu(mgr, wallet);
			}
		
		
		else {
			System.out.println("You must first add money to your wallet, before you can start ordering drinks.");
			custMenu(mgr, wallet);
		}
	}
	
		/**
		 * This choice is for the user to access mywallet to get balance or add more money.
		 */
		else if (choice == 3){
			System.out.println("Balance: " + wallet.getBalance());
			System.out.println("Would you like to add money or main menu?");
			Scanner four = new Scanner(System.in);
			String walletChoice = four.nextLine();
			if (walletChoice.equals("add money")) {
				System.out.println("How much would you like to add to your budget?");
				Scanner moneyIn = new Scanner(System.in);
				double moMoney = 0.0;
				/* try and catch precondition ensures that a double is entered
				 * and it is followed by an if statement to ensure that it is 
				 * not negative.
				 */
				try{
				moMoney = moneyIn.nextDouble();
				}
				catch(InputMismatchException e){
					System.out.println("You must enter a double");
					custMenu(mgr, wallet);
				}
				if (moMoney < 0){
					System.out.println("You cannot enter a negative number");
					custMenu(mgr, wallet);
				}
				wallet.setBalance(wallet.getBalance() + moMoney);
				System.out.println("Your new balance is: " + wallet.getBalance());
				
				assert moMoney >= 0;
				System.out.println("Would you like to log out or go to the main menu?");
				Scanner five = new Scanner(System.in);
				String escape = five.nextLine();
				if (escape.equals("main menu")) {
					custMenu(mgr, wallet);
				}
				else {
					Barfrog frog = new Barfrog();
					frog.main(null);
					
				}
				
			}
			else {
			System.out.println("Returning to main menu...");
			custMenu(mgr, wallet);
			}
			
		}
		/**
		 * This choice is for the user to close their tab.
		 */
		else if (choice == 4){
			System.out.println("Closing tab...");
			mgr.closeTab(this, mgr.getOrders());
			
			System.out.println("Returning to main menu...");
			System.out.println();
			custMenu(mgr, wallet);
		}
		/**
		 * This choice is for the user to logout.
		 */
		else if (choice == 5){
			Barfrog frog = new Barfrog();
			frog.main(null);
		}
		
		else {
			System.out.println("Please enter a correct number. ");
			custMenu(mgr, wallet);			
		}
		
	
	}

}