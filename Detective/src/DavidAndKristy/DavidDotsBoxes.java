package DavidAndKristy;

import java.util.Scanner;

public class DavidDotsBoxes {

	public static Scanner in = new Scanner(System.in);
	public static int inputInt;
	public static String[][] grid;
	public static int[] point1 = {0,0};
	public static int[] point2 = {0,0};
	public static int[] score = {0,0}; // to keep track of the current score.
	public static int maxScore = 0;
	public static int turn = 0; // keep track of whose turn it is.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter number of rows between 3 and 9.");
		int row = in.nextInt();
		System.out.println("Enter number of columns between 3 and 9.");
		int col = in.nextInt();
		setMaxScore(row,col);
		setGrid(row,col); // setter.
		printGrid(); // printer.
		for(int i = 0; i < 4; ++i){
			getLnInput();
		}
		System.out.println(hasWonBox(point1,point2));
	}
	public static void setMaxScore(int row, int col){
		maxScore = row * col;
	}
	public static int getTotalScore(){
		return (getCScore() * getPScore());
	}
	public static boolean isGameOver(){
		return (getTotalScore() == maxScore); // check if all boxes have been formed.
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
	public static int whoseTurn(){
		return turn;
	}
	public static int getPScore(){
		return score[0];
	}
	public static int getCScore(){
		return score[1];
	}
	public static void addScore(int player){
		++score[player];
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
	public static void setXY(int[] coord, int x, int y){
		setX(coord,x);
		setY(coord,y);
	}
	public static void setVertLn(int[] start, int[] end){

		/*
		 *  Procedure to print a vertical line.
		 *  Parameters -> coordinates for first point and second point.
		 *  
		 *  parameter -> [xCoord,yCoord];
		 * 
		 * */
		int[] tmp = (getY(start) < getY(end)) ? end : start; // get greater yCoord.
		int[] max = {0,0};
		setXY(max,getX(tmp), getY(tmp));
		
		/*
		 *  We need to update the REAL coordinates of the points.
		 *  But since we're only using the coordinates of the one with
		 *  the greater y-coordinate, we'll only update the coordinates of that(max).
		 * */
		if(getY(max) != 0) setY(max,(getY(max) * 2)); // give actual y-coordinate.

		grid[getY(max) - 1][getX(max)] = "|  "; // set the line.
	}
	public static void setHorizLn(int[] start, int[] end){
		
		
		int[] tmp = (getX(start) < getX(end)) ? start : end; // get left-most coordinate.
		int[] min = {0,0};
		setXY(min,getX(tmp), getY(tmp));
		if(getY(min) != 0) setY(min,(getY(min) * 2)); // give actual y-coordinate.
		grid[getY(min)][getX(min)] = "o--";
	}
	public static boolean isValidX(int xCoord){
		// check if it's in bound.
		return(xCoord >= 0 && xCoord < grid[0].length);
	}
	public static boolean isValidY(int yCoord){
		// check if it's in bound.
		return (yCoord >= 0 && (yCoord <= grid.length/2));
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
		 *  This will make sure a line can be made, from one point to another(must have different values).
		 * */
		
		// see if X Coordinates are equal AND Y Coordinates are equal.
		return (isCoordEq(getX(start),getX(end)) && isCoordEq(getY(start), getY(end)));
	}
	public static boolean hasLn(int[] start, int[] end){
		/*
		*  Procedure to check if a line already exists.
		*
		*  Error check-> make sure a line doesn't exist already.
		*
		*  -- check what kind of line we need to form.
		*  -- get the coordinate that we need to convert
		*  -- set the line ('---' or '|  ') so we can later compare.
		*  -- convert the coordinate to its correct values.
		*  -- check if a line is there -> compare the two strings(token and grid[xCoord][yCoord])
		*  -- return the value.
		* */

		// allocate memory for variables.
		//System.out.println(end[1]);
		int[] copy;
		int diff = 0;
		String token;
		int type = getLnType(start,end); // find out the type of line.

		if(type == 1){
			copy = (getX(start) < getX(end)) ? start : end; // get left-most coordinate.
			token = "o--";
		}
		else{
			copy = (getY(start) < getY(end)) ? end : start; // get greater yCoord
			token = "|  ";
			++diff;
		}
		int[] tmp = {0,0};
		setXY(tmp, getX(copy), getY(copy));

		if(getY(tmp) != 0) setY(tmp,(getY(tmp) * 2)); // give actual y-coordinate.

		// check if lines exist.
		return (grid[getY(tmp) - diff][getX(tmp)].equals(token));


	}
	public static int getLnType(int[] start, int[] end){
		/*
		 *  Function that will check if the points can actually form a valid line.
		 *  A valid line -> can either be vertical or horizontal, not diagonal.
		 *
		 *  horizontal line ->
		 *  -- y coordinates must be same
		 *  -- x coordinates must be next to each other, either left or right side.
		 *
		 *  vertical line ->
		 *  -- x coordinates must be the same
		 *  -- y coordinates must be next to each other, either up or down.
		 *
		 *  0 - NO LINE
		 *  1 - HORIZONTAL LINE
		 *  2 - VERTICAL LINE
		 *  
		 * */
		
		//Check if horizontal line can be formed -> Y Coordinates must be the same, x Coordinates must be next to each other.
		if(isCoordEq(getY(start), getY(end)) && (getX(start) == (getX(end) - 1) || (getX(start) == (getX(end) + 1)))) return 1;
		// check if vertical line can be formed -> x Coordinates must be the same, y coordinates must be next to each other.
		else if(isCoordEq(getX(start), getX(end)) && (getY(start) == (getY(end) - 1) || (getY(start) == (getY(end) + 1)))) return 2;
		return 0; // default case -> line cannot be formed.
		
	}
	public static int[] formPoint(int x, int y){
		return (new int[] {x,y});
	}
	public static boolean hasWonBox(int[] start, int[] end){
		/*
		*  We need to check whether a box has been formed.
		*  This function will return true if a box could be formed with the new line.
		*  This function will return false if a box cannot be formed with the new line.
		*
		*  To do this we'll->
		*  -- Check what kind of line it is.
		*  -- Check it's surroundings, and see if there are lines there already.
		*  -- If a line exists there, will keep checking until either a line doesn't exist, or a full box has been formed.
		*  -- Else -> return false, no box could be formed.
		* */
		int type = getLnType(start, end); // line type.
		int[] tmp;
		int[] min = {0,0};
		int[] max = {0,0};
		int diff = 0;
		// horizontal line
		if(type == 2){
			// vertical line
			tmp = (getY(start) < getY(end)) ? end : start; // get greater yCoord.
			setXY(max, getX(tmp), getY(tmp));
			tmp = (getY(max) == getY(start)) ? end : start;
			setXY(min, getX(tmp), getY(tmp));

			if(getX(min) != 0 && hasLn(formPoint(getX(min) - 1,getY(min)), formPoint(getX(min),getY(min)))){
				/*
				*  if inside -> horizontal line on the left exists.
				*  we'll set the variable diff to one
				*  -- we do this to check the left side of the line
				* */

				++diff;
				//if(hasLn(formPoint(getX(min) - diff,getY(min)), formPoint(getX(min) - diff,getY(max))) && hasLn(formPoint(getX(max) - diff,getY(max)), formPoint(getX(max),getY(max))));
			}
			else if(getX(min) != grid[0].length && hasLn(formPoint(getX(min) + 1,getY(min)), formPoint(getX(min),getY(min)))){
				/*
				*  if inside -> horizontal line exists on the right.
				*  we'll set the variable diff to -1.
				*  -- we'll do this to check lines on the right side (subtract -1 will add 1).
				* */
				--diff;
			}
			return (hasLn(formPoint(getX(min) - diff,getY(min)), formPoint(getX(min) - diff,getY(max))) && hasLn(formPoint(getX(max) - diff,getY(max)), formPoint(getX(max),getY(max))));


		}
		else{
			// horizontal line
			tmp = (getX(start) < getX(end)) ? start : end; // get left-most coordinate.
			setXY(min,getX(tmp),getY(tmp));
			tmp = (getX(min) == getX(start)) ? end : start;
			setXY(max, getX(tmp), getY(tmp));

			if(getY(min) != 0 && hasLn(formPoint(getX(min),getY(min)), formPoint(getX(min),getY(min) - 1))){
				/*
				*  if inside -> vertical line exists on the left side of the new line to the top.
				*  we'll set the variable diff to one
				*  -- we do this to check the left side of the line
				* */

				++diff;
				//if(hasLn(formPoint(getX(min),getY(min) - 1), formPoint(getX(max),getY(max) - 1)) && hasLn(formPoint(getX(max),getY(max)), formPoint(getX(max),getY(max) - 1)));
			}
			else if(getY(min) != (grid.length / 2) && hasLn(formPoint(getX(min),getY(min) - 1), formPoint(getX(min),getY(min)))){
				/*
				*  if inside -> vertical line exists on the left side of the new line to the bottom.
				*  we'll set the variable diff to -1.
				*  -- we'll do this to check lines on the right side (subtract -1 will add 1).
				* */
				--diff;
				//if(hasLn(formPoint(getX(min),getY(min) - 1), formPoint(getX(max),getY(max) - 1)) && hasLn(formPoint(getX(max),getY(max)), formPoint(getX(max),getY(max) - 1)));
			}
			return (hasLn(formPoint(getX(min),getY(min) - diff), formPoint(getX(max),getY(max) - diff)) && hasLn(formPoint(getX(max),getY(max)), formPoint(getX(max),getY(max) - diff)));


		}



	}
	public static void setLn(int type, int[] p1, int[] p2){
		switch(type){
			case 0: System.out.println("------A line could not be formed---------\nThe dots are not next to each other!");
				break;
			case 1: setHorizLn(p1,p2);
				break;
			case 2: setVertLn(p1,p2);
				break;
			default: System.out.println("ERROR OCCURED!!!!"); // this should never happen!
				break;
		}
	}
	public static void getLnInput(){
		System.out.println("Coordinates of the first dot:");
		getCoordinateInput(point1);

		System.out.println("Coordinates of the second dot:");
		getCoordinateInput(point2);

		/*
		*  AFTER receiving the coordinates of dots to be connected -> we need to ensure the coordinates are valid.
		*  Error checking includes ->
		*  -- Coordinates are not the same
		*  -- A vertical or horizontal line can actually be formed.
		*  -- A line doesnt already exist.
		*
		* */

		// are coordinates the same?
		if(arePointsEq(point1,point2)) System.out.println("--------A line could not be formed---------\nThe coordinates of the dots MUST be different!");
		// if test passed -> find out the type of line and set the grid to its new values.
		else if(hasLn(point1,point2)) System.out.println("--------A line could not be formed---------\nA line already exists there!");
		else{
			// if inside -> all coordinates should  be correct and valid.
			// so set the line
			setLn(getLnType(point1,point2),point1, point2);

			// after setting the line, check if a box can be formed.
			if(hasWonBox(point1,point2)){
				// if inside -> a box has been formed.
				// update the score of whoever's turn it is
				addScore(whoseTurn());

				// check if game is over.
				if(isGameOver()){
					System.out.println("Game has won\nThe winner is player " + whoseTurn());
				}
			}
		}

		printGrid(); // print the grid.
	}
	public static boolean isPlayerTurn(){
		// will check if its the players turn.
		return (whoseTurn() == 0);
	}



}
