/*
Program description: This program will prompt the use to enter the diameter
of a sphere to calculate the volume and display result.
CMSC 203, CRN 30503
Programmer name: Odalis Flores
Due date: 02.13.2020
 */

import java.util.Scanner;
public class SphereVolume 
{
	public static void main(String[] args) 
	{
		//declare variables to hold diameter, radius and volume as doubles
		double diam, radius, volume;
		//display header
		System.out.print("\n\t******Calculating Volumne of a Sphere******\n");
		//open keyboard scanner
		Scanner keyboard= new Scanner (System.in);
		//prompt user to enter diameter
		System.out.println("Please enter the diameter of the Sphere: ");
		//get diameter from user
		diam= keyboard.nextDouble();
		//calculate the radius
		radius =diam /2;
		//calculate the volume
		volume = (4.0/3.0) * Math.PI * Math.pow(radius, 3.0);
		//print the volume of sp here
		System.out.println("The volume of a sphere with diameter of "+ diam + " is " +
				volume );
		//thank you message
		System.out.print("\nThank you for using my program");
		//close keyboard scanner
		keyboard.close();
	}

}
