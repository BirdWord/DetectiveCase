package caveExplorer;

public class GameStartEvent implements Event {

	public static final String[] story1 = {"Hello, you must be the new detective working on this case.",
										"We are currently at the scene of the crime.", 
										"The victim was a small fun-sized girl named Kristy.",
										"We could not find out how she was killed, so we would like for you to investigate."
										};
	public static final String[] story2 = {};
	public GameStartEvent() {
		
	}

	@Override
	public void play() {
		readSequence(story1);
		CaveExplorer.print("Will you help us?");
		while(CaveExplorer.in.nextLine().indexOf("yes") < 0){
			CaveExplorer.print("Please say yes. I beg you.");
		}
		readSequence(story2);
		CaveExplorer.inventory.setHasMap(true);
	}

	public static void readSequence(String[] sequence) {
		for(String s: sequence){
			CaveExplorer.print(s);
			CaveExplorer.print(" - - - Press Enter - - - ");
			CaveExplorer.in.nextLine();
		}
	}

}
