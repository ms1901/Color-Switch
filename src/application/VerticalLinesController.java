package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class VerticalLinesController implements Controller, Initializable {

	@FXML
	private Line pink;

	@FXML
	private Line red;

	@FXML
	private Line blue;

	@FXML
	private Line green;
	private int duration = 0;

	public void initialize(URL arg0, ResourceBundle arg1) {

		duration = 100; // cyclecount
		set_linemotion(100);

	}

	public void increasedifficulty(int c) {
		System.out.println("in increased difficulty in vertical lines controller");
		if (duration - c > 0) {
			duration = duration + c;
			set_linemotion(duration);

		}

	}

	private void set_linemotion(int cyclecount) {
		// Creating Translate Transition
		TranslateTransition translateTransition = new TranslateTransition();
		TranslateTransition translateTransition1 = new TranslateTransition();
		TranslateTransition translateTransition2 = new TranslateTransition();
		TranslateTransition translateTransition3 = new TranslateTransition();

		// Setting the duration of the transition
		translateTransition.setDuration(Duration.millis(1900));
		translateTransition1.setDuration(Duration.millis(2000));
		translateTransition2.setDuration(Duration.millis(2100));
		translateTransition3.setDuration(Duration.millis(2200));

		// Setting the node for the transition
		translateTransition.setNode(blue);
		translateTransition1.setNode(pink);
		translateTransition2.setNode(red);
		translateTransition3.setNode(green);

		// Setting the value of the transition along the x axis.
		translateTransition.setByX(300);
		translateTransition1.setByX(300);
		translateTransition2.setByX(300);
		translateTransition3.setByX(300);

		// Setting the cycle count for the transition
		translateTransition.setCycleCount(cyclecount);
		translateTransition1.setCycleCount(cyclecount);
		translateTransition2.setCycleCount(cyclecount);
		translateTransition3.setCycleCount(cyclecount);

		// Setting auto reverse value to false
		translateTransition.setAutoReverse(true);
		translateTransition1.setAutoReverse(true);
		translateTransition2.setAutoReverse(true);
		translateTransition3.setAutoReverse(true);

		// Playing the animation
		translateTransition.play();
		translateTransition1.play();
		translateTransition2.play();
		translateTransition3.play();
	}

	@Override
	public int Collision(Shape player, String color) {
		// TODO Auto-generated method stub
		Shape intersect1 = Shape.intersect(player, pink);
		Shape intersect2 = Shape.intersect(player, red);
		Shape intersect3 = Shape.intersect(player, blue);
		Shape intersect4 = Shape.intersect(player, green);
		if (intersect1.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(pink.getStroke().toString()))) {
				System.out.println("dead by pink");
				return 0;
			}

		}
		if (intersect2.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(red.getStroke().toString()))) {
				System.out.println("dead by red");
				return 0;
			}

		}
		if (intersect3.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(blue.getStroke().toString()))) {
				System.out.println("dead by blue");
				return 0;
			}

		}
		if (intersect4.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(green.getStroke().toString()))) {
				System.out.println("dead by green");
				return 0;
			}

		}
		return 2;

	}

}
