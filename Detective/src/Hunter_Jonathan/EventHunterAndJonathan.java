package Hunter_Jonathan;

import java.util.Scanner;

public class EventHunterAndJonathan {

	//radars are odd
	//ships are even
	public static int[][] board1;
	public static int[][] AIboard1;
	private String map;
	
	public EventHunterAndJonathan() {
		Scanner input = new Scanner(System.in);
		board1 = new int[6][6];
		AIboard1 = new int[6][6];
		int[][] ships = new int[3][2];
		int[] shot = new int[2];
		int shotsHit = 0;
		int tries = 0;
		
		System.out.println("Welcome to the game of Battleship.");
		printBoard(board1);
		placeShip();
		while(!JonathanBattleShip.win()){
			printBoard(board1);
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
		}
		System.out.println("You have won the game. It has taken you" + tries + "to beat the game.");
		System.out.println("Here is your last clue.");
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

	public static void printBoard(int[][] board){
	        System.out.println("\t1 \t2 \t3 \t4 \t5");
	        System.out.println();
	        
	        for(int row=0 ; row < 5 ; row++ ){
	            System.out.print((row+1)+"");
	            for(int column=0 ; column < 5 ; column++ ){
	                if(board[row][column]==-1){
	                    System.out.print("\t"+"~");
	                }else if(board[row][column]==0){
	                    System.out.print("\t"+"*");
	                }else if(board[row][column]==1){
	                    System.out.print("\t"+"X");
	                }
	                
	            }
	            System.out.println();
	        }

	    }
}
