package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class Doublecross implements Obstacle {

	private AnchorPane obspane;
	private FXMLLoader fxmlLoader;
	Doublecrosscontroller controller;
	private int id = 0;

	public Doublecross() throws IOException {
		fxmlLoader = new FXMLLoader(getClass().getResource("Doublecross.fxml"));
		obspane = fxmlLoader.load();
		id = 2;
		controller = fxmlLoader.<Doublecrosscontroller>getController();
	}

	public AnchorPane getobspane() {
		return obspane;
	}

	public Doublecrosscontroller getcontrol() {
		return controller;
	}

	public int getid() {
		// TODO Auto-generated method stub
		return 2;
	}

}
