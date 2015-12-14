package frog;

/**
 * This is the bar class that has an id, a name, 
 * an address, and a description.
 */

public class Bar {

	public int barID;
	public String barName;
	public String barAddress;
	public String barDescription;
	
	/**
	 * Bar constructor with null values.
	 */
	
	public Bar(){
		this.barID = 00;
		this.barName = "AC's";
		this.barAddress="000 King St";
		this.barDescription="The best bar ever";
	}
	
	/**
	 * Creates the bar and attaches its related information.
	 * 
	 * @param id the bar id
	 * @param name the name of the bar
	 * @param addr the address of the bar
	 * @param descr the description of the bar
	 */
	
	public Bar(int id, String name, String addr, String descr){
		this.barID = id;
		this.barName = name;
		this.barAddress = addr;
		this.barDescription = descr;
	}
	
	/**
	 * Method for getting the bar id.
	 * 
	 * @return the bar id.
	 */
	
	public int getID(){
		return this.barID;
	}
	
	/**
	 * Method for getting the bar name.
	 * 	 
	 * @return the bar name.
	 */
	
	public String getName(){
		return this.barName;
	}
	
	/**
	 * Method for getting the bar address.
	 * 
	 * @return the bar address.
	 */

	public String getAddress(){
		return this.barAddress;
	}
	
	/**
	 * Method for getting the bar description.
	 * 
	 * @return the bar description.
	 */

	public String getDescription(){
		return this.barDescription;
	}
	
	/**
	 * Method for setting the bar id.
	 * 
	 * @param id sets the bar id.
	 */

	public void setID(int id){
		this.barID = id;
	}
	
	/**
	 * Method for setting the bar name.
	 * 
	 * @param name sets the bar name.
	 */
	
	public void setName(String name){
		this.barName = name;
	}
	
	/**
	 * Method for setting the bar address.
	 * 
	 * @param addr sets the bar address.
	 */
	public void setAddress(String addr){
		this.barAddress = addr;
	}
	
	/**
	 * Method for setting the bar description.
	 * 
	 * @param descr sets the bar description.
	 */
	public void setDescription(String descr){
		this.barDescription = descr;
	}


}