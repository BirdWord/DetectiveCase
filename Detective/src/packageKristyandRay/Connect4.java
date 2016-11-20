package packageKristyandRay;

public class Connect4 implements caveExplorer.Event{
	private static final String[] storyPart1 = {};

	@Override
	public void play() {
		String[][] arr = new String[8][8];
		Kristy.connect4(arr);
		
	}
		
}
