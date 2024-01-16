package edu.ics372.gp2.traincontroller.jabs.start;

import edu.ics372.gp2.traincontroller.jabs.display.TrainControllerGUI;
import edu.ics372.gp2.traincontroller.jabs.timer.Clock;
import javafx.application.Application;

/**
 * TrainController driver
 * Starts clock thread
 * Runs TrainControllerGUI
 */
public class Main {
	public static void main(String[] args) {
		Clock.getInstance();
		new Thread() {
			@Override
			public void run() {
				Application.launch(TrainControllerGUI.class, null);
			}
		}.start();
	}
}//End Main
