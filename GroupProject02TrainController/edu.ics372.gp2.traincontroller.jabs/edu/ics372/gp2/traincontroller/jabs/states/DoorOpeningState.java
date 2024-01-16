package edu.ics372.gp2.traincontroller.jabs.states;

import edu.ics372.gp2.traincontroller.jabs.timer.Notifiable;
import edu.ics372.gp2.traincontroller.jabs.timer.Timer;

/**
 * @author Banji, Say, Jeffrey, Abshir 
 * Represent Door Opening State
 * 4 sec Timer event
 * 
 * Updated 4/26/23
 */
public class DoorOpeningState extends TrainState implements Notifiable {
	private static final int FOURSECONDS = 4;
	private static DoorOpeningState instance;
	private Timer timer;

	/**
	 * Private for the singleton pattern
	 */
	private DoorOpeningState() {
	}//End constructor

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static DoorOpeningState getInstance() {
		if (instance == null) {
			instance = new DoorOpeningState();
		}
		return instance;
	}//End getInstance

	/**
	 * Process onDoorOpening request
	 */
	@Override
	public void onDoorOpening() {
		timer.addTimeValue(FOURSECONDS);
		TrainContext.getInstance().showDoorOpening(timer.getTimeValue() + " secs");
	} //End onDoorOpening

	/**
	 * Process clock tick event
	 * @param int timerValue
	 */
	@Override
	public void onTimerTick(int timerValue) {
		TrainContext.getInstance().showDoorOpening(timer.getTimeValue() + " secs");
	} //End onTimerTick

	/**
	 * Process the timer runs out event
	 */
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().showDoorOpening(timer.getTimeValue() + " secs");
		TrainContext.getInstance().changeState(DoorOpenState.getInstance());
	} //End onTimerRunsOut

	/**
	 * Initializes the state 
	 * Initialize a 4 sec Timer
	 * Adds itself as a listener to managers Updates the
	 * displays
	 */
	@Override
	public void enter() {
		timer = new Timer(this, FOURSECONDS);
		TrainContext.getInstance().showDoorOpening(timer.getTimeValue() + " secs");
	} //End enter

	/**
	 * Exit this state
	 * Resets Timer
	 */
	@Override
	public void leave() {
		timer.stop();
		timer = null;
	} //End leave
} //End class DoorOpeningState