package application;

import java.io.IOException;
import java.net.URL;
import javafx.util.*;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
//import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;

public class SampleController implements Initializable {
	 @FXML
	    private ImageView gifts;

	@FXML
	private ImageView Highscore;

	@FXML
	private ImageView rules;

	@FXML
	private Pane pane1;

	@FXML
	private Arc blue1;

	@FXML
	private Arc yellow1;

	@FXML
	private Arc pink1;

	@FXML
	private Arc purple1;

	@FXML
	private Arc yellow12;

	@FXML
	private Arc blue12;

	@FXML
	private Arc pink12;

	@FXML
	private Arc purple12;

	@FXML
	private Arc purple11;

	@FXML
	private Arc blue11;

	@FXML
	private Arc yellow11;

	@FXML
	private Arc pink11;

	@FXML
	private ImageView pause;

	@FXML
	private ImageView settings;

	@FXML
	private ImageView startnewgame;

	@FXML
	private Pane infintypane;
	@FXML
    void opengifts(MouseEvent event) throws IOException {
		System.out.println("gifts");
		Parent newgame = FXMLLoader.load(getClass().getResource("SpinTheWheel.fxml"));
		Scene newgamewindow = new Scene(newgame);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(newgamewindow);
		newgamewindow.getRoot().requestFocus();

    }


	@FXML
	void pauseclicked(MouseEvent event) throws IOException {
		System.out.println("pause clicked");
		Parent newgame = FXMLLoader.load(getClass().getResource("Chosefromresumegame.fxml"));
		Scene newgamewindow = new Scene(newgame);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(newgamewindow);
		newgamewindow.getRoot().requestFocus();
	}

	@FXML
	void rulesclicked(MouseEvent event) throws IOException {
		System.out.println("rules clicked");
		// System.out.println("pause clicked");
		Parent newgame = FXMLLoader.load(getClass().getResource("Rules.fxml"));
		Scene newgamewindow = new Scene(newgame);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(newgamewindow);
		window.show();

	}

	@FXML
	void settingclicked(MouseEvent event) throws IOException {
		System.out.println("setting clicked");
		Parent newgame = FXMLLoader.load(getClass().getResource("Settings.fxml"));
		Scene newgamewindow = new Scene(newgame);
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

	@FXML
	void trophyclick(MouseEvent event) throws IOException {

		System.out.println("trophy clicked");
		// System.out.println("start anew game");
		Parent newgame = FXMLLoader.load(getClass().getResource("Trophy.fxml"));
		Scene newgamewindow = new Scene(newgame);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(newgamewindow);
		window.show();

	}

	@FXML
	void closewindow(MouseEvent event) {
		System.out.println("exit ");
		Platform.exit();
	}

	@FXML
	void startnewgame(MouseEvent event) throws IOException {
		System.out.println("start a new game");
		// Parent newgame=FXMLLoader.load(getClass().getResource("Gameplay.fxml"));
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gameplay.fxml"));
		Parent newgame = fxmlLoader.load();
		Scene newgamewindow = new Scene(newgame);
		ArrayList<Integer> obs = new ArrayList<>();
		obs.add(0);
		obs.add(1);
		// obs.add(2);
		// obs.add(3);

		Controllergameplay controller;
		controller = fxmlLoader.<Controllergameplay>getController();
		ArrayList<Double> arr = new ArrayList<>();
		arr.add(367.0);
		arr.add(579.0);
		arr.add(0.0);
		arr.add(0.0);
		arr.add(0.0);
		arr.add(0.0);
		controller.startgame(obs, 0, arr, "#8300ff");
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(newgamewindow);
		window.show();
		newgamewindow.getRoot().requestFocus();

	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		setRotate(pane1, true, 0, 360, 2);
		zoomin(Highscore);
		zoomin(pause);
		zoomin(rules);
		zoomin(settings);
		// setRotate(pane11,true,360,0,1);

		// setRotate(pane11,true,360,10);
		/*
		 * setRotate(purple1,true,360,10); setRotate(blue1,true,360,10);
		 * setRotate(yellow1,true,360,10); setRotate(pink1,true,360,10);
		 */

	}

	private void setRotate(Pane r, boolean reverse, int angle, int end, int duration)

	{

		RotateTransition rt = new RotateTransition(Duration.seconds(duration), r);

		// rt.setAutoReverse(reverse);

		rt.setFromAngle(angle);
		rt.setToAngle(end);
		rt.setCycleCount(1000);

		rt.play();

	}
}
