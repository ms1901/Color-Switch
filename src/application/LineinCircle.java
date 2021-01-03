package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class LineinCircle implements Obstacle {

	private AnchorPane obspane;
	private FXMLLoader fxmlLoader;
	LineinCircleController controller;
	private int id = 0;

	public LineinCircle() throws IOException {
		fxmlLoader = new FXMLLoader(getClass().getResource("Lineincircle.fxml"));
		obspane = fxmlLoader.load();
		id = 7;
		controller = fxmlLoader.<LineinCircleController>getController();
	}

	public AnchorPane getobspane() {
		return obspane;
	}

	public LineinCircleController getcontrol() {
		return controller;
	}

	public int getid() {
		// TODO Auto-generated method stub
		return 7;
	}

}
