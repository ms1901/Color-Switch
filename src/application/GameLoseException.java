package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameLoseException extends Exception 
{ 
    public GameLoseException(int s,Event e) throws IOException, ClassNotFoundException 
    { 
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scorecard.fxml"));
		Parent newgame = fxmlLoader.load();
		Scene newgamewindow = new Scene(newgame, 700, 800);
		Scorecardcontroller controller;
		controller = fxmlLoader.<Scorecardcontroller>getController();
		if (controller == null) {
			System.out.println("controller is null");
		}
		controller.dostarcalculation(s);

		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setScene(newgamewindow);
		window.show();
		System.out.println("Game OVER  ending");
		
    } 
} 

