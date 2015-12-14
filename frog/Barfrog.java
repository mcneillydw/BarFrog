package frog;

import java.util.Scanner;
import java.io.*;

/**
 * This is the main class that operates the barfrog program.
 * @author Dan McNeilly
 */

public class Barfrog {

	public static void main(String[] args) {
		
		User data = new User();
		Bar bar = new Bar();
		BarPatron cust = new BarPatron();
		BarManager mgr = new BarManager();
		myWallet custWallet = cust.getWallet();
		myWallet barWallet = mgr.getWallet();
		mainMenu(bar, cust, mgr, custWallet, barWallet);
		
	}
	
	
	/**
	 * This method creates the main menu for users.
	 * @param bar The bar that the user or manager accesses.
	 * @param cust The customer that the bar manager gets the drink for.
	 * @param mgr the manager that works at the correlated bar.
	 * @param custWallet the customers budget or cash willing to spend that evening.
	 * @param bar Wallet the money brought into the bar account from drinks ordered.
	 */

	private static void mainMenu(Bar bar, BarPatron cust, BarManager mgr, myWallet custWallet, myWallet barWallet) {
		System.out.println("Welcome to BarFrog! ");
		System.out.println("...Helping you master your night. ");
		System.out.println("  @..@ ");
		System.out.println(" (____)");
		System.out.println("(>____<)");
		System.out.println(" ^^~~^^");
		System.out.println("Are you a customer or a bar employee? ");
		
		
		
		Scanner in = new Scanner(System.in);
		String userType = in.nextLine();
		
		//checkargument pre-condition, commented out due to better alternative.

		Scanner two = new Scanner(System.in);
		//checkArgument(userType.equals("customer") || userType.equals("bar employee"));
		if (userType.equals("customer")) {
			cust.custMenu(mgr, custWallet);
		} else if (userType.equals("bar employee")) {
			mgr.mgrMenu(barWallet); 
		}
		else {
			System.out.println("error");
			mainMenu(bar, cust, mgr, custWallet, barWallet);
		}

	}

	private static void checkArgument(boolean b) {
		// TODO Auto-generated method stub
		
	}
}