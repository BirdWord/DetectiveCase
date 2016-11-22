package DavidAndKristy;

import java.util.Scanner;

import caveExplorer.CaveExplorer;

public class EventDavidAndKristy implements caveExplorer.Event{
	public static String[][] DavidDotsBoxesgrid;
	public static int row,col;
	
	public void play(){ // mini game loop
		System.out.println("\n\nYou've reached the kitchen.\n------------Welcome to Dots and Boxes!-----------");
		System.out.println("If you lose to the AI, you're life will end here.");
		System.out.println("If you win, I'll let you out of this room \nand give you a hint. Good Luck! \n");
		
		System.out.println("How big do you want the grid to be?");

		// get row number and do error checking.
		System.out.println("How many rows? (between 3 and 9)");
		row = DavidDotsBoxes.getIntegerInput();
		while(row < 3 || row > 9){
			System.out.println("The row needs to be between 3 and 9.\nPick a new row number.");
			row = CaveExplorer.in.nextInt();
		}

		// get column number and do error checking.
		System.out.println("How many columns? (between 3 and 9)");
		col = DavidDotsBoxes.getIntegerInput();
		while(col < 3 || col > 9){
			System.out.println("The row needs to be between 3 and 9.\nPick a new row number.");
			col = CaveExplorer.in.nextInt();
		}

		// set the max score the players can get( row * col).
		DavidDotsBoxes.setMaxScore(row,col);
		// create the DavidDotsBoxesgrid, by setting the rows and cols their correct values.
		setGrid(row,col); // setter.
		// print the DavidDotsBoxesgrid
		printGrid(); // printer.
		
		System.out.println("\nYou go first.");
		
		while(!DavidDotsBoxes.isGameOver()){
			System.out.println("\n--------SCORE [Player: " + DavidDotsBoxes.getPScore() + ",AI: " + DavidDotsBoxes.getCScore() + "]----------");
			// while game is not over, keep taking turns!

			if(DavidDotsBoxes.isPlayerTurn()){ // check if its the players turn
				// if inside -> its the players turn
				DavidDotsBoxes.getLnInput(); // get the players coordinates and form the line
				if(DavidDotsBoxes.getCheat()){
					DavidDotsBoxes.score[0] = DavidDotsBoxes.maxScore; // automatic winner.
					break; // for cheat code.
				}
			}
			else{
				// if inside -> its the computer's turn
				KristyAI.computerTurn(); // computer takes turn
				DavidDotsBoxes.score[1] = KristyAI.computerBox; // update score.
				DavidDotsBoxes.turn = 0; // go back to players turn.
				/*
				* The AI will ensure that the coordinates are valid and correct.
				* */


			}
		}
		System.out.println("----------Final score: [Player: " + DavidDotsBoxes.getPScore() + ",AI: " + DavidDotsBoxes.getCScore() + "]-----------");
		// after loop -> game has ended.
		// check who won.
		if(DavidDotsBoxes.getCScore() > DavidDotsBoxes.getPScore()){
			// if inside -> computer won
			System.out.println("You have lost, you loser!...");
			CaveExplorer.alive = false;
		}
		else{
			System.out.println("Wooow... youre actually pretty good..\n<THE HINT>");
			CaveExplorer.lockedDoors[1].setLocked(false);
			CaveExplorer.lockedDoors[1].setOpen(true);
			CaveExplorer.inventory.setKitchenKey(false);
		}
		
	}
	
	public static void setGrid(int row, int col){
		// to connect two points, we'll use 'o--' instead of 'o', IF horizontal.
		DavidDotsBoxes.grid = new String[(2 * (row + 1)) - 1][col + 1];
		String token; // string that will be given to column.
		for(int y = 0; y < DavidDotsBoxes.grid.length; ++y){ // traverse through the rows.
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
			for(int x = 0; x < DavidDotsBoxes.grid[y].length; ++x){ // traverse through the column.
				DavidDotsBoxes.grid[y][x] = token; // set the value to the token based on the type of row.
			}
		}
	}
	public static void printGrid(){
		// procedure to print the DavidDotsBoxesgrid array.
		for(int y = 0; y < DavidDotsBoxes.grid.length; ++y){
			for(int x = 0; x < DavidDotsBoxes.grid[y].length; ++x){
				System.out.print(DavidDotsBoxes.grid[y][x]);
			}
			System.out.println(""); // every row needs a new line.
		}
	}
}
