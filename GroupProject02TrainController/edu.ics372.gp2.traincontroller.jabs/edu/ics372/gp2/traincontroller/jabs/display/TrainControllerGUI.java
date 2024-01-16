package edu.ics372.gp2.traincontroller.jabs.display;

import edu.ics372.gp2.traincontroller.jabs.buttons.ApproachSignalButton;
import edu.ics372.gp2.traincontroller.jabs.buttons.ArriveSignalButton;
import edu.ics372.gp2.traincontroller.jabs.buttons.DoorObstructionButton;
import edu.ics372.gp2.traincontroller.jabs.buttons.GUIButton;
import edu.ics372.gp2.traincontroller.jabs.buttons.StartButton;
import edu.ics372.gp2.traincontroller.jabs.states.TrainContext;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * @author Banji, Say, Jeffrey, Abshir
 * 
 * GUI to implement the ControllerDisplayInterface interface A pretty elementary
 * interface
 *
 * Updated 4/11/23
 */
public class TrainControllerGUI extends Application implements ControllerDisplayInterface {
	
	private final int HEIGHT = 40;
	private final int WIDTH = 900;
	private GUIButton approachSignalButton;
	private GUIButton arriveSignalButton;
	private GUIButton makeDoorObstructedButton;
	private GUIButton startButton;
	private Text trainStatus = new Text("NULL DEFAULT");
	private Text timerValue = new Text("Default");
	
	/**
	 * Sets up the interface
	 */
	@Override
	public void start(@SuppressWarnings("exports") Stage primaryStage) throws Exception {

		approachSignalButton = new ApproachSignalButton("Approaching Station");
		arriveSignalButton = new ArriveSignalButton("Station Arrival");
		makeDoorObstructedButton = new DoorObstructionButton("Door Obstruction");
		startButton = new StartButton("Start");
		
		HBox hbox3 = new HBox(100, trainStatus, timerValue);
		HBox hbox4 = new HBox(10, startButton, approachSignalButton, 
				arriveSignalButton, makeDoorObstructedButton);
		HBox hbox5 = new HBox(100, hbox3, hbox4);
		showDoorClosed(" ");
		showStopped(" ");
		showTimeLeft("Press Start Button to initialize");

		Scene scene = new Scene(hbox5, WIDTH, HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JABS TRAIN CONTROLLER");
		TrainContext.getInstance().setDisplay(this);
		primaryStage.show();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});
	}

	/**
	 * display the remaining time
	 * 
	 * @param String value remaining
	 */
	@Override
	public void showTimeLeft(String value) {
		timerValue.setText(value);								
	} 
	///////////// Train States //////////////// ///
	
	/**
	 * Indicate that train is decelerating
	 */
	@Override
	public void showDecelerating() {
		trainStatus.setText("Train Decelerating");
		showTimeLeft("In transit, waiting for arrival");
	}
	
	/**
	 * Indicate that train is accelerating
	 * @param String value
	 */
	@Override
	public void showAccelerating(String value) {
		trainStatus.setText("Train Accelerating");
		showTimeLeft(value + " untill full speed");
	}
	
	/**
	 * Indicate that train is at full speed
	 */
	@Override
	public void showFullSpeed() {
		trainStatus.setText("Train Full Speed");
		showTimeLeft("In transist, waiting for approach");
	}

	/**
	 * Indicate that train is stopped
	 * @param String value
	 */
	@Override
	public void showStopped(String value) {
		trainStatus.setText("Train Stopped");
		showTimeLeft(value + " till door opens");
	}

	///////////// Door states ////////////////
	/**
	 * Indicate that the door is closed
	 * @param String value
	 */
	@Override
	public void showDoorClosed(String value) {
		trainStatus.setText("Door Closed");
		showTimeLeft(value + " untill train leaves");
	}

	/**
	 * Indicate that the door is opened
	 * @param String value
	 */
	@Override
	public void showDoorOpened(String value) {
		trainStatus.setText("Door Fully Opened");
		showTimeLeft(value + " untill door starts closing");
	}

	/**
	 * Indicate that the door is opening
	 * @param String value
	 */
	@Override
	public void showDoorOpening(String value) {
		trainStatus.setText("Door Opening");
		showTimeLeft(value + " untill door is fully opened");
	}

	/**
	 * Indicate that the door is closing
	 * @param String value
	 */
	@Override
	public void showDoorClosing(String value) {
		trainStatus.setText("Door Closing");
		showTimeLeft(value + " untill door is fully closed");
	}

	/**
	 * Indicate that the door is re-opening
	 * @param String value
	 */
	@Override
	public void showDoorReopening(String value) {
		trainStatus.setText("Door Re-opening");
		showTimeLeft(value + " untill door is reopened");
	}

	/**
	 * Indicate that the door is re-opened
	 * @param String value
	 */
	@Override
	public void showDoorReopen(String value) {
		trainStatus.setText("Door Fully Re-opened");
		showTimeLeft(value + " untill door starts closing");
	}

	///////////// External Events \\\\\\\\\\\\\\\
	/**
	 * Indicate that train is approaching station
	 */
	public void approachSignalRequest() {
		trainStatus.setText("Train Approaching Station");
	}

	/**
	 * Indicate that train has arrived at station
	 */
	public void arriveSignalRequest() {
	}

	/**
	 * Indicate that the door is obstructed
	 */
	public void doorObstructionRequest() {
		trainStatus.setText("Door Obstructed");
	}
	
	/**
	 * Disable start button after first press
	 */
	public void disableStartButton() {
		startButton.setDisable(true);
	}
}//End class TrainControllerGUI