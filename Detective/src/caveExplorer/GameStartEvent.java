package caveExplorer;

public class GameStartEvent implements Event {

	public static final String[] story1 = {"Hello, you must be the new detective working on this case.",
										"We are currently at the scene of the crime.", 
										"The victim was a small fun-sized girl named Kristy.",
										"According to the autopsy, she was hit by a blunt object near her temple.",
										"Please investigate the mansion where her body was found."
										};
	public static final String[] story2 = {"Okay, thank you for your help.",
										"We have some information that may help you for this case.",
										"First of all, the murderer was last seen inside this very mansion;\nso please be careful while you are in there.",
										"Secondly, this mansion belongs to a rather puzzling, exquisite gentleman.",
										"Therefore, there may be some 'surprises' while you are inside.",
										"Otherwise, you may start your investigation now."
										};
	@Override
	public void play() {
		readSequence(story1);
		CaveExplorer.print("Will you help us?");
		while(CaveExplorer.in.nextLine().indexOf("yes") < 0){
			CaveExplorer.print("For the love of god, if you had any emotion at all, you would care about this poor girl.");
		}
		readSequence(story2);
		CaveExplorer.print("Oh, I almost forgot, we have a map of the mansion.");
		CaveExplorer.print("Would you like it?");
		while(CaveExplorer.in.nextLine().indexOf("yes") < 0){
			CaveExplorer.print("This mansion is very large, so you may get lost.\nPlease reconsider.");
		}
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
