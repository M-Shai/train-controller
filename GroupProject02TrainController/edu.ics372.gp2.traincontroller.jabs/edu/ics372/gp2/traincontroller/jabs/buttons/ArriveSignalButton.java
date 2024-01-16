package edu.ics372.gp2.traincontroller.jabs.buttons;

import edu.ics372.gp2.traincontroller.jabs.states.TrainContext;
import javafx.event.ActionEvent;

/**
 * @author Banji, Say, Jeffrey, Abshir
 * Signals arrival at station
 * 
 * Updated 4/11/23
 */
public class ArriveSignalButton extends GUIButton {

	/**
	 * @param string
	 */
	public ArriveSignalButton(String string) {
		super(string);
	}//End constructor

	/**
	 * @param actionEvent
	 */
	@Override
	public void handle(ActionEvent arg0) {
		TrainContext.getInstance().arriveSignalRequest();
	}//End handle
}//End ArriveSignal