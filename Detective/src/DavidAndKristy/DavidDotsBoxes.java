package DavidAndKristy;

import java.util.Scanner;

public class DavidDotsBoxes {

	public static Scanner in = new Scanner(System.in);
	public static int inputInt;
	public static String[][] grid;
	public static int[] point1;
	public static int[] point2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter number of rows between 3 and 9.");
		int row = in.nextInt();
		System.out.println("Enter number of columns between 3 and 9.");
		int col = in.nextInt();
		setGrid(row,col); // setter.
		// test vertical line
		printGrid(); // printer.
		setVertLn(new int[] {5,2}, new int[] {5,3});
		setHorizLn(new int[] {3,0}, new int[] {4,0});
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
		// first make some space.
		System.out.println("\n\n\n");
		for(int y = 0; y < grid.length; ++y){
			for(int x = 0; x < grid[y].length; ++x){
				System.out.print(grid[y][x]);
			}
			System.out.println(""); // every row needs a new line.
		}
	}
	public static int getY(int[] coord){
		return coord[1];
	}
	public static int getX(int[] coord){
		return coord[0];
	}
	public static void setX(int[] coord, int val){
		coord[0] = val;
	}
	public static void setY(int[] coord, int val){
		coord[1] = val;
	}
	public static void setVertLn(int[] start, int[] end){

		/*
		 *  Procedure to print a vertical line.
		 *  Parameters -> coordinates for first point and second point.
		 *  
		 *  parameter -> [xCoord,yCoord];
		 * 
		 * */
		int[] max = (getY(start) < getY(end)) ? end : start; // get greater yCoord.
		
		/*
		 *  We need to update the REAL coordinates of the points.
		 *  But since we're only using the coordinates of the one with
		 *  the greater y-coordinate, we'll only update the coordinates of that(max).
		 * */
		if(getY(max) != 0) setY(max,(getY(max) * 2)); // give actual y-coordinate.
		//if(getX(max) != 0) setX(max,(getX(max) * 1)); // give actual x-coordinate.
		grid[getY(max) - 1][getX(max)] = "|"; // set the line.
	}
	public static void setHorizLn(int[] start, int[] end){
		
		
		int[] min = (getX(start) < getX(end)) ? start : end; // get left-most coordinate.
		if(getY(min) != 0) setY(min,(getY(min) * 2)); // give actual y-coordinate.
		grid[getY(min)][getX(min)] = "o--";
	}
	public static void getLnInput(){
		System.out.println("Coordinates of the first dot:");
		System.out.println("What is the X coordinate?");
		setX(point1, in.nextInt());
		while(getX(point1) < 0 || )
		System.out.println("What is the Y coordinate?");
		setY(point1,in.nextInt());

		System.out.println("Coordinates of the second dot:");
		System.out.println("What is the X Coordinate?");
		setX(point2,in.nextInt());
		System.out.println("What is the Y Coordinate?");
		setY(point2, in.nextInt());
	}
	public static setLn(int[] start, int[] end){
		/*
		*  Procedure to set and print a line.
		*  Parameters will be coordinates of two points.
		*  Parameter -> [xCoord, yCoord]
		* */

		// first check what kind of line it is.
		if((getX(start) + 1) == getX(end) || (getX(start) - 1) == getX(end)) setHorizLn(start,end); // horizontal line.
		else if((getY(start) + 1) == getY(end) || (getY(start) - 1) == getY(end)) setVertLn(start,end); // vertical line.
		else System.out.println("Invalid input. Try again");

		printGrid();
	}


}
