import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/*
 * TwoDimRaggedArrayUtility will analyze file data to read and write to file
 * it will find the index of the highest in a row/column as well as throughout 
 * the entire ragges array. 
 * Name: Odalis Flores
 * Class: CMSC 203
 * CRN: 202030
 * Assignment 5
 * Professor: Robert Alexander
 * @author Odalis Flores
*/

public class TwoDimRaggedArrayUtility {
	/**
	 * readFile will read double numbers from a file sources and save to a two dimensional array
	 * of type strings, it will then be converted to a double ragged array of type double
	 * @param file file to read doubles from
	 * @return two dimensional ragged array
	 * @throws FileNotFoundException
	 */
	public static double[][] readFile(File file) throws FileNotFoundException{

		int rowCount = 0, 
				colCount;
		String[][] tempData = new String[10][];
		Scanner inputFile = new Scanner(file);
		
		while(inputFile.hasNextLine()){
			tempData[rowCount] = inputFile.nextLine().split(" ");
			rowCount++;
			}
		inputFile.close();
		
		double data[][]= new double[rowCount][];
		
		for(int row=0; row < rowCount; row++){
			
			colCount = tempData[row].length;
			data[row] = new double[colCount];
			
			for(int col=0; col<colCount; col++){
				if(tempData[row][col]!=null) {
					data[row][col]=Double.parseDouble(tempData[row][col]);
					}
				}
			}
		return data;
	}
	/**
	 * writeToFile willWrite the ragged array of doubles into the file, each row is on a 
	 * separate line and the double numbers are separated by a space.
	 * @param data the two dimensional array
	 * @param outputFile the file to write to
	 * @throws FileNotFoundException
	 */
	public static void writeToFile(double[][] data, File outputFile)throws FileNotFoundException  {
		
		PrintWriter output= new PrintWriter(outputFile);
		for(int row=0; row < data.length;row++){
			for(int col=0; col< data[row].length; col++) {
				if(col==0)
					output.print(data[row][col]);
				else
					output.print(" "+data[row][col]);
			}
			output.println();
		}
		output.close();
	}
	/**
	 * getTotal calculates the sum of the total amount of
	 * elements in the array
	 * @param data the two dimensional array
	 * @return total sum of elements
	 */
	public static double getTotal(double[][] data) {
		double sum= 0;
		for(int row = 0; row<data.length;row++) {
			for (int col=0; col<data[row].length;col++)
				sum += data[row][col];
			}
		return sum;
	}
	/**
	 * getAverage will calculate the average of the total sum
	 * of elements in the array
	 * @param data the two dimensional array
	 * @return average of array
	 */
	public static double getAverage(double[][] data) {
		double totElements = 0;
		for(int row=0; row<data.length;row++){
			for(int col=0; col< data[row].length; col++) {
				totElements ++;
			}
		}
		return getTotal(data)/totElements;
	}
	/**
	 * getRowTotal calculates the sum of elements in given row
	 * @param data the two dimensional array
	 * @param row specified row index
	 * @return total of elements in given row
	 */
	public static double getRowTotal(double[][] data, int row) {
		double rowTotal=0;
		for(int col=0; col<data[row].length;col++) {
			rowTotal+=data[row][col];
			}
		return rowTotal;
	}
	/**
	 * getColumnTotal calculates the sum of elements in given column
	 * @param data the two dimensional array
	 * @param col column index
	 * @return total of elements in given column
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double colTotal=0;
		for(int row=0; row<data.length;row++) {
			if (data[row].length<= col)
				continue;
			colTotal+=data[row][col];
		}
		return colTotal;
	}
	/**
	 * getHighestInRow will look at given row to get the largest
	 * element in specified row
	 * @param data the two dimensional array
	 * @param row row index
	 * @return the largest element in specified row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highest = data[row][getHighestInRowIndex(data,row)];
		return highest;
	}
	/**
	 * getHighestInRowIndex will look at given row to get the largest
	 * element in specified row
	 * @param data the two dimensional array
	 * @param row row index
	 * @return the index of the largest element in row
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highest = data[row][0];
		int colIndex =0;
		for (int col=0; col<data[row].length;col++) {
			if(highest< data[row][col]){
				highest= data[row][col];
				colIndex=col;
			}
		}
		return colIndex;
	}
	/**
	 * getLowestInRow will look at given row to get the smallest
	 * element in specified row
	 * @param data the two dimensional array
	 * @param row row index
	 * @return the smallest element in specified row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = data[row][getLowestInRowIndex(data,row)];
		return lowest;
	}
	/**
	 * getLowestInRowIndex will look at given row to get the smallest
	 * element in specified row
	 * @param data the two dimensional array
	 * @param row row index
	 * @return the index of the smallest element in row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowest = Double.MAX_VALUE;;
		int colIndex =0;
		for (int col=0; col<data[row].length;col++) {
			if(lowest> data[row][col]){
				lowest= data[row][col];
				colIndex=col;
			}
		}
		return colIndex;	
	}
	/**
	 * getHighestInColumn will get the largest element in a 
	 * given column
	 * @param data the two dimensional array
	 * @param col specified column index
	 * @return the largest element in specified column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		return data[getHighestInColumnIndex(data,col)][col];
	}
	/**
	 * getHighestInColumnIndex will look at given column to get the largest
	 * element in specified column
	 * @param data the two dimensional array
	 * @param col column index
	 * @return the index of the largest element in column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		int index=0;
		
		double highest = Double.MIN_VALUE;;
		
		for(int row=0; row< data.length;row++) {
			if (data[row].length<= col)
				continue;
			if(highest < data[row][col]) {
				highest = data[row][col];
				index = row;
			}
		}
		return index;
	}
	/**
	 * getLowestInColumn will get the smallest element in a 
	 * given column
	 * @param data the two dimensional array
	 * @param col specified column index
	 * @return the smallest element in specified column
	 */
	public static double getLowestInColumn(double[][] data, int col){
		return data[getLowestInColumnIndex(data,col)][col];
		
	}
	/**
	 * getLowestInColumnIndex will look at given column to get the smallest
	 * element in specified column
	 * @param data the two dimensional array
	 * @param col column index
	 * @return the index of the smallest element in column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		int index=0;
		
		double lowest = Double.MAX_VALUE;
		
		for(int row=0; row< data.length;row++) {
			if (data[row].length<= col)
				continue;
			if(lowest > data[row][col]) {
				lowest = data[row][col];
				index = row;
			}
		}
		return index;
	}
	/**
	 * getHighestInArray will analyze array to find the largest value
	 * @param data the two dimensional array
	 * @return the largest element in the two dimensional array
	 */
	public static double getHighestInArray(double[][] data) {
		double highest= data[0][0];
		
		for(int row = 0; row<data.length;row++) {
			for (int col=0; col<data[row].length;col++)
				if (highest < data[row][col])
					highest = data[row][col];
		}
		
		return highest;
	}
	/**
	 * getLowestInArray will analyze array to find the smallest value
	 * @param data the two dimensional array
	 * @return the smallest element in the two dimensional array
	 */
	public static double getLowestInArray(double[][] data) {
		double lowest= data[0][0];
		for(int row = 0; row<data.length;row++) {
			for (int col=0; col<data[row].length;col++)
				if (lowest> data[row][col])
					lowest= data[row][col];
			}
		return lowest;
		}
}
