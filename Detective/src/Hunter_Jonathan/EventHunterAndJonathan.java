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
		
		board1 = new int[6][6];
		board2 = new int[6][6];
		AIboard1 = new int[6][6];
		AIboard2 = new int[6][6];
		int[] shot = new int[2];
		int tries = 0;
		int shotsHit = 0;
		
		
		System.out.println("Welcome to the game of Battleship.");
		printBoard(board1);
		System.out.println("Where would you like to place your first ship?");
		in = input.nextInt();
		System.out.println("Where would you like to place your second ship?");
		getInput();
		System.out.println("Where would you like to place your third ship?");
		getInput();
		
		
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
	
	public static void getInput(){
		String x = in.nextLine();
		int input1 = Integer.parseInt(x);
		String y = in.nextLine();
		int input2 = Integer.parseInt(y);
	}
}
