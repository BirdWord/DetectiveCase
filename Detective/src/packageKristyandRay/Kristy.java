package packageKristyandRay;

import java.util.Scanner;

public class Kristy {

	static Scanner in;
	public static void connect4(String[][] arr){
		in = new Scanner(System.in);
		for(int i = 0; i<arr.length; i++){
			for(int j = 0; j<arr[0].length; j++){
				arr[i][j] = " ";
			}
		}
		while(true){
			RayGUInWIN.printBoard(arr);
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
					aiTurn(arr);
				}
			}
			else
				System.out.println("That is not a valid column number.");
		}
	}
	public static void aiTurn(String[][] arr)
	{
			double rand = Math.random();
			int roll = (int)(arr[0].length*rand);
			for (int i = arr.length-1; i<-1;i--)
			{
				if (arr[i][roll] == null)
				{
					arr[i][roll]="x";
					break;
				}
				
			}
//		while(!arr[0][roll].equals(null)){
//			
//			arr[row][roll] = "x";
//		}
	}

}
