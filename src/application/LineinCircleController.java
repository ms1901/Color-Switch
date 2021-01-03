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
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class LineinCircleController implements Initializable, Controller {

	@FXML
	private Pane circle1;

	@FXML
	private Arc pinkarc;

	@FXML
	private Arc bluearc;

	@FXML
	private Arc purplearc;

	@FXML
	private Arc yellowarc;

	@FXML
	private Line pinkline;

	@FXML
	private Line purpleline;

	@FXML
	private Line blueline;

	@FXML
	private Line yellowline;

	@FXML
	private ImageView star;

	@FXML
	private Circle starcircle;

	private int duration = 0;

	public void initialize(URL arg0, ResourceBundle arg1) {

		setRotate(circle1, true, 360, 10);
		duration = 10;

	}

	private void setRotate(Pane r, boolean reverse, int angle, int duration)

	{
		RotateTransition rt = new RotateTransition(Duration.seconds(duration), r);
		rt.setFromAngle(0);
		rt.setToAngle(360);
		rt.setCycleCount(18);

		rt.play();

	}

	@Override
	public int Collision(Shape player, String color) {
		Shape intersect1 = Shape.intersect(player, pinkarc);
		Shape intersect2 = Shape.intersect(player, yellowarc);
		Shape intersect3 = Shape.intersect(player, bluearc);
		Shape intersect4 = Shape.intersect(player, purplearc);
		Shape intersect5 = Shape.intersect(player, pinkline);
		Shape intersect6 = Shape.intersect(player, yellowline);
		Shape intersect7 = Shape.intersect(player, blueline);
		Shape intersect8 = Shape.intersect(player, purpleline);

		if (intersect1.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(pinkarc.getStroke().toString()))) {
				System.out.println("dead by pinkbig");
				// circle1.getChildren().remove(arc1);
				return 0;
			}

		}
		if (intersect2.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(yellowarc.getStroke().toString()))) {
				System.out.println("dead by yellowbig");
				return 0;
			}

		}
		if (intersect3.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(bluearc.getStroke().toString()))) {
				return 0;
			}

		}
		if (intersect4.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(purplearc.getStroke().toString()))) {
				System.out.println("dead by purplecircle");
				return 0;
			}

		}
		if (intersect5.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(pinkline.getStroke().toString()))) {
				System.out.println("dead by pinkbig");
				// circle1.getChildren().remove(arc1);
				return 0;
			}

		}
		if (intersect6.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(yellowline.getStroke().toString()))) {
				System.out.println("dead by yellowbig");
				return 0;
			}

		}
		if (intersect7.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(blueline.getStroke().toString()))) {
				return 0;
			}

		}
		if (intersect8.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(purpleline.getStroke().toString()))) {
				System.out.println("dead by purplecircle");
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

	@Override
	public void increasedifficulty(int i) {
		// TODO Auto-generated method stub
		System.out.println("in increased difficulty");
		if (duration - i > 0) {
			duration = duration - i;
			setRotate(circle1, true, 360, duration);

		}

	}

}
