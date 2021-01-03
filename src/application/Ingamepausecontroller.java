/*import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ingamepausecontroller {

    @FXML
    private ImageView pause;

    @FXML
    private ImageView replay;

    @FXML
    private ImageView exit;

    @FXML
    void exittomainmenu(MouseEvent event)throws IOException {
    	System.out.println("exit to main menu");
    	Parent newgame=FXMLLoader.load(getClass().getResource("Sample.fxml"));
    	Scene newgamewindow=new Scene(newgame,700,800);
    	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(newgamewindow);
    	window.show();

    }

    @FXML
    void pausegame(MouseEvent event) throws IOException{
    	System.out.println("exit to main menu");
    	Parent newgame=FXMLLoader.load(getClass().getResource("Gameplay.fxml"));
    	Scene newgamewindow=new Scene(newgame,700,800);
    	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(newgamewindow);
    	window.show();


    }

    @FXML
    void replay(MouseEvent event)throws IOException {
    	System.out.println("repaly");
    	Parent newgame=FXMLLoader.load(getClass().getResource("Gameplay.fxml"));
    	Scene newgamewindow=new Scene(newgame,700,800);
    	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(newgamewindow);
    	window.show();


    }
}*/
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ingamepausecontroller implements Initializable {

	@FXML
	private ImageView pause;

	@FXML
	private ImageView replay;

	@FXML
	private ImageView exit;

	@FXML
	private ImageView saveicon;

	private DataTable data;
	private ArrayList<Integer> obs;
	private ArrayList<Double> obspos;
	private int stars;
	private String ball_color;
//    private ArrayList<Integer> obspos;
//    private ArrayList<Integer> starpos;
//    private ArrayList<Integer> colorpos;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println("Problem at intializable");
		this.data = new DataTable();
		obs = new ArrayList<>();
		obspos = new ArrayList<>();
//	    obspos=new ArrayList<Integer>();
//	    starpos=new ArrayList<Integer>();
//	    colorpos=new ArrayList<Integer>();
//    	obs.add("Circle");
//    	this.obspos.add(1);
//    	this.obspos.add(1);
//    	this.starpos.add(2);
//    	this.starpos.add(2);
//    	this.colorpos.add(3);
//    	this.colorpos.add(3);
//		
	}

	public void GameStates(int starcount, ArrayList<Integer> obss, ArrayList<Double> op, String color) {
		obs = obss;
		stars = starcount;
		obspos = op;
		ball_color = color;
	}

	@FXML
	void exittomainmenu(MouseEvent event) throws IOException {
		System.out.println("go back home clicked");
		// System.out.println("start anew game");
		BorderPane newgame = (BorderPane) FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Scene newgamewindow = new Scene(newgame, 700, 700);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(newgamewindow);
		window.show();

	}

	@FXML
	void pausegame(MouseEvent event) throws IOException {
		System.out.println("go back");
		// System.out.println("start anew game");
//    	AnchorPane newgame=(AnchorPane)FXMLLoader.load(getClass().getResource("Gameplay.fxml"));
//    	Scene newgamewindow=new Scene(newgame,700,700);
//    	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
//    	window.setScene(newgamewindow);
//    	window.show();

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoadDisplay.fxml"));
		Parent newgame = fxmlLoader.load();
		Scene newgamewindow = new Scene(newgame);
		LoadDisplayController controller;
		controller = fxmlLoader.<LoadDisplayController>getController();
		controller.startgame(obs, stars, obspos, ball_color);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(newgamewindow);
		window.show();
		newgamewindow.getRoot().requestFocus();

	}

	@FXML
	void replay(MouseEvent event) throws IOException {
		System.out.println("start a new game");
		// Parent newgame=FXMLLoader.load(getClass().getResource("Gameplay.fxml"));
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gameplay.fxml"));
		Parent newgame = fxmlLoader.load();
		Scene newgamewindow = new Scene(newgame);
		ArrayList<Integer> obs = new ArrayList<>();
		obs.add(0);
		obs.add(1);
		Controllergameplay controller;
		controller = fxmlLoader.<Controllergameplay>getController();
		ArrayList<Double> arr = new ArrayList<>();
		arr.add(367.0);
		arr.add(579.0);
		arr.add(0.0);
		arr.add(0.0);
		arr.add(0.0);
		arr.add(0.0);
		controller.startgame(obs, 0, arr, ball_color);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(newgamewindow);
		window.show();
		newgamewindow.getRoot().requestFocus();

	}

	@FXML
	void SaveGame(MouseEvent event) {

		System.out.println("Problem at save Game of mouse event");
		data.update(stars, obs, obspos, ball_color);
		System.out.println("Ball Coordinated" + obspos.get(0) + obspos.get(1));
		System.out.println("tempObtsacle Coordinated" + obspos.get(2) + obspos.get(3));
		System.out.println("temp2 Coordinated" + obspos.get(4) + obspos.get(5));
		System.out.println();
		// System.out.println("Game is saved successfully");
		Main.getDatabase().removeData(data);
		data.saveGame();
		System.out.println("Game is saved successfully");

	}

}
