package packageKristyandRay;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Door;
import caveExplorer.GameStartEvent;

public class Connect4 implements caveExplorer.Event{
	private static final String[] storyPart1 = {"Upon using the key on the door, a puzzle appears CaveExplorerin front of you very eyes.",
												"You gasp and stare at the words written on the box: ",
												"This is an area of mystery and danger; if you wish to continue on, let us play a little game...",
												"Just a simple game of Connect 4..."
	};
	private static final String[] storyPart2 = {"As you win the game, the puzzle fades and the door blasts open, stunning you.",
												"A faded photograph of a man slowly falls to the ground.",
												"The man looks familar although you can't quite place your finger on who it is.",
												"You bend your back and reach for the photo, but it vanishes as you touch it."
												};
	@Override
	public void play() {
		GameStartEvent.readSequence(storyPart1);
		String[][] arr = new String[6][7];
		Kristy.connect4(arr);
		GameStartEvent.readSequence(storyPart2);
		CaveExplorer.print("As you insert the red key into the hole, it melds into the door and both silently vanish.");
		CaveExplorer.lockedDoors[0].setLocked(false);
		CaveExplorer.lockedDoors[0].setOpen(true);
		CaveExplorer.inventory.setLivingRoomKey(false);
	}
		
}
