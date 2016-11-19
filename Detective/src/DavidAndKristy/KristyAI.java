package DavidAndKristy;

import java.util.Scanner;

public class KristyAI {
	static int x;
	static int y;
	public static int computerBox;
	public static Scanner in = new Scanner(System.in);
	public static String[][] grid;
	
	
	public static void main(String[] args){
		setGrid(3,3);
		grid[0][0] = "o--";	
		grid[1][1] = "|  ";
		grid[2][0] = "o--";
		printGrid();
		checkBoxes();
		printGrid();
	//	computerTurn();
		
	}
	
	public static void computerTurn(){
		boolean inLoop = true;
		
		while(inLoop){
			checkBoxes();
			x = (int) (Math.random() * 7); 
			y = (int) (Math.random() * 4); 
			System.out.println("x = " + x);
			System.out.println("y = " + y);
			if(x % 2 == 0 && grid[x][y] != "o--" && y != 3){
				grid[x][y] = "o--";
				printGrid();
				inLoop = false;
			}
			else if(x % 2 == 1 && grid[x][y] != "|  "){
				grid[x][y] = "|  ";
				printGrid();
				inLoop = false;
			}
		}
	}
	
	public static void checkBoxes(){
		for(int row = 0; row < grid.length; row++){
			for(int col = 0; col < grid[0].length; col++){
				if(grid[row][col].equals("o--") && grid[row + 1][col].equals("|  ") && grid[row + 2][col].equals("o--") && grid[row + 1][col + 1].equals("   ")){
					grid[row + 1][col + 1] = "|  ";
					computerBox++;
					System.out.println("a");
				}
				else if(grid[row][col].equals("o--") && grid[row + 1][col].equals("|  ") && grid[row + 1][col + 1].equals("|  ")){
					grid[row + 2][col] = "o--";
					computerBox++;
					System.out.println("b");
				}
				else if(grid[row][col].equals("|  ") && grid[row + 1][col].equals("o--") && grid[row][col + 1].equals("|  ") && grid[row-1][col].equals("o  ")){
					grid[row - 1][col] = "o--";
					computerBox++;
					System.out.println("c");
				}
				else if(grid[row][col].equals("o--") && grid[row + 1][col + 1].equals("|  ") && grid[row + 2][col].equals("o--") && grid[row + 1][col].equals("   ")){
					grid[row + 1][col] = "|  ";
					computerBox++;
					System.out.println("d");
				}
				System.out.println(computerBox);
			}
			
		}
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
