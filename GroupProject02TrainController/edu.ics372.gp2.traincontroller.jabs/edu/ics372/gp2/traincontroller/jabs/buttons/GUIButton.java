package edu.ics372.gp2.traincontroller.jabs.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * The abstract GUI Button object. 
 * Removes of conditionals
 *
 */
public abstract class GUIButton extends Button implements EventHandler<ActionEvent> {
	/**
	 * Create the button with the proper text. Makes the button a listener to clicks
	 * on itself.
	 * 
	 * @param string the text
	 */

	public GUIButton(String string) {
		super(string);
		setOnAction(this);
	}
}