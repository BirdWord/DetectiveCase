package packageKristyandRay;

import java.lang.reflect.Array;

import caveExplorer.CaveExplorer;
//import java.util.Scanner;

public class Kristy {

	public static void connect4(String[][] arr){
//		in = new Scanner(System.in);
		for(int i = 0; i<arr.length; i++){
			for(int j = 0; j<arr[0].length; j++){
				arr[i][j] = " ";
			}
		}
		while(true){
			RayGUInWIN.printBoard(arr);
			System.out.println("Which column?");
//			int ing = Integer.parseInt(in.nextLine());
//			String ing = CaveExplorer.in.nextLine();
			int input =getIntegerInput();
			
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
					if(RayGUInWIN.determineIfWinner(arr,row,input))
					{
						RayGUInWIN.determineWinner(arr,row,input);
						break;
					}
					aiTurn(arr);//hi
					
					
				}
			}
			else
				System.out.println("That is not a valid column number.");
		}
	}
	private static int getIntegerInput() {
		 System.out.println("Please enter an integer.");
		 boolean isInteger = false;
		 String integerString = CaveExplorer.in.nextLine();
		 int value = 0;
		 while(!isInteger){
		 try{
		 value = Integer.parseInt(integerString);
		 //will not continue if an error above is thrown
		 isInteger = true;//exits loop if entry is valid
		 }catch(NumberFormatException e){
		 System.out.println("You must enter an integer. You better try again.");
		 integerString = CaveExplorer.in.nextLine();
		 }
		 }
		 return value;
		 }
	public static void aiTurn(String[][] arr)
	{
			double rand = Math.random();
			int roll = (int)(arr[0].length*rand);
				System.out.println(roll);
				for (int i = arr.length-1; i>-1;i--)
				{
					
					if (arr[i][roll].equals(" "))
					{
						arr[i][roll]="x";
						i =-1;
						if(RayGUInWIN.determineIfWinner(arr,i,roll))
						{
							RayGUInWIN.determineWinner(arr,i,roll);
							break;
						}
					
					}
				
				}
//		while(!arr[0][roll].equals(null)){
//			
//			arr[row][roll] = "x";
//		}
			//ji
	}
	
	

}
