/* 
* Goomba.java 
* Author: [Doug Hadaway] 
* Submission Date:  
* 
* Purpose: Allows the user to play a game similar to hangman called Goomba. 
* 
* Statement of Academic Honesty: 
* 
* The following code represents my own work. I have neither  
 
CSCI 1301: Introduction to Computing and Programming Summer 2014 
Project 3: Goomba (A Word Guessing Game) 
Page	9	of	9	
	
* received nor given inappropriate assistance. I have not copied 
* or modified code from any source other than the course webpage 
* or the course textbook. I recognize that any unauthorized 
* assistance or plagiarism will be handled in accordance with 
* the University of Georgia's Academic Honesty Policy and the 
* policies of this course. I recognize that my work is based 
* on an assignment created by the Department of Computer 
* Science at the University of Georgia. Any publishing 
* or posting of source code for this project is strictly 
* prohibited unless you have written consent from the Department 
* of Computer Science at the University of Georgia. 
*/

import java.util.Scanner;
public class Goomba {

	public static final boolean testingMode= true;
	public static void main(String[] args) {
		Scanner keyboard=new Scanner(System.in);
		String difficulty="";
		int numGuesses=0;
		int numSpaces=0;
		String letterGuess;
		String spaceGuesses="";
		
		for(int numGames=0;numGames<25;numGames++)
		{
			String secretWord= RandomWord.newWord();
			String displayWord="";
			//this while statement because only want to keep looping if they input incorrect answer
			do
			{
				System.out.println("Enter your difficulty: Easy (e), Intermediate (i), or Hard (h)");
				difficulty=keyboard.next();
				difficulty=difficulty.substring(0,1);
				if(difficulty.equalsIgnoreCase("e"))
				{
					numGuesses=15;
					numSpaces=7;
					if(testingMode==true)
					{
						System.out.println("The Secret word is: "+secretWord);
					}
				}
				else if(difficulty.equalsIgnoreCase("i"))
				{
					numGuesses=12;
					numSpaces=5;
					if(testingMode==true)
					{
						System.out.println("The Secret word is: "+secretWord);
					}
				}
				else if(difficulty.equalsIgnoreCase("h"))
				{
					numGuesses=10;
					numSpaces=3;
					if(testingMode==true)
					{
						System.out.println("The Secret word is: "+secretWord);
					}
				}
				else
				{
					System.out.println("Invalid difficulty. Try Again...");
				}
			}while(!difficulty.equalsIgnoreCase(("e"))&&!difficulty.equalsIgnoreCase(("i"))&&!difficulty.equalsIgnoreCase(("h")));
			//putting the dashes in the word
			for(int i=0;i<secretWord.length();i++)
			{
				displayWord+="-";
			}
			System.out.println("The word is: " +displayWord);
			//actually playing game 
			//VV keep going while still have guesses and displayWord 
			//doesn't equal secret word.
			while(numGuesses>0&&!displayWord.equalsIgnoreCase(secretWord))
			{
				System.out.println("Please enter a letter you want to guess: ");
				letterGuess=keyboard.next().substring(0,1);
				System.out.println("Please enter the spaces you want to check (separated by spaces):");
				String decoy=keyboard.nextLine();
				spaceGuesses=keyboard.nextLine();
				Scanner scanGuesses=new Scanner(spaceGuesses);
				String oldWord=displayWord;
				//^^store the space guesses in a new scanner
				//VV then use .hasNextInt to catch the next # in spaceGuesses
				//dealing with the space choices
				//do i need keyboard. or scanGuesses.?
				while(scanGuesses.hasNextInt())
				{
					int index=scanGuesses.nextInt();
					//dealing with if guess is a match or not
					if(secretWord.substring((index-1),index).equalsIgnoreCase(letterGuess))
					{
						if(index==1)
						{
							displayWord=letterGuess+displayWord.substring(index);
						}
						else if(index==secretWord.length())
						{
							displayWord=displayWord.substring(0,index-1)+letterGuess;
						}
						else
						{
						displayWord=displayWord.substring(0,index-1)+letterGuess+displayWord.substring(index);
						}
					}
					//deal with invalid input
					//if length of spaceGuesses string is less that numSpaces provided VV
					
				}
				if(!oldWord.equalsIgnoreCase(displayWord))
				{
					System.out.println("Your guess is in the word!");
				}
				else if(spaceGuesses.length()<numSpaces)
				{
					System.out.println("Your input is not valid. Try Again.");
				}
				else if(oldWord.equalsIgnoreCase(displayWord))
				{
					System.out.println("Your letter was not found in the spaces provided.");
					numGuesses--;
				}
				else
				{
					System.out.println("Your input is not valid. Try Again.");
				}
				System.out.println("The updated word is: " +displayWord);
				System.out.println("Guesses Remaining: "+numGuesses);
			}
			if(numGuesses==0)
			{
				System.out.println("You have failed to guess the word... :(");
			}
			else
			{
				System.out.println("You have guessed the word! Congratulations");
			}
			System.out.println("Would you like to play again? Yes(y) No(n)");
			String answer=keyboard.next();
			if(answer.substring(0,1).equalsIgnoreCase("y"))
			{
				
			}
			else
			{
				System.exit(0);
			}
		}
		
	}

}
