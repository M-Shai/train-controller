module org.oobook.microwavev1fx {
	requires javafx.controls;
	requires javafx.base;
	requires java.desktop;
	requires javafx.graphics;

	exports edu.ics372.gp2.traincontroller.jabs.display to javafx.graphics;
	exports edu.ics372.gp2.traincontroller.jabs.start to javafx.graphics;
}