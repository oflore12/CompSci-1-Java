/*
 * HolidayBonus class calculates the bonuses of each store and the sum of all bonuses
 * Name: Odalis Flores
 * Class: CMSC 203
 * CRN: 202030
 * Assignment 5
 * Professor: Robert Alexander
 * @author Odalis Flores
 */
public class HolidayBonus {
	/**
	 * no argument/empty constructor
	 */
	public HolidayBonus(){}
	/**
	 * calculateHolidayBonus will calculate the bonus each store receives
	 * and returns the total bonuses for each store
	 * @param data the two dimensional array of store sales
	 * @param high bonus for the highest store in a category
	 * @param low bonus for the lowest store in a category
	 * @param other bonus for all other stores in a category
	 * @return one dimensional array for total bonuses for each store
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other ){
		double[] holidayBonus = new double [data.length];
		
		for(int rowNum=0; rowNum < data.length ;rowNum++) {
			for(int col=0; col < data[rowNum].length ;col++) {
			
				if(data[rowNum][col]>0) {
					if(data[rowNum][col] == data[TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col)][col])
						holidayBonus[rowNum]+=high;
		
					else if(data[rowNum][col]== data[TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col)][col])
						holidayBonus[rowNum]+=low;
					
					else holidayBonus[rowNum]+=other;
					}
			else holidayBonus[rowNum]+=0;
				
				}
			}
		return holidayBonus;
	}
	/**
	 * calculateTotalHolidayBonus this method calculates the sum of all
	 * bonuses received from each store.
	 * @param data the two dimensional array of store sales
	 * @param high bonus for the highest store in a category
	 * @param low bonus for the lowest store in a category
	 * @param other bonus for all other stores in a category
	 * @return sum of total holiday bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other ){
		double totalBonus=0;
		
		double[] holidayBonus = calculateHolidayBonus(data,high,low,other);
		
		for(int i=0; i < data.length;i++) {
			totalBonus+=holidayBonus[i];
		}
		
		return totalBonus;   
	}
	
}
