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

	public static void aiTurn(){
		boolean attacking = true;
		while(attacking ){
			int attkRow = (int)(Math.random() * EventHunterAndJonathan.AIboard1.length);
			int attkCol = (int)(Math.random() * EventHunterAndJonathan.AIboard1[0].length);
			for(int i = 0; i < EventHunterAndJonathan.AIboard1.length; i++){
				for(int j = 0; j < EventHunterAndJonathan.AIboard1[0].length; j++){
					if(EventHunterAndJonathan.AIboard1[i][j].equals("O")){
						if(EventHunterAndJonathan.AIboard1[i][j-1].equals(" ")){
							if(EventHunterAndJonathan.board2[i][j-1].equals(" O ")){
								EventHunterAndJonathan.AIboard1[i][j-1] = "O";
								attacking = false;
							}else{
								EventHunterAndJonathan.AIboard1[i][j-1] = "X";
								attacking = false;
							}
						}
						if(EventHunterAndJonathan.AIboard1[i+1][j].equals(" ")){
							if(EventHunterAndJonathan.board2[i+1][j].equals(" O ")){
								EventHunterAndJonathan.AIboard1[i+1][j] = "O";
								attacking = false;
							}else{
								EventHunterAndJonathan.AIboard1[i+1][j] = "X";
								attacking = false;
							}
						}
						if(EventHunterAndJonathan.AIboard1[i][j+1].equals(" ")){
							if(EventHunterAndJonathan.board2[i][j+1].equals(" O ")){
								EventHunterAndJonathan.AIboard1[i][j+1] = "O";
								attacking = false;
							}else{
								EventHunterAndJonathan.AIboard1[i][j+1] = "X";
								attacking = false;
							}
						}
						if(EventHunterAndJonathan.AIboard1[i-1][j].equals(" ")){
							if(EventHunterAndJonathan.board2[i-1][j].equals(" O ")){
								EventHunterAndJonathan.AIboard1[i-1][j] = "O";
								attacking = false;
							}else{
								EventHunterAndJonathan.AIboard1[i-1][j] = "X";
								attacking = false;
							}
						}
					}
				}
			}
			if(EventHunterAndJonathan.AIboard1[attkRow][attkCol].equals(" ")){
				if(EventHunterAndJonathan.board2[attkRow][attkCol].equals(" O ")){
					EventHunterAndJonathan.AIboard1[attkRow][attkCol] = "O";
					attacking = false;
				}else{
					EventHunterAndJonathan.AIboard1[attkRow][attkCol] = "X";
					attacking = false;
				}
			}
		}
	}

	public static void generateShips(){
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