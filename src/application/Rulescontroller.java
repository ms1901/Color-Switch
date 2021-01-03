package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Rulescontroller implements Initializable {

	@FXML
	private ImageView backtomainmenu;

	@FXML
	void backtomenu(MouseEvent event) throws IOException {
		System.out.println("back to main menu clicked");
		Parent newgame = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Scene newgamewindow = new Scene(newgame, 700, 800);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(newgamewindow);
		window.show();

	}
	void zoomin(ImageView i) {
		ScaleTransition scaleTransition = new ScaleTransition();

		// Setting the duration for the transition
		scaleTransition.setDuration(Duration.millis(1000));

		// Setting the node for the transition
		scaleTransition.setNode(i);

		// Setting the dimensions for scaling
		scaleTransition.setByY(0.1);
		scaleTransition.setByX(0.1);

		// Setting the cycle count for the translation
		scaleTransition.setCycleCount(50);

		// Setting auto reverse value to true
		scaleTransition.setAutoReverse(false);

		// Playing the animation
		scaleTransition.play();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		zoomin(backtomainmenu);
		
	}

}
