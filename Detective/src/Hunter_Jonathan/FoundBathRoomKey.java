package Hunter_Jonathan;

import caveExplorer.CaveExplorer;
import caveExplorer.Event;
import caveExplorer.GameStartEvent;

public class FoundBathRoomKey implements Event {
	private static final String[] story1 = {"Hmmm, you stumbled upon a porcelain white key.",
											"I guess this is the final key?"
	};
	private static final String[] story2 = {"After picking up the key, you see a glimpse of a man's shadow.",
											"A postcard from Time Square drifts downward, vanishing when it reaches the ground.",
											"You think nothing of it and proceed."};
	public void play() { 
		GameStartEvent.readSequence(story1);
		CaveExplorer.print("Do you care to pick up the key?");
		while(CaveExplorer.in.nextLine().indexOf("yes") < 0){
			CaveExplorer.print("Just take the key; you probably need it -_-");
		}
		GameStartEvent.readSequence(story2);
		CaveExplorer.inventory.setBathroomKey(true);
	}
}
