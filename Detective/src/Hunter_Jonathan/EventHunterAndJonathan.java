package Hunter_Jonathan;

import java.util.Scanner;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class EventHunterAndJonathan implements caveExplorer.Event{

	//radars are odd
	//ships are even
	public static String[][] board1;
	public static String[][] AIboard1;
	public static String[][] board2;
	public static String[][] AIboard2;
	public static String map;
	
	public EventHunterAndJonathan() {
		Scanner input = new Scanner(System.in);
		board1 = new String[6][6];
		AIboard1 = new String[6][6];
		board2 = new String[6][6];
		AIboard2 = new String[6][6];
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}
}