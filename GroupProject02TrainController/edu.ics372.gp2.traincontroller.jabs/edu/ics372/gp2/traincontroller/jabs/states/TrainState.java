package edu.ics372.gp2.traincontroller.jabs.states;

/**
 * @author Banji, Say, Jeffrey, Abshir 
 * Super class for all states
 * 
 * Updated 4/26/23
 */
public abstract class TrainState {

  /**
   * Initializes the state
   */
  public abstract void enter();

  /**
   * Performs any necessary clean up while leaving the state
   */
  public abstract void leave();
  
  //----------- State Invokers ----------------

  /**
   * Process accelerate request
   */
  public void onAccelerate () {

  }
  
  /**
   * Process full speed request
   */
  public void onFullSpeed () {

  }

  /**
   * Process decelerate request
   */
  public void onDecelerate () {

  }

  /**
   * Process stop request
   */
  public void onStopped () {

  }
  
  /**
   * Process door open request
   */
  public void onDoorOpen () {

  }
  
  /**
   * Process door open request
   */
  public void onDoorOpening () {

  }
  
  /**
   * Process door closing request
   */
  public void onDoorClosing () {

  }
  
  /**
   * Process door reopening request
   */
  public void onDoorReopening () {

  }
  
  /**
   * Process door reopen request
   */
  public void onDoorReopen () {

  }
  
  /**
   * Process door closed request
   */
  public void onDoorClosed () {

  }
  
  //----------- Asynchronous Events ----------------
  
  /**
   * Process approach signal event fires
   */
  public void onApproachSignal () {
	  
  }
  
  /**
   * Process arrive signal event fires
   */
  public void onArriveSignal () {
	  
  }
  
  /**
   * Process door obstructed signal event fires
   */
  public void onDoorObstructedSignal () {
	  
  }
  
  //----------- Synchronous Events ----------------
  
  /**
   * Process obstructed timer event
   */
  public void obstructedTimer () {
	  
  }
  
  /**
   * Process reopen timer event
   */
  public void onReopenTimer () {
	  
  }
  
  /**
   * Process closing timer event
   */
  public void onClosingTimer () {
	  
  }
  
  /**
   * Process open timer event
   */
  public void onOpenTimer () {
	  
  }
  
  /**
   * Process closing timer event
   */
  public void onOpeningTimer () {
	  
  }
  
  /**
   * Process stop timer event
   */
  public void onStopTimer () {
	  
  }
  
  //----------- Clock Methods ----------------

  /**
   * Process clock tick Generates the timer runs out event
   * @param int timer value
   */
  public void onTimerTick(int timerValue) {

  }
  
  /**
   * Process clock ticks Generates the timer runs out event
   */
  public void onTimerRunsOut() {

  }
}//End class TrainState