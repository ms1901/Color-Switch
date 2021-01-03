package application;

import javafx.scene.media.AudioClip;

import javafx.scene.media.MediaPlayer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.io.*;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	public static ArrayList<Obstacle> obs;
	public static MediaPlayer mediaPlayer;
	private static DataBase current;
	public static ArrayList<String> colors;

	public static ArrayList<String> colorlist() 
	{
		colors = new ArrayList<>();
		colors.add("0x00fbffff");
		colors.add("0x8300ffff");
		colors.add("0xfffa00ff");
		colors.add("0xff0055ff");
		return colors;
		
	}

	public static Obstacle obstaclelist(int i) {
		obs = new ArrayList<>();
		try {
			if (i == 0) {
				return new SingleCircleObstacle();
			} else if (i == 1) {
				return new DoubleCircleObstacle();
			} else if (i == 2) {
				return new Doublecross();

			} else if (i == 3) {
				return new VerticalLines();
			} else if (i == 4) {
				return new MultipleCircle();
			} else if (i == 5) {
				return new SquareObstacle();
			} else if (i == 6) {
				return new CrossinCircle();
			} else if (i == 7) {
				return new LineinCircle();
			}
			else if(i==8)
			{
				return new StarObstacle();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			SoundController sound = SoundController.getInstance();
			this.deserialize();
			System.out.println("saved highscore: " + current.getSavedscore().getHighscore() + "Saved Total Score: "
					+ current.getSavedscore().getTotalscore());
			sound.addmusic();
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("Sample.fxml"));
			
			Scene scene = new Scene(root, 700, 700);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		launch(args);

	}

	public static DataBase getDatabase() {

		return current;
	}

	public static void deletAllProgress() {
		current =DataBase.getinstance();
	}



	public static void serialize() throws IOException {
		System.out.println("Serialize is called");
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("database.txt"));
			out.writeObject(current);
		} finally {
			out.close();
			System.out.println("Saved");
			// System.exit(0);
		}
	}

	public static void deserialize() throws ClassNotFoundException, FileNotFoundException, IOException {
		System.out.println("Deserilize is called");
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("database.txt"));
			current = (DataBase) in.readObject();
			in.close();
		} catch (FileNotFoundException e) {
			current = DataBase.getinstance();
		} catch (NullPointerException e) {
			current = DataBase.getinstance();
		}
	}
}
