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
		while(shotsHit != 3){
			//print(EventHunterAndJonathan.board1.length, EventHunterAndJonathan.board1[0].length);
			tries++;
			attack();
			//cheat code
			if(input.equals("ship")){
				break;
			}
			if(hit() == true){
				System.out.println("You have hit a ship.");
				shotsHit++;
				attack();
				if(shotsHit == 3){
					break;
				}
			}else{
				System.out.println("You did not hit a ship.");
				HunterAI.aiTurn();
			}
			if(HunterAI.aiWin() == true){
				System.out.println("You have lost the game. You are unable to solve the mystery and the murderer has gotten away.");
			}
		}
			System.out.println("You have won the game. It has taken you" + tries + "to beat the game.");
			System.out.println("Here is your last clue.");
	}
	
//	public static boolean win(){
//		int shotsHit = 0;
//		if(shotsHit == 3){
//			return true;
//		}
//		return false;
//	}

	public static void attack(){
		Scanner input = new Scanner(System.in);
		System.out.println("Which row would you like to hit?");
		int x2 = input.nextInt();
		System.out.println("Which column would you like to hit?");
		int y2 = input.nextInt();
		checkValid(x2, y2);
		if(checkValid(x2,y2) == true){
			if(EventHunterAndJonathan.board1[x2][y2].equals( " X ")){
				System.out.println("You have already shot this location. Please choose another location.");
			}else{
				EventHunterAndJonathan.board1[x2][y2] = " X ";
			}
		}
	}
	
	private static boolean checkValid(int x2, int y2) {
		if(x2 < EventHunterAndJonathan.board1.length && y2 < EventHunterAndJonathan.board1[0].length){
			return true;
		}else{
			System.out.println("This is not a valid input.");
			return false;
		}
	}

	public static boolean hit() {
		for(int row = 0; row < EventHunterAndJonathan.AIboard1.length; row++){
			for(int col = 0; col < EventHunterAndJonathan.AIboard1[0].length; col++){
				if(EventHunterAndJonathan.AIboard2[row][col].equals(" O ")){
					return true;
				}
				if(EventHunterAndJonathan.board1[row][col].equals(" O ")){
					EventHunterAndJonathan.board2[row][col] = " X ";
					return true;
				}
			}
		}
		return false;
	}

	private static void placeShip() {
		Scanner input = new Scanner(System.in);
		while(numberOfPlayerShips < 3){
			System.out.println("Where would you like to place your first ship(4 spaces)?");
			int x = input.nextInt();
			int y = input.nextInt();
			EventHunterAndJonathan.board2[x][y] = " O ";
			numberOfPlayerShips++;
			System.out.println("Where would you like to place your second ship(3 spaces)?");
			int x1 = input.nextInt();
			int y1 = input.nextInt();
			//place in a while loop to make it easier and so that the response can be repeated.
			if(x1 == x && y1 == y){
				System.out.println("You have already placed these coordinates. Please choose another place to "
						+ "put your ship.");
			}else{
				EventHunterAndJonathan.board2[x1][y1] = " O ";
				numberOfPlayerShips++;
				System.out.println("Where would you like to place your third ship(2 spaces)?");
				int x2 = input.nextInt();
				int y2 = input.nextInt();
				if(x2 == x && x2 == x1 && y2 == y && y2 == y1){
					System.out.println("You have already placed these coordinates. Please choose another place to "
							+ "put your ship.");
				}else{
					EventHunterAndJonathan.board2[x2][y2] = " O ";
					numberOfPlayerShips++;
				}
			}
		}
	}

	//make a print board method that prints both boards. like do in class or basically just screw yourself over.
	//there are no pity points, Jonathan. So work your ass off or pay the price in spades.
	public static void print(int roomsX, int roomsY) {
		EventHunterAndJonathan.map = " ";
			for(int col = 0; col < EventHunterAndJonathan.board2[0].length + 1;col++){
				EventHunterAndJonathan.map += "___";
			}
			EventHunterAndJonathan.map += "___\n";
			//CaveRoom[] row: CaveExplorer.caves
			for(int row = 0; row < EventHunterAndJonathan.board2.length; row++){
				for(int i = 0; i < 3; i++){
					String text = "";
					text += "|";
					EventHunterAndJonathan.map += text + "\n";
				}
			}
	}
	
}
