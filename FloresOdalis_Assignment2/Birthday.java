/*
 *Program for toy company to purchase birthday gifts for the young children 
 *The toys you can choose are divided into three categories: 
 *plushies, blocks, and books.  
 *You can add a card and/or a balloon with each gift. 
 *The program prints a title and a list of all the gifts to the console, 
 *with a total for each gift, and the total amount of the order. 
 *The program generates a random five-digit number to serve as 
 *the order number, followed by programmer name.  
 * Programmer name: Odalis Flores
 * CMSC 203, CRN: 30503
 * Assignment 1
 * Due date: 02/27/2020
 */

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.JOptionPane;

public class Birthday {

	public static void main(String[] args) {
		//keyboard scanner
		Scanner keyboard = new Scanner (System.in);
		//toy class driver
		Toy t = new Toy();
		//random object
		Random randomNumbers = new Random();
		//dollar format
		DecimalFormat dollar = new DecimalFormat("#,##0.00");
		//constant for programmer name
		final String PROGRAMMER_NAME= "Odalis R. Flores";
		//string variable to hold child's name, age, toy, balloon, card and additional toy option
		String childName,
		childAge,
		toy,
		balloon,
		card,
		additionalToy,
		userInput;
		//integer to hold age and order number
		int age, orderNumber;
		//double variable that adds total cost
		double orderTotal =  0;
		//display message
		JOptionPane.showMessageDialog(null, "Welcome to the Toy Company"
				+ " to choose gifts for young children");
		
		//prompt user to enter childs name
		childName = JOptionPane.showInputDialog("Enter the name of the child");
		//prompt user to enter age
		childAge =JOptionPane.showInputDialog("Enter the age of the child");
		//convert string input to integer
		age = Integer.parseInt(childAge);
		//set age in toy object
		t.setAge(age);
		//prompt user to choose toy to purchase
		toy = JOptionPane.showInputDialog("Choose a toy: a Plushie, Blocks, or a book");
		t.setToy(toy);
		t.setCost(toy);
		
		
		//VALIDATE TOY CHOICE
		if (t.ageOK()==false)
		{
			userInput= JOptionPane.showInputDialog("Toy is not age appropiate would you like to cancel? Yes or No?");
			while (userInput.equalsIgnoreCase("YES"))
			{
				//prompt user to enter childs name
				childName = JOptionPane.showInputDialog("Enter the name of the child");
				//prompt user to enter age
				childAge =JOptionPane.showInputDialog("Enter the age of the child");
				//convert string input to integer
				age = Integer.parseInt(childAge);
				//set age in toy object
				t.setAge(age);
				//prompt user to choose toy to purchase
				toy = JOptionPane.showInputDialog("Choose a toy: a Plushie, Blocks, or a book");
				t.setToy(toy);
				t.setCost(toy);
			}
		}
		
		
		//Prompt user if they want balloon
		balloon = JOptionPane.showInputDialog("Do you want a balloon with the gift? Yes or No");
		t.addBalloon(balloon);
		//Prompt user if they want a card
		card = JOptionPane.showInputDialog("Do you want a card with the gift? Yes or No");
		t.addCard(card);
		//Prompt user if they want another toy
		additionalToy = JOptionPane.showInputDialog("Would you like to purchase another toy");
		//print order on console
		System.out.println("\t****BIRTHDAY GIFTS****");
		System.out.println("The gift for " + childName + t.toString());
		orderTotal+=t.getCost();
		
		
		
		
		
		
		
		
		
		
		//Prompt user if they want another toy
		//additionalToy = JOptionPane.showInputDialog("Would you like to purchase another toy");
		//while answer is yes repeat questions
		while(additionalToy.equalsIgnoreCase("YES"))
		{
			//prompt user to enter childs name
			childName = JOptionPane.showInputDialog("Enter the name of the child");
			//prompt user to enter age
			childAge =JOptionPane.showInputDialog("Enter the age of the child");
			//convert string input to integer
			age = Integer.parseInt(childAge);
			//set age in toy object
			t.setAge(age);
			//prompt user to choose toy to purchase
			toy = JOptionPane.showInputDialog("Choose a toy: a Plushie, Blocks, or a book");
			t.setToy(toy);
			t.setCost(toy);
			
			
			//VALIDATE TOY CHOICE
			if (t.ageOK()==false)
			{
				userInput= JOptionPane.showInputDialog("Toy is not age appropiate would you like to cancel? Yes or No?");
				while (userInput.equalsIgnoreCase("YES"))
				{
					//prompt user to enter childs name
					childName = JOptionPane.showInputDialog("Enter the name of the child");
					//prompt user to enter age
					childAge =JOptionPane.showInputDialog("Enter the age of the child");
					//convert string input to integer
					age = Integer.parseInt(childAge);
					//set age in toy object
					t.setAge(age);
					//prompt user to choose toy to purchase
					toy = JOptionPane.showInputDialog("Choose a toy: a Plushie, Blocks, or a book");
					t.setToy(toy);
					t.setCost(toy);
					//userInput= JOptionPane.showInputDialog("Toy is not age appropiate would you like to cancel? Yes or No?");
				}
			}
			
			
			//Prompt user if they want balloon
			balloon = JOptionPane.showInputDialog("Do you want a balloon with the gift? Yes or No");
			t.addBalloon(balloon);
			//Prompt user if they want a card
			card = JOptionPane.showInputDialog("Do you want a card with the gift? Yes or No");
			t.addCard(card);
			//Prompt user if they want another toy
			additionalToy = JOptionPane.showInputDialog("Would you like to purchase another toy");
			System.out.println("The gift for " + childName + t.toString());
			orderTotal+=t.getCost();
		}


		//get random number for order total
		orderNumber=randomNumbers.nextInt(100000);
		//display order total
		System.out.println("\nThe order number is "+orderNumber + ". The order total is $" + dollar.format(orderTotal));
		//display programmer name
		System.out.println("\nProgrammer Name: " +PROGRAMMER_NAME);
		
		keyboard.close();
		System.exit(0);
	}

}
