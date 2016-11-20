package packageKristyandRay;

public class RayGUInWIN {
	private final static String PLAYER = "x";
	//DISPLAYING THE BOARD METHOD
	public static void printBoard(String[][] arr){
		//First, print out the columns in case someone is dumbfounded
		for(int num = 0; num < arr[0].length; num++){
			System.out.print(" ["+num+"]");
		}
		System.out.println();
		//After that, make the top line of the board
		System.out.print(" ____");
		for(int i = 1; i < arr[0].length-1; i++){
			System.out.print("____");
		}
		System.out.print("___\n");
		//Next, make each column
		for(int row = 0; row<arr.length; row++){
			//Each row is split into 3 pieces
			//PIECE 1
			for(int i = 0; i < arr[row].length; i++){
				System.out.print("|   ");
			}
			System.out.print("|\n");
			//PIECE 2
			for(int j = 0; j<arr[row].length; j++){
				System.out.print("| "+arr[row][j]+" ");
			}
			System.out.print("|\n");
			//PIECE 3
			for(int k = 0; k<arr[row].length; k++){
				System.out.print("|___");
			}
			System.out.print("|\n");
		}
	}
	//CHECKING WINNER; THIS FUNCTION WILL check if there is a winner
	//IF THERE IS NO WINNER, THIS WILL RETURN FALSE
	//This method will take as parameter of the board array
	public static void determineWinner(String[][] arr, int row, int col){
		if(determineIfWinner(arr, row, col)){
			String winner = arr[row][col];
			if(winner.equals(PLAYER))
				System.out.println("The player has won.");
			else
				System.out.println("The computer has won.");
		}
	}
	//goes through the rows that can be wins and checks if any are winning rows
	//breaks to go to next iteration of loop if one is not equal
	public static boolean determineIfWinner(String[][] arr, int row, int col){
		int[][] checkArray = getWinRows(arr, row, col);
		int[] currentRange;
		int rowCount;
		int colCount;
		for(int i = 0; i<checkArray.length; i++){
			currentRange = checkArray[i];
			String check = arr[currentRange[0]][currentRange[2]];
			if(currentRange[3] > currentRange[2] && currentRange[1] > currentRange[0]){
				rowCount = currentRange[0];
				colCount = currentRange[2];
				rowCount++;
				colCount++;
				while(rowCount <= currentRange[1]){
					if(!arr[rowCount][colCount].equals(check))
						break;
					if(rowCount == currentRange[1])
						return true;
					rowCount++;
					colCount++;
				}
			}
			else if(currentRange[3] > currentRange[2] && currentRange[1] < currentRange[0]){
				rowCount = currentRange[0];
				colCount = currentRange[2];
				rowCount--;
				colCount++;
				while(colCount <= currentRange[3]){
					if(!arr[rowCount][colCount].equals(check))
						break;
					if(rowCount == currentRange[1])
						return true;
					rowCount--;
					colCount++;
				}
			}
			else if(currentRange[3] > currentRange[2] && currentRange[1] == currentRange[0]){
				for(int j = currentRange[2]; j <= currentRange[3]; j++){
					if(!arr[row][j].equals(check))
						break;
					if(j == currentRange[3])
						return true;
				}
			}
			else if(currentRange[3] == currentRange[2] && currentRange[1] > currentRange[0]){
				for(int j = currentRange[0]; j <= currentRange[1]; j++){
					if(!arr[j][col].equals(check))
						break;
					if(j == currentRange[1])
						return true;
				}
			}
		}
		return false;
	}
	//WITH A PARAMETER OF THE ACTUAL GAME BOARD and the row+col of last played piece
	//THIS FUNCTION WILL GRAB ALL OF THE RANGES OF THE POSSIBLE WAYS
	//TO WIN IN THE SPECIFIC CONNECT 4 BOARD
	//THEN IT WILL STORE THEM IN A 2D ARRAY
	//return looks like [[1,2][2,3]] kind of
	//row, col 
	private static int[][] getWinRows(String[][] arr, int row, int col){
		int[][] winRows = new int[16][4];
		int nextIndex = 0;
		int start;
		int start2;
		//HORIZONTAL
		//Loop through columns in which it is possible to get 4 in a row aka 3 more pieces after the first one
		start = col - 3;
		//make sure start is inside the array
		while(start < 0){
			start++;
		}
		//find all the ranges for col changes
		while(start < arr[0].length-3 && col >= start && col <= start+3){
			winRows[nextIndex] = intArray4(row, row, start, start+3);
			nextIndex++;
			start++;
		}
		//VERTICAL
		start = row - 3;
		while(start < 0){
			start++;
		}
		while(start < arr.length-3 && row >= start && row <= start+3){
			winRows[nextIndex] = intArray4(start, start+3, col, col);
			nextIndex++;
			start++;
		}
		//DIAGONAL WITH A NEGATIVE SLOPE
		//first find top left most space
		start = row;
		start2 = col;
		while(start!=0 && start2!=0){
			start--;
			start2--;
		}
		while(start < arr.length-3 && start2 < arr[0].length-3 &&
		col <= start2+3 && col >= start2 && row <= start+3 && row >= start){
			winRows[nextIndex] = intArray4(start, start+3, start2, start2+3);
			start++;
			start2++;
			nextIndex++;
		}
		//DIAGONAL WITH A POSITIVE SLOPE
		//find the bottom left most space
		start = row;
		start2 = col;
		while(start!=arr.length-1 && start2!=0){
			start++;
			start2--;
		}
		while(start > 3 && start2 < arr[0].length-3 &&
		col <= start2+3 && col >= start2 && row >= start-3 && row <= start){
			winRows[nextIndex] = intArray4(start, start-3, start2, start2+3);
			start--;
			start2++;
			nextIndex++;
		}
		//remove all the [0,0,0,0] since those mean nothing and the duplicates
		winRows = removeNullArrays(winRows);
		return winRows;
	}
	//this array creator stores ranges as [initial row, final row, initial column, final column]
	private static int[] intArray4(int idx1, int idx2, int idx3, int idx4){
		int[] local = new int[4];
		local[0] = idx1;
		local[1] = idx2;
		local[2] = idx3;
		local[3] = idx4;
		return local;
	}
	//this method removes null and duplicate arrays in a integer 2d array
	private static int[][] removeNullArrays(int[][] arr){
    	//check dupes in array
    	boolean[] dupesArray = new boolean[arr.length];
    	//true means keep, false means dupe aka toss
    	dupesArray[0] = true;
    	//iterate through rest of array
    	for(int i = 1; i<arr.length; i++){
    		//only have to check if item was there previously in array
    		for(int j = 0; j<i; j++){
    			if(j!=i && sameArrays(arr[i], arr[j])){
    				dupesArray[i] = false;
    				break;
    			}
    			dupesArray[i] = true;
    		}
    	}
    	//mark all null arrays as dupes
    	int[] nullArray = {0,0,0,0};
    	for(int i = 0; i<arr.length; i++){
    		if(sameArrays(arr[i], nullArray))
    			dupesArray[i] = false;
    	}
    	//check which items are true aka arent duplicates and need number of 
    	//nonduplicates to find length of array without duplicates
    	int nonDupes = 0;
    	for(boolean b: dupesArray){
    		if(b)
    			nonDupes++;
    	}
    	//now, create new array which will contain items if they werent duplicate
    	int[][] ret = new int[nonDupes][4];
    	//counter to add to return array
    	int c = 0;
    	for(int k = 0; k<arr.length; k++){
    		if(dupesArray[k]){
    			ret[c] = arr[k];
    			c++;
    		}
    			
    	}
    	return ret;
    }
	//checks if arrays' contents are the same
	private static boolean sameArrays(int[] arr1, int[] arr2){
		for(int i = 0; i<arr1.length; i++){
			if(arr1[i]!=arr2[i])
				return false;
		}
		return true;
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	