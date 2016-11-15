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
			System.out.print(" ["+(num+1)+"]");
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
}
