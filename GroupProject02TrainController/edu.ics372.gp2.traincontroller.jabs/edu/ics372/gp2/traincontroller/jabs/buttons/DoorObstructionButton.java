package edu.ics372.gp2.traincontroller.jabs.buttons;

import edu.ics372.gp2.traincontroller.jabs.states.TrainContext;
import javafx.event.ActionEvent;

/**
 * @author Banji, Say, Jeffrey, Abshir
 * Creates a door obstruction
 * 
 * Updated 4/11/23
 */
public class DoorObstructionButton extends GUIButton {
	
	/**
	 * @param string
	 */
	public DoorObstructionButton(String string) {
		super(string);
	}//End constructor

	/**
	 * @param ActionEvent
	 */
	@Override
	public void handle(ActionEvent arg0) {
		TrainContext.getInstance().doorObstructionRequest();
	}//End handle
}//End class DoorObstructionButton
