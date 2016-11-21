package DavidAndKristy;

import caveExplorer.CaveExplorer;
import caveExplorer.Event;
import caveExplorer.GameStartEvent;

public class FoundKitchenKey implements Event {
	private static final String[] story1 = {"Ouch! What did I step on? Woah, it's a black key!",
											"Maybe it's the missing key to unlock the door!"
											};
	private static final String[] story2 = {"As you pick up the key, you get a sudden memory flash.",
											"Why did I just have a vision about Christmas CaveExplorerin Times Square?"};
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