package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Crossincirclemain extends Application {
	@Override

	public void start(Stage primaryStage) {
		try {
			// BorderPane root =
			// (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("CrossinCircleandcross.fxml"));
			Scene scene = new Scene(root, 700, 700);
			// scene.setOnKeyPressed);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			// scene.getRoot().requestFocus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
