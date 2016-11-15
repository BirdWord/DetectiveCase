package packageKristyandRay;

import java.util.Scanner;

public class Connect4 {
	static Scanner in;
	public Connect4() {
		
	}
	public static void main(String[] args){
		connect4();
	}
	public static void connect4(){
		in = new Scanner(System.in);
		String[][] arr = new String[8][8];
		for(int i = 0; i<arr.length; i++){
			for(int j = 0; j<arr[0].length; j++){
				arr[i][j] = " ";
			}
		}
		while(true){
			for(int i = 0; i<arr[0].length; i++){
				System.out.print(i);
			}
			System.out.println();
			printPic(arr);
			System.out.println("Which column?");
			int input = Integer.parseInt(in.nextLine());
			if(input <= arr[0].length-1 && input > -1){
				int row = arr.length-1;
				while(arr[row][input].equals("o")){
					row--;
					if(row < 0){
						System.out.println("This column is full.");
						break;
					}
				}
				if(row > -1){
					arr[row][input] = "o";
				}
			}
		}
	}
	public static void printPic(String[][] arr){
		for(int i = 0; i<arr.length; i++){
			for(int j = 0; j<arr[i].length; j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	

}
