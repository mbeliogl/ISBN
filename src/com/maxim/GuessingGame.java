package com.maxim;

import java.util.Scanner;
import java.util.Random;


public class GuessingGame
{
    public static void main(String [] args)
    {
	// generates a random number
	Random rand = new Random();
	int num = rand.nextInt(101);
	// initiates the number of guesses count
	int numGuesses = 0;
	// Initiates the scanner to track the input of the user
	Scanner input = new Scanner(System.in);

	String userGuess;
	// initiates a boolean value to judge whether the game is continued
	boolean end = false;
	// the while loop works while the end value is equal to false. It prints out a message asking for input and judges the input while adding each guess.
	while (!end)
	    {
		System.out.println("Please input your guess from 1 to 100: (or q to quit)");
		userGuess = input.next();
		
		numGuesses ++;
		// If the input is equal to string q then the game exits and prints out the correct num
		if(userGuess.equals("q"))
		   {
		       System.out.println("The Mystery Number Was " + num);
		       
		       System.exit(0);

		   }
		// if the input is not q then it converts it to an integer value guessNum
	        int guessNum = Integer.parseInt(userGuess);
		// judges whether the user guessed number matches the secret one
	        if (guessNum == num)
		    {
			// prints out the number of guesses after a win
			System.out.println("Good Job! It took" +  " " + numGuesses + " " + "guesses" + "\t");
			// asks the user to play again
			System.out.println("Would you like to play again y/n?");
			// judges the input
			String play = input.next();
			// if the answer is yes then the program generates a new random number and resets the numGuesses
			if(play.equals("y"))
			   {
			       System.out.println();
			       Random newRand = new Random();
			       num = newRand.nextInt(101);
			       numGuesses = 0;
			   }
			// if the answer is not yes then the program prints out the correct mystery number and exits
			   else if (play.equals("n"))
			       {
				   System.out.println();
				   System.out.println("The Mystery Number Was " + num);
				   end = true;
			       }
				   
			   
		        
		    }
		// judges whether the user-guessed number is smaller or bigger
		else if (guessNum < num)
		    {
			System.out.println("Too Low!");
			
		    }

		else if (guessNum > num)
		    {
			System.out.println("Too High!");
		
		    }

	    }


    }
}
