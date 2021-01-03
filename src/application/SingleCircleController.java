package application;

import java.net.URL;
import java.util.ResourceBundle;

//import com.sun.javafx.geom.Shape;

import javafx.animation.RotateTransition;

import javafx.fxml.FXML;

import javafx.scene.image.ImageView;

import javafx.fxml.Initializable;

import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class SingleCircleController implements Initializable, Controller {
	boolean first = true;
	@FXML
	private ImageView colorswitchball;

	@FXML
	private Circle colorswitch;
	@FXML
	private AnchorPane Base;

	@FXML
	private Pane obstaclepane;

	@FXML
	private Arc arc1;

	@FXML
	private Arc arc2;

	@FXML
	private Arc arc3;

	@FXML
	private Arc arc4;

	@FXML
	private ImageView star;

	@FXML
	private Circle starcircle;

	float velocity = 1f;
	float acceleration = 1f;
	boolean once = false;
	private Arc array[];
	private int duration = 10;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		setRotate(obstaclepane, true, 360, 8);
		duration = 10;
		array = new Arc[4];
		array[0] = arc1;
		array[1] = arc2;
		array[2] = arc3;
		array[3] = arc4;

	}

	public void increasedifficulty(int c) {
		System.out.println("in increased difficulty");
		if (duration - c > 0) {
			duration = duration - c;
			setRotate(obstaclepane, true, 360, duration);

		}

	}

	public Arc[] getparts() {
		return array;
	}

	public int Collision(Shape player, String color) {
		Shape intersect1 = Shape.intersect(player, arc1);
		Shape intersect2 = Shape.intersect(player, arc2);
		Shape intersect3 = Shape.intersect(player, arc3);
		Shape intersect4 = Shape.intersect(player, arc4);
		if (intersect1.getBoundsInParent().getWidth() > 0)

		{
			if (!(player.getFill().toString().contentEquals(arc1.getStroke().toString()))) {
				System.out.println("dead by arc1");
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
				System.out
						.println("dead by arc4" + "player" + player.getFill() + "  arc4" + arc4.getStroke().toString());
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

			if (colorswitch.getId().contentEquals("colorswitch")) {
				first = false;
				int a = (int) (Math.random() * (Main.colorlist().size() - 1));

				while (Main.colorlist().get(a).contentEquals(player.getFill().toString())) {

					a = (int) (Math.random() * (Main.colorlist().size() - 1));
				}
				System.out.println(Main.colorlist().get(a).toString() + " " + player.getFill().toString());
				player.setFill(Color.web(Main.colorlist().get(a), 1));
				colorswitch.setVisible(false);
				colorswitchball.setVisible(false);
				// return true;
			}

		}

		return 2;

	}

	private void setRotate(Pane r, boolean reverse, int angle, int duration)

	{

		RotateTransition rt = new RotateTransition(Duration.seconds(duration), r);
		rt.setFromAngle(0);
		rt.setToAngle(360);
		rt.setCycleCount(1000);

		rt.play();

	}

}
