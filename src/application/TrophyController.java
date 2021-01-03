package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TrophyController implements Initializable {

	@FXML
	private ImageView homebutton;

	@FXML
	private Label score5;

	@FXML
	private Label score4;

	@FXML
	private Label score3;

	@FXML
	private Label score2;

	@FXML
	private Label score1;

	@FXML
	private Label starsspent;

	@FXML
	private Label starsearned;

	@FXML
	void gobacktohomepage(MouseEvent event) throws IOException {
		System.out.println("go back home clicked");
		// System.out.println("start anew game");
		BorderPane newgame = (BorderPane) FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Scene newgamewindow = new Scene(newgame, 700, 700);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(newgamewindow);
		window.show();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		int[] scores = Main.getDatabase().getSavedscore().getTopScores();
		int totalscore = Main.getDatabase().getSavedscore().getTotalscore();
		int scorespent = Main.getDatabase().getSavedscore().getStarspent();
		score1.setText(String.valueOf(scores[0]));
		score2.setText(String.valueOf(scores[1]));
		score3.setText(String.valueOf(scores[2]));
		score4.setText(String.valueOf(scores[3]));
		score5.setText(String.valueOf(scores[4]));
		starsearned.setText(String.valueOf(totalscore)); // starearned is null
		starsspent.setText(String.valueOf(scorespent));

	}

}
