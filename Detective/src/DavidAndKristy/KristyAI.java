package DavidAndKristy;

import java.util.Scanner;

public class KristyAI {
	static int x;
	static int y;
	public static Scanner in = new Scanner(System.in);
	public static String[][] dots = new String[3][3];
	
	public static void main(String[] args){
		checkBoxes();
		computerTurn();
	}
	
	public static void computerTurn(){
		boolean inLoop = true;
		while(true){
			x = (int) (Math.random() * 3);
			y = (int) (Math.random() * 3);
			if(dots[x][y] == "   "){
				dots[x][y] = "---";
				inLoop = false;
			}
			else{
				inLoop = true;
			}
		}
	}
	
	public static void checkBoxes(){
		int count = 0;
		for(int row = 0; row < dots.length; row++){
			for(int col = 0; col < dots[0].length; col++){
				if(dots[row][col] == "---" || dots[row][col] == "==="){
					count++;
					//if(dots[row +1 ][col])
				}
			}
		}
	}
}
