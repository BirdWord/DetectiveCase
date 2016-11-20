package caveExplorer;

public class Door {
	private boolean locked;
	private boolean open;
	private String description;
	private String details;
	public Door(){
		locked = false;
		open = true;
		description = "room";
		details = "";
	}
	public Door(boolean locked, boolean open, String description, String details){
		this.locked = locked;
		this.open = open;
		this.description = description;
		this.details = details;
	}
	public void setLocked(boolean b){
		locked = b;
	}
	public boolean isLocked(){
		return locked;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public void setOpened(boolean b){
		open = b;
	}
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}
	public String getDetails() {
		// TODO Auto-generated method stub
		return details;
	}
}
