package DavidAndKristy;

import java.util.Scanner;

public class DavidDotsBoxes {

	public static Scanner in = new Scanner(System.in);
	public static int inputInt;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter number of rows between 3 and 9.");
		int row = in.nextInt();
		System.out.println("Enter number of columns between 3 and 9.");
		int col = in.nextInt();
		printBox(row,col);

	}
	public static void printBox(int row, int col){
		// to connect two points, we'll use 'o--' instead of 'o', IF horizontal.
		for(int y = 0; y <= row; ++y){
			for(int x = 0; x <= col; ++x){
				System.out.print("o--");
			}
			System.out.println("");
		}//
	}

}
