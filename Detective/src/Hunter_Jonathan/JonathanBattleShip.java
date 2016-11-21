package Hunter_Jonathan;

import java.util.Scanner;

public class JonathanBattleShip {
	static int numberOfPlayerShips = 3;
	
	public static boolean win(){
		int shotsHit = 0;
		if(shotsHit == 3){
			return true;
		}
		return false;
	}

	public static void attack(int x2, int y2){
		checkValid(x2, y2);
		if(checkValid(x2,y2) == true){
			EventHunterAndJonathan.AIboard1[x2][y2] = " X ";
		}
	}
	
	private static boolean checkValid(int x2, int y2) {
//		if(){
//			return true;
//		}
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

	public static boolean AIwin() {
		//make it so that it tells how many ships player has left
		if(numberOfPlayerShips == 0){
			return true;
		}
		return false;
	}
}
