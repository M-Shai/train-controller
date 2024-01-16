package edu.ics372.gp2.traincontroller.jabs.states;

import edu.ics372.gp2.traincontroller.jabs.timer.Notifiable;
import edu.ics372.gp2.traincontroller.jabs.timer.Timer;

/**
 * @author Banji, Say, Jeffrey, Abshir 
 * Represents Door Re-Open State
 * 8 sec Timer
 * 
 * Updated 4/26/23
 */
public class DoorReopenState extends TrainState implements Notifiable {
	private static final int EIGHTSECONDS = 8;
	private static DoorReopenState instance;
	private Timer timer;

	/**
	 * Private for the singleton pattern
	 */
	private DoorReopenState() {
	}//End Constructor

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static DoorReopenState getInstance() {
		if (instance == null) {
			instance = new DoorReopenState();
		}
		return instance;
	}//End getInstance

	/**
	 * Process DoorReopen request
	 */
	@Override
	public void onDoorReopen() {
		timer.addTimeValue(EIGHTSECONDS);
		TrainContext.getInstance().showDoorReopen(timer.getTimeValue() + " secs");
	} //End onDoorReopen
	
	/**
	 * Process clock tick event
	 * @param int timerValue
	 */
	@Override
	public void onTimerTick(int timerValue) {
		TrainContext.getInstance().showDoorReopen(timer.getTimeValue() + " secs");
	} //End onTimerTick

	/**
	 * Process the timer runs out event
	 * Transition to DoorClosingState
	 */
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().showDoorReopen(timer.getTimeValue() + " secs");
		TrainContext.getInstance().changeState(DoorClosingState.getInstance());
	} //End onTimerRunsOut

	/**
	 * Initializes the state
	 * Initialize 8 sec Timer 
	 * Adds itself as a listener to managers Updates the
	 * displays
	 * 
	 */
	@Override
	public void enter() {
		timer = new Timer(this, EIGHTSECONDS);
		TrainContext.getInstance().showDoorReopen(timer.getTimeValue() + " secs");
	} //End enter
	
	/**
	 * Exit this state
	 * Reset Timer
	 */
	@Override
	public void leave() {
		timer.stop();
		timer = null;
	} //End leave
} //End class DoorReopenState
