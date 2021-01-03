package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Gifcontrol implements Initializable {

	@FXML
	private ImageView image;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Image i = new Image(new File("/Gif/colorswitch.gif").toURI().toString());
		image.setImage(i);

	}

}
