package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {
	public static CaveRoom caves[][];
	public static Scanner in = new Scanner(System.in);
	public static CaveRoom currentRoom;
	public static Inventory inventory;
	public static boolean alive;
	public static void main(String args[]){
		caves = new CaveRoom[5][10];
		for(int i = 0; i<caves.length; i++){
			for(int j = 0; j<caves[0].length; j++){
				caves[i][j] = new CaveRoom("This room has coordinates ("+i+","+j+").");
			}
		}
		inventory = new Inventory();
		//caves[2][0] = new EventRoom("There is a nice police officer outside of a vast, abandonned mansion.", new GameStartEvent());
		int rand1 = generateNumber(1,4);
		switch(rand1){
		case 1: caves[0][1] = new EventRoom("   You picked up the red key from the ground.", new packageKristyandRay.FoundLivingRoomKey());break;
		case 2: caves[0][2] = new EventRoom("   You picked up the red key from the ground.", new packageKristyandRay.FoundLivingRoomKey());break;
		case 3: caves[0][3] = new EventRoom("   You picked up the red key from the ground.", new packageKristyandRay.FoundLivingRoomKey());break;
		case 4: caves[2][3] = new EventRoom("   You picked up the red key from the ground.", new packageKristyandRay.FoundLivingRoomKey());break;
		}
		
		implementConnections();
		currentRoom = caves[2][0];
		currentRoom.enter();
		inventory.setHasMap(true);
		startExploring();
	}
	private static void startExploring() {
		alive = true;
		while(alive){
			if(inventory.hasLivingRoomKey()){
				caves[4][3] = new EventRoom("   You stuck the red key into the keyhole and opened the door.", new packageKristyandRay.Connect4());
				implementConnections();
			}
			print(currentRoom.getDescription());
			print(inventory.getDescription());
			print("Which way would you like to go?");
			String input = in.nextLine();
			currentRoom.interpretInput(input);
		}
	}
	public static void print(String string) {
		System.out.println(string);
	}
	public static void implementConnections(){
		caves[0][0].setConnection(CaveRoom.SOUTH, caves[0][1], new Door());
		caves[3][0].setConnection(CaveRoom.SOUTH, caves[3][1], new Door());
		caves[2][0].setConnection(CaveRoom.EAST, caves[2][1], new Door());
		caves[2][2].setConnection(CaveRoom.NORTH, caves[1][2], new Door());
		caves[3][1].setConnection(CaveRoom.SOUTH, caves[4][1], new Door());
		for(int i = 1; i< 4; i++){
			caves[2][i].setConnection(CaveRoom.SOUTH, caves[3][i], new Door());
			caves[0][i].setConnection(CaveRoom.SOUTH, caves[1][i], new Door());
		}
		for(int i = 1; i<3; i++){
			caves[3][i].setConnection(CaveRoom.EAST, caves[3][i+1], new Door());
			caves[1][i].setConnection(CaveRoom.EAST, caves[1][i+1], new Door());
			caves[4][i].setConnection(CaveRoom.EAST, caves[4][i+1], new Door());
		}
		caves[4][3].setConnection(CaveRoom.EAST, caves[4][4], new Door(true, false, "locked door", ""));
		caves[4][4].setConnection(CaveRoom.NORTH, caves[3][4], new Door());
		caves[3][4].setConnection(CaveRoom.NORTH, caves[2][4], new Door());
		caves[2][4].setConnection(CaveRoom.NORTH, caves[1][4], new Door());
		caves[1][4].setConnection(CaveRoom.NORTH, caves[0][4], new Door());
		caves[0][4].setConnection(CaveRoom.EAST, caves[0][5], new Door());
		caves[0][5].setConnection(CaveRoom.EAST, caves[0][6], new Door());
		caves[0][6].setConnection(CaveRoom.SOUTH, caves[1][6], new Door());
		caves[1][6].setConnection(CaveRoom.SOUTH, caves[2][6], new Door());
		caves[2][6].setConnection(CaveRoom.SOUTH, caves[3][6], new Door());
		caves[3][6].setConnection(CaveRoom.SOUTH, caves[4][6], new Door());
		caves[4][6].setConnection(CaveRoom.WEST, caves[4][5], new Door());
		caves[4][5].setConnection(CaveRoom.NORTH, caves[3][5], new Door());
		caves[3][5].setConnection(CaveRoom.NORTH, caves[2][5], new Door());
		caves[2][5].setConnection(CaveRoom.NORTH, caves[1][5], new Door());
		caves[0][6].setConnection(CaveRoom.EAST, caves[0][7], new Door(true, false, "locked door", ""));
		caves[0][7].setConnection(CaveRoom.EAST, caves[0][8], new Door());
		caves[0][8].setConnection(CaveRoom.EAST, caves[0][9], new Door());
		caves[0][9].setConnection(CaveRoom.SOUTH, caves[1][9], new Door());
		caves[1][9].setConnection(CaveRoom.WEST, caves[1][8], new Door());
		caves[1][8].setConnection(CaveRoom.WEST, caves[1][7], new Door());
		caves[1][7].setConnection(CaveRoom.SOUTH, caves[2][7], new Door());
		caves[2][7].setConnection(CaveRoom.EAST, caves[2][8], new Door());
		caves[2][8].setConnection(CaveRoom.EAST, caves[2][9], new Door());
		caves[2][8].setConnection(CaveRoom.SOUTH, caves[3][8], new Door());
		caves[3][8].setConnection(CaveRoom.WEST, caves[3][7], new Door());
		caves[3][7].setConnection(CaveRoom.SOUTH, caves[4][7], new Door());
		caves[4][7].setConnection(CaveRoom.EAST, caves[4][8], new Door());
		caves[4][8].setConnection(CaveRoom.EAST, caves[4][9], new Door());
		caves[4][9].setConnection(CaveRoom.NORTH, caves[3][9], new Door(true, false, "locked door", ""));
	}
	private static int generateNumber(int low, int high){
		return (int)(Math.random()*(high-low+1))+low;
	}
}

