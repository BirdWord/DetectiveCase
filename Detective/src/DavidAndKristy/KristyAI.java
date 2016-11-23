package DavidAndKristy;

import java.util.Scanner;

public class KristyAI {
	static int x;
	static int y;
	public static int computerBox;
	public static boolean doubleCrossed;
	public static boolean moreBoxes;
	public static boolean inLoop;
	private static boolean notDone;
  
	public static void main(String[] args){ 
		//fix the counter; and computer turn
		//give hint if win; cheat code; end game; lose game
		//make it so that computer makes count +2 if makes 2 boxes
	}
 
	public static void computerTurn(){
	//	boolean inLoop = true;
		inLoop = true;
		while(inLoop){
			System.out.println("inLoop");
		//	doubleCross();
		//	System.out.println("doubleCross");
		//	if(doubleCrossed == false){
				System.out.println("notDouble");
				twoBoxOneMove();
				checkCompleted();
				if(notDone){
					checkBoxes(); // LOOOK HERE.
					System.out.println("box");
					checkCompleted();
					if(notDone && !moreBoxes){
						System.out.println("in if");
						basicMove();
						inLoop = false;
					}
				}
			//} 
		}
	}
	
	public static void basicMove(){
		System.out.println("in Basic");
		boolean pickLine = true;
		while(pickLine){
			x = (int) (Math.random() * (2*EventDavidAndKristy.row + 1));
			y = (int) (Math.random() * (EventDavidAndKristy.col + 1));
			if(x % 2 == 0 && y == EventDavidAndKristy.col){
				pickLine = true;
			}
			else if(DavidDotsBoxes.grid[x][y].equals("o--") || DavidDotsBoxes.grid[x][y].equals("|  ")){
				pickLine = true;
			}
			else if(DavidDotsBoxes.grid[x][y].equals("o  ") || DavidDotsBoxes.grid[x][y].equals("   ")){
				pickLine = false;
			}
		}
		System.out.println(pickLine);
		if(!pickLine){
			if(x % 2 == 0){
				DavidDotsBoxes.grid[x][y] = "o--";
				DavidDotsBoxes.printGrid();
				System.out.println("basic");
			}
			else if(x % 2 == 1){
				DavidDotsBoxes.grid[x][y] = "|  ";
				DavidDotsBoxes.printGrid();
				System.out.println("basic");
			}
		}	
	}
	
	public static void checkCompleted(){
		notDone = false;
		for(int row = 0; row < DavidDotsBoxes.grid.length; row++){
			for(int col = 0; col < DavidDotsBoxes.grid[0].length; col++){
				if(DavidDotsBoxes.grid[row][col].equals("   ") || DavidDotsBoxes.grid[row][col].equals("o  ")){
					notDone = true;
					break; 
				}
			}
		}
		System.out.println(notDone);
	}
	
	public static void twoBoxOneMove(){
		System.out.println("2box");
		for(int row = 0; row < DavidDotsBoxes.grid.length - 1; row++){
			System.out.println("1st for");
			for(int col = 0; col < DavidDotsBoxes.grid[0].length; col++){
				System.out.println("2nd for");
				if(row < DavidDotsBoxes.grid.length - 2 && col < DavidDotsBoxes.grid[0].length - 2 && 
						DavidDotsBoxes.grid[row][col].equals("o--") && DavidDotsBoxes.grid[row][col + 1].equals("o--") &&
						DavidDotsBoxes.grid[row + 1][col].equals("|  ") && DavidDotsBoxes.grid[row + 1][col + 2].equals("|  ") &&
						DavidDotsBoxes.grid[row + 1][col + 1].equals("   ") && DavidDotsBoxes.grid[row + 2][col].equals("o--") &&
						DavidDotsBoxes.grid[row + 2][col + 1].equals("o--")){
					DavidDotsBoxes.grid[row + 1][col + 1] = "|  ";
					computerBox = computerBox + 2;
					System.out.println(computerBox);
				}
				else if(row < DavidDotsBoxes.grid.length - 4 && col < DavidDotsBoxes.grid[0].length - 2 &&
						DavidDotsBoxes.grid[row][col].equals("o--") && DavidDotsBoxes.grid[row + 1][col].equals("|  ") && 
						DavidDotsBoxes.grid[row + 1][col + 2].equals("|  ") && DavidDotsBoxes.grid[row + 2][col].equals("o  ") &&
						DavidDotsBoxes.grid[row + 3][col].equals("|  ") && DavidDotsBoxes.grid[row + 3][col + 1].equals("|  ") &&
						DavidDotsBoxes.grid[row + 4][col].equals("o--")){
					DavidDotsBoxes.grid[row + 2][col] = "o--";
					computerBox = computerBox + 2;
					System.out.println(computerBox);
				}
			}
		}
	}
		
	public static void checkBoxes(){
		System.out.println("checkingBoxes");
		
			for(int row = 0; row < DavidDotsBoxes.grid.length -1; row++){ // it wont check the last row of the grid because there is no more rows under it
				for(int col = 0; col < DavidDotsBoxes.grid[0].length; col++){
					//DavidDotsBoxes.addScore(DavidDotsBoxes.whoseTurn()); // computer's score is updated.
						twoBoxOneMove();
						if(DavidDotsBoxes.grid[row][col].equals("o--") && DavidDotsBoxes.grid[row + 1][col].equals("|  ") &&
								DavidDotsBoxes.grid[row + 2][col].equals("o--") && DavidDotsBoxes.grid[row + 1][col + 1].equals("  ")){
							DavidDotsBoxes.grid[row + 1][col + 1] = "|  ";
							computerBox++;  
						}
						else if(DavidDotsBoxes.grid[row][col].equals("o--") && DavidDotsBoxes.grid[row + 1][col].equals("|  ") &&
								DavidDotsBoxes.grid[row + 1][col + 1].equals("|  ") && DavidDotsBoxes.grid[row + 2][col].equals("o  ")){
							DavidDotsBoxes.grid[row + 2][col] = "o--";
							computerBox++;
						}
						else if(DavidDotsBoxes.grid[row][col].equals("|  ") && DavidDotsBoxes.grid[row + 1][col].equals("o--") &&
								DavidDotsBoxes.grid[row][col + 1].equals("|  ") && DavidDotsBoxes.grid[row-1][col].equals("o  ")){
							DavidDotsBoxes.grid[row - 1][col] = "o--";
							computerBox++;
						}
						else if(DavidDotsBoxes.grid[row][col].equals("o--") && DavidDotsBoxes.grid[row + 1][col + 1].equals("|  ") &&
								DavidDotsBoxes.grid[row + 2][col].equals("o--") && DavidDotsBoxes.grid[row + 1][col].equals("   ")){
							DavidDotsBoxes.grid[row + 1][col] = "|  ";
							computerBox++;
						}
					
			}
				
		}
			moreBoxes = false;
			System.out.println(moreBoxes);
		
	}

	//simplified version of double crossed strategy since this does not take into account the number and length of the chains
	
//	public static void doubleCross(){ 
//		boolean crossOnce = false;
//		for(int row = 0; row < DavidDotsBoxes.grid.length - 1; row++){
//			for(int col = 0; col < DavidDotsBoxes.grid[0].length; col++){
//				if(!crossOnce && row < DavidDotsBoxes.grid.length - 4 && col < DavidDotsBoxes.grid[0].length - 1 && 
//						DavidDotsBoxes.grid[row][col].equals("o  ") && 
//						DavidDotsBoxes.grid[row + 1][col].equals("|  ") && DavidDotsBoxes.grid[row + 1][col + 1].equals("|  ") && 
//						DavidDotsBoxes.grid[row + 3][col].equals("|  ") && DavidDotsBoxes.grid[row + 3][col + 1].equals("|  ") && 
//						DavidDotsBoxes.grid[row + 4][col].equals("o--") && DavidDotsBoxes.grid[row + 2][col].equals("o  ")){
//					DavidDotsBoxes.grid[row][col] = "o--";
//					doubleCrossed = true;
//					crossOnce = true;
//					inLoop = false;
//				}
//				else if(!crossOnce && row < DavidDotsBoxes.grid.length - 4 && col < DavidDotsBoxes.grid[0].length - 1 
//						&& DavidDotsBoxes.grid[row][col].equals("o--") && 
//						DavidDotsBoxes.grid[row + 1][col].equals("|  ") && DavidDotsBoxes.grid[row + 1][col + 1].equals("|  ") && 
//						DavidDotsBoxes.grid[row + 3][col].equals("|  ") && DavidDotsBoxes.grid[row + 3][col + 1].equals("|  ") && 
//						DavidDotsBoxes.grid[row + 4][col].equals("o  ") && DavidDotsBoxes.grid[row + 2][col].equals("o  ")){
//					DavidDotsBoxes.grid[row + 4][col] = "o--";
//					doubleCrossed = true;
//					crossOnce = true; 
//					inLoop = false;
//				}
//				else if(!crossOnce && row < DavidDotsBoxes.grid.length - 2 && col < DavidDotsBoxes.grid[0].length - 2 && 
//						DavidDotsBoxes.grid[row][col].equals("o--") && 
//						DavidDotsBoxes.grid[row][col + 1].equals("o--") && DavidDotsBoxes.grid[row + 1][col + 1].equals("   ") && 
//						DavidDotsBoxes.grid[row + 1][col + 2].equals("|  ") && DavidDotsBoxes.grid[row + 2][col].equals("o--") && 
//						DavidDotsBoxes.grid[row + 2][col + 1].equals("o--") && DavidDotsBoxes.grid[row + 1][col].equals("   ")){
//					DavidDotsBoxes.grid[row + 1][col] = "|  ";
//					doubleCrossed = true;
//					crossOnce = true;
//					inLoop = false;
//				}
//				else if(!crossOnce && row < DavidDotsBoxes.grid.length - 2 && col < DavidDotsBoxes.grid[0].length - 2 
//						&& DavidDotsBoxes.grid[row][col].equals("o--") && 
//						DavidDotsBoxes.grid[row][col + 1].equals("o--") && DavidDotsBoxes.grid[row + 1][col + 1].equals("   ") && 
//						DavidDotsBoxes.grid[row + 1][col + 2].equals("   ") && DavidDotsBoxes.grid[row + 2][col].equals("o--") && 
//						DavidDotsBoxes.grid[row + 2][col + 1].equals("o--") && DavidDotsBoxes.grid[row + 1][col].equals("|  ")){
//					DavidDotsBoxes.grid[row + 1][col + 2] = "|  ";
//					doubleCrossed = true;
//					crossOnce = true;
//					inLoop = false;
//				}
//			}
//		}
//	}

}