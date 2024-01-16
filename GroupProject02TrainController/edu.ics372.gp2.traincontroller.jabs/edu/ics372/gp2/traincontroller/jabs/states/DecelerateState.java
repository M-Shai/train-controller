package edu.ics372.gp2.traincontroller.jabs.states;

/**
 * @author Banji, Say, Jeffrey, Abshir 
 * Represents the decelerate state.
 *
 * Update 4/13/23
 */
public class DecelerateState extends TrainState {
	private static DecelerateState instance;

	/**
	 * Private for the singleton pattern
	 */
	private DecelerateState() {
	} //End constructor

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static DecelerateState getInstance() {
		if (instance == null) {
			instance = new DecelerateState();
		}
		return instance;
	} //End getInstance

	/**
	 * Process onArriveSignal request
	 */
	@Override
	public void onArriveSignal() {
		//System.out.println("DecelerateState.onArriveSignal()");
		TrainContext.getInstance().changeState(StopState.getInstance());
	} //End onArriveSignal

	/**
	 * Initializes the state 
	 * Adds itself as a listener to managers Updates the
	 * displays
	 */
	@Override
	public void enter() {
		//System.out.println("DecelerateState.enter()");
		TrainContext.getInstance().showDecelerating();
		//TrainContext.getInstance().showTimeLeft(" ");
	} //End enter

	/**
	 * Exit state
	 * Reset timer
	 */
	@Override
	public void leave() {
		//System.out.println("DecelerateState.leave()");
		//TrainContext.getInstance().showStopped();
	} //Exit leave
} //Exit class DecelerateState