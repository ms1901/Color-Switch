package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class DoubleCircleObstacle implements Obstacle {

	private AnchorPane obspane;
	private FXMLLoader fxmlLoader;
	TwoCircleController controller;
	private int id;

	public DoubleCircleObstacle() throws IOException {
		fxmlLoader = new FXMLLoader(getClass().getResource("CircleObstacle.fxml"));
		obspane = fxmlLoader.load();
		controller = fxmlLoader.<TwoCircleController>getController();
		id = 1;
	}

	public AnchorPane getobspane() {
		return obspane;
	}

	public TwoCircleController getcontrol() {
		return controller;
	}

	public int getid() {
		// TODO Auto-generated method stub
		return 1;
	}

}
