package application;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Shape;

public interface Obstacle {

	AnchorPane getobspane();

	Controller getcontrol(); // make an interface of type controller
	// Shape getparts();

	int getid();

}
