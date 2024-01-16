package edu.ics372.gp2.traincontroller.jabs.states;

import edu.ics372.gp2.traincontroller.jabs.timer.Notifiable;
import edu.ics372.gp2.traincontroller.jabs.timer.Timer;

/**
 * @author Banji, Say, Jeffrey, Abshir 
 * Represents Door Re-Opening State
 * 8 sec Timer
 * 
 * Updated 4/26/23
 */
public class DoorReopeningState extends TrainState implements Notifiable {
	private static int timeValue;
	private static DoorReopeningState instance;
	private Timer timer;

	/**
	 * Private for the singleton pattern
	 */
	private DoorReopeningState() {
	}//End constructor

	/**
	 * For singleton
	 * @param int time value
	 * @return the object
	 */
	public static DoorReopeningState getInstance(int time) {
		if (instance == null) {
			instance = new DoorReopeningState();
		}
		timeValue = time;
		return instance;
	} //End getInstance

	/**
	 * Process onDoorReopening request
	 */
	@Override
	public void onDoorReopening() {
		timer.addTimeValue(timeValue);
		TrainContext.getInstance().showDoorReopening(timer.getTimeValue() + " secs");
	} //End onDoorReopening

	/**
	 * Process clock tick event
	 * @param int timerValue
	 */
	@Override
	public void onTimerTick(int timerValue) {
		TrainContext.getInstance().showDoorReopening(timer.getTimeValue() + " secs");
	} //End onTimerTick

	/**
	 * Process the timer runs out event
	 * Transition to DoorReopeningState
	 */
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().showDoorReopening(timer.getTimeValue() + " secs");
		TrainContext.getInstance().changeState(DoorReopenState.getInstance());
	} //End onTimerRunsOut

	/**
	 * Initializes the state 
	 * Initialize Timer
	 * Adds itself as a listener to managers Updates the
	 * displays
	 */
	@Override
	public void enter() {
		timer = new Timer(this, timeValue);
		TrainContext.getInstance().showDoorReopening(timer.getTimeValue() + " secs");
	} //End enter

	/**
	 * Exit state
	 * Reset Timer
	 */
	@Override
	public void leave() {
		timer.stop();
		timer = null;
	} //End leave
} //End class DoorReopeningState
