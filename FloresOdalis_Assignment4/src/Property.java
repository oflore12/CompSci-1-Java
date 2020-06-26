/*
 * Property class 
 * The class Property will contain: 
 * 1. Instance variables for property name, city, rental amount, owner, and plot.
 * 2. toString method to represent a Property object. 
 * Constructors and getter and setter methods.  
 * Name: Odalis R. Flores
 * Class: CMSC 203
 * CRN: 202030
 * Assignment 4
 * Professor: Robert Alexander
 * @author Odalis Flores
 */
public class Property {
	
private String city;
private String owner;
private String propertyName;
private double rentAmount;
private Plot plot;

	/**
	 * no argument constructor
	 * sets strings to null 
	 * rent amount to 0
	 * and plot to default, 0,0,1,1
	 */
	public Property() {
		city="";
		owner="";
		propertyName="";
		rentAmount=0;
		plot= new Plot(0,0,1,1);
	}
	/*
	 * copy constructor
	 * sets instances to property object p
	 * creates a new plot object for property object p
	 */
	public Property(Property p) {
		city=p.getCity();
		owner=p.getOwner();
		propertyName=p.getPropertyName();
		rentAmount=p.getRentAmount();
		plot= new Plot(p.plot);
	}
	
	/**
	 * constructor that accepts 4 arguments and creates a new plot object
	 * @param propertyName string name of property
	 * @param city string city of property
	 * @param rentAmount double property rent amount
	 * @param owner string property owner
	 */
	public Property (String propertyName, String city, double rentAmount, String owner) {
		this.propertyName= propertyName;
		this.city= city;
		this.rentAmount= rentAmount;
		this.owner=owner;
		plot = new Plot();
	}
	
	/**
	 * constructor that accepts 8 arguments and creates a new plot object
	 * @param propertyName string name of property
	 * @param city string city of property
	 * @param rentAmount double property rent amount
	 * @param owner string property owner
	 * @param x integer value of x
	 * @param y integer value of y
	 * @param width integer value of width
	 * @param depth integer value of depth
	 */
	public Property (String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName= propertyName;
		this.city= city;
		this.rentAmount= rentAmount;
		this.owner=owner;
		plot= new Plot(x,y,width,depth);
	}
	/**
	 * getCity city getter
	 * @return city string value of property city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * getOwner owner getter
	 * @return owner string value of property owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * getPropertyName propertyName getter
	 * @return propertyName string value of property name
	 */
	public String getPropertyName() {
		return propertyName;
	}
	/**
	 * getRentAmount rent getter
	 * @return rentAmount double value of rent for property
	 */
	public double getRentAmount() {
		return rentAmount;
	}
	/**
	 * getPlot plot getter
	 * @return plot Plot object for property
	 */
	public Plot getPlot() {
		return plot;
	}
	/**
	 * setCity city setter
	 * sets city to city
	 * @param city string
	 */
	public void setCity (String city) {
		this.city=city;
	}
	/**
	 * setOwner owner setter
	 * sets owner to owner
	 * @param owner string
	 */
	public void setOwner (String owner) {
		this.owner=owner;
	}
	/**
	 * setPropertyName property name setter
	 * sets property name to property name
	 * @param propertyName string
	 */
	public void setPropertyName (String propertyName) {
		this.propertyName=propertyName;
	}
	/**
	 * setRentAmount rent amount setter
	 * sets rent amount to rent amount
	 * @param rentAmount double
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount=rentAmount;
	}
	
	/**
	 * setPlot sets plot object to x,y,width and depth
	 * @param x x-value of the property's plot
	 * @param y y-value of the property's plot
	 * @param width the horizontal size of the property's plot
	 * @param depth the vertical size of the property's plot 
	 * @return plot object
	 */
	public Plot setPlot(int x, int y, int width, int depth) {
		plot = new Plot(x,y,width,depth);
		return plot;
	}
	/**
	 * Prints out the name, city, owner and rent amount for a property
	 */
	@Override
	public String toString() {
		String strg= "Property Name: "+propertyName
	               +"\nLocated in "+city
	               +"\nBelonging to: "+ owner
	               +"\nRent Amount: "+rentAmount+"\n";
		return strg;
	}
	
}
