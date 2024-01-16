package edu.ics372.gp2.traincontroller.jabs.states;

import edu.ics372.gp2.traincontroller.jabs.timer.Notifiable;
import edu.ics372.gp2.traincontroller.jabs.timer.Timer;

/**
 * @author Banji, Say, Jeffrey, Abshir 
 * Represents door closed state
 * 3 sec timer
 * 
 * Updated 4/13/23
 */
public class DoorClosedState extends TrainState implements Notifiable {
	private static final int THREESECONDS = 3;
	private static DoorClosedState instance;
	private Timer timer;
	/**
	 * Private constructor for the singleton pattern
	 */
	private DoorClosedState() {
	} //End constructor

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static DoorClosedState getInstance() {
		if (instance == null) {
			instance = new DoorClosedState();
		}
		return instance;
	} //End getInstance

	/**
	 * Process clock tick event
	 * @param int time
	 */
	@Override
	public void onTimerTick(int timerValue) {
		//System.out.println("DoorClosedState onTimerTick() : timerValue = " + timerValue);
		//TrainContext.getInstance().showTimeLeft(timerValue + " sec");
		TrainContext.getInstance().showDoorClosed(timer.getTimeValue() + " secs");
		//System.out.println("DoorClosedState onTimerTick() line 42");
	} //End onTimerTick

	/**
	 * Process the timer runs out event
	 */
	@Override
	public void onTimerRunsOut() {
		//System.out.println("DoorClosedState onTimerRunsOut() timer.getValue() = " + timer.getTimeValue());
		//TrainContext.getInstance().showTimeLeft(0 + " sec");
		TrainContext.getInstance().showDoorClosed(timer.getTimeValue() + " secs");
		TrainContext.getInstance().changeState(AccelerateState.getInstance());
	} //End onTimerRunsOut

	/**
	 * Process onDoorClosed request
	 */
	@Override
	public void onDoorClosed() {
		timer.addTimeValue(THREESECONDS);
		//TrainContext.getInstance().showTimeLeft(timer.getTimeValue() + " sec");
		TrainContext.getInstance().showDoorClosed(timer.getTimeValue() + " secs");
	} //End onDoorClosed

	/**
	 * Initialize the state
	 * Initializes 3 sec timer
	 * Update display
	 */
	@Override
	public void enter() {
		//System.out.println("DoorClosedState enter() i.timer = " + THREESECONDS);
		timer = new Timer(this, THREESECONDS);
		//System.out.println("DoorClosedState enter() timer.getValue() = " + timer.getTimeValue());
		TrainContext.getInstance().showDoorClosed(timer.getTimeValue() + " secs");
		//TrainContext.getInstance().showTimeLeft(timer.getTimeValue() + " sec");
	} //End enter

	/**
	 * Exit state
	 * Reset timer
	 */
	@Override
	public void leave() {
		//System.out.println("DoorClosedState leave()");
		timer.stop();
		timer = null;
		//TrainContext.getInstance().showTimeLeft(0 + " sec");
	} //End leave
} //End class DoorClosedState