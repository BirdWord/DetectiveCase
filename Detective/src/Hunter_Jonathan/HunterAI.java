package Hunter_Jonathan;

import caveExplorer.CaveExplorer;

public class HunterAI {

	public HunterAI(){
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
		while(attacking){
			int attkRow = (int)(Math.random() * EventHunterAndJonathan.AIboard1.length);
			int attkCol = (int)(Math.random() * EventHunterAndJonathan.AIboard1[0].length);
			for(int i = 0; i < EventHunterAndJonathan.AIboard1.length; i++){
				for(int j = 0; j < EventHunterAndJonathan.AIboard1[0].length; j++){
					if(EventHunterAndJonathan.AIboard1[i][j].equals("O")){
						if(j-1 >= 0){
							if(EventHunterAndJonathan.AIboard1[i][j-1].equals(" ")){
								if(EventHunterAndJonathan.board2[i][j-1].equals(" O ")){
									EventHunterAndJonathan.AIboard1[i][j-1] = "O";
									EventHunterAndJonathan.board2[i][j-1] = " X ";
									attacking = true;
									CaveExplorer.print("Ghost: I have hit your ship at "+i+","+(j-1)+".");
								}else{
									EventHunterAndJonathan.AIboard1[i][j-1] = "X";
									EventHunterAndJonathan.board2[i][j-1] = " X ";
									attacking = false;
									CaveExplorer.print("Ghost: I have missed your ship at "+i+","+(j-1)+".");
									break;
								}
							}
						}
						if(i+1 < EventHunterAndJonathan.AIboard1.length){
							if(EventHunterAndJonathan.AIboard1[i+1][j].equals(" ")){
								if(EventHunterAndJonathan.board2[i+1][j].equals(" O ")){
									EventHunterAndJonathan.AIboard1[i+1][j] = "O";
									EventHunterAndJonathan.board2[i+1][j] = " X ";
									attacking = true;
									CaveExplorer.print("Ghost: I have hit your ship at "+(i+1)+","+j+".");
								}else{
									EventHunterAndJonathan.AIboard1[i+1][j] = "X";
									EventHunterAndJonathan.board2[i+1][j] = " X ";
									attacking = false;
									CaveExplorer.print("Ghost: I have missed your ship at "+(i+1)+","+j+".");
									break;
								}
							}
						}
						if(j+1 < EventHunterAndJonathan.AIboard1[i].length){
							if(EventHunterAndJonathan.AIboard1[i][j+1].equals(" ")){
								if(EventHunterAndJonathan.board2[i][j+1].equals(" O ")){
									EventHunterAndJonathan.AIboard1[i][j+1] = "O";
									EventHunterAndJonathan.board2[i][j+1] = " X ";
									attacking = true;
									CaveExplorer.print("Ghost: I have hit your ship at "+i+","+(j+1)+".");
								}else{
									EventHunterAndJonathan.AIboard1[i][j+1] = "X";
									EventHunterAndJonathan.board2[i][j+1] = " X ";
									attacking = false;
									CaveExplorer.print("Ghost: I have missed your ship at "+i+","+(j-1)+".");
									break;
								}
							}
						}
						if(i-1 >= 0){
							if(EventHunterAndJonathan.AIboard1[i-1][j].equals(" ")){
								if(EventHunterAndJonathan.board2[i-1][j].equals(" O ")){
									EventHunterAndJonathan.AIboard1[i-1][j] = "O";
									EventHunterAndJonathan.board2[i-1][j] = " X ";
									attacking = true;
									CaveExplorer.print("Ghost: I have hit your ship at "+(i-1)+","+j+".");
								}else{
									EventHunterAndJonathan.AIboard1[i-1][j] = "X";
									EventHunterAndJonathan.board2[i-1][j] = " X ";
									attacking = false;
									CaveExplorer.print("Ghost: I have missed your ship at "+(i-1)+","+j+".");
									break;
								}
							}
						}
					}
				}
				if(attacking == false){
					break;
				}
			}
			if(attacking == false){
				break;
			}
			if(EventHunterAndJonathan.AIboard1[attkRow][attkCol].equals(" ")){
				if(EventHunterAndJonathan.board2[attkRow][attkCol].equals(" O ")){
					EventHunterAndJonathan.AIboard1[attkRow][attkCol] = "O";
					EventHunterAndJonathan.board2[attkRow][attkCol] = " X ";
					attacking = true;
					CaveExplorer.print("Ghost: I have hit your ship at "+attkRow+","+attkCol+".");
				}else{
					EventHunterAndJonathan.AIboard1[attkRow][attkCol] = "X";
					EventHunterAndJonathan.board2[attkRow][attkCol] = " X ";
					attacking = false;
					CaveExplorer.print("Ghost: I have missed your ship at "+attkRow+","+attkCol+".");
				}
			}
			int spaces = 0;
			for(int i = 0; i < EventHunterAndJonathan.AIboard1.length; i++){
				for(int j = 0; j < EventHunterAndJonathan.AIboard1[0].length; j++){
					if(EventHunterAndJonathan.AIboard1[i][j].equals(" ")){
						spaces ++;
					}
				}
			}
			if(spaces == 0){
				attacking = false;
			}
		}
		if(aiWin()) {
			CaveExplorer.alive = false;
		}else{
			JonathanBattleShip.attack();
		}
	}

	public static boolean aiWin(){
		for(int i = 0; i < EventHunterAndJonathan.board2.length; i++){
			for(int j = 0; j < EventHunterAndJonathan.board2[0].length; j++){
				if(EventHunterAndJonathan.board2[i][j].equals(" O ")){
					return false;
				}
			}
		}
		return true;
	}

	public static void generateShips(){
		int ships = 3;
		while (ships > 1){
			int shipRow = (int)(Math.random() * EventHunterAndJonathan.AIboard2.length);
			int shipCol = (int)(Math.random() * EventHunterAndJonathan.AIboard2[0].length);
			if(validhor(shipRow, shipCol,ships)){
				for(int i = 0; i < ships;i++){
					EventHunterAndJonathan.AIboard2[shipRow][shipCol + i] = "O";
				}
				ships --;
			}
		}
		boolean carrier = true;
		while(carrier){
			int shipRow = (int)(Math.random() * EventHunterAndJonathan.AIboard2.length);
			int shipCol = (int)(Math.random() * EventHunterAndJonathan.AIboard2[0].length);
			if(validver(shipRow, shipCol)){
				for(int i = 0; i < 4;i++){
					EventHunterAndJonathan.AIboard2[shipRow + i][shipCol] = "O";
					carrier = false;
				}
			}
		}
		CaveExplorer.print("Ghost: I have placed my ships.");
	}

	public static boolean validver(int shipRow, int shipCol){
		if(shipRow + 4 > EventHunterAndJonathan.AIboard2.length){
			return false;
		}
		for(int i = 0; i < 4;i++){
			if (EventHunterAndJonathan.AIboard2[shipRow+i][shipCol].equals("O")){
				return false;
			}
		}
		return true;
	}

	public static boolean validhor(int row, int col, int ship){
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