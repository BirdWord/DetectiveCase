package packageKristyandRay;

public class RayGUInWIN {
	public RayGUInWIN() {
		
	}
	public static void main(String[] args){
		String[][] testArr = new String[5][8];
		for(int i = 0; i<testArr.length; i++){
			for(int j = 0; j<testArr[i].length; j++){
				if(j%2==0){
					testArr[i][j] = "o";
				}
				else
					testArr[i][j] = "x";
			}
		}
		printBoard(testArr);
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
	//CHECKING WINNER; THIS FUNCTION WILL RETURN THE WINNER (X or O)
	//IF THERE IS NO WINNER, THIS WILL RETURN NULL
	//This method will take as parameter of the board array and the
	//row+column of the piece last placed 
	public String determineWinner(String[][] arr, int row, int col){
		String check;
		int nextToCheck;
		//VERTICAL FIRST; SKIP LAST 3 OF ARRAY SINCE YOU CANT CHECK 4 WITH THEM
		for(int r = 0; r <= arr.length-4; r++){
			check = arr[r][col];
			for(nextToCheck = r+1; nextToCheck <= r+3; nextToCheck++){
				if(arr[nextToCheck][col] != check)
					break;
				else if(nextToCheck == r+3)
					return check;
			}
		}
		//HORIZONTAL; SAME IDEA
		for(int c = 0; c < arr[0].length-4; c++){
			check = arr[row][c];
			for(nextToCheck = c+1; nextToCheck <= c+3; nextToCheck++){
				if(arr[row][nextToCheck] != check)
					break;
				else if(nextToCheck == c+3)
					return check;
			}
		}
		//DIAGONAL WITH NEGATIVE SLOPE
		int c = col; int r = row;
		//trying to get the spot touching the edge of the top left side of the board to have 
		//the starting point
		while(c > 0 || r > 0){
			c--; r--;
		}
		//find out when to end
		
		return null;
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	