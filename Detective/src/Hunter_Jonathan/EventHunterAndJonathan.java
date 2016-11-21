package Hunter_Jonathan;

import java.util.Scanner;

public class EventHunterAndJonathan {

	//radars are odd
	//ships are even
	public static String[][] board1;
	public static String[][] AIboard1;
	
	public EventHunterAndJonathan() {
		Scanner input = new Scanner(System.in);
		board1 = new String[6][6];
		AIboard1 = new String[6][6];
		int shotsHit = 0;
		int tries = 0;
		
		System.out.println("Welcome to the game of Battleship.");
		//fix to make it print both boards
		print(board1.length, board1[0].length);
		placeShip();
		if(JonathanBattleShip.win() == false){
			while(!JonathanBattleShip.win()){
				print(board1.length, board1[0].length);
				tries++;
				if(input.equals("ship")){
					System.out.println("You have won the game.");
				}
				System.out.println("Which row would you like to hit?");
				int x = input.nextInt();
				System.out.println("Which column would you like to hit?");
				int y = input.nextInt();
				JonathanBattleShip.attack(x,y);
				if(JonathanBattleShip.hit() == true){
					shotsHit++;
				}
				if(JonathanBattleShip.AIwin() == true){
					System.out.println("You have lost the game. You are unable to solve the mystery and the murderer has gotten away.");
				
				}
			}
			System.out.println("You have won the game. It has taken you" + tries + "to beat the game.");
			System.out.println("Here is your last clue.");
		}
	}

	 private void placeShip() {
		 Scanner input = new Scanner(System.in);
		 System.out.println("Where would you like to place your first ship?");
			int x = input.nextInt();
			int y = input.nextInt();
			//board1[x][y] = " O ";
			System.out.println("Where would you like to place your second ship?");
			int x1 = input.nextInt();
			int y1 = input.nextInt();
			//board1[x1][y1] = " O ";
			System.out.println("Where would you like to place your third ship?");
			int x2 = input.nextInt();
			int y2 = input.nextInt();
			//board1[x2][y2] = " O ";
	}

	 public static void print(int roomsX, int roomsY) {
			for (int j = 0; j != roomsX; j++) {
				System.out.print("____");
			}
			System.out.println();
			
			for (int i = 0; i != roomsY; i++) {
				for (int j = 3; j > 0; j--) {
					for (int k = 0; k != roomsX; k++) {
						if (j == 1) {
							System.out.print("|___");
						} else {
							if (j == 2) {
								System.out.print("|   ");
							} else {
								System.out.print("|   ");
							}
						}
					}
					System.out.println("|");
				}
			}
		}
}
