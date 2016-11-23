package Hunter_Jonathan;

import java.util.Scanner;

public class JonathanBattleShip {
	static int numberOfPlayerShips = 3;
	private static int[] ship1;
	private static int[] ship2;
	private static int[] ship3;
	private static Scanner input = new Scanner(System.in);
	
	public static void startGame(){
		int shotsHit = 0;
		int tries = 0;
		
		System.out.println("Welcome to the game of Battleship.");
		
		//fix to make it print both boards
		printBoard(EventHunterAndJonathan.board2);
		printBoard(EventHunterAndJonathan.AIboard1);
		while(shotsHit != 3){
			placeShip();
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
				HunterAI.aiWin();
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

	
	//fix this whole method. NO SLEEPING
	private static void placeShip() {
		int[] ship1 = new int[2];
		while(numberOfPlayerShips != 3){
			System.out.println("Which row would you like to place your first ship(4 spaces)?");
			int x = input.nextInt();
			ship1[0] = x;
			System.out.println("Which column would you like to place your first ship(4 spaces)?");
			int y = input.nextInt();
			ship1[1] = y;
			checkValid(x,y);
			if(checkValid(x,y) == true){
				System.out.println("Would you like to place it horizontal or vertical?");
				String z = input.nextLine();
				if(z.equals("horizontal")){
					if(validhor(x,y,4)){
						for(int i = 0; i < numberOfPlayerShips; i++){
							EventHunterAndJonathan.board2[x][y + i] = " O ";
						}
						numberOfPlayerShips--;
						placeSecondShip();
						placeThirdShip();
					}else{
						System.out.println("This is not a valid location. Please choose another location.");
					}
				}else if(z.equals("vertical")){
					if(validver(x,y,4)){
						for(int i = 0; i < numberOfPlayerShips; i++){
							EventHunterAndJonathan.board2[x + i][y] = " O ";
						}
					}
					placeSecondShip();
					placeThirdShip();
				}else{
					System.out.println("This is not a valid input. Please say vertical or horizontal");
				}
			}
		}
	}

	public static void placeSecondShip(){
		int[] ship2 = new int[3];
		System.out.println("Which row would you like to place your second ship(3 spaces)?");
		int x1 = input.nextInt();
		ship2[0] = x1;
		System.out.println("Which column would you like to place your second ship?");
		int y1 = input.nextInt();
		ship2[1] = y1;
		checkValid(x1,y1);
		if(checkValid(x1,y1) == true){
			if(x1 == ship1[0] && y1 == ship1[1]){
				System.out.println("You have already placed these coordinates. Please choose another place to "
						+ "put your ship.");
			}else{
				System.out.println("Would you like to place it horizontal or vertical?");
				String z1 = input.nextLine();
				if(z1.equals("horizontal")){
					if(validhor(x1,y1,3)){
						for(int i = 0; i < numberOfPlayerShips; i++){
							EventHunterAndJonathan.board2[x1 + i][y1] = " O ";
						}
						numberOfPlayerShips--;
					}else{
						System.out.println("This is not a valid location. Please choose another location.");
					}
				}else if(z1.equals("vertical")){
					if(validver(x1,y1,3)){
						for(int i = 0; i < numberOfPlayerShips; i++){
							EventHunterAndJonathan.board2[x1 + i][y1] = " O ";
						}
						numberOfPlayerShips--;
					}else{
						System.out.println("This is not a valid location. Please choose another location.");
					}
				}else{
					System.out.println("This is not a valid input.");
				}
			}
		}
	}
	
	public static void placeThirdShip(){
		int[] ship3 = new int[3];
		System.out.println("Which row would you like to place your third ship(2 spaces)?");
		int x2 = input.nextInt();
		ship3[0] = x2;
		System.out.println("Which column would you like to place your third ship?");
		int y2 = input.nextInt();
		ship3[1] = y2;
		checkValid(ship3[0],ship3[1]);
		if(checkValid(ship3[0],ship3[1]) == true){
			if(ship3[0] == ship1[0] && ship3[0] == ship2[0] && ship3[1] == ship1[1] && ship3[1] == ship2[1]){
				System.out.println("You have already placed these coordinates. Please choose another place to "
						+ "put your ship.");
			}else{
				System.out.println("Would you like to place it horizontal or vertical?");
				String z2 = input.nextLine();
				if(z2.equals("horizontal")){
					if(validhor(x2,y2,2)){
						for(int i = 0; i < numberOfPlayerShips; i++){
							EventHunterAndJonathan.board2[x2 + i][y2] = " O ";
						}
						numberOfPlayerShips--;
					}else{
						System.out.println("This is not a valid location. Please choose another location.");
					}
				}else if(z2.equals("vertical")){
					if(validver(x2,y2,2)){
						for(int i = 0; i < numberOfPlayerShips; i++){
							EventHunterAndJonathan.board2[x2 + i][y2] = " O ";
						}
						numberOfPlayerShips--;
					}else{
						System.out.println("This is not a valid location. Please choose another location.");
					}
				}else{
					System.out.println("This is not a valid input.");
				}
			}
		}
	}
	//make a print board method that prints both boards. like do in class or basically just screw yourself over.
	//there are no pity points, Jonathan. So work your ass off or pay the price in spades.
//	public static void print(String[][] board) {
//		EventHunterAndJonathan.map = " ";
//			for(int col = 0; col < EventHunterAndJonathan.board2[0].length + 1;col++){
//				EventHunterAndJonathan.map += "___";
//			}
//			EventHunterAndJonathan.map += "___\n";
//			//CaveRoom[] row: CaveExplorer.caves
//			for(int row = 0; row < EventHunterAndJonathan.board2.length; row++){
//				for(int i = 0; i < 3; i++){
//					String text = "";
//					text += "|";
//					EventHunterAndJonathan.map += text + "\n";
//				}
//			}
//	}
	public static void printBoard(String[][] arr){
		//First, print out the columns in case someone is dumbfounded
		for(int num = 0; num < arr[0].length; num++){
			System.out.print("    ["+num+"]  ");
		}
		System.out.println();
		//After that, make the top line of the board
		System.out.print(" ___________________");
		for(int i = 1; i < arr[0].length-1; i++){
			System.out.print("_______");
		}
		System.out.print("______\n");
		//Next, make each column
		for(int row = 0; row<arr.length; row++){
			//Each row is split into 3 pieces
			//PIECE 1
			for(int i = 0; i < arr[row].length; i++){
				System.out.print("|        ");
			}
			System.out.print("|\n");
			//PIECE 2
			for(int j = 0; j<arr[row].length; j++){
				System.out.print("|        ");
			}
			System.out.print("|\n");
			//PIECE 3
			for(int k = 0; k<arr[row].length; k++){
				System.out.print("|________");
			}
			System.out.print("|\n");
		}
	}
	
	private static boolean validver(int shipRow, int shipCol, int shipSize) {
		if(shipRow + shipSize > EventHunterAndJonathan.board2.length){
			return false;
		}
		for(int i = 0; i < 4;i++){
			if (EventHunterAndJonathan.board2[shipRow+i][shipCol].equals("O")){
				return false;
			}
		}
		return true;
	}

	public static boolean validhor(int row, int col, int shipSize){
		if(col + shipSize > EventHunterAndJonathan.board2[0].length){
			return false;
		}
		for(int i = 0; i < shipSize-1;i++){
			if (EventHunterAndJonathan.board2[row][col+i].equals("O")){
				return false;
			}
		}
		return true;
	}
}
