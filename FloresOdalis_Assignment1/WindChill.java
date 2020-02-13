import java.util.Scanner;

public class WindChill {

	public static void main(String[] args) {
		double tempInFahrenheit,
		windSpeed,
		velocity,
		windChill;
		final double TEMP_MIN = -45, 
				TEMP_MAX=40,
				WIND_MIN=5,
				WIND_MAX=60;
		final int ASSIGNMENT_NUM=1;
		final String PROGRAMMER_NAME= "Odalis R. Flores";
		Scanner keyboard= new Scanner (System.in);
		//Prompt user to enter temp
		System.out.println("\t*****Wind Chill Temperature Index*****\n");
		String enterTemp= "Please enter Fahrenheit temperature between ";
		System.out.print(enterTemp +TEMP_MIN + " and " + TEMP_MAX +": ");
		tempInFahrenheit= keyboard.nextDouble();
		//validate input
		while (tempInFahrenheit <TEMP_MIN || tempInFahrenheit >TEMP_MAX)
		{
			System.out.print("INAVLID INPUT!!\n"+ enterTemp +TEMP_MIN + " and " + TEMP_MAX +": ");
			tempInFahrenheit= keyboard.nextDouble();
		}
		
		//Prompt user to enter wind speed
		String enterWind="Please enter wind speed between ";
		System.out.print( enterWind +WIND_MIN + " and " + WIND_MAX +": ");
		windSpeed= keyboard.nextDouble();
		//validate input
		while (windSpeed <WIND_MIN || windSpeed >WIND_MAX)
		{
			System.out.print("INAVLID INPUT!!\n"+ enterWind +WIND_MIN + " and " + WIND_MAX +": ");
			windSpeed= keyboard.nextDouble();
		}
		//calculate velocity
		velocity = Math.pow(windSpeed, 0.16);
		//calculate wind chill
		windChill= 35.75 + 0.615 * tempInFahrenheit - 35.75 * velocity + 0.4275 * tempInFahrenheit *velocity;
		System.out.println("\nThe wind chill temperature is: "+windChill + " degrees Fahrenheit");
		
		System.out.print("\nThank you for testing my program!\nProgrammer name: "+PROGRAMMER_NAME +"\nAssignment number: "+
				ASSIGNMENT_NUM);
		keyboard.close();

	}
	

}
