package Hunter_Jonathan;

public class HunterAI {

	public HunterAI() {
		generateShips();
	}

	public void generateShips() {
		int ships = 4;
		while (ships > 1){
			int shipRow = (int)(Math.random() * EventHunterAndJonathan.AIboard1.length);
			int shipCol = (int)(Math.random() * EventHunterAndJonathan.AIboard1[0].length);
			if(valid(shipRow, shipCol,ships)){
				for(int i = 0; i < ships;i++){
					EventHunterAndJonathan.AIboard1[shipRow + i][shipCol + i] = "O";
				}
				ships --;
			}
		}
	}

	public static boolean valid(int row, int col, int ship){
		if(col + ship > EventHunterAndJonathan.AIboard1[0].length){
			return false;
		}
		for(int i = 0; i < ship;i++){
			if (EventHunterAndJonathan.AIboard1[row+i][col+i].equals("O")){
				return false;
			}
		}
		return true;
	}
}