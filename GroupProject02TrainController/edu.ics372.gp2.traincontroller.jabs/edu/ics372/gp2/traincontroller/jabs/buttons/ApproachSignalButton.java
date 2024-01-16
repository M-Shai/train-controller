package edu.ics372.gp2.traincontroller.jabs.buttons;

import edu.ics372.gp2.traincontroller.jabs.states.TrainContext;
import javafx.event.ActionEvent;

/**
 * @author Banji, Say, Jeffrey, Abshir
 * Signals approaching station
 * 
 * Updated 4/11/23
 */
public class ApproachSignalButton extends GUIButton {

	/**
	 * @param string
	 */
	public ApproachSignalButton(String string) {
		super(string);
	}//End Contsructor

	/**
	 * @param ActionEvent
	 */
	@Override
	public void handle(ActionEvent arg0) {
		TrainContext.getInstance().approachSignalRequest();
	}//End handle
}//End ApproachSignalButton