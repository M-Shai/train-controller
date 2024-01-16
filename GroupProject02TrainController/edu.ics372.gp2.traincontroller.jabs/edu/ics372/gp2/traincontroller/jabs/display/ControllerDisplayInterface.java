package edu.ics372.gp2.traincontroller.jabs.display;

/**
 * @author Banji, Say, Jeffrey, Abshir
 * 
 * Specifies what the display system should do. Note that the implementation has
 * a lot of freedom to choose its display.
 * 
 * Updated 4/26/23
 */
public interface ControllerDisplayInterface {
	
	/**
	 * Displays time remaining
	 * 
	 * @param String remaining time
	 */
	public void showTimeLeft(String time);

	/**
	 * Indicate that the door is now closed
	 */
	public void showDoorClosed(String time);
	
	/**
	 * Indicate that the door is opening
	 */
	public void showDoorOpening(String time);

	/**
	 * Indicate that the door is now open
	 */
	public void showDoorOpened(String time);
	
	/**
	 * Indicate that the door is closing
	 */
	public void showDoorClosing(String time);
	
	/**
	 * Indicate that the door is reopening
	 */
	public void showDoorReopening (String time);
	
	/**
	 * Indicate that the door is reopened
	 */
	public void showDoorReopen (String time);
	
	/**
	 * Indicate that train is accelerating
	 */
	public void showAccelerating (String time);
	
	/**
	 * Indicate that train is at full speed
	 */
	public void showFullSpeed ();
	
	/**
	 * Indicate that train is decelerating
	 */
	public void showDecelerating ();
	
	/**
	 * Indicate that train is stopped
	 */
	public void showStopped (String time);
}//End Interface ControllerDisplayInterface