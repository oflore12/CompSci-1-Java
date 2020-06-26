import java.text.DecimalFormat;

/*
 * ManagementCompany will contain instance variables of name, tax Id, management fee, 
 * MAX_PROPERTY (a constant set to 5) and an array named properties of Property objects 
 * of size MAX_PROPERTY, as well as two constants MGMT_WIDTH and MGMT_DEPTH, 
 * both set to 10; an attribute plot of type Plot that defines the plot of the 
 * ManagementCompany Class
 * Name: Odalis Flores
 * Class: CMSC 203
 * CRN: 202030
 * Assignment 4
 * Professor: Robert Alexander
 * @author Odalis Flores
 */
public class ManagementCompany {
	private final int MAX_PROPERTY=5;
	private double mgmFeePer;
	private String name;
	private Property[] properties = new Property [MAX_PROPERTY];
	private String taxID;
	private final int MGMT_WIDTH=10;
	private final int MGMT_DEPTH=10;
	private Plot plot;
	private int index;
	
	/**
	 * no argument constructor initializes the strings to null and default plot
	 * initializes index to 0 and initialized properties array
	 */
	public ManagementCompany() {
		name="";
		taxID=""; 
		plot= new Plot (0,0,MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
		index=0;
	}
	/**
	 * ManagementCompnay constructor that accepts 3 arguments creates
	 * a default plot and initializes index to 0 and initializes properties array
	 * @param name the name of management company
	 * @param taxID management company taxID
	 * @param mgmFee management company management fee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name=name;
		this.taxID=taxID;
		this.mgmFeePer=mgmFee;
		plot= new Plot (0,0,MGMT_WIDTH, MGMT_DEPTH);
		properties= new Property[MAX_PROPERTY];
		index=0;
	}
	/**
	 * ManagementCompnay constructor that accepts 7 arguments creates
	 * a plot object based on the arguments and creates properties array
	 * and initializes index to 0
	 * @param name the name of management company
	 * @param taxID management company taxID
	 * @param mgmFee management company management fee
	 * @param x the plot x value
	 * @param y the plot y value
	 * @param width the plot width
	 * @param depth the plot depth
	 */

	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth ) {
		this.name=name;
		this.taxID=taxID;
		this.mgmFeePer=mgmFee;
		plot= new Plot (x,y,width,depth);
		properties = new Property[MAX_PROPERTY];
		index=0;
	}
	/**
	 * Management company initializes variable to another company
	 * creates new properties array and initializes index to 0
	 * @param otherCompany
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = otherCompany.plot;
		properties = new Property[MAX_PROPERTY];
		index=0;
	}
/**
 * getMAX_PROPERTY will return the private final instance
 * @return MAX_PROPERTY
 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
/**
 * addProperty will check if the property passed as an argument has no information
 * returns -2 if true, if the index exceeds the MAX_PROPERTY it will return -1, 
 * if the plot is not encompassed by the property plot it will return -3,
 * if any of the properties overlap ex
 * if all if statements are false then the property is added to the properties array and
 * index is incremented and index -1 will return
 * @param property the object property 
 * @return -2 || -1||-3||-4||index-1
 */
	public int addProperty(Property property) {
		if(property==null)
			return -2;
		
		if(index>=MAX_PROPERTY)
			return -1;
		
		if(!plot.encompasses(property.getPlot()))
			return -3;
		
		for(int i= 0; i<index;i++) {
			if(property.getPlot().overlaps(properties[i].getPlot()))
					return -4;
		}
		
		properties[index]= property;
		index++;
		return index-1;
		
	}
	/**
	 * addProperty method will create a new property object based on the arguments passed.
	 * if the index exceeds the MAX_PROPERTY it will return -1, 
	 * * if the plot is not encompassed by the property plot it will return -3,
	 * if all if statements are false then the property is added to the properties array and
	 * index is incremented and index -1 will return
	 * @param name name of the property
	 * @param city name of the property city
	 * @param rent amount of rent for property
	 * @param owner name of the property owner
	 * @return -2 || -1||-3||-4||index-1
	 */

	public int addProperty(String name,String city,double rent,String owner) {
		Property property= new Property(name, city, rent, owner);
		
		if(index>=5)
			return -1;
		
		if(!plot.encompasses(property.getPlot()))
			return -3;
		
		for(int i= 0; i<index;i++) {
			if(property.getPlot().overlaps(properties[i].getPlot()))
					return -4;
		}
		
		properties[index]= property;
		index++;
		return index-1;
	}
	/**
	 * addProperty method will create a new property object based on the arguments passed.
	 * if the index exceeds the MAX_PROPERTY it will return -1, 
	 * * if the plot is not encompassed by the property plot it will return -4,
	 * if all if statements are false then the property is added to the properties array and
	 * index is incremented and index -1 will return
	 * @param name name of the property
	 * @param city name of the property city
	 * @param rent amount of rent for property
	 * @param owner name of the property owner
	 * @param x the plot x value
	 * @param y the plot y value
	 * @param width the plot width
	 * @param depth the plot depth
	 * @return -2 || -1||-3||-4||index-1
	 */
	public int addProperty(String name,String city,double rent,String owner,int x,int y,int width,int depth) {
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		
		if(index>=5)
			return -1;
		
		if(!plot.encompasses(property.getPlot()))
			return -3;
		
		for(int i= 0; i<index;i++) {
			if(property.getPlot().overlaps(properties[i].getPlot()))
					return -4;
		}
		
		properties[index]= property;
		index++;
		return index-1;
	}
	/**
	 * totalRent will calculate the sum of all property rent
	 * @return double totalRent
	 */
	public double totalRent() {
		double totalRent=0;
		for (int i=0; i<index; i++){
			totalRent+= properties[i].getRentAmount();
		}
		return totalRent;
	}
	/**
	 * maxRentProp will find the property with the max rent amount by
	 * calling the maxRentPropertyIndex toString
	 * @return max of type string
	 */
	public String maxRentProp() {
		String maxRent = properties[maxRentPropertyIndex()].toString();
		return maxRent;
	}
	
	public double maxRentProperty() {
		return properties[maxRentPropertyIndex()].getRentAmount();
	}
	/**
	 * maxRentPropertyIndex will find the property with the max rent amount and
	 * return the index of that property
	 * @return integer value of index
	 */

	public int maxRentPropertyIndex() {
		int maxIndex = 0;
		double maxRent = properties[0].getRentAmount();
		for (int i=0; i < index; i++) {
		if (properties[i].getRentAmount()> maxRent)
			{
			maxIndex= i;
			maxRent = properties[i].getRentAmount();
			}
		}
		return maxIndex;
	}
	/**
	 * displayPropertyAtIndex will display the property toString 
	 * at i
	 * @param i index of properties array
	 * @return strg toString at properties at index i
	 */
	public String displayPropertyAtIndex(int i) {
		String strg = properties[i].toString();
		return strg;
	}
	/**
	 * String method getName
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * void method setName to set name with name
	 * @param name String name
	 */
	public void setName(String name) {
		this.name= name;
	}
	/**
	 * Plot method called getPlot
	 * @return plot
	 */
	public Plot getPlot() {
		return plot;
	}
	/**
	 * setPlot method that sets the plot with x,y, width and depth
	 * @param x x-value of the property's plot
	 * @param y y-value of the property's plot
	 * @param width the horizontal size of the property's plot
	 * @param depth the vertical size of the property's plot 
	 * @return plot object
	 */
	public void setPlot(int x, int y, int width, int depth) {
		plot = new Plot (x,y,width,depth);
	}

	private static DecimalFormat df1 = new DecimalFormat("#.#");
	/**
	 * toString will display the management company information
	 * and all the toString's for each property in the properties array
	 * it will calculate the total mgmtFeePer for each property and
	 * display total
	 */
	public String toString() {
		String strg;
		String propertyInfo = "";
		double totMgmFeePer = (mgmFeePer / 100) * totalRent();
		
		for(int i=0;i < index ;i++) {
			propertyInfo+=displayPropertyAtIndex(i);
		}
		strg = "List of all properties for "+ name +", taxID: " + taxID 
				+"\n_____________________________________\n"
				+propertyInfo
				+"_____________________________________\ntotal management Fee: " 
				+ df1.format(totMgmFeePer);
		return strg;
	}
}
