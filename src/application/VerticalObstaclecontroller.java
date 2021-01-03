package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class VerticalObstaclecontroller implements Initializable {

	@FXML
	private Pane pane;

	@FXML
	private Line pink;

	@FXML
	private Line red;

	@FXML
	private Line blue;

	@FXML
	private Line green;

	@FXML
	private MediaView mv;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		setRotate(pane, true, 360, 10);
		set_linemotion();

//		String vurl="file:/C:/Users/VANI SIKKA/Music/final.mp4/";
//		Media media= new Media(vurl);
//		MediaPlayer mp= new MediaPlayer(media);
//		mv.setFitHeight(700);
//		mv.setFitWidth(600);
//		mv.setMediaPlayer(mp);
//		mp.play();

	}

	private void setRotate(Pane r, boolean reverse, int angle, int duration) {
		RotateTransition rt = new RotateTransition(Duration.seconds(duration), r);

		rt.setAutoReverse(reverse);
		rt.setByAngle(angle);
		rt.setDelay(Duration.seconds(0));
		rt.setRate(3);
		rt.setCycleCount(18);
		rt.play();
	}

	private void set_linemotion() {
		// Creating Translate Transition
		TranslateTransition translateTransition = new TranslateTransition();
		TranslateTransition translateTransition1 = new TranslateTransition();
		TranslateTransition translateTransition2 = new TranslateTransition();
		TranslateTransition translateTransition3 = new TranslateTransition();

		// Setting the duration of the transition
		translateTransition.setDuration(Duration.millis(1000));
		translateTransition1.setDuration(Duration.millis(1100));
		translateTransition2.setDuration(Duration.millis(1200));
		translateTransition3.setDuration(Duration.millis(1300));

		// Setting the node for the transition
		translateTransition.setNode(blue);
		translateTransition1.setNode(pink);
		translateTransition2.setNode(red);
		translateTransition3.setNode(green);

		// Setting the value of the transition along the x axis.
		translateTransition.setByX(300);
		translateTransition1.setByX(300);
		translateTransition2.setByX(300);
		translateTransition3.setByX(300);

		// Setting the cycle count for the transition
		translateTransition.setCycleCount(1000);
		translateTransition1.setCycleCount(1000);
		translateTransition2.setCycleCount(1000);
		translateTransition3.setCycleCount(1000);

		// Setting auto reverse value to false
		translateTransition.setAutoReverse(true);
		translateTransition1.setAutoReverse(true);
		translateTransition2.setAutoReverse(true);
		translateTransition3.setAutoReverse(true);

		// Playing the animation
		translateTransition.play();
		translateTransition1.play();
		translateTransition2.play();
		translateTransition3.play();
	}

}
