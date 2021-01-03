package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Scorecardcontroller implements Initializable {

	@FXML
	private ImageView igm;
	// @FXML
	// private Pane star;
	@FXML
	private ImageView menu;

	@FXML
	private Circle replay;

	@FXML
	private Label CSLabel;

	@FXML
	private Label BSLabel;

	@FXML
	private Label TSLabel;

	@FXML
	void backtomenu(MouseEvent event) throws IOException {
		System.out.println("go back home clicked");
		// System.out.println("start anew game");
		BorderPane newgame = (BorderPane) FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Scene newgamewindow = new Scene(newgame, 700, 700);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(newgamewindow);
		window.show();

	}

	@FXML
	void gameplay(MouseEvent event) throws IOException {
		System.out.println("replay game clicked");
		// System.out.println("start anew game");
//    	AnchorPane newgame=(AnchorPane)FXMLLoader.load(getClass().getResource("Gameplay.fxml"));
//    	Scene newgamewindow=new Scene(newgame,700,700);
//    	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
//    	window.setScene(newgamewindow);
//    	window.show();

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
		controller.startgame(obs, 0, arr, "#00fbff");
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(newgamewindow);
		window.show();
		newgamewindow.getRoot().requestFocus();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// Image i = new Image(new File("C:/Users/VANI
		// SIKKA/Downloads/colorswitch.gif").toURI().toString());
		// igm.setImage(i);
		System.out.println("intialize is called");
		ScaleTransition scaleTransition = new ScaleTransition();

		scaleTransition.setDuration(Duration.millis(1000));

		scaleTransition.setNode(replay);
		scaleTransition.setByY(.4);
		scaleTransition.setByX(.4);
		scaleTransition.setCycleCount(50);
		scaleTransition.setAutoReverse(false);
		scaleTransition.play();

		/*
		 * ScaleTransition scaleTransition1 = new ScaleTransition();
		 * 
		 * 
		 * scaleTransition1.setDuration(Duration.millis(1000));
		 * 
		 * 
		 * scaleTransition1.setNode(star); scaleTransition1.setByY(.4);
		 * scaleTransition1.setByX(.4); scaleTransition1.setCycleCount(50);
		 * scaleTransition1.setAutoReverse(false); scaleTransition1.play();
		 */

	}

	public void dostarcalculation(int currentscore) throws ClassNotFoundException, FileNotFoundException, IOException {
		Main.deserialize();
		System.out.println(currentscore);
		System.out.println("stars updation started, Manasvi");
		DataBase db = Main.getDatabase();
		int hs = db.getSavedscore().getHighscore();
		int ts = db.getSavedscore().getTotalscore();
		System.out.println("HighScore saved :" + hs + " Total score saved" + ts);
		System.out.println("database");
		// CSLabel=new Label();
		if (CSLabel == null) {
			System.out.println("CSLabel is null");
		}
		CSLabel.setText(String.valueOf(currentscore));
		System.out.println("label");
		// BSLabel=new Label();
		// TSLabel=new Label();
		if (currentscore >= hs) {
			db.getSavedscore().setHighscore(currentscore);
			BSLabel.setText(Integer.toString(currentscore));
		} else {
			BSLabel.setText(Integer.toString(db.getSavedscore().getHighscore()));
		}
		db.getSavedscore().setTotalscore(ts + currentscore);
		TSLabel.setText(Integer.toString(ts + currentscore));
		db.getSavedscore().updateTopScores(currentscore);
		for (int i = 0; i < 5; i++) {
			System.out.println(db.getSavedscore().getTopScores()[i]);
		}
//		if(db.getSavedscore().getTopScores().size()>5)
//		{
//			
//		}
//		if(db.getSavedscore().getTopScores()!=null)
//		{
//			System.out.println(" Size of score list: "+db.getSavedscore().getTopScores().length);
//			//if()
//			for(int i=0;i<5;i++)
//			{
////				if(currentscore>db.getSavedscore().getTopScores().get(i))
////				{
////					db.getSavedscore().getTopScores().add(i, currentscore);
////				}
//				System.out.println(i);
//			}
//		}
//		else
//		{
//			System.out.println("Instantiated the score arrayList");
//			System.out.println(" Size of score list: "+db.getSavedscore().getTopScores().size());
//			db.getSavedscore().setTopScores(new ArrayList<>());
//			db.getSavedscore().getTopScores().add(currentscore);
//		}

		DataBase.saveStars();

	}

}
