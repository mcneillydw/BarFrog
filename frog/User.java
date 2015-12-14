package frog;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class User {	

	public int ID;
	public String ccNum;
	public String name;
	public String Email;
	public String zip;

	public void getBarInfo(Bar bar) {
		System.out.println("Bar name: " + bar.getName() + "/nBar Description: " + bar.getDescription()
				+ "/nBar Address: " + bar.getAddress());
	}

	public User() {
		this.ID = 00;
		this.ccNum = getCC();
		this.name = getName();
		this.Email = getEmail();
		this.zip = getZip();
	}
	
	public String getCC() {
		return ccNum;
	}
	public void setCC(String ccNum) {
		this.ccNum = ccNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	//writes the user info to a file.
	public void SaveToFile() { 
			try {

				String content = "User name : " + name + "\r\nCredit Card number : " 
				      + ccNum + "\r\nArea code : " + zip  + "\r\nEmail : " + Email;

				File file = new File("frogSave/output.txt");

				// if file doesn't exist, then create it
				if (!file.exists()) {
					file.createNewFile();
				}

				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(content);
				bw.close();

				System.out.println("Done");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	//Reads the user info from a file
	public void ReadIn() {

			try (BufferedReader br = new BufferedReader(new FileReader("frogSave/output.txt")))
			{

				String data;
				ArrayList<String> custInfo= new ArrayList<String>();

				while ((data = br.readLine()) != null) {
					String[] newData = data.split(":");
					custInfo.add(newData[1]);  			
				}
				editProfile(custInfo.get(0), custInfo.get(1), custInfo.get(2), custInfo.get(3)); 

			} catch (IOException e) {
				e.printStackTrace();
			} 

		}
	
	
	
	
	public void editProfile(String name, String ccNum, String zip, String Email) {
		Scanner edit = new Scanner(System.in);

		System.out.println("Your first name? ");
		String newName = edit.next();
		this.name = newName;
		
		
		System.out.println("Please enter your credit card number: ");
		String newccNum = edit.next();
		this.ccNum = newccNum;
		
		System.out.println("Enter your zip code: ");
		String newZip = edit.next();
		this.zip = newZip;

		System.out.println("Enter your email for your receipt: ");
		String newMail = edit.next();
		this.Email = newMail;

		System.out.println("Name: " + newName);
		System.out.println("Credit Card number: " + newccNum);
		System.out.println("Zip code: " + newZip);		
		System.out.println("Email:" + newMail);
		
		

	}
	
	

}