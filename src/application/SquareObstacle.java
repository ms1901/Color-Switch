package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class SquareObstacle implements Obstacle {

	private AnchorPane obspane;
	private FXMLLoader fxmlLoader;
	Squarecontroller controller;
	private int id;

	public SquareObstacle() throws IOException {
		fxmlLoader = new FXMLLoader(getClass().getResource("Square.fxml"));
		obspane = fxmlLoader.load();
		controller = fxmlLoader.<Squarecontroller>getController();
		id = 5;
	}

	public AnchorPane getobspane() {
		return obspane;
	}

	public Squarecontroller getcontrol() {
		return controller;
	}

	public int getid() {
		// TODO Auto-generated method stub
		return 5;
	}

}
