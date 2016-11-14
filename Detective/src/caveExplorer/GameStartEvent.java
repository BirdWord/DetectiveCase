package caveExplorer;

public class GameStartEvent implements Event {

	public static final String[] SEQ1 = {"A spikey-haired guy with orange pants flies up to you.",
										"Have you arrived to save us from the treacherous Buu?",
										"We need your help."
										};
	public static final String[] SEQ2 = {"Great, I will be busy meditating on my super yellow version while you figure out Buu is.",
										"Kaaaa, maaaaaay...",
										"By the way, here's a map."
										};
	public GameStartEvent() {
		
	}

	@Override
	public void play() {
		readSequence(SEQ1);
		CaveExplorer.print("Will you help us?");
		while(CaveExplorer.in.nextLine().indexOf("yes") < 0){
			CaveExplorer.print("Please say yes. I beg you.");
		}
		readSequence(SEQ2);
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
