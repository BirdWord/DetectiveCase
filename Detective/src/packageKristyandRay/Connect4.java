package packageKristyandRay;

import caveExplorer.GameStartEvent;

public class Connect4 implements caveExplorer.Event{
	private static final String[] storyPart1 = {"Upon using the key on the door, a puzzle appears in front of you very eyes.",
												"You gasp and stare at the words written on the box: ",
												"This is an area of mystery and danger; if you wish to continue on, let us play a little game...",
												"Just a simple game of Connect 4..."
	};

	@Override
	public void play() {
		GameStartEvent.readSequence(storyPart1);
		String[][] arr = new String[8][8];
		Kristy.connect4(arr);
	}
		
}
