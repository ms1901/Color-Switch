package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Doublecrosscontroller implements Initializable, Controller {
	boolean first = true;
	@FXML
	private Pane pane2;

	@FXML
	private Line pinksmall;

	@FXML
	private Line purplesmall;

	@FXML
	private Line yellowsmall;

	@FXML
	private Line bluesmall;

	@FXML
	private Pane pane1;

	@FXML
	private Line purplebig;

	@FXML
	private Line bluebig;

	@FXML
	private Line yellowbig;

	@FXML
	private Line pinkbig;

	@FXML
	private Circle colorswitch;

	@FXML
	private ImageView colorswitchball;
	private int duration1 = 0;
	private int duration2 = 0;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// setRotate(outerpane,true,360,10);
		// setRotate(innerpane,true,360,10);
		setRotate(pane1, true, 360, 30);
		setRotate(pane2, true, 360, 30);
		duration1 = 30;
		duration2 = 30;

	}

	public void increasedifficulty(int c) {
		System.out.println("in increased difficulty");
		if (duration1 - c > 0) {
			duration1 = duration1 - c;
			setRotate(pane1, true, 360, duration1);

		}
		if (duration2 - c > 0) {
			duration2 = duration2 - c;
			setRotate(pane2, true, 360, duration2);

		}

	}

	private void setRotate(Pane r, boolean reverse, int angle, int duration) {
		RotateTransition rt = new RotateTransition(Duration.seconds(duration), r);

		// rt.setAutoReverse(reverse);
		rt.setByAngle(angle);
		// rt.setDelay(Duration.seconds(0));
		rt.setRate(5);
		rt.setCycleCount(100);
		rt.play();
	}

	@Override
	public int Collision(Shape player, String color) {
		// TODO Auto-generated method stub
		Shape intersect1 = Shape.intersect(player, pinkbig);
		Shape intersect2 = Shape.intersect(player, yellowbig);
		Shape intersect3 = Shape.intersect(player, bluebig);
		Shape intersect4 = Shape.intersect(player, purplebig);
		Shape intersect5 = Shape.intersect(player, pinksmall);
		Shape intersect6 = Shape.intersect(player, yellowsmall);
		Shape intersect7 = Shape.intersect(player, bluesmall);
		Shape intersect8 = Shape.intersect(player, purplesmall);

		if (intersect1.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(pinkbig.getStroke().toString()))) {
				System.out.println("dead by pinkbig");
				// circle1.getChildren().remove(arc1);
				return 0;
			}

		}
		if (intersect2.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(yellowbig.getStroke().toString()))) {
				System.out.println("dead by yellowbig");
				return 0;
			}

		}
		if (intersect3.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(bluebig.getStroke().toString()))) {
				System.out.println(
						"dead by bluebig" + player.getFill().toString() + " " + bluebig.getStroke().toString());
				return 0;
			}

		}
		if (intersect4.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(purplebig.getStroke().toString()))) {
				System.out.println("dead by purplebig");
				return 0;
			}

		}
		if (intersect5.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(pinksmall.getStroke().toString()))) {
				System.out.println("dead by pinksmall");
				return 0;
			}

		}
		if (intersect6.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(yellowsmall.getStroke().toString()))) {
				System.out.println("dead by yellowsmall");
				return 0;
			}

		}
		if (intersect7.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(bluesmall.getStroke().toString()))) {
				System.out.println(
						"dead by bluesmall" + player.getFill().toString() + " " + bluesmall.getStroke().toString());
				return 0;
			}

		}
		if (intersect8.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(purplesmall.getStroke().toString()))) {
				System.out.println("dead by purplesmall");
				return 0;
			}

		}
		Shape intersect = Shape.intersect(player, colorswitch);
		if (first && intersect.getBoundsInParent().getWidth() > 0) {

			if (colorswitch.getId().contentEquals("colorswitch")) {
				first = false;
				int a = (int) (Math.random() * (Main.colorlist().size() - 1));
				while (Main.colorlist().get(a).contentEquals(player.getFill().toString())) {
					a = (int) (Math.random() * (Main.colorlist().size() - 1));

				}
				System.out.println(Main.colorlist().get(a) + "   +player " + player.getFill().toString());

				player.setFill(Color.web(Main.colorlist().get(a), 1));
				colorswitch.setVisible(false);
				colorswitchball.setVisible(false);
				// return true;
			}

		}

		return 2;
	}

}
