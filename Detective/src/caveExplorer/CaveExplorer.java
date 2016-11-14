package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {
	public static CaveRoom caves[][];
	public static Scanner in = new Scanner(System.in);
	public static CaveRoom currentRoom;
	public static Inventory inventory;
	public static void main(String args[]){
		caves = new CaveRoom[5][5];
		for(int i = 0; i<caves.length; i++){
			for(int j = 0; j<caves[0].length; j++){
				caves[i][j] = new CaveRoom("This caves has coordinates ("+i+","+j+").");
			}
		}
		caves[0][2] = new EventRoom("This is the room where that guy with a tail met you.", new GameStartEvent());
		currentRoom = caves[0][1];
		currentRoom.enter();
		caves[0][1].setConnection(CaveRoom.EAST, caves[0][2], new Door());
		caves[0][2].setConnection(CaveRoom.SOUTH, caves[1][2], new Door());
		caves[1][2].setConnection(CaveRoom.SOUTH, caves[2][2], new Door());
		inventory = new Inventory();
		startExploring();
	}
	private static void startExploring() {
		while(true){
			System.out.println(inventory.getDescription());
			System.out.println(currentRoom.getDescription());
			System.out.println("What would you like to do?");
			String input = in.nextLine();
			currentRoom.interpretInput(input);
		}
	}
	public static void print(String string) {
		System.out.println(string);
	}
}

