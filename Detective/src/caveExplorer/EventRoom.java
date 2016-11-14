package caveExplorer;

public class EventRoom extends CaveRoom {
	
	private Event event;
	private boolean eventOccurred;

	public EventRoom(String description, Event event) {
		super(description);
		eventOccurred = false;
		this.event = event;
		// TODO Auto-generated constructor stub
	}
	public void enter(){
		super.enter();
		if(!eventOccurred){
			eventOccurred = true;
			event.play();
		}
	}
}
