package DavidAndKristy;

import java.util.Scanner;

public class EventDavidAndKristy {
	public static Scanner in = new Scanner(System.in);
	public static String[][] grid;
	public static int[] point1 = {0,0};
	public static int[] point2 = {0,0};
	public static int playerBoxes;
	public static int computerBoxes;
	
	public static void main(String args[]){
		int row,col;
		System.out.println("You've reached the kitchen. Welcome to Dots and Boxes!");
		System.out.println("If you lose to the AI, you're life will end here.");
		System.out.println("If you win, I'll let you out of this room \nand give you a hint. Good Luck! \n");
		
		System.out.println("How big do you want the grid to be?");

		// get row number and do error checking.
		System.out.println("How many rows? (between 3 and 9)");
		row = in.nextInt();
		while(row < 3 || row > 9){
			System.out.println("The row needs to be between 3 and 9.\nPick a new row number.");
			row = in.nextInt();
		}

		// get column number and do error checking.
		System.out.println("How many columns? (between 3 and 9)");
		col = in.nextInt();
		while(col < 3 || col > 9){
			System.out.println("The row needs to be between 3 and 9.\nPick a new row number.");
			col = in.nextInt();
		}

		// set the max score the players can get( row * col).
		DavidDotsBoxes.setMaxScore(row,col);
		// create the grid, by setting the rows and cols their correct values.
		setGrid(row,col); // setter.
		// print the grid
		printGrid(); // printer.
		
		System.out.println("You go first.");
		
		playerBoxes = 0;
		computerBoxes = 0;
		
		boolean gameStart = true;
		boolean playerTurn = true; 
		
		while(DavidDotsBoxes.isGameOver()){
			// while game is not over, keep taking turns!

			if(DavidDotsBoxes.isPlayerTurn()){ // check if its the players turn
				// if inside -> its the players turn
				DavidDotsBoxes.getLnInput(); // get the players coordinates and form the line
			}
			else{
				// if inside -> its the computer's turn
				KristyAI.computerTurn(); // computer takses turn
				/*
				*  Since computer turn doesn't check
				*
				* */
			}
		}
		//need to system.print out at the end of player and computer turn the scores
		
	}
	
	public static void setGrid(int row, int col){
		// to connect two points, we'll use 'o--' instead of 'o', IF horizontal.
		grid = new String[(2 * (row + 1)) - 1][col + 1];
		String token; // string that will be given to column.
		for(int y = 0; y < grid.length; ++y){ // traverse through the rows.
			/*
			*  When creating lines, there are Vertical and Horizontal lines.
			*  Horizontal lines will be easy to make and are nothing special.
			*  But vertical lines are different, since they require a String Line of its.
			*  We will draw both lines by dividing the rows by two types.
			*
			*  The rows will be divided into two types -> even or odd.
			*  Even -> the dots will be drawn.
			*  Odd -> space will be allocated for future VERTICAL lines.
			*
			*  A token will be used to give the column the value needed.
			*  token -> if even: regular row with dot. if odd: special row that will be used to allocate space.
			* */
			if(y % 2 == 0) token = "o  "; // even row.
			else token = "   "; // odd row.
			for(int x = 0; x < grid[y].length; ++x){ // traverse through the column.
				grid[y][x] = token; // set the value to the token based on the type of row.
			}
		}
	}
	public static void printGrid(){
		// procedure to print the grid array.
		for(int y = 0; y < grid.length; ++y){
			for(int x = 0; x < grid[y].length; ++x){
				System.out.print(grid[y][x]);
			}
			System.out.println(""); // every row needs a new line.
		}
	}
}
