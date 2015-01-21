import java.util.Scanner;
public class RockPaperScissorsLizardSpock {

	public static void main(String[] args) {
		String choice;
		Scanner keyboard=new Scanner(System.in);
		System.out.println("Would you like to play Rock Paper Scissors Lizard Spock? (y/n)");
		choice=keyboard.next();
		choice=choice.substring(0,1);
		int computerScore=0;
		int playerScore=0;
		int move=0;
		String wordMove="";
		String computersMove="";
		if(choice.equalsIgnoreCase("n"))
		{
			System.out.println("Goodbye!");
			System.exit(0);
		}
		else if(!(choice.equalsIgnoreCase("y")||choice.equalsIgnoreCase("\n")))
		{
			System.out.println("The input you entered is invalid.");
			System.out.println("Would you like to play Rock Paper Scissors Lizard Spock? (y/n)");
			choice=keyboard.next();
			choice=choice.substring(0,1);
			if(!(choice.equalsIgnoreCase("y")||choice.equalsIgnoreCase("\n")))
			{
				System.out.println("You have entered too many invalid inputs.");
				System.out.println("Goodbye!");
				System.exit(0);
			}
		}
		if(choice.equalsIgnoreCase("y"))
		{
			System.out.println("Round 1");
			System.out.print("Which gesture would you like to choose . . .\n"+
					   "1) rock \n"+
					   "2) paper \n"+
					   "3) scissors \n"+
					   "4) lizard \n"+
					   "5) spock \n"+
					  "Please enter your choice(1-5): ");
			move=keyboard.nextInt();
			computersMove=RockPaperScissorsLizardSpockComputerPlayer.getChoice();
			System.out.println("The computer player chooses " +computersMove);
			switch(move)
			{
			case 1:
				wordMove="rock";
				break;
			case 2:
				wordMove="paper";
				break;
			case 3:
				wordMove="scissors";
				break;
			case 4:
				wordMove="lizard";
				break;
			case 5:
				wordMove="spock";
				break;
			}
			if(move==1 && (computersMove=="scissors"||computersMove=="lizard"))
			{
				if(computersMove=="scissors")
				{
					System.out.println("Rock crushes scissors.");
				}
				else
				{
					System.out.println("Rock crushes lizard.");
				}
				playerScore++;
				System.out.println("Congratulations! You win a point.");
				System.out.println("\n");
			}
			else if(move==4 && (computersMove=="spock"||computersMove=="paper"))
			{
				if(computersMove=="spock")
				{
					System.out.println("Lizard poisons spock.");
				}
				else
				{
					System.out.println("Lizard eats paper");
				}
				playerScore++;
				System.out.println("Congratulations! You win a point.");
				System.out.println("\n");
			}
			else if(move==5 && (computersMove=="scissors"||computersMove=="rock"))
			{
				if(computersMove=="scissors")
				{
					System.out.println("Spock smashes scissors");
				}
				else
				{
					System.out.println("Spock vaporizes rock");
				}
				playerScore++;
				System.out.println("Congratulations! You win a point.");
				System.out.println("\n");
			}
			else if(move==3 && (computersMove=="lizard"||computersMove=="paper"))
			{
				if(computersMove=="lizard")
				{
					System.out.println("Scissors decapitates lizard.");
				}
				else
				{
					System.out.println("Scissors cuts paper.");
				}
				playerScore++;
				System.out.println("Congratulations! You win a point.");
				System.out.println("\n");
			}
			else if(move==2 && (computersMove=="rock"||computersMove=="spock"))
			{
				if(computersMove=="rock")
				{
					System.out.println("Paper covers rock.");
				}
				else
				{
					System.out.println("Paper disproves spock.");
				}
				playerScore++;
				System.out.println("Congratulations! You win a point.");
				System.out.println("\n");
			}
			
			
			
			
			
			else if(move==1 && (computersMove=="paper"||computersMove=="spock"))
			{
				if(computersMove=="paper")
				{
					System.out.println("Paper covers rock.");
				}
				else
				{
					System.out.println("Spock vaporizes rock.");
				}
				computerScore++;
				System.out.println("The computer player wins a point.");
				System.out.println("\n");
			}
			else if(move==4 && (computersMove=="rock"||computersMove=="scissors"))
			{
				if(computersMove=="rock")
				{
					System.out.println("Rock crushes lizard");
				}
				else
				{
					System.out.println("Scissors decapitates lizard");
				}
				computerScore++;
				System.out.println("The computer player wins a point.");
				System.out.println("\n");
			}
			else if(move==5 && (computersMove=="lizard"||computersMove=="paper"))
			{
				if(computersMove=="lizard")
				{
					System.out.println("Lizard poisons spock.");
				}
				else
				{
					System.out.println("Paper disproves spock.");
				}
				computerScore++;
				System.out.println("The computer player wins a point.");
				System.out.println("\n");
			}
			else if(move==3 && (computersMove=="spock"||computersMove=="rock"))
			{
				if(computersMove=="spock")
				{
					System.out.println("Spock smashes scissors.");
				}
				else
				{
					System.out.println("Rock crushes scissors.");
				}
				computerScore++;
				System.out.println("The computer player wins a point.");
				System.out.println("\n");
			}
			else if(move==2 && (computersMove=="scissors"||computersMove=="lizard"))
			{
				if(computersMove=="scissors")
				{
					System.out.println("Scissors cuts paper.");
				}
				else
				{
					System.out.println("Lizard eats paper.");
				}
				computerScore++;
				System.out.println("The computer player wins a point.");
				System.out.println("\n");
			}
			
			
			
			else if(wordMove.equalsIgnoreCase(computersMove))
			{
				System.out.println("The computer player chooses "+computersMove);
				System.out.println("Your tied with the computer.");
				System.out.println("No points awarded.");
				System.out.println("\n");
			}
				
				
				
			System.out.println("Round 2");
			System.out.print("Which gesture would you like to choose . . .\n"+
					   "1) rock \n"+
					   "2) paper \n"+
					   "3) scissors \n"+
					   "4) lizard \n"+
					   "5) spock \n"+
					  "Please enter your choice(1-5): ");
			move=keyboard.nextInt();
			computersMove=RockPaperScissorsLizardSpockComputerPlayer.getChoice();
			System.out.println("The computer player chooses " +computersMove);
			if(move==1 && (computersMove=="scissors"||computersMove=="lizard"))
			{
				if(computersMove=="scissors")
				{
					System.out.println("Rock crushes scissors.");
				}
				else
				{
					System.out.println("Rock crushes lizard.");
				}
				playerScore++;
				System.out.println("Congratulations! You win a point.");
				System.out.println("\n");
			}
			else if(move==4 && (computersMove=="spock"||computersMove=="paper"))
			{
				if(computersMove=="spock")
				{
					System.out.println("Lizard poisons spock.");
				}
				else
				{
					System.out.println("Lizard eats paper");
				}
				playerScore++;
				System.out.println("Congratulations! You win a point.");
				System.out.println("\n");
			}
			else if(move==5 && (computersMove=="scissors"||computersMove=="rock"))
			{
				if(computersMove=="scissors")
				{
					System.out.println("Spock smashes scissors");
				}
				else
				{
					System.out.println("Spock vaporizes rock");
				}
				playerScore++;
				System.out.println("Congratulations! You win a point.");
				System.out.println("\n");
			}
			else if(move==3 && (computersMove=="lizard"||computersMove=="paper"))
			{
				if(computersMove=="lizard")
				{
					System.out.println("Scissors decapitates lizard.");
				}
				else
				{
					System.out.println("Scissors cuts paper.");
				}
				playerScore++;
				System.out.println("Congratulations! You win a point.");
				System.out.println("\n");
			}
			else if(move==2 && (computersMove=="rock"||computersMove=="spock"))
			{
				if(computersMove=="rock")
				{
					System.out.println("Paper covers rock.");
				}
				else
				{
					System.out.println("Paper disproves spock.");
				}
				playerScore++;
				System.out.println("Congratulations! You win a point.");
				System.out.println("\n");
			}
			
			
			
			
			
			else if(move==1 && (computersMove=="paper"||computersMove=="spock"))
			{
				if(computersMove=="paper")
				{
					System.out.println("Paper covers rock.");
				}
				else
				{
					System.out.println("Spock vaporizes rock.");
				}
				computerScore++;
				System.out.println("The computer player wins a point.");
				System.out.println("\n");
			}
			else if(move==4 && (computersMove=="rock"||computersMove=="scissors"))
			{
				if(computersMove=="rock")
				{
					System.out.println("Rock crushes lizard");
				}
				else
				{
					System.out.println("Scissors decapitates lizard");
				}
				computerScore++;
				System.out.println("The computer player wins a point.");
				System.out.println("\n");
			}
			else if(move==5 && (computersMove=="lizard"||computersMove=="paper"))
			{
				if(computersMove=="lizard")
				{
					System.out.println("Lizard poisons spock.");
				}
				else
				{
					System.out.println("Paper disproves spock.");
				}
				computerScore++;
				System.out.println("The computer player wins a point.");
				System.out.println("\n");
			}
			else if(move==3 && (computersMove=="spock"||computersMove=="rock"))
			{
				if(computersMove=="spock")
				{
					System.out.println("Spock smashes scissors.");
				}
				else
				{
					System.out.println("Rock crushes scissors.");
				}
				computerScore++;
				System.out.println("The computer player wins a point.");
				System.out.println("\n");
			}
			else if(move==2 && (computersMove=="scissors"||computersMove=="lizard"))
			{
				if(computersMove=="scissors")
				{
					System.out.println("Scissors cuts paper.");
				}
				else
				{
					System.out.println("Lizard eats paper.");
				}
				computerScore++;
				System.out.println("The computer player wins a point.");
				System.out.println("\n");
			}

			
			
			else if(wordMove.equalsIgnoreCase(computersMove))
			{
				System.out.println("The computer player chooses "+computersMove);
				System.out.println("Your tied with the computer.");
				System.out.println("No points awarded.");
				System.out.println("\n");
			}
				
				
				
			System.out.println("Round 3");
			System.out.print("Which gesture would you like to choose . . .\n"+
					   "1) rock \n"+
					   "2) paper \n"+
					   "3) scissors \n"+
					   "4) lizard \n"+
					   "5) spock \n"+
					  "Please enter your choice(1-5): ");
			move=keyboard.nextInt();
			computersMove=RockPaperScissorsLizardSpockComputerPlayer.getChoice();
			System.out.println("The computer player chooses " +computersMove);
			if(move==1 && (computersMove=="scissors"||computersMove=="lizard"))
			{
				if(computersMove=="scissors")
				{
					System.out.println("Rock crushes scissors.");
				}
				else
				{
					System.out.println("Rock crushes lizard.");
				}
				playerScore++;
				System.out.println("Congratulations! You win a point.");
				System.out.println("\n");
			}
			else if(move==4 && (computersMove=="spock"||computersMove=="paper"))
			{
				if(computersMove=="spock")
				{
					System.out.println("Lizard poisons spock.");
				}
				else
				{
					System.out.println("Lizard eats paper");
				}
				playerScore++;
				System.out.println("Congratulations! You win a point.");
				System.out.println("\n");
			}
			else if(move==5 && (computersMove=="scissors"||computersMove=="rock"))
			{
				if(computersMove=="scissors")
				{
					System.out.println("Spock smashes scissors");
				}
				else
				{
					System.out.println("Spock vaporizes rock");
				}
				playerScore++;
				System.out.println("Congratulations! You win a point.");
				System.out.println("\n");
			}
			else if(move==3 && (computersMove=="lizard"||computersMove=="paper"))
			{
				if(computersMove=="lizard")
				{
					System.out.println("Scissors decapitates lizard.");
				}
				else
				{
					System.out.println("Scissors cuts paper.");
				}
				playerScore++;
				System.out.println("Congratulations! You win a point.");
				System.out.println("\n");
			}
			else if(move==2 && (computersMove=="rock"||computersMove=="spock"))
			{
				if(computersMove=="rock")
				{
					System.out.println("Paper covers rock.");
				}
				else
				{
					System.out.println("Paper disproves spock.");
				}
				playerScore++;
				System.out.println("Congratulations! You win a point.");
				System.out.println("\n");
			}
			else if(wordMove.equalsIgnoreCase(computersMove))
			{
				System.out.println("The computer player chooses "+computersMove);
				System.out.println("Your tied with the computer.");
				System.out.println("No points awarded.");
				System.out.println("\n");
			}
			
			
			
			
			else if(move==1 && (computersMove=="paper"||computersMove=="spock"))
			{
				if(computersMove=="paper")
				{
					System.out.println("Paper covers rock.");
				}
				else
				{
					System.out.println("Spock vaporizes rock.");
				}
				computerScore++;
				System.out.println("The computer player wins a point.");
				System.out.println("\n");
			}
			else if(move==4 && (computersMove=="rock"||computersMove=="scissors"))
			{
				if(computersMove=="rock")
				{
					System.out.println("Rock crushes lizard");
				}
				else
				{
					System.out.println("Scissors decapitates lizard");
				}
				computerScore++;
				System.out.println("The computer player wins a point.");
				System.out.println("\n");
			}
			else if(move==5 && (computersMove=="lizard"||computersMove=="paper"))
			{
				if(computersMove=="lizard")
				{
					System.out.println("Lizard poisons spock.");
				}
				else
				{
					System.out.println("Paper disproves spock.");
				}
				computerScore++;
				System.out.println("The computer player wins a point.");
				System.out.println("\n");
			}
			else if(move==3 && (computersMove=="spock"||computersMove=="rock"))
			{
				if(computersMove=="spock")
				{
					System.out.println("Spock smashes scissors.");
				}
				else
				{
					System.out.println("Rock crushes scissors.");
				}
				computerScore++;
				System.out.println("The computer player wins a point.");
				System.out.println("\n");
			}
			else if(move==2 && (computersMove=="scissors"||computersMove=="lizard"))
			{
				if(computersMove=="scissors")
				{
					System.out.println("Scissors cuts paper.");
				}
				else
				{
					System.out.println("Lizard eats paper.");
				}
				computerScore++;
				System.out.println("The computer player wins a point.");
				System.out.println("\n");
			}

			
			
			else if(wordMove.equalsIgnoreCase(computersMove))
			{
				System.out.println("The computer player chooses "+computersMove);
				System.out.println("Your tied with the computer.");
				System.out.println("No points awarded.");
				System.out.println("\n");
			}
				
			
			System.out.println("Game Over");
			System.out.println("Your final score is "+playerScore);
			System.out.println("The computer player's final score is " +computerScore);
			if(computerScore<playerScore)
			{
				System.out.println("Congratulations! You won against the computer player.");
			}
			else if(computerScore==playerScore)
			{
				System.out.println("You tied with the computer player");
			}
			else if(computerScore>playerScore)
			{
				System.out.println("You lost against the computer player.");
			}
		}
	}
}
