package Hunter_Jonathan;

import java.util.Scanner;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.GameStartEvent;
import packageKristyandRay.Kristy;

public class EventHunterAndJonathan implements caveExplorer.Event{

	//radars are odd
	//ships are even
	public static String[][] board1;
	public static String[][] AIboard1;
	public static String[][] board2;
	public static String[][] AIboard2;
	
	public static final String[] BathRoomStory1= {};
	public static final String[] BathRoomStory2 = {};
	
	public EventHunterAndJonathan() {
		Scanner input = new Scanner(System.in);
		board1 = new String[6][6];
		AIboard1 = new String[6][6];
		board2 = new String[6][6];
		AIboard2 = new String[6][6];
	}

	@Override
	public void play() {
		GameStartEvent.readSequence(BathRoomStory1);
		String[][] arr = new String[6][7];
		JonathanBattleShip.startGame();
		GameStartEvent.readSequence(BathRoomStory2);
		CaveExplorer.print("As you insert the white key into the hole, it melds into the door and both silently vanish.");
		CaveExplorer.lockedDoors[0].setLocked(false);
		CaveExplorer.lockedDoors[0].setOpen(true);
		CaveExplorer.inventory.setLivingRoomKey(false);
	}
}