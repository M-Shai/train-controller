package edu.ics372.gp2.traincontroller.jabs.states;

import edu.ics372.gp2.traincontroller.jabs.timer.Notifiable;
import edu.ics372.gp2.traincontroller.jabs.timer.Timer;

/**
 * @author Banji, Say, Jeffrey, Abshir 
 * Represents Accelerate State
 * 6sec Timer event, ApproachSignalButton Event
 * 
 * Updated 4/26/23
 */
public class AccelerateState extends TrainState implements Notifiable {
	private static final int SIXSECONDS = 6;
	private static AccelerateState instance;
	private Timer timer;

	/**
	 * Private for the singleton pattern
	 */
	private AccelerateState() {
	}//End constructor

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static AccelerateState getInstance() {
		if (instance == null) {
			instance = new AccelerateState();
		}
		return instance;
	}//End getInstance

	/**
	 * Initiate acceleration
	 */
	@Override
	public void onAccelerate() {
		timer = new Timer(this, SIXSECONDS);
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue() + " secs");
	}//End onAccelerate

	/**
	 * Process approach signal
	 * Transitions to DecelerateState
	 */
	@Override
	public void onApproachSignal() {
		TrainContext.getInstance().changeState(DecelerateState.getInstance());
	}//End onApproachSignal

	/**
	 * Process clock tick event
	 * @param int timerValue
	 */
	@Override
	public void onTimerTick(int timerValue) {
		TrainContext.getInstance().showAccelerating(timer.getTimeValue() + " secs");
	}//End onTimerTick

	/**
	 * Process the timer runs out event
	 * Transition to FullSpeedState
	 */
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().showAccelerating(timer.getTimeValue() + " secs");
		TrainContext.getInstance().changeState(FullSpeedState.getInstance());
	}//End onTimerRunsOut

	/**
	 * Initializes the state 
	 * Initialize a 6 sec timer
	 * Adds itself as a listener to managers Updates the
	 * displays
	 * 
	 */
	@Override
	public void enter() {
		timer = new Timer(this, SIXSECONDS);
		TrainContext.getInstance().showAccelerating(timer.getTimeValue() + " secs");
	}//End enter
	
	/**
	 * Exits this state
	 * resets timer
	 */
	@Override
	public void leave() {
		timer.stop();
		timer = null;
		TrainContext.getInstance().showTimeLeft(0 + " ");
	}//End leave
}//End Class AccelerateState
