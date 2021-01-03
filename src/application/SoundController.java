package application;

import java.io.IOException;
import java.net.URL;
import java.security.AccessControlContext;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class SoundController implements Initializable {
	private static SoundController soundController = null;

	public static SoundController getInstance() {
		if (soundController == null) {
			soundController = new SoundController();
		}
		return soundController;
	}

	public SoundController() {
	}

	@FXML
	private ImageView backtomainmenu;
	@FXML
	private Text label;

	@FXML
	private ImageView image;

	@FXML
	public CheckBox checkbox;
	static boolean canplay = true;
	static AudioClip note = null;

	@FXML
	void backtomenu(MouseEvent event) throws IOException {
		System.out.println("back to main menu clicked");
		Parent newgame = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Scene newgamewindow = new Scene(newgame, 700, 800);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(newgamewindow);
		window.show();

	}

	public void addstar() {
		if (canplay) {
			AudioClip note = new AudioClip(this.getClass().getResource("star.wav").toString());
			note.play();
		}

	}

	public void addjump() {
		if (canplay) {
			AudioClip note = new AudioClip(this.getClass().getResource("jumpin.wav").toString());
			note.play();
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		zoomin( backtomainmenu);
		zoomin( image);
		if (canplay == false) {
			checkbox.setSelected(true);
			
		}

		EventHandler event = new EventHandler() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				if (checkbox.isSelected()) {
					System.out.println("checked");
					canplay = false;

				}

				else {
					System.out.println("NOT checked");
					canplay = true;
				}
				addmusic();
			}

		};

		// set event to checkbox
		checkbox.setOnAction((javafx.event.EventHandler<ActionEvent>) event);

	}
	
	public void addmusic() {

		if (canplay) {
			note = new AudioClip(this.getClass().getResource("colorswitch.mp3").toString());
			// note=new AudioClip(this.getClass().getResource("star.wav").toString());
			note.play();
			note.setCycleCount(AudioClip.INDEFINITE);

		} else {
			if (note != null)
				note.stop();
		}
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


}
