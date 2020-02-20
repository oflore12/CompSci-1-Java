import java.util.Scanner;

public class MovieDriver 
{

	public static void main(String[] args) 
	{
		//string variable to hold user input
		String userInput;
		//char variable to hold character of user input
		char answer;
		//Movie object
		Movie m = new Movie();
		//keyboard Scanner
		Scanner keyboard= new Scanner (System.in);
		//Prompt user to enter movie name
		System.out.println("Please enter the title of a movie:");
		//set user input to title in movie object
		m.setTitle(keyboard.nextLine());
		//Prompt user to enter movie rating
		System.out.println("Please enter the movie’s rating:");
		//get user input and set to movie object
		m.setRating(keyboard.nextLine());
		//Prompt user to enter tickets sold
		System.out.println("Please enter the number of tickets sold at this theater:");
		//get user input and set to movie object
		m.setSoldTickets(keyboard.nextInt());
		//display movie toString method
		System.out.println(m);
		//keyboard buffer
		keyboard.nextLine();
		
		//Prompt user if they would like to enter another movie
		System.out.println("Would you like to enter another? ( y=yes or n=no");
		//get user input
		userInput = keyboard.nextLine();
		//set first character to answer
		answer =userInput.charAt(0);
		//if answer is y repeat loop
		while (answer == 'y')
		{
			System.out.println("Please enter the title of a movie:");
			m.setTitle(keyboard.nextLine());
			System.out.println("Please enter the movie’s rating:");
			m.setRating(keyboard.nextLine());
			System.out.println("Please enter the number of tickets sold at this theater:");
			m.setSoldTickets(keyboard.nextInt());
			System.out.println(m);
			keyboard.nextLine();
			
			System.out.println("Would you like to enter another? ( y=yes or n=no");
			userInput = keyboard.nextLine();
			answer =userInput.charAt(0);
		}
		//display goodbye
		System.out.println("\nGoodbye");
		//close keyboard scanner
		keyboard.close();
	}
	
}
