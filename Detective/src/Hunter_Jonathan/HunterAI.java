package Hunter_Jonathan;

public class HunterAI {

	public HunterAI() {
		for(int i = 0; i < EventHunterAndJonathan.AIboard1.length; i++){
			for(int j = 0; j < EventHunterAndJonathan.AIboard1[0].length; j++){
				EventHunterAndJonathan.AIboard1[i][j] = " ";
			}
		}
		for(int i = 0; i < EventHunterAndJonathan.AIboard2.length; i++){
			for(int j = 0; j < EventHunterAndJonathan.AIboard2[0].length; j++){
				EventHunterAndJonathan.AIboard2[i][j] = " ";
			}
		}
		generateShips();
	}

	public static void generateShips() {
		int ships = 4;
		while (ships > 1){
			int shipRow = (int)(Math.random() * EventHunterAndJonathan.AIboard2.length);
			int shipCol = (int)(Math.random() * EventHunterAndJonathan.AIboard2[0].length);
			if(valid(shipRow, shipCol,ships)){
				for(int i = 0; i < ships;i++){
					EventHunterAndJonathan.AIboard2[shipRow][shipCol + i] = "O";
				}
				ships --;
			}
		}
	}

	public static boolean valid(int row, int col, int ship){
		if(col + ship > EventHunterAndJonathan.AIboard2[0].length){
			return false;
		}
		for(int i = 0; i < ship-1;i++){
			if (EventHunterAndJonathan.AIboard2[row][col+i].equals("O")){
				return false;
			}
		}
		return true;
	}
}