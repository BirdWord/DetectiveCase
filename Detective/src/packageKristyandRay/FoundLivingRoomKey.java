package packageKristyandRay;

import caveExplorer.CaveExplorer;
import caveExplorer.Event;
import caveExplorer.GameStartEvent;

public class FoundLivingRoomKey implements Event {
	private static final String[] story1 = {"While walking around, you stumble upon a peculiar glossy, red key.",
											"I don't know; maybe there's a locked door somewhere where you can use the key?"
											};
	private static final String[] story2 = {"As you reach down to grab the key, you hear hint footsteps.",
											"You're tired and want to get this investigation over with, so you ignore them and trudge on."};
	@Override
	public void play() { 
		GameStartEvent.readSequence(story1);
		CaveExplorer.print("Do you care to pick up the key?");
		while(CaveExplorer.in.nextLine().indexOf("yes") < 0){
			CaveExplorer.print("Just take the key; you probably need it -_-");
		}
		CaveExplorer.inventory.setLivingRoomKey(true);
		GameStartEvent.readSequence(story2);
	}
 
}
