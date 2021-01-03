package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;

public class Resumegamecontroller implements Initializable {
	@FXML
	private ImageView backtomainmenu;

	@FXML
	private TableView<LoaderMenuItems> Table;

	@FXML
	private TableColumn<LoaderMenuItems, String> gamecol;

	@FXML
	private TableColumn<LoaderMenuItems, String> playcol;

	private final ObservableList<LoaderMenuItems> data = FXCollections.observableArrayList();

	@FXML
	private Button DeletButton;

	@FXML
	void DeletButtonPressed(MouseEvent event) throws ClassNotFoundException, FileNotFoundException, IOException {

		System.out.println("Delete Button is clicked");
		Main.deletAllProgress();
		Main.serialize();
		for (int i = 0; i < Table.getItems().size(); i++) {
			Table.getItems().clear();
		}
	}

//	    @FXML
//	    void PauseButtonIsClicked(MouseEvent event) throws ClassNotFoundException, FileNotFoundException, IOException {   	
//	    	
//	   	System.out.println("Pause Button is Clicked");
	//
//	   	Main.deserialize();
	//
//	   	DataBase db=Main.getDatabase();
	//
//	    	for(DataTable arr:db.getDatabaseFiles() )
//	   	{
//	    		System.out.println("The game Id is: "+arr.getgameid());
//	    		System.out.println("The game star count is: "+arr.getnoofstars());
//////	    		System.out.println("The game obstable name is: "+arr.getobstacle().get(0));
//////	    		System.out.println("The game obstable Position is: "+arr.getobspos().get(0)+" "+arr.getobspos().get(1));
//////	    		System.out.println("The game star Position is: "+arr.getstarpos().get(0)+" "+arr.getstarpos().get(1));
//////	    		System.out.println("The game ColorSwitcher Position is: "+arr.getcolorpos().get(0)+" "+arr.getcolorpos().get(1));
//////	    		
//	 	}
	////
	// }

	@FXML
	void backtomenu(MouseEvent event) throws IOException {
		Parent newgame = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Scene newgamewindow = new Scene(newgame, 700, 800);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(newgamewindow);
		window.show();

	}

	@FXML
	void GetSelectedGame(MouseEvent event) throws IOException {
		LoaderMenuItems selected = Table.getSelectionModel().getSelectedItem();
		System.out.println("Item is selected");
		DataTable arr = selected.getDt();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoadDisplay.fxml"));
		Parent newgame = fxmlLoader.load();
		Scene newgamewindow = new Scene(newgame);
		LoadDisplayController controller;
		controller = fxmlLoader.<LoadDisplayController>getController();
		controller.startgame(arr.getobstacle(), arr.getnoofstars(), arr.getobspos(), arr.getBall_color());
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(newgamewindow);
		window.show();
		newgamewindow.getRoot().requestFocus();
		System.out.println("The game Id is: " + arr.getgameid());
		System.out.println("The game star count is: " + arr.getnoofstars());
//	 		System.out.println("The game obstable name is: "+arr.getobstacle().get(0));
//	 		System.out.println("The game obstable Position is: "+arr.getobspos().get(0)+" "+arr.getobspos().get(1));
//	 		System.out.println("The game star Position is: "+arr.getstarpos().get(0)+" "+arr.getstarpos().get(1));
//	 		System.out.println("The game ColorSwitcher Position is: "+arr.getcolorpos().get(0)+" "+arr.getcolorpos().get(1));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gamecol.setCellValueFactory(new PropertyValueFactory<>("msg"));
		// playcol.set

		playcol.setCellValueFactory(new PropertyValueFactory<>("imgeholder"));

		try {
			addItemsToTable();
		} catch (ClassNotFoundException e) {
			System.out.println("Exception at adding items in the table");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Exception at adding items in the table");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Exception at adding items in the table");
			e.printStackTrace();
		}
	}

	private void addItemsToTable() throws ClassNotFoundException, FileNotFoundException, IOException {

		Main.deserialize();

		Iterator db = Main.getDatabase().creatIterator();
		int i = 1;

//	    	for(DataTable arr:db.getDatabaseFiles() )
//	    	{
//	    		ImageView iv=new ImageView();
//	    		Image im= new Image(this.getClass().getResourceAsStream("play.png"));
//	    		iv.setImage(im);
//	    		LoaderMenuItems temp=new LoaderMenuItems(iv,i,arr.getnoofstars(),arr);
//	    		i=i+1;
//	    		//temp.getiv().setFitWidth(80);
//	    		data.add(temp);
//	    		
//	    		
//	    	}

		while (db.hasnext()) {
			DataTable temp = db.next();
			ImageView iv = new ImageView();
			Image im = new Image(this.getClass().getResourceAsStream("play.png"));
			iv.setImage(im);
			LoaderMenuItems t = new LoaderMenuItems(iv, i, temp.getnoofstars(), temp);
			i = i + 1;
			// temp.getiv().setFitWidth(80);
			data.add(t);

		}

		Table.setItems(data);
	}

	/*
	 * @FXML private ImageView backtomainmenu;
	 * 
	 * @FXML void backtomenu(MouseEvent event) throws IOException { Parent
	 * newgame=FXMLLoader.load(getClass().getResource("Sample.fxml")); Scene
	 * newgamewindow=new Scene(newgame,700,800); Stage
	 * window=(Stage)((Node)event.getSource()).getScene().getWindow();
	 * window.setScene(newgamewindow); window.show();
	 * 
	 * }
	 */

}
