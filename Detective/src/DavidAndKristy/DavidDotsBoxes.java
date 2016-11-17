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
		// getter for Y Coordinate.
		return coord[1];
	}
	public static int getX(int[] coord){
		// getter for X Coordinate.
		return coord[0];
	}
	public static void setX(int[] coord, int val){
		// setter for X Coordinate.
		coord[0] = val;
	}
	public static void setY(int[] coord, int val){
		// setter for Y Coordinate.
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
		grid[getY(max) - 1][getX(max)] = "|"; // set the line.
	}
	public static void setHorizLn(int[] start, int[] end){
		
		
		int[] min = (getX(start) < getX(end)) ? start : end; // get left-most coordinate.
		if(getY(min) != 0) setY(min,(getY(min) * 2)); // give actual y-coordinate.
		grid[getY(min)][getX(min)] = "o--";
	}
	public static boolean isValidX(int xCoord){
		return(xCoord > 0 && xCoord < grid[0].length);
	}
	public static boolean isValidY(int yCoord){
		return (yCoord > 0 && yCoord < grid.length);
	}
	public static void getCoordinateInput(int[] point){
		System.out.println("What is the X coordinate?");
		setX(point, in.nextInt());
		while(!isValidX(getX(point))){
			System.out.println("Invalid X Coordinate. Please input a new X Coordinate.");
			setX(point,in.nextInt());
		}
		
		System.out.println("What is the Y coordinate?");
		setY(point,in.nextInt());
		while(!isValidY(getY(point))){
			System.out.println("Invalid Y Coordinate. Please input a new Y Coordinate.");
			setY(point,in.nextInt());
		}
	}
	public static boolean isCoordEq(int coord1, int coord2){
		return coord1 == coord2;
	}
	public static boolean arePointsEq(int[] start, int[] end){
		/*
		 *  Function that will check if the points are in different positions.
		 * */
		
		// see if X Coordinates are NOT equal OR Y Coordinates are NOT equal.
		return (!isCoordEq(getX(start),getX(end)) || !isCoordEq(getY(start), getY(end)));
	}
	public static boolean isLnForm(int[] start, int[] end){
		/*
		 *  Function that will check if the points can actually form a valid line.
		 *  A valid line -> can either be vertical or horizontal, not diagonal.
		 *  
		 * *////
		
		//Check if horizontal line can be formed -> Y Coordinates must be the same.
		if(isCoordEq(getY(start), getY(end)) && (getX(start) == (getX(end) - 1) || (getX(start)) == )
		
	}
	public static void getLnInput(){
		System.out.println("Coordinates of the first dot:");
		getCoordinateInput(point1);

		System.out.println("Coordinates of the second dot:");
		getCoordinateInput(point2);
	}
	public static void setLn(int[] start, int[] end){
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
