package edu.ics372.gp2.traincontroller.jabs.states;

import edu.ics372.gp2.traincontroller.jabs.display.TrainControllerGUI;

/**
 * @author Banji, Say, Jeffrey, Abshir 
 * The context is an observer for the clock and stores the
 * context info for states which need the clock and implement
 * Notifiable.
 * 
 * The states which need TrainContext are Accelerate DoorOpening
 * DoorReOpening DoorReOpen DoorOpen DoorClosed DoorClosingState Stop
 * 
 * Updated 4/26/23
 */
public class TrainContext {
	private TrainControllerGUI display;
	private TrainState currentState;
	private static TrainContext instance;

	/**
	 * Make it a singleton
	 */
	private TrainContext() {
		instance = this;
		currentState = AccelerateState.getInstance();
	}//End constructor

	/**
	 * Return the instance
	 * 
	 * @return the object
	 */
	public static TrainContext getInstance() {
		if (instance == null) {
			instance = new TrainContext();
		}
		return instance;
	}//End getInstance

	/**
	 * The display could change. So we have to get its reference.
	 * 
	 * @param display The current display object
	 */
	public void setDisplay(TrainControllerGUI display) {
		this.display = display;
	}//End setDisplay

	/**
	 * Lets door closed state be the starting state 
	 * adds the object as an observable
	 * for clock
	 */
	public void initialize() {
		currentState = DoorClosedState.getInstance();
		TrainContext.getInstance().showDoorClosed(" ");
		display.disableStartButton();
		currentState.enter();
	}//End Initialize

	/**
	 * Called from the states to change the current state
	 * 
	 * @param nextState the next state
	 */
	public void changeState(TrainState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	} //End changeState

    /**
	 * The onRequest methods 
	 * switch context to the next state
	 */
	public void onAccelerateRequest() {
		currentState.onAccelerate();
	} //End onAccelerateRequest
	
	public void onStopRequest() {
		currentState.onStopped();
	} //End onStopRequest

	public void onDoorOpeningRequest() {
		currentState.onDoorOpening();
	} //End onDoorOpeningRequest

	public void onDoorOpenRequest() {
		currentState.onDoorOpen();
	}//End onDoorOpenRequest

	public void onDoorReopenRequest() {
		currentState.onDoorReopen();
	}//End onDoorReopenRequest

	public void onDoorReOpeningRequest() {
		currentState.onDoorReopening();
	}//End onDoorReopeningRequest

	public void onDoorClosingRequest() {
		currentState.onDoorClosing();
	}//End onDoorClosingRequest

	public void onDoorClosedRequest() {
		currentState.onDoorReopen();
	}//End onDoorClosedRequest

	/**
	 * show time left
	 * @param String time left
	 */
	public void showTimeLeft(String time) {
		display.showTimeLeft(time);
	}//End showTimeLeft

	
	/**
	 * show accelerating 
	 * @param String value
	 */
	public void showAccelerating(String value) {
		display.showAccelerating(value);
	}//End showAccelerating
	
	/**
	 * show full speed
	 */
	public void showFullSpeed() {
		display.showFullSpeed();
	}//End showFullSpeed
	
	/**
	 * show decelerating
	 */
	public void showDecelerating() {
		display.showDecelerating();
	}//End showDecelerating

	/**
	 * public void showDoorClosing
	 * @param String time value
	 */
	public void showDoorClosing(String value) {
		display.showDoorClosing(value);
	}
	
	/**
	 * show door opening
	 * @param String time value
	 */
	public void showDoorOpening(String value) {
		display.showDoorOpening(value);
	}//End showDoorOpening
	
	/**
	 * show door re-opening
	 * @param String time value
	 */
	public void showDoorReopening(String value) {
		display.showDoorReopening(value);
	}//End showDoorReopening
	
	/**
	 * show door re-open
	 * @param String time value
	 */
	public void showDoorReopen(String value) {
		display.showDoorReopen(value);
	}//End showDoorReopen
	
	/**
	 * show door opened
	 * @param String time value
	 */
	public void showDoorOpened(String value) {
		display.showDoorOpened(value);
	}//End showDoorOpened
	
	/**
	 * show door closed
	 * @param String time value
	 */
	public void showDoorClosed(String value) {
		display.showDoorClosed(value);
	}//End showDoorClosed
	
	/**
	 * show approaching
	 */
	public void approachSignalRequest() {
		currentState.onApproachSignal();
		// display.approachSignalRequest();
	}//End approachSignalRequest
	
	/**
	 * show arrival
	 */
	public void arriveSignalRequest() {
		currentState.onArriveSignal();
		// display.arriveSignalRequest();
	}
	/**
	 * show door obstruction
	 */
	public void doorObstructionRequest() {
		currentState.onDoorObstructedSignal();
		// display.doorObstructionRequest();
	}
	
	/**
	 * show train stopped
	 * @param String time value
	 */
	public void showStopped(String value) {
		display.showStopped(value);
	}//End showStopped
} //End class TrainContext
