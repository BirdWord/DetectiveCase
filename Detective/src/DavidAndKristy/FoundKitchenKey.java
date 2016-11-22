package DavidAndKristy;

import caveExplorer.CaveExplorer;
import caveExplorer.Event;
import caveExplorer.GameStartEvent;

public class FoundKitchenKey implements Event {
	private static final String[] story1 = {"Ouch! You stepped on something. Woah, it's a black key!",
											"Maybe it's the missing key to unlock the door!"
											};
	private static final String[] story2 = {"As you pick up the key, you noticed a framed picture on the wall.",
											"It is a quote that says 'Break A leg'",
											"Does this hold a secret meaning?"
											};
	@Override
	public void play() {
		GameStartEvent.readSequence(story1);
		CaveExplorer.print("Hey, do you wanna pick up the key?");
		while(CaveExplorer.in.nextLine().indexOf("yes") < 0){
			CaveExplorer.print("JUST TAKE THE KEY; DO YOU NOT SEE THE LOCKED DOOR???");
		}
		CaveExplorer.inventory.setKitchenKey(true);
		GameStartEvent.readSequence(story2);
	}

}