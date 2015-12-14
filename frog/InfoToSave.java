package frog;
import java.io.*;
import java.util.ArrayList;

public class InfoToSave {
	
	File file = new File("BarFrog/frogSave/output.txt");
	
	public void saveOrders(ArrayList<DrinkOrder> orders) {
		try {

			String orderlist = "";
			
			//@SuppressWarnings("static-access")
			//ArrayList<DrinkOrder> orders = barguy.getOrders();
			//System.out.println(barguy.orders);
			//System.out.println(orders);
			for (DrinkOrder s : orders)
			{
			    orderlist += s + "\n";
			}
			
			// if file doesn't exist, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(orderlist);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}