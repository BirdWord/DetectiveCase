package Hunter_Jonathan;

import caveExplorer.CaveExplorer;
import caveExplorer.GameStartEvent;

public class EventHunterAndJonathan implements caveExplorer.Event{
	private static final String[] story1 = {"As you push the porcelain key into its hole, the bathtub begins to fill.",
											"You walk toward the bathtub to inspect it closer.",
											"There are floating ships in the water.",
											"A ghostly voice screams, 'What are you doing here??'",
											"'PREPARE FOR BATTLE; THIS IS BATTLESHIP WAR!!!"
											};
	private static final String[] story2 = {"The water in the bathroom slowly drains.",
											"A treasure chest appears at the bottom of the tub.",
											"Magically, it opens itself and reveals a golden coin.",
											"One side is carved a letter B and the other looks like a faint N.",
											"As you grab onto the coin, it turns to dust.",
											"Behind you, the locked door pops open."
											};
	//radars are odd
	//ships are even
	public static String[][] board1= new String[6][6];
	public static String[][] AIboard1= new String[6][6];
	public static String[][] board2= new String[6][6];
	public static String[][] AIboard2= new String[6][6];
	public static String map;
	
	@Override
	public void play(){
		GameStartEvent.readSequence(story1);
		JonathanBattleShip.startGame();
		if(CaveExplorer.alive){
			GameStartEvent.readSequence(story2);
			CaveExplorer.lockedDoors[2].setLocked(false);
			CaveExplorer.lockedDoors[2].setOpen(true);
			CaveExplorer.inventory.setBathroomKey(false);
		}
		else{
			CaveExplorer.print("Rest in peace, you terrible detective.");
			CaveExplorer.print("THE END");
		}
	}

}