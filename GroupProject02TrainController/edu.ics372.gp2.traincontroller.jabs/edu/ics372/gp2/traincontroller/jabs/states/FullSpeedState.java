package edu.ics372.gp2.traincontroller.jabs.states;

/**
 * @author Banji, Say, Jeffrey, Abshir 
 * Represents the full speed state.
 * ApproachSinalButton event
 * 
 * Updated 4/26/23
 */
public class FullSpeedState extends TrainState {
  private static FullSpeedState instance;

  /**
   * Private for the singleton pattern
   */
  private FullSpeedState() {
  } //End constructor

  /**
   * For singleton
   * 
   * @return the object
   */
  public static FullSpeedState getInstance() {
    if (instance == null) {
      instance = new FullSpeedState();
    }
    return instance;
  } //End getInstance

  /**
   * Process onApproach request
   * Transition to DecelerateState
   */
  @Override
  public void onApproachSignal () {
    TrainContext.getInstance().changeState(DecelerateState.getInstance());
  }//End onApproachSignal

  /**
   * Initializes the state 
   * Adds itself as a listener to managers Updates the
   * displays
   * 
   */
  @Override
  public void enter() {
    TrainContext.getInstance().showFullSpeed();
  }//End enter

  /**
   * Exit state
   * reset timer
   */
  @Override
  public void leave() {
	  //System.out.println("FullSpeedState.leave()");
  }//End leave
}//End class FullSpeedState
