package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Squarecontroller implements Initializable, Controller {

	@FXML
	private Pane pane4;

	@FXML
	private Line yellow;

	@FXML
	private Line pink;

	@FXML
	private Line blue;

	@FXML
	private Line purple;

	@FXML
	private ImageView star;

	@FXML
	private Circle starcircle;
	private int duration = 0;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		setRotate(pane4, true, 360, 10);
		duration = 10;

	}

	public void increasedifficulty(int c) {
		System.out.println("in increased difficulty");
		if (duration - c > 0) {
			duration = duration - c;
			setRotate(pane4, true, 360, duration);

		}

	}

	private void setRotate(Pane r, boolean reverse, int angle, int duration) {
		RotateTransition rt = new RotateTransition(Duration.seconds(duration), r);

		// rt.setAutoReverse(reverse);
		rt.setByAngle(angle);
		rt.setDelay(Duration.seconds(0));
		rt.setRate(2);
		rt.setCycleCount(1000);
		rt.play();
	}

	public int Collision(Shape player, String color) {
		// TODO Auto-generated method stub
		Shape intersect1 = Shape.intersect(player, pink);
		Shape intersect2 = Shape.intersect(player, yellow);
		Shape intersect3 = Shape.intersect(player, blue);
		Shape intersect4 = Shape.intersect(player, purple);

		if (intersect1.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(pink.getStroke().toString()))) {
				System.out.println("dead by pinkbig");
				// circle1.getChildren().remove(arc1);
				return 0;
			}

		}
		if (intersect2.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(yellow.getStroke().toString()))) {
				System.out.println("dead by yellowbig");
				return 0;
			}

		}
		if (intersect3.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(blue.getStroke().toString()))) {
				System.out.println("dead by bluebig" + player.getFill().toString() + " " + blue.getStroke().toString());
				return 0;
			}

		}
		if (intersect4.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(purple.getStroke().toString()))) {
				System.out.println("dead by purplebig");
				return 0;
			}

		}
		if (starcircle != null) {

			Shape intersect = Shape.intersect(starcircle, player);
			if (starcircle != null && intersect.getBoundsInParent().getWidth() > 0) {

				starcircle = null;

				star.setVisible(false);
				return 1;
			}
		}

		return 2;

		// return false;
	}

}
