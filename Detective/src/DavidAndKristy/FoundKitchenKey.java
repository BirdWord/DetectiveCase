package DavidAndKristy;

import caveExplorer.CaveExplorer;
import caveExplorer.Event;
import caveExplorer.GameStartEvent;

public class FoundKitchenKey implements Event {
	private static final String[] story1 = {"",
											""
											};
	private static final String[] story2 = {"",
											""};
	@Override
	public void play() {
		GameStartEvent.readSequence(story1);
		CaveExplorer.print("Do you care to pick up the key?");
		while(CaveExplorer.in.nextLine().indexOf("yes") < 0){
			CaveExplorer.print("Just take the key; you probably need it -_-");
		}
		CaveExplorer.inventory.setKitchenKey(true);
		GameStartEvent.readSequence(story2);
	}

}