/*
 * TwoDimRaggedArrayUtilitySTUDENT_Test student test case
 * Name: Odalis Flores
 * Class: CMSC 203
 * CRN: 202030
 * Assignment 5
 * Professor: Robert Alexander
 * @author Odalis Flores
 */

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT = {{200,100,300},{400, 512, 700, 100},{800,200,5, 600},{1100}};;
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(5017.0,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT),.001);
		//fail("Student testGetTotal not implemented");	
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(418.083,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT),.001);
		//fail("Student testGetAverage not implemented");	
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(1712.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,1),.001);
		//fail("Student testGetRowTotal not implemented");	
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(2500.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,0),.001);
		//fail("Student testGetColumnTotal not implemented");	
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(1100.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT),.001);
		//fail("Student testGetHighestInArray not implemented");	
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT, outputFile);}
			catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(200, array[0][0],.001);
		assertEquals(100, array[0][1],.001);
		assertEquals(300, array[0][2],.001);
		assertEquals(400, array[1][0],.001);
		assertEquals(512, array[1][1],.001);
		assertEquals(700, array[1][2],.001);
		assertEquals(100, array[1][3],.001);
		assertEquals(800, array[2][0],.001);
		assertEquals(200, array[2][1],.001);
		assertEquals(5, array[2][2],.001);
		assertEquals(600, array[2][3],.001);
		assertEquals(1100, array[3][0],.001);
	}

}
