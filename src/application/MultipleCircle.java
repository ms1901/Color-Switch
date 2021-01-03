package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class MultipleCircle implements Obstacle {

	private AnchorPane obspane;
	private FXMLLoader fxmlLoader;
	Multiplecirclecontroller controller;
	private int id;

	public MultipleCircle() throws IOException {
		fxmlLoader = new FXMLLoader(getClass().getResource("MultipleCircles.fxml"));
		obspane = fxmlLoader.load();
		controller = fxmlLoader.<Multiplecirclecontroller>getController();
		id = 4;
	}

	public AnchorPane getobspane() {
		return obspane;
	}

	public Multiplecirclecontroller getcontrol() {
		return controller;
	}

	@Override
	public int getid() {
		// TODO Auto-generated method stub
		return 4;
	}

}
