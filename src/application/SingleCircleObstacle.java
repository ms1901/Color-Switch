package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class SingleCircleObstacle implements Obstacle {

	private AnchorPane obspane;
	private FXMLLoader fxmlLoader;
	SingleCircleController controller;

	private int id;

	public SingleCircleObstacle() throws IOException {
		fxmlLoader = new FXMLLoader(getClass().getResource("OneCircleObstacle.fxml"));
		obspane = fxmlLoader.load();
		id = 0;
		controller = fxmlLoader.<SingleCircleController>getController();
	}

	public AnchorPane getobspane() {
		return obspane;
	}

	public SingleCircleController getcontrol() {
		return controller;
	}

	@Override
	public int getid() {
		// TODO Auto-generated method stub
		return 0;
	}

}
