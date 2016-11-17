package packageKristyandRay;

import java.util.Scanner;

public class Connect4 implements caveExplorer.Event{
	private static String[] storyPart1 = {};
	
public static void main(String[] args)
{
	String[][] arr = new String[8][8];
	Kristy.connect4(arr);
}
@Override
public void play() {
	String[][] arr = new String[8][8];
	Kristy.connect4(arr);
	
}
	
}
