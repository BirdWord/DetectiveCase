package Hunter_Jonathan;

import caveExplorer.CaveExplorer;
import caveExplorer.Event;
import caveExplorer.GameStartEvent;

public class FoundBathRoomKey implements Event {
	private static final String[] story1 = {"Hmmm, you stumbled upon a porcelain white key.",
											"I guess this is the final key?"
	};
	public void play() { 
		GameStartEvent.readSequence(story1);
		CaveExplorer.print("Do you care to pick up the key?");
		while(CaveExplorer.in.nextLine().indexOf("yes") < 0){
			CaveExplorer.print("Just take the key; you probably need it -_-");
		}
		CaveExplorer.inventory.setBathroomKey(true);
	}
}
