package Hunter_Jonathan;

import java.util.Scanner;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class JonathanBattleShip {
	static int numberOfPlayerShips = 3;
	
	public static void startGame(){
		Scanner input = new Scanner(System.in);
		int shotsHit = 0;
		int tries = 0;
		
		System.out.println("Welcome to the game of Battleship.");
		//fix to make it print both boards
		//print(EventHunterAndJonathan.board1.length, EventHunterAndJonathan.board1[0].length);
		placeShip();
		if(JonathanBattleShip.win() == false){
			while(!JonathanBattleShip.win()){
				//print(EventHunterAndJonathan.board1.length, EventHunterAndJonathan.board1[0].length);
				tries++;
				if(input.equals("ship")){
					System.out.println("You have won the game.");
				}
				if(JonathanBattleShip.hit() == true){
					System.out.println("You have hit a ship.");
					shotsHit++;
				}else{
					System.out.println("You did not hit a ship.");
				}
				if(JonathanBattleShip.AIwin() == true){
					System.out.println("You have lost the game. You are unable to solve the mystery and the murderer has gotten away.");
					break;
				
				}
			}
			System.out.println("You have won the game. It has taken you" + tries + "to beat the game.");
			System.out.println("Here is your last clue.");
		}
	}
	
	public static boolean win(){
		int shotsHit = 0;
		if(shotsHit == 3){
			return true;
		}
		return false;
	}

	public static void attack(){
		Scanner input = new Scanner(System.in);
		System.out.println("Which row would you like to hit?");
		int x2 = input.nextInt();
		System.out.println("Which column would you like to hit?");
		int y2 = input.nextInt();
		checkValid(x2, y2);
		if(checkValid(x2,y2) == true){
			if(EventHunterAndJonathan.AIboard2[x2][y2].equals( " X ")){
				System.out.println("You have already shot this location.");
			}
			EventHunterAndJonathan.AIboard1[x2][y2] = " X ";
		}
	}
	
	private static boolean checkValid(int x2, int y2) {
		if(x2 < EventHunterAndJonathan.AIboard1.length && y2 < EventHunterAndJonathan.AIboard1[0].length){
			return true;
		}
		System.out.println("This is not a valid input.");
		return false;
	}

	public static boolean hit() {
		for(int row = 0; row < EventHunterAndJonathan.AIboard1.length; row++){
			for(int col = 0; col < EventHunterAndJonathan.AIboard1[0].length; col++){
				if(EventHunterAndJonathan.AIboard1[row][col].equals(" O ")){
					return true;
				}
				if(EventHunterAndJonathan.board1[row][col].equals(" O ")){
					EventHunterAndJonathan.board2[row][col] = " X ";
					numberOfPlayerShips--;
					return true;
				}
			}
		}
		return false;
	}

	 private static void placeShip() {
		 Scanner input = new Scanner(System.in);
		 System.out.println("Where would you like to place your first ship?");
			int x = input.nextInt();
			int y = input.nextInt();
			EventHunterAndJonathan.board1[x][y] = " O ";
			System.out.println("Where would you like to place your second ship?");
			int x1 = input.nextInt();
			int y1 = input.nextInt();
			EventHunterAndJonathan.board1[x1][y1] = " O ";
			System.out.println("Where would you like to place your third ship?");
			int x2 = input.nextInt();
			int y2 = input.nextInt();
			EventHunterAndJonathan.board1[x2][y2] = " O ";
	}
	 
	public static boolean AIwin() {
		//make it so that it know how many ships player has left
		if(numberOfPlayerShips == 0){
			return true;
		}
		return false;
	}
	
//	public static void print(int roomsX, int roomsY) {
//		 EventHunterAndJonathan.map = " ";
//			for(int i = 0; i < EventHunterAndJonathan.board1[0].length + 1;i++){
//				EventHunterAndJonathan.map += "___";//4 underscores
//			}
//			EventHunterAndJonathan.map += "___\n";//3 underscores
//			//fix map!
//			for(CaveRoom[] row: CaveExplorer.caves){
//				//three rows of text
//				for(int i = 0; i < 3; i++){
//					//a line of text for each
//					String text = "";
//					text += "|";
//					EventHunterAndJonathan.map += text + "\n";
//				}// last of the 3 text lines
//			}//last row
//}
}
