# BarFrog
## AUTHOR: Daniel McNeilly

##Synopsis

BarFog is software that will be applied to a POS system in a bar or restaurant.  When starting the program, you will be prompted to sign in as a customer or a bar manager.  Once this is done, you will see a "main menu" and you can make selections appropriately.  

Barfrog.java is used as a main class that introduces you to the program.  If you are customer, the program then accesses the barpatron.java class and gives you options on how you would like to proceed.

As a customer "edit profile info" establishes your account and gives the bar your information.  You will enter personal information such as your credit card number and email address.  You have the option to order a drink, and this information will get sent to the BarManager.java class for them to process your order.  You also have the option to add money to your tab or account with the MyWallet.java class, to track your spending.  The drinks you order, which will be controlled in the DrinkOrder.java class, will be deducted automatically from your balance.  When you are finished and do not wish to order anything else, you can close your tab and it will tell you everything you ordered, how much it all is, and what is left on your account.  

As a Bar Manager you have similar options but from the bar's perspective in the BarManager.java class. You can access and edit your bar profile's information, you must enter your bar manager's account information to receive payments, and the email for receipt confirmation. Accessing the bar wallet will give the bar manager a list of drinks that have been ordered and the money expected to receive for those drinks.

##Usage
When you compile the code, you will be asked if you are a customer or bar manager.  After selecting customer, you will be given another menu: 
what would you like to do? (Please enter corresponding number) 
1. Edit profile info 
2. Order a drink 
3. Access myWallet 
4. Close my Tab
5. Log out/n
From here, you should first edit your profile info.  It will ask you a series of questions, and when you have answered them all, it will return you to the main menu.  You may now proceed to put money in your account via option 3.  It will ask you what amount you would like to add, and this will be your new balance.  When you return to the main menu, you can now choose option 2 and continue to order drinks until your wallet is empty or you are satiated.  Once your experience at the bar is complete, you can choose option 4 and close your tab.  This will give you a list of drinks you ordered along with the new balance of your wallet after the drink prices have been deducted.
As a bar manager, you option menu will look like this:
what would you like to do? (Please enter corresponding number) 
1. Edit profile info 
2. Edit Bar Info 
3. Access Bar Wallet 
4. Log Out 
You have option to enter the bar managers profile information, the associated bar information, and to retrieve the order list and monetary totals from option 3.

 
##Code example

private static void mainMenu(Bar bar, BarPatron cust, BarManager mgr, myWallet custWallet, myWallet barWallet) {
		
		
## Motivation

This is an actual phone app that is being created by some of my associates.  I'm hoping that some of my code can be used and contribute to the app development and final product. 
