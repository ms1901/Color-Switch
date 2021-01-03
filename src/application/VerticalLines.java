package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class VerticalLines implements Obstacle {

	private AnchorPane obspane;
	private FXMLLoader fxmlLoader;
	VerticalLinesController controller;
	private int id;

	public VerticalLines() throws IOException {
		fxmlLoader = new FXMLLoader(getClass().getResource("VerticalLines.fxml"));
		obspane = fxmlLoader.load();
		controller = fxmlLoader.<VerticalLinesController>getController();
		id = 3;
	}

	public AnchorPane getobspane() {
		return obspane;
	}

	public VerticalLinesController getcontrol() {
		return controller;
	}

	public int getid() {
		// TODO Auto-generated method stub
		return 3;
	}

}
