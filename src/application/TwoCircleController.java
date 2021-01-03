package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class TwoCircleController implements Initializable, Controller {

	@FXML
	private ImageView star;
	@FXML
	private Circle starcircle;

	@FXML
	private Pane circle1;

	@FXML
	private Arc arc14;

	@FXML
	private Arc arc11;

	@FXML
	private Arc arc13;

	@FXML
	private Arc arc12;

	@FXML
	private Pane circle2;

	@FXML
	private Arc arc4;

	@FXML
	private Arc arc3;

	@FXML
	private Arc arc2;

	@FXML
	private Arc arc1;
	private int duration1 = 0, duration2 = 0;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		setRotate(circle1, true, 0, 360, 10);

		setRotatei(circle2, true, 0, 360, 30);
		duration1 = 10;
		duration2 = 30;
	}

	private void setRotate(Pane r, boolean reverse, int angle, int end, int duration) {

		RotateTransition rt = new RotateTransition(Duration.seconds(5), r);

		rt.setAutoReverse(reverse);

		rt.setFromAngle(angle);
		rt.setToAngle(end);
		rt.setCycleCount(1000);

		rt.play();

	}

	private void setRotatei(Pane r, boolean reverse, int angle, int end, int duration)

	{

		RotateTransition rt = new RotateTransition(Duration.seconds(5), r);

//	rt.setAutoReverse(reverse);

		rt.setFromAngle(angle);
		rt.setToAngle(end);
		rt.setCycleCount(1000);

		rt.play();

	}

	public void increasedifficulty(int c) {
		duration1 = duration1 - c;
		duration2 = duration2 - c;

		setRotate(circle1, true, 0, 360, 10);

		setRotatei(circle2, true, 0, 360, 30);

	}

	@Override
	public int Collision(Shape player, String color) {
		Shape intersect1 = Shape.intersect(player, arc1);
		Shape intersect2 = Shape.intersect(player, arc2);
		Shape intersect3 = Shape.intersect(player, arc3);
		Shape intersect4 = Shape.intersect(player, arc4);
		Shape intersect5 = Shape.intersect(player, arc11);
		Shape intersect6 = Shape.intersect(player, arc12);
		Shape intersect7 = Shape.intersect(player, arc13);
		Shape intersect8 = Shape.intersect(player, arc14);

		if (intersect1.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(arc1.getStroke().toString()))) {
				System.out.println("dead by arc1");
				// circle1.getChildren().remove(arc1);
				return 0;
			}

		}
		if (intersect2.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(arc2.getStroke().toString()))) {
				System.out.println("dead by arc2");
				return 0;
			}

		}
		if (intersect3.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(arc3.getStroke().toString()))) {
				System.out.println("dead by arc3");
				return 0;
			}

		}
		if (intersect4.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(arc4.getStroke().toString()))) {
				System.out.println("dead by arc4");
				return 0;
			}

		}
		if (intersect5.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(arc11.getStroke().toString()))) {
				System.out.println("dead by arc11");
				return 0;
			}

		}
		if (intersect6.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(arc12.getStroke().toString()))) {
				System.out.println("dead by arc12" + arc12.getFill().toString());
				return 0;
			}

		}
		if (intersect7.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(arc13.getStroke().toString()))) {
				System.out.println("dead by arc13");
				return 0;
			}

		}
		if (intersect8.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(arc14.getStroke().toString()))) {
				System.out.println("dead by arc14" + player.getFill() + " " + arc14.getStroke().toString());
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

	}

}
