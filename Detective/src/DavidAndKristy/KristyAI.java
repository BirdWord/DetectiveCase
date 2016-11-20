package DavidAndKristy;

import java.util.Scanner;

public class KristyAI {
	static int x;
	static int y;
	public static int computerBox;
	public static boolean doubleCrossed;
	public static boolean sideChain;
	public static boolean moreBoxes;
	public static Scanner in = new Scanner(System.in);
	public static String[][] grid;
	
	public static void main(String[] args){ //wont make a box if it need a vertical line in the last column 
		setGrid(3,3);
//		grid[0][0] = "o--";	
//		grid[1][1] = "|  ";
//		grid[2][0] = "o--";
//		grid[4][2] = "o--";
//		grid[3][3] = "|  ";
//		grid[3][2] = "|  ";
//		grid[4][1] = "o--";
//		grid[5][1] = "|  ";
//		grid[5][2] = "|  ";
		
		grid[1][0] = "|  ";
		grid[0][0] = "o--";
		grid[1][1] = "|  ";
		grid[3][0] = "|  ";
		grid[3][1] = "|  ";
		grid[4][0] = "o--";
		
		
		printGrid();
		computerTurn();
	}
	
	public static void computerTurn(){
		boolean inLoop = true;
		
		while(inLoop){
			doubleCross();
			if(doubleCrossed){ //dont checkBoxes 
				x = (int) (Math.random() * 7);  //change it to user input for number of rows and 
				y = (int) (Math.random() * 4);  //change it to user input for number of columns
				System.out.println("x = " + x);
				System.out.println("y = " + y);
				if(x % 2 == 0 && !grid[x][y].equals("o--") && y != 3){
					grid[x][y] = "o--";
					printGrid();
					//printGrid();
					inLoop = false;
				}
				else if(x % 2 == 1 && !grid[x][y].equals("|  ")){
					grid[x][y] = "|  ";
					printGrid();
					//printGrid();
					inLoop = false;
				}
			}
			else{
				checkBoxes();
				if(!moreBoxes){
					x = (int) (Math.random() * 7);  //change it to user input for number of rows and 
					y = (int) (Math.random() * 4);  //change it to user input for number of columns
					System.out.println("x = " + x);
					System.out.println("y = " + y);
					if(x % 2 == 0 && !grid[x][y].equals("o--") && y != 3){
						grid[x][y] = "o--";
						printGrid();
						//printGrid();
						inLoop = false;
					}
					else if(x % 2 == 1 && !grid[x][y].equals("|  ")){
						grid[x][y] = "|  ";
						printGrid();
						//printGrid();
						inLoop = false;
					}
				}
			}
		}
	}
	
	public static void checkBoxes(){
		moreBoxes = true;
		while(moreBoxes){
			for(int row = 0; row < grid.length -1; row++){ // it wont check the last row of the grid because there is no more rows under it
				for(int col = 0; col < grid[0].length; col++){
					if(grid[row][col].equals("o--") && grid[row + 1][col].equals("|  ") && grid[row + 2][col].equals("o--") && grid[row + 1][col + 1].equals(" ")){
						grid[row + 1][col + 1] = "|  ";
						computerBox++;
	//					System.out.println("a");
						moreBoxes = true;
					}
					else if(grid[row][col].equals("o--") && grid[row + 1][col].equals("|  ") && grid[row + 1][col + 1].equals("|  ") && grid[row + 2][col].equals("o  ")){
						grid[row + 2][col] = "o--";
						computerBox++;
	//					System.out.println("b");
						moreBoxes = true;
					}
					else if(grid[row][col].equals("|  ") && grid[row + 1][col].equals("o--") && grid[row][col + 1].equals("|  ") && grid[row-1][col].equals("o  ")){
						grid[row - 1][col] = "o--";
						computerBox++;
	//					System.out.println("c");
						moreBoxes = true;
					}
					else if(grid[row][col].equals("o--") && grid[row + 1][col + 1].equals("|  ") && grid[row + 2][col].equals("o--") && grid[row + 1][col].equals("   ")){
						grid[row + 1][col] = "|  ";
						computerBox++;
	//					System.out.println("d");
						moreBoxes = true;
					}
					else{
						moreBoxes = false;
					}
	//				System.out.println(computerBox);
				}
				
			}
		}
	}
	
	public static void doubleCross(){
		boolean crossOnce = false;
		for(int row = 0; row < grid.length - 1; row++){
			for(int col = 0; col < grid[0].length; col++){
				if(!crossOnce && grid[row][col].equals("o--") && grid[row + 1][col].equals("|  ") && grid[row + 1][col + 1].equals("|  ") &&
						grid[row + 3][col].equals("|  ") && grid[row + 3][col + 1].equals("|  ") && grid[row + 4][col].equals("o--") &&
						grid[row + 2][col].equals("o  ")){
					doubleCrossed = true;
					crossOnce = true;
						
				}
				else if(!crossOnce && grid[row][col].equals("o--") && grid[row][col + 1].equals("o--") && grid[row + 1][col + 1].equals("|  ") &&
						grid[row + 1][col + 3].equals("|  ") && grid[row + 2][col].equals("0--") && grid[row + 2][col + 1].equals("o--") &&
						grid[row + 1][col + 1].equals("   ")){
					doubleCrossed = true;
					crossOnce = true;
				}
			}
		}
	}
	
//	public static void sideChain(){ //breaks the side chain; if player makes vertical, computer make horizontal and vice versa
//		for(int row = 0; row < grid.length - 1; row++){
//			for(int col = 0; col < grid[0].length; col++){
//				
//					
//				}
//			}
//	}
	
	
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
