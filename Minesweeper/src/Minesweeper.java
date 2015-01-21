import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class represents a Minesweeper game.
 *
 * @author Doug Hadaway <bhad1@uga.edu>
 */
public class Minesweeper {
	Scanner keyboard=new Scanner(System.in);
	public static int rows;
	public static int cols;
	public int numOfRows=0;
	public int numOfCols=0;
    private int roundsComplete=0;
    /**
     * Constructs an object instance of the {@link Minesweeper} class using the
     * information provided in <code>seedFile</code>. Documentation about the 
     * format of seed files can be found in the project's <code>README.md</code>
     * file.
     *
     * @param seedFile the seed file used to construct the game
     * @see            <a href="https://github.com/mepcotterell-cs1302/cs1302-minesweeper-alpha/blob/master/README.md#seed-files">README.md#seed-files</a>
     */
	// is this how to read from seedfile?
	//still need to make row and cols here go equal the global variable?
    public Minesweeper(File seedFile) {
    	Scanner seedfile = null;
		try {
			seedfile = new Scanner(seedFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	numOfRows= seedfile.nextInt();
    	numOfCols= seedfile.nextInt();
    	int seedMines=seedfile.nextInt();
    	boolean[][] seedMineArray = new boolean[numOfRows][numOfCols];
    	while(seedfile.hasNextInt())
    	{
    		seedMineArray[seedfile.nextInt()][seedfile.nextInt()]=true;
    	}
    } // Minesweeper


    /**
     * Constructs an object instance of the {@link Minesweeper} class using the
     * <code>rows</code> and <code>cols</code> values as the game grid's number
     * of rows and columns respectively. Additionally, One quarter (rounded up) 
     * of the squares in the grid will will be assigned mines, randomly.
     *
     * @param rows the number of rows in the game grid
     * @param cols the number of cols in the game grid
     */
    public Minesweeper(int rows, int cols) {
    	
    	numOfRows=rows;
    	numOfCols=cols;
    	
    }
    	
    
    
    // TODO implement 
    // Minesweeper
    

    /**
     * Starts the game and execute the game loop.
     */
    public void run() {
    System.out.println("  /\\/\\ (_)_ __   ___  _____      _____  ___ _ __   ___ _ __");
    System.out.println(" /    \\| | '_ \\ / _ \\/ __\\ \\ /\\ / / _ \\/ _ \\ '_ \\ / _ \\ '__|");
    System.out.println("/ /\\/\\ \\ | | | |  __/\\__ \\\\ V  V /  __/  __/ |_) |  __/ |    ");
    System.out.println("\\/    \\/_|_| |_|\\___||___/ \\_/\\_/ \\___|\\___| .__/ \\___|_|     ");
    System.out.println("                                     ALPHA |_| EDITION        ");
    System.out.println(numOfRows);
    System.out.println(numOfCols);
	for(int i=0;i<numOfRows;i++)
	{
		System.out.print(i+ "");
		for(int n=0;n<numOfCols;n++)
		{
			System.out.print("|    ");
			if(n==numOfCols-1)
			{
				System.out.println("|    ");
			}
		}
	}
	for(int i=0;i<numOfRows;i++)
	{
		if(i==numOfRows-1)
		{
			System.out.println("    "+i);
		}
		else
		System.out.print("    "+i);
	}
	boolean[][] grid=new boolean[numOfRows+1][numOfCols+1];
	int[][] printArray=new int[numOfRows][numOfCols];
	Random ranMineRow=new Random();
	Random ranMineCol=new Random();
	int mines=(int)(numOfRows*numOfCols*0.1);
	int extraMine=mines%1;
	if(extraMine>0)
	{
		mines=mines+1-extraMine;
	}
	
	for(int i=mines;i>0;i--)
	{
		
		grid[ranMineRow.nextInt(numOfRows)][ranMineCol.nextInt(numOfCols)]=true;
	}
	System.out.println("Mines: "+mines);
	// reveal update 
	for(int round=0;round<1000;round++)
	{
		int score = (rows * cols) - mines - round;
		String command=keyboard.next();
		System.out.println("Round: "+round);
    	if(command.equalsIgnoreCase("Mark")||command.equalsIgnoreCase("m"))
    	{
    		int row=keyboard.nextInt();
    		int col=keyboard.nextInt();
    		if(numOfRows>20||numOfCols>20)
    		{
    			System.out.println("ಠ_ಠ says, Cannot create a mine field with that many rows and/or columns!");
    			break;
    		}
    		if(row<0||row>numOfRows||col<0||col>numOfCols)
    		{
    			System.out.println("ಠ_ಠ says, Command not recognized!");
    			break;
    		}
    		for(int i=0;i<numOfRows;i++)
    		{
    			System.out.print(i+ "");
    			for(int n=0;n<numOfCols;n++)
    			{
    				if(row==i&&col==n)
    				{
    					System.out.print("| F  ");
    				}
    				else
    				{
    					System.out.print("|    ");
    				}
    				if(n==numOfCols-1)
    				{
    					System.out.println("|    ");
    				}
    			}
    		}
    		for(int i=0;i<numOfRows;i++)
    		{
    			if(i==numOfRows-1)
    			{
    				System.out.println("    "+i);
    			}
    			else
    			System.out.print("    "+i);
    		}
    	}
    	else if(command.equalsIgnoreCase("Reveal")||command.equalsIgnoreCase("r"))
    	{
    		int row=keyboard.nextInt();
    		int col=keyboard.nextInt();
    		int nearMinesCount=0;
    		if(numOfRows>20||numOfCols>20)
    		{
    			System.out.println("ಠ_ಠ says, Cannot create a mine field with that many rows and/or columns!");
    			break;
    		}
    		if(row<0||row>numOfRows||col<0||col>numOfCols)
    		{
    			System.out.println("ಠ_ಠ says, Command not recognized!");
    			break;
    		}
    		if(!(row==numOfRows)||!(row==numOfRows+1))
    		{
	    		if(grid[row+1][col]==true)
	    		{
	    			nearMinesCount++;
	    		}
    		}
    		if(!(row==0))
    		{
	    		if(grid[row-1][col]==true)
	    		{
	    			nearMinesCount++;
	    		}
    		}
    		if(!(col==numOfCols))
    		{
	    		if(grid[row][col+1]==true)
	    		{
	    			nearMinesCount++;
	    		}
    		}
    		if(!(col==0))
    		{
	    		if(grid[row][col-1]==true)
	    		{
	    			nearMinesCount++;
	    		}
    		}
    		if(!(row==0||col==0))
    		{
	    		if(grid[row-1][col-1]==true)
	    		{
	    			nearMinesCount++;
	    		}
    		}
    		if(!(row==numOfRows||col==numOfCols))
	    		if(grid[row+1][col+1]==true)
	    		{
	    			nearMinesCount++;
	    		}
    		if(!(row==numOfRows||col==0))
    		{
	    		if(grid[row+1][col-1]==true)
	    		{
	    			nearMinesCount++;
	    		}
    		}
    		if(!(row==0||col==numOfCols))
    		{
	    		if(grid[row-1][col+1]==true)
	    		{
	    			nearMinesCount++;
	    		}
    		}
    		if(grid[row][col]==true)
    		{
    			System.out.println("Oh no... You revealed a mine!");
    			System.out.println("  __ _  __ _ _ __ ___   ___    _____   _____ _ __ ");
    			System.out.println(" / _` |/ _` | '_ ` _ \\ / _ \\  / _ \\ \\ / / _ \\ '__|");
    			System.out.println("| (_| | (_| | | | | | |  __/ | (_) \\ V /  __/ |   ");
    			System.out.println(" \\__, |\\__,_|_| |_| |_|\\___|  \\___/ \\_/ \\___|_|   ");
    			System.out.println(" |___/                                            ");
    			System.exit(0);
    		}
    		for(int i=0;i<numOfRows;i++)
    		{
    			System.out.print(i+ "");
    			for(int n=0;n<numOfCols;n++)
    			{
    				if(row==i&&col==n)
    				{
    					System.out.print("| "+nearMinesCount+"  ");
    				}
    				else
    				{
    					System.out.print("|    ");
    				}
    				if(n==numOfCols-1)
    				{
    					System.out.println("|    ");
    				}
    			}
    		}
    		for(int i=0;i<numOfRows;i++)
    		{
    			if(i==numOfRows-1)
    			{
    				System.out.println("    "+i);
    			}
    			else
    			System.out.print("    "+i);
    		}
    	}
    	else if(command.equalsIgnoreCase("Guess")||command.equalsIgnoreCase("g"))
    	{
    		int row=keyboard.nextInt();
    		int col=keyboard.nextInt();
    		if(numOfRows>20||numOfCols>20)
    		{
    			System.out.println("ಠ_ಠ says, Cannot create a mine field with that many rows and/or columns!");
    			break;
    		}
    		if(row<0||row>numOfRows||col<0||col>numOfCols)
    		{
    			System.out.println("ಠ_ಠ says, Command not recognized!");
    			break;
    		}
    		for(int i=0;i<numOfRows;i++)
    		{
    			System.out.print(i+ "");
    			for(int n=0;n<numOfCols;n++)
    			{
    				if(row==i&&col==n)
    				{
    					System.out.print("| ?  ");
    				}
    				else
    				{
    					System.out.print("|    ");
    				}
    				if(n==numOfCols-1)
    				{
    					System.out.println("|    ");
    				}
    			}
    		}
    		for(int i=0;i<numOfRows;i++)
    		{
    			if(i==numOfRows-1)
    			{
    				System.out.println("    "+i);
    			}
    			else
    			System.out.print("    "+i);
    		}
    	}
    	else if(command.equalsIgnoreCase("Help")||command.equalsIgnoreCase("h"))
    	{
    		System.out.println("Commands available...");
    		System.out.println("Reveal: r/reveal row col");
    		System.out.println("Mark: m/mark   row col");
    		System.out.println("Guess: g/guess  row col");
    		System.out.println("Help: h/help");
    		System.out.println("Quit: q/quit");
    	}
    	else if(command.equalsIgnoreCase("Quit")||command.equalsIgnoreCase("q"))
    	{
    		System.out.println("ლ(ಠ_ಠლ)");
    		System.out.println("Y U NO PLAY MORE?");
    		System.out.println("Bye!");
    		System.exit(0);
    	}
    	else
    	{
    		System.out.println("ಠ_ಠ says, Command not recognized!");
    	}
    	if(round>30)
    	{
    		System.out.println("░░░░░░░░░▄░░░░░░░░░░░░░░▄░░░░ \"So Doge\" ");
    		System.out.println("░░░░░░░░▌▒█░░░░░░░░░░░▄▀▒▌░░░");
    		System.out.println("░░░░░░░░▌▒▒█░░░░░░░░▄▀▒▒▒▐░░░ \"Such Score\"");
    		System.out.println("░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐░░░ ");
    		System.out.println("░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐░░░ \"Much Minesweeping\"");
    		System.out.println("░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌░░░");
    		System.out.println("░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒▌░░ \"Wow\"");
    		System.out.println("░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐░░");
    		System.out.println("░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄▌░");
    		System.out.println("░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▌░");
    		System.out.println("▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒▐░");
    		System.out.println("▐▒▒▐▀▐▀▒░▄▄▒▄▒▒▒▒▒▒░▒░▒░▒▒▒▒▌");
    		System.out.println("▐▒▒▒▀▀▄▄▒▒▒▄▒▒▒▒▒▒▒▒░▒░▒░▒▒▐░");
    		System.out.println("░▌▒▒▒▒▒▒▀▀▀▒▒▒▒▒▒░▒░▒░▒░▒▒▒▌░");
    		System.out.println("░▐▒▒▒▒▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▒▄▒▒▐░░");
    		System.out.println("░░▀▄▒▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▄▒▒▒▒▌░░");
    		System.out.println("░░░░▀▄▒▒▒▒▒▒▒▒▒▒▄▄▄▀▒▒▒▒▄▀░░░ CONGRATULATIONS!");
    		System.out.println("░░░░░░▀▄▄▄▄▄▄▀▀▀▒▒▒▒▒▄▄▀░░░░░ YOU HAVE WON!");
    		System.out.println("░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▀▀░░░░░░░░ SCORE: "+score);
    	}
	}
    }
	
    // still need to round up the mines if they have decimal?

    /**
     * The entry point into the program. This main method does implement some
     * logic for handling command line arguments. If two integers are provided
     * as arguments, then a Minesweeper game is created and started with a 
     * grid size corresponding to the integers provided and with 10% (rounded
     * up) of the squares containing mines, placed randomly. If a single word 
     * string is provided as an argument then it is treated as a seed file and 
     * a Minesweeper game is created and started using the information contained
     * in the seed file. If none of the above applies, then a usage statement
     * is displayed and the program exits gracefully. 
     *
     * @param args the shell arguments provided to the program
     */
    public static void main(String[] args) {

	/*
	  The following switch statement has been designed in such a way that if
	  errors occur within the first two cases, the default case still gets
	  executed. This was accomplished by special placement of the break
	  statements.
	*/

	Minesweeper game = null;

	switch (args.length) {

        // random game
	case 2: 

	    int rows, cols;

	    // try to parse the arguments and create a game
	    try {
		rows = Integer.parseInt(args[0]);
		cols = Integer.parseInt(args[1]);
		game = new Minesweeper(rows, cols);
		break;
	    } catch (NumberFormatException nfe) { 
		// line intentionally left blank
	    } // try

	// seed file game
	case 1: 

	    String filename = args[0];
	    File file = new File(filename);

	    if (file.isFile()) {
		game = new Minesweeper(file);
		break;
	    } // if
    
        // display usage statement
	default:

	    
		System.out.println("Usage: java Minesweeper [FILE]");
	    System.out.println("Usage: java Minesweeper [ROWS] [COLS]");
	    System.exit(0);

	} // switch

	// if all is good, then run the game
	game.run();

    } // main

} // Minesweeper
