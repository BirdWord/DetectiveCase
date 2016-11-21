package DavidAndKristy;

import java.util.Scanner;

public class KristyAI {
	static int x;
	static int y;
	public static int computerBox;
	public static boolean doubleCrossed;
	public static boolean moreBoxes;

	public static void main(String[] args){ 

//		grid[0][0] = "o--";
//		grid[1][1] = "|  ";
//		grid[2][0] = "o--";
//		grid[4][2] = "o--";
//		grid[3][3] = "|  ";
//		grid[3][2] = "|  ";
//		grid[4][1] = "o--";
//		grid[5][1] = "|  ";
//		grid[5][2] = "|  ";

//		grid[1][0] = "|  ";
//		grid[0][0] = "o--";
//		grid[1][1] = "|  ";
//		grid[3][0] = "|  ";
//		grid[3][1] = "|  ";
//		grid[4][0] = "o--";


//		DavidDotsBoxes.printGrid();
//		computerTurn();
	}

	public static void computerTurn(){
		boolean inLoop = true;

		while(inLoop){
			doubleCross();
			if(doubleCrossed){
				x = (int) (Math.random() * (2*EventDavidAndKristy.row + 1));  
				y = (int) (Math.random() * (EventDavidAndKristy.col + 1));  

				if(x % 2 == 0 && !DavidDotsBoxes.grid[x][y].equals("o--") && y != EventDavidAndKristy.col){ //change the 3 to user input
					DavidDotsBoxes.grid[x][y] = "o--";
					DavidDotsBoxes.printGrid();
					inLoop = false;
				}
				else if(x % 2 == 1 && !DavidDotsBoxes.grid[x][y].equals("|  ")){
					DavidDotsBoxes.grid[x][y] = "|  ";
					DavidDotsBoxes.printGrid();
					inLoop = false;
				}
			}
			else{
				checkBoxes();
				if(!moreBoxes){
					x = (int) (Math.random() * (2*EventDavidAndKristy.row + 1));
					y = (int) (Math.random() * (EventDavidAndKristy.col + 1));
				
					if(x % 2 == 0 && !DavidDotsBoxes.grid[x][y].equals("o--") && y != EventDavidAndKristy.col){ //change the 3 to user input
						DavidDotsBoxes.grid[x][y] = "o--";
						DavidDotsBoxes.printGrid();
						inLoop = false;
					}
					else if(x % 2 == 1 && !DavidDotsBoxes.grid[x][y].equals("|  ")){
						DavidDotsBoxes.grid[x][y] = "|  ";
						DavidDotsBoxes.printGrid();
						inLoop = false;
					}
				}
			}
		}
	}

	public static void checkBoxes(){
		moreBoxes = true;
		while(moreBoxes){
			for(int row = 0; row < DavidDotsBoxes.grid.length -1; row++){ // it wont check the last row of the grid because there is no more rows under it
				for(int col = 0; col < DavidDotsBoxes.grid[0].length; col++){
					DavidDotsBoxes.addScore(DavidDotsBoxes.whoseTurn()); // computer's score is updated.
					if(DavidDotsBoxes.grid[row][col].equals("o--") && DavidDotsBoxes.grid[row + 1][col].equals("|  ") &&
							DavidDotsBoxes.grid[row + 2][col].equals("o--") && DavidDotsBoxes.grid[row + 1][col + 1].equals(" ")){
						DavidDotsBoxes.grid[row + 1][col + 1] = "|  ";
						computerBox++;
						moreBoxes = true;
					}
					else if(DavidDotsBoxes.grid[row][col].equals("o--") && DavidDotsBoxes.grid[row + 1][col].equals("|  ") &&
							DavidDotsBoxes.grid[row + 1][col + 1].equals("|  ") && DavidDotsBoxes.grid[row + 2][col].equals("o  ")){
						DavidDotsBoxes.grid[row + 2][col] = "o--";
						computerBox++;
						moreBoxes = true;
					}
					else if(DavidDotsBoxes.grid[row][col].equals("|  ") && DavidDotsBoxes.grid[row + 1][col].equals("o--") &&
							DavidDotsBoxes.grid[row][col + 1].equals("|  ") && DavidDotsBoxes.grid[row-1][col].equals("o  ")){
						DavidDotsBoxes.grid[row - 1][col] = "o--";
						computerBox++;
						moreBoxes = true;
					}
					else if(DavidDotsBoxes.grid[row][col].equals("o--") && DavidDotsBoxes.grid[row + 1][col + 1].equals("|  ") &&
							DavidDotsBoxes.grid[row + 2][col].equals("o--") && DavidDotsBoxes.grid[row + 1][col].equals("   ")){
						DavidDotsBoxes.grid[row + 1][col] = "|  ";
						computerBox++;
						moreBoxes = true;
					}
					else{
						// if it could form a box -> decrease the initial adder to the computer's score.
						--DavidDotsBoxes.score[DavidDotsBoxes.whoseTurn()];
						moreBoxes = false;
					}
				}

			}
		}
	}

	public static void doubleCross(){ //simplified version of double crossed strategy
		boolean crossOnce = false;
		for(int row = 0; row < DavidDotsBoxes.grid.length - 1; row++){
			for(int col = 0; col < DavidDotsBoxes.grid[0].length; col++){
				if(!crossOnce && row < DavidDotsBoxes.grid.length - 4 && DavidDotsBoxes.grid[row][col].equals("o  ") && 
						DavidDotsBoxes.grid[row + 1][col].equals("|  ") && DavidDotsBoxes.grid[row + 1][col + 1].equals("|  ") && 
						DavidDotsBoxes.grid[row + 3][col].equals("|  ") && DavidDotsBoxes.grid[row + 3][col + 1].equals("|  ") && 
						DavidDotsBoxes.grid[row + 4][col].equals("o--") && DavidDotsBoxes.grid[row + 2][col].equals("o  ")){
					DavidDotsBoxes.grid[row][col] = "o--";
					doubleCrossed = true;
					crossOnce = true;
				}
				else if(!crossOnce && row < DavidDotsBoxes.grid.length - 4 && DavidDotsBoxes.grid[row][col].equals("o--") && 
						DavidDotsBoxes.grid[row + 1][col].equals("|  ") && DavidDotsBoxes.grid[row + 1][col + 1].equals("|  ") && 
						DavidDotsBoxes.grid[row + 3][col].equals("|  ") && DavidDotsBoxes.grid[row + 3][col + 1].equals("|  ") && 
						DavidDotsBoxes.grid[row + 4][col].equals("o  ") && DavidDotsBoxes.grid[row + 2][col].equals("o  ")){
					DavidDotsBoxes.grid[row + 4][col] = "o--";
					doubleCrossed = true;
					crossOnce = true; 
				}
				else if(!crossOnce && row < DavidDotsBoxes.grid.length - 2 && DavidDotsBoxes.grid[row][col].equals("o--") && 
						DavidDotsBoxes.grid[row][col + 1].equals("o--") && DavidDotsBoxes.grid[row + 1][col + 1].equals("   ") && 
						DavidDotsBoxes.grid[row + 1][col + 2].equals("|  ") && DavidDotsBoxes.grid[row + 2][col].equals("o--") && 
						DavidDotsBoxes.grid[row + 2][col + 1].equals("o--") && DavidDotsBoxes.grid[row + 1][col].equals("   ")){
					DavidDotsBoxes.grid[row + 1][col] = "|   ";
					doubleCrossed = true;
					crossOnce = true;
				}
				else if(!crossOnce && row < DavidDotsBoxes.grid.length - 2 && DavidDotsBoxes.grid[row][col].equals("o--") && 
						DavidDotsBoxes.grid[row][col + 1].equals("o--") && DavidDotsBoxes.grid[row + 1][col + 1].equals("   ") && 
						DavidDotsBoxes.grid[row + 1][col + 2].equals("   ") && DavidDotsBoxes.grid[row + 2][col].equals("o--") && 
						DavidDotsBoxes.grid[row + 2][col + 1].equals("o--") && DavidDotsBoxes.grid[row + 1][col].equals("|  ")){
					DavidDotsBoxes.grid[row + 1][col + 2] = "|  ";
					doubleCrossed = true;
					crossOnce = true;
				}
			}
		}
	}

}