package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BallHitBottom extends Exception 
{ 
    public BallHitBottom(int s,ArrayList<Integer> ObstacleList,ArrayList<Double> arr,String color,Event e) throws IOException 
    { 
    	System.out.println("EXCEPTION HANDLING");
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Continuetoplay.fxml"));
		Parent newgame = fxmlLoader.load();
		Scene newgamewindow = new Scene(newgame, 700, 800);
		ContinueController controller;
		controller = fxmlLoader.<ContinueController>getController();
		controller.intializevariables(s, ObstacleList, arr,color);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setScene(newgamewindow);

		window.show();
		
    } 
} 

