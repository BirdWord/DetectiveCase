package packageKristyandRay;

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
		CaveExplorer.alive=true;
		while(CaveExplorer.alive){
			RayGUInWIN.printBoard(arr);
			CaveExplorer.print("Hurry pick a column, you will lose anyways!");
//			int ing = Integer.parseInt(in.nextLine());
			int input = getIntegerInput();
//			int inp =getIntegerInput();
//			int input = inp;
			
			
			if (input == 888)
			{
				CaveExplorer.print("you have vanquished the evil entity!");
				break;
			}
			else
			if(input <= arr[0].length-1 && input > -1){
				int row = arr.length-1;
				while(arr[row][input].equals("D")||arr[row][input].equals("N")){
					row--;
					if(row < 0){
						System.out.println("This column is full.");
						break;
					}
				}
				if(row > -1){
					arr[row][input] = "D";
					String[] lang= {"you never get here alive, MWAHAHAHAHA","you will never win","you never find the murderer"};
					double rand = Math.random();
					int roll = (int)(lang.length*rand);
					CaveExplorer.print(lang[roll]);
					if (RayGUInWIN.determineIfWinner(arr, row, input))
					{
						RayGUInWIN.printBoard(arr);
						RayGUInWIN.determineWinner(arr,row,input);
						if (RayGUInWIN.determineWinner(arr,row,input).equals("N"))
						{
							CaveExplorer.print("The evil entity has defeated you!");
							CaveExplorer.print("You got ripped and sheaded into pieces and thrown out of the window!");
							CaveExplorer.alive=false;
						}
						else
							CaveExplorer.print("you have vanquished the evil entity!");
						break;
					}
					
					aiTurn(arr, row, input);//hi
					
					
				}
			}
			else
				System.out.println("Are you blind? Pick another one.");
		}
	}
	private static int getIntegerInput() {
		 System.out.println("Input your column.");
		 boolean isInteger = false;
		 String integerString = CaveExplorer.in.nextLine();
		 int value = 0;
		 while(!isInteger){
		 try{
		 value = Integer.parseInt(integerString);
		 //will not continue if an error above is thrown
		 isInteger = true;//exits loop if entry is valid
		 }catch(NumberFormatException e){
		 System.out.println("Hurry up, put an integer or your sins will measure in hell.");
		 integerString = CaveExplorer.in.nextLine();
		 }
		 }
		 return value;
	}
	public static void aiTurn(String[][] arr, int row, int col)
	{
		int[] roli = {col-1,col,col+1};
		int rand = (int)(Math.random()*3);
		int roll = roli[rand];
		while ((roll<0)|| (roll>arr[0].length-1))
		{
			rand = (int)(Math.random()*3);
			roll = roli[rand];
			
		}
			
		
				boolean hi = true;
				while(hi)
				{
					if (roll >= 0 || roll< arr[0].length-1)
					{
						for (int i = arr.length-1; i>-1;i--)
						{
							if (arr[i][roll].equals(" "))
							{
								arr[i][roll]="N";
								if (RayGUInWIN.determineIfWinner(arr, i, roll))
								{
									RayGUInWIN.printBoard(arr);
									if (RayGUInWIN.determineWinner(arr,i,roll).equals("N"))
									{
										CaveExplorer.print("The evil entity has defeated you!");
										CaveExplorer.print("You got ripped and sheaded into pieces and thrown out of the window!");
										CaveExplorer.alive=false;
									}
									else
									{
										CaveExplorer.print("you have vanquished the evil entity!");
										break;
									}
								}
								i =-1;
								hi=false;	
							}
				
						}
						
						double rand2 = Math.random();
						roll = (int)(arr[0].length*rand2);
					}
			}
	}
}	
