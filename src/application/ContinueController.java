package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ContinueController implements Initializable {

	@FXML
	private Button YesButton;

	@FXML
	private Button NoBuuton;

	private ArrayList<Integer> obs;
	private ArrayList<Double> obspos;
	private int stars;
	private String color;

	@FXML
	void NoButtonIsPressed(MouseEvent event) throws IOException, ClassNotFoundException {
		int a=stars+5;
		try
        { 
            // Throw an object of user defined exception 
            throw new GameLoseException(a, event); 
        } 
        catch (GameLoseException ex) 
        { 
            System.out.println("Caught game loss"); 
  
           
        } 

	}

	@FXML
	void YesButtonIsPressed(MouseEvent event) throws IOException, ClassNotFoundException {

		Main.deserialize();
		DataBase db = Main.getDatabase();
		//db.getSavedscore().reducetotalscore(2);
		db.getSavedscore().increaseearnedscore(5);
		DataBase.saveStars();

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoadDisplay.fxml"));
		Parent newgame = fxmlLoader.load();
		Scene newgamewindow = new Scene(newgame);
		LoadDisplayController controller;
		controller = fxmlLoader.<LoadDisplayController>getController();
		controller.startgame(obs, stars, obspos, color);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(newgamewindow);
		window.show();
		newgamewindow.getRoot().requestFocus();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void intializevariables(int s, ArrayList<Integer> o, ArrayList<Double> oo, String c) {
		obs = o;
		System.out.println("STARS in game"+s);
		stars = s;
		obspos = oo;
		color = c;
	}

}
