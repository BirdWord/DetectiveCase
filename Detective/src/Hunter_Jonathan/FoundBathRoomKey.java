package Hunter_Jonathan;

import caveExplorer.CaveExplorer;
import caveExplorer.Event;
import caveExplorer.GameStartEvent;

public class FoundBathRoomKey implements Event {
	private static final String[] story1 = {"Stuff"};
	private static final String[] story2 = {"Stuff"};
	public void play() { 
		GameStartEvent.readSequence(story1);
		CaveExplorer.print("Do you care to pick up the key?");
		while(CaveExplorer.in.nextLine().indexOf("yes") < 0){
			CaveExplorer.print("Just take the key; you probably need it -_-");
		}
		CaveExplorer.inventory.setBathroomKey(true);
		GameStartEvent.readSequence(story2);
	}

}
