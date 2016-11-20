package caveExplorer;

public class Inventory {
	private boolean hasMap;
	private String map;
	private boolean hasLivingRoomKey;
	private boolean hasKitchenKey;
	private boolean hasBathroomKey;
	public Inventory(){
		hasMap = false;
		hasLivingRoomKey = false;
		hasKitchenKey = false;
		hasBathroomKey = false;
	}
	public void setLivingRoomKey(boolean b){
		hasLivingRoomKey=true;
	}
	public void setKitchenKey(boolean b){
		hasKitchenKey=true;
	}
	public void setBathroomKey(boolean b){
		hasBathroomKey=true;
	}
	public boolean isHasMap() {
		return hasMap;
	}
	public void setHasMap(boolean hasMap) {
		this.hasMap = hasMap;
		updateMap();
	}
	public String getDescription(){
		if(hasMap)
			return map;
		return "There is nothing in your inventory.";
	}
	public void updateMap(){
		map = " ";
		for(int i = 0; i<CaveExplorer.caves[0].length-1; i++){
			map+= "____";
		}
		map+="___\n";
		for(CaveRoom[] row: CaveExplorer.caves){
			for(int i = 0; i<3;i++){
				String text = "";
				for(CaveRoom cr: row){
					if(cr.getDoor(CaveRoom.WEST) != null && cr.getDoor(CaveRoom.WEST).isOpen()){
						text += " ";
					}
					else if(cr.getDoor(CaveRoom.WEST) != null && cr.getDoor(CaveRoom.WEST).isLocked()){
						text += "е";
					}
					else{
						text+="|";
					}
					if(i == 0){
						text+="   ";
					}
					else if(i == 1){
						text+=" "+cr.getContents()+" ";
					}
					else if(i == 2){
						if(cr.getDoor(CaveRoom.SOUTH) != null && cr.getDoor(CaveRoom.SOUTH).isOpen()){
							text+="   ";
						}
						else if(cr.getDoor(CaveRoom.SOUTH) != null && cr.getDoor(CaveRoom.SOUTH).isLocked()){
							text += "еее";
						}
						else{
							text+="___";
						}
					}
					
				}
				text+="|";
				map+=text+"\n";
			}
		}
	}
}
