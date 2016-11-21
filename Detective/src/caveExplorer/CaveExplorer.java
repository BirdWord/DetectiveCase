package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {
	public static CaveRoom caves[][];
	public static Scanner in = new Scanner(System.in);
	public static CaveRoom currentRoom;
	public static Inventory inventory;
	public static Door[] lockedDoors = {new Door(true, false, "locked door", ""), new Door(true, false, "locked door", ""), new Door(true, false, "locked door", "")};
	public static boolean alive;
	public static void main(String args[]){
		caves = new CaveRoom[5][10];
		for(int i = 0; i<caves.length; i++){
			for(int j = 0; j<caves[0].length; j++){
				caves[i][j] = new CaveRoom("This room has coordinates ("+i+","+j+").");
			}
		}
		inventory = new Inventory();
		//caves[2][0] = new EventRoom("There is a nice police officer outside of a vast, abandoned mansion.", new GameStartEvent());
		int rand1 = generateNumber(1,4);
		switch(rand1){
		case 1: caves[0][1] = new EventRoom("   You picked up the red key from the ground.", new packageKristyandRay.FoundLivingRoomKey());break;
		case 2: caves[0][2] = new EventRoom("   You picked up the red key from the ground.", new packageKristyandRay.FoundLivingRoomKey());break;
		case 3: caves[0][3] = new EventRoom("   You picked up the red key from the ground.", new packageKristyandRay.FoundLivingRoomKey());break;
		case 4: caves[2][3] = new EventRoom("   You picked up the red key from the ground.", new packageKristyandRay.FoundLivingRoomKey());break;
		}
		caves[1][5] = new EventRoom("   You picked up the blue key from the ground.", new DavidAndKristy.FoundKitchenKey());
		int rand3 = generateNumber(1,2);
		switch(rand3){
		case 1: caves[1][7] = new EventRoom("   You picked up the white key from the ground.", new Hunter_Jonathan.FoundBathRoomKey());break;
		case 2: caves[1][8] = new EventRoom("   You picked up the white key from the ground.", new Hunter_Jonathan.FoundBathRoomKey());break;
		}
		//when stuff is done hide more keys
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
				caves[4][3].setConnection(CaveRoom.WEST, caves[4][2], new Door());
				caves[4][3].setConnection(CaveRoom.EAST, caves[4][4], lockedDoors[0]);
			}
			if(inventory.hasKitchenKey()){
				caves[0][6] = new EventRoom("   You stuck the blue key into the keyhole and opened the door.", new DavidAndKristy.EventDavidAndKristy());
				caves[0][6].setConnection(CaveRoom.WEST, caves[0][5], new Door());
				caves[0][6].setConnection(CaveRoom.SOUTH, caves[1][6], new Door());
				caves[0][7].setConnection(CaveRoom.EAST, caves[4][4], lockedDoors[1]);
			}
			if(inventory.hasBathroomKey()){
				caves[0][6] = new EventRoom("   You stuck the white key into the keyhole and opened the door.", new Hunter_Jonathan.EventHunterAndJonathan());
				caves[0][6].setConnection(CaveRoom.WEST, caves[0][5], new Door());
				caves[0][6].setConnection(CaveRoom.SOUTH, caves[1][6], new Door());
				caves[0][7].setConnection(CaveRoom.EAST, caves[4][4], lockedDoors[1]);
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
		Door lockedDoor = new Door(true, false, "locked door", "");
		caves[0][0].setConnection(CaveRoom.SOUTH, caves[1][0], new Door());
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
		caves[4][3].setConnection(CaveRoom.EAST, caves[4][4], lockedDoor);
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
		caves[0][6].setConnection(CaveRoom.EAST, caves[0][7], lockedDoor);
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
		caves[4][9].setConnection(CaveRoom.NORTH, caves[3][9], lockedDoor);
		caves[3][9] = new EventRoom("This is the final encounter...", new FinalRoom());
		caves[3][9].setConnection(CaveRoom.SOUTH, caves[4][9], lockedDoor);
	}
	private static int generateNumber(int low, int high){
		return (int)(Math.random()*(high-low+1))+low;
	}
}

