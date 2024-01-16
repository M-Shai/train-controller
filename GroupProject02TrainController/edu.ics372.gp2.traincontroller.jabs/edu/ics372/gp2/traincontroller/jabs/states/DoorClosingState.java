package edu.ics372.gp2.traincontroller.jabs.states;

import edu.ics372.gp2.traincontroller.jabs.timer.Notifiable;
import edu.ics372.gp2.traincontroller.jabs.timer.Timer;

/**
 * @author Banji, Say, Jeffrey, Abshir 
 * Represents door closing state
 * 5 sec Timer, DoorObstructionSignal event
 * 
 * Updated 4/11/23
 */
public class DoorClosingState extends TrainState implements Notifiable {
	private static final int FIVESECONDS = 5;
	private static DoorClosingState instance;
	private Timer timer;

	/**
	 * Private for the singleton pattern
	 */
	private DoorClosingState() {
	}//End constructor

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static DoorClosingState getInstance() {
		if (instance == null) {
			instance = new DoorClosingState();
		}
		return instance;
	}//End getInstance

	/**
	 * Process DoorClosing request
	 */
	@Override
	public void onDoorClosing() {
		//System.out.println("DoorClosingState.onDoorClosing()");
		timer.addTimeValue(FIVESECONDS);
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue() + " sec");
	}//End onDoorClosing

	/**
	 * Process Door Obstruction request
	 */
	@Override
	public void onDoorObstructedSignal() {
		int timeValue = timer.getTimeValue();
		//System.out.println("*************DoorClosingState.onDoorDoorObstructedState()****************");
		//System.out.println("FIVESECONDS = " + FIVESECONDS);
		//System.out.println("timeValue = " + timeValue);
		//System.out.println("4/5 = " + (.8));
		double timeToReopen = (FIVESECONDS - timeValue) * (.8);
		//System.out.println("timeToReopen = " + timeToReopen);
		TrainContext.getInstance().changeState(DoorReopeningState.getInstance((int)timeToReopen));
	} //End onDoorObstructedSignal
	
	/**
	 * Process clock tick event
	 * @param int timerValue
	 */
	@Override
	public void onTimerTick(int timerValue) {
		//System.out.println("DoorClosingState.onTimerTick() timerValue = " + timerValue);
		//TrainContext.getInstance().showTimeLeft(timerValue + " sec");
		TrainContext.getInstance().showDoorClosing(timer.getTimeValue() + " secs");
	} //End onTimerTick

	/**
	 * Process the timer runs out event
	 */
	@Override
	public void onTimerRunsOut() {
		//System.out.println("DoorClosingState.onTimeRunsOut()");
		//TrainContext.getInstance().showTimeLeft(0 + " sec");
		TrainContext.getInstance().showDoorClosing(timer.getTimeValue() + " secs");
		TrainContext.getInstance().changeState(DoorClosedState.getInstance());
	} //End onTimerRunsOut

	/**
	 * Initializes the state 
	 * Initialize 5 sec Timer
	 * Adds itself as a listener to managers Updates the
	 * displays
	 * 
	 */
	@Override
	public void enter() {
		//System.out.println("DoorClosingState.enter()");
		timer = new Timer(this, FIVESECONDS);
		TrainContext.getInstance().showDoorClosing(timer.getTimeValue() + " secs");
		//TrainContext.getInstance().showTimeLeft(timer.getTimeValue() + " sec");
	} //End enter

	/**
	 * Exit this state
	 * Reset timer
	 */
	@Override
	public void leave() {
		//System.out.println("DoorClosingState.leave()");
		timer.stop();
		timer = null;
		//TrainContext.getInstance().showTimeLeft(0 + " sec");
	} //End leave
} //End class DoorClosingState
