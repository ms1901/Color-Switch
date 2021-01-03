package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class Triangleoutofcircle implements Obstacle {

	private AnchorPane obspane;
	private FXMLLoader fxmlLoader;
	Triangleoutofcirclecontroller controller;
	private int id;

	public Triangleoutofcircle() throws IOException {
		fxmlLoader = new FXMLLoader(getClass().getResource("Triangleoutcircle.fxml"));
		obspane = fxmlLoader.load();
		controller = fxmlLoader.<Triangleoutofcirclecontroller>getController();
		id = 6;
	}

	public AnchorPane getobspane() {
		return obspane;
	}

	public Triangleoutofcirclecontroller getcontrol() {
		return controller;
	}

	public int getid() {
		// TODO Auto-generated method stub
		return id;
	}

}
