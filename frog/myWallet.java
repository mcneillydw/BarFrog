package frog;


/**
 * eWallet that can users and bar managers can store credit card information.
 * @author Dan McNeilly
 * 
 * 
 */
public class myWallet {
    private int walletID;
    public static double balance;
    private long cardNumber;

    /**
	 * Wallet class constructor that sets null values to 
	 * walletid, balance of the wallet, 
	 * and the credit card information.
	 */
    public myWallet() {
        this.walletID = 0;
        this.setBalance(0.0);
        this.cardNumber = 9819465435L;
    }
    /**
	 * Wallet class that takes in values and gives them variables.
	 * @param id  wallet id 
	 * @param bal provides wallet balance
	 * @param cardnum credit card info
	 */

    public myWallet(int id, double bal, long cardNum) {
        this.walletID = id;
        this.setBalance(bal);
        this.cardNumber = cardNum;
    }
    
    /**
	 * This method is for receiving money onto the balance
	 * @param amt is the amount the balance is increased by.
	 */

    public void receiveMoney(myWallet cust, double amt) {
    	cust.setBalance(balance - amt);
    	this.setBalance(getBalance() + amt);
    }
    /**
   	 * This method is for paying money from the balance
   	 * @param amt is the amount the balance is decreased by.
   	 */

    public void payMoney(double amt)throws NumberFormatException {
        this.setBalance(getBalance() - amt);
    }
    
    /**
   	 * This method is for retrieving the balance
   	 * @return the balance of Mywallet.
   	 */

	public double getBalance() {
		return myWallet.balance;
		
	}
	public void setBalance(double balance) {
		if (myWallet.balance < 0)
            throw new IllegalArgumentException("Balance cannot be less than 0");
		else{
		myWallet.balance = balance;
		}
		
		//postcondition to ensure balance cannot be a negative number.
		assert myWallet.balance > 0;
		
		
		
	}
}