package Hunter_Jonathan;

import java.util.Scanner;

public class EventHunterAndJonathan {

	//radars are odd
	//ships are even
	public static int[][] board1;
	public static int[][] board2;
	public static int[][] AIboard1;
	public static int[][] AIboard2;
	private String map;
	public static Scanner in = new Scanner(System.in);
	
	public EventHunterAndJonathan() {
		
		board1 = new int[8][8];
		board2 = new int[8][8];
		AIboard1 = new int[8][8];
		AIboard2 = new int[8][8];
		
		System.out.println("Welcome to the game of Battleship.");
		printBoard();
		
	}

	public void printBoard(){
		map = " ";
		for(int i = 0; i < board1[0].length-1; i++){
			map+= "____";
		}
			map+="___\n";
			for(int i = 0; i < 3;i++){
				String text = "";
				text+="|";
				map+=text+"\n";
			}
		}
	
	public static void makeArrays(){
		String x = in.nextLine();
		int input1 = Integer.parseInt(x);
		String y = in.nextLine();
		int input2 = Integer.parseInt(y);
		JonathanBattleShip.attack(input1, input2);
	}
}
