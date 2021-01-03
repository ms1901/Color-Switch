package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class CrossinCircle implements Obstacle {

	private AnchorPane obspane;
	private FXMLLoader fxmlLoader;
	Crossincirclecontroller controller;
	private int id;

	public CrossinCircle() throws IOException {
		fxmlLoader = new FXMLLoader(getClass().getResource("CrossinCircle.fxml"));
		obspane = fxmlLoader.load();
		id = 6;
		controller = fxmlLoader.<Crossincirclecontroller>getController();
	}

	public AnchorPane getobspane() {
		return obspane;
	}

	public Crossincirclecontroller getcontrol() {
		return controller;
	}

	public int getid() {
		// TODO Auto-generated method stub
		return 6;
	}

}
