package edu.ics372.gp2.traincontroller.jabs.buttons;

import edu.ics372.gp2.traincontroller.jabs.states.TrainContext;
import javafx.event.ActionEvent;

/**
 * @author Banji, Say, Jeffrey, Abshir
 * Sets the initial train state
 * Initialize application
 * 
 * Updated 4/11/23
 */
public class StartButton extends GUIButton {

	/**
	 * @param string
	 */
	public StartButton(String string) {
		super(string);
	}//End constructor
	
	/**
	 * @param ActionEvent
	 */
	@Override
	public void handle(ActionEvent arg0) {
		//System.out.println("Start Button");
		TrainContext.getInstance().initialize();
	}//End handle
}