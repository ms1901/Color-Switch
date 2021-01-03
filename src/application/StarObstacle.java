package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class StarObstacle implements Obstacle {

	private AnchorPane obspane;
	private FXMLLoader fxmlLoader;
	StarController controller;

	private int id;

	public StarObstacle() throws IOException {
		fxmlLoader = new FXMLLoader(getClass().getResource("StarObstacle.fxml"));
		obspane = fxmlLoader.load();
		id = 8;
		controller = fxmlLoader.<StarController>getController();
	}

	public AnchorPane getobspane() {
		return obspane;
	}

	public StarController getcontrol() {
		return controller;
	}

	@Override
	public int getid() {
		// TODO Auto-generated method stub
		return 8;
	}

}