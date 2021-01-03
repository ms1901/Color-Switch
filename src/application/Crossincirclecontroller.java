package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Crossincirclecontroller implements Initializable, Controller {

	@FXML
	private ImageView colorswitchball;

	@FXML
	private Circle colorswitch;
	@FXML
	private Pane innerpane;
	boolean first = true;
	@FXML
	private Line yellowline;

	@FXML
	private Line blueline;

	@FXML
	private Line purpleline;

	@FXML
	private Line pinkline;

	@FXML
	private Pane outerpane;

	@FXML
	private Arc pinkcir;

	@FXML
	private Arc bluecir;

	@FXML
	private Arc purplecir;

	@FXML
	private Arc yellowcir;

	@FXML
	private ImageView star;

	@FXML
	private Circle starcircle;

	private int duration = 0;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		setRotate(outerpane, true, 360, 10);
		setRotate(innerpane, true, 360, 10);
		duration = 10;
		// setRotate(pane1,true,360,10);
		// setRotate(pane2,true,360,10);

	}

	public void increasedifficulty(int c) {
		duration = duration - c;
		setRotate(outerpane, true, 360, duration);
		setRotate(innerpane, true, 360, duration);

	}

	private void setRotate(Pane r, boolean reverse, int angle, int duration) {
		RotateTransition rt = new RotateTransition(Duration.seconds(duration), r);

		rt.setAutoReverse(reverse);
		rt.setByAngle(angle);
		rt.setDelay(Duration.seconds(0));
		rt.setRate(2);
		rt.setCycleCount(18);
		rt.play();
	}

	@Override
	public int Collision(Shape player, String color) {
		// TODO Auto-generated method stub
		Shape intersect1 = Shape.intersect(player, pinkcir);
		Shape intersect2 = Shape.intersect(player, yellowcir);
		Shape intersect3 = Shape.intersect(player, bluecir);
		Shape intersect4 = Shape.intersect(player, purplecir);
		Shape intersect5 = Shape.intersect(player, pinkline);
		Shape intersect6 = Shape.intersect(player, yellowline);
		Shape intersect7 = Shape.intersect(player, blueline);
		Shape intersect8 = Shape.intersect(player, purpleline);

		if (intersect1.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(pinkcir.getStroke().toString()))) {
				System.out.println("dead by pinkbig");
				// circle1.getChildren().remove(arc1);
				return 0;
			}

		}
		if (intersect2.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(yellowcir.getStroke().toString()))) {
				System.out.println("dead by yellowbig");
				return 0;
			}

		}
		if (intersect3.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(bluecir.getStroke().toString()))) {
				return 0;
			}

		}
		if (intersect4.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(purplecir.getStroke().toString()))) {
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
		Shape intersect = Shape.intersect(player, colorswitch);
		if (first && intersect.getBoundsInParent().getWidth() > 0) {
			// collisionDetected = true;
			if (colorswitch.getId().contentEquals("colorswitch")) {
				int a = (int) (Math.random() * (Main.colorlist().size() - 1));
				player.setFill(Color.web(Main.colorlist().get(a), 1));
				colorswitch.setVisible(false);
				colorswitchball.setVisible(false);
				// return true;
				first = false;
			}

		}

		return 2;

	}

}
