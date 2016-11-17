package packageKristyandRay;

import java.util.Arrays;

public class RayGUInWIN {
	public RayGUInWIN() {
		
	}
	public static void main(String[] args){
		String[][] testArr = new String[6][7];
		/*for(int i = 0; i<testArr.length; i++){
			for(int j = 0; j<testArr[i].length; j++){
				if(j%2==0){
					testArr[i][j] = "o";
				}
				else
					testArr[i][j] = "x";
			}
		}*/
		/*for(int i = 0; i<testArr.length; i++){
			for(int j = 0; j<testArr[0].length; j++){
				testArr[i][j] = " ";
			}
		}
		printBoard(testArr);*/
		int[][] winsArr = getWinRows(testArr);
		for(int[] arr: winsArr){
			Arrays.toString(arr);
		}
	}
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
	public static boolean determineWinner(String[][] arr){
		return false;
	}
	//WITH A PARAMETER OF THE ACTUAL GAME BOARD
	//THIS FUNCTION WILL GRAB ALL OF THE POSSIBLE WAYS
	//TO WIN IN THE SPECIFIC CONNECT 4 BOARD
	//THEN IT WILL STORE THEM IN A 2D ARRAY
	//return looks like [[1,2][2,3]] kind of
	//row, col
	private static int[][] getWinRows(String[][] arr){
		int[][] winRows = new int[18][2];
		int[] coords = new int[2];
		int nextIndex = 0;
		//HORIZONTALS
		for(int row = 0; row < arr.length; row++){
			for(int col = 0; col < arr[0].length-3; col++){
				coords[0] = row;
				coords[1] = col;
			}
			winRows[nextIndex] = coords;
			nextIndex++;
		}
		return winRows;
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	