
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

public class Multiplecirclecontroller implements Initializable, Controller {

	@FXML
	private Pane circle1;

	@FXML
	private Arc pink1;

	@FXML
	private Arc blue1;

	@FXML
	private Arc purple1;

	@FXML
	private Arc yellow1;

	@FXML
	private Arc pink2;

	@FXML
	private Arc blue2;

	@FXML
	private Arc purple2;

	@FXML
	private Arc yellow2;

	@FXML
	private Circle starcircle;

	@FXML
	private ImageView star;
	private int duration = 0;

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		setRotate(circle1, true, 0, 360, 6);
		duration = 6;
		// setRotate(pane11,true,360,0,1);

		// setRotate(pane11,true,360,10);
		/*
		 * setRotate(purple1,true,360,10); setRotate(blue1,true,360,10);
		 * setRotate(yellow1,true,360,10); setRotate(pink1,true,360,10);
		 */

	}

	private void setRotate(Pane r, boolean reverse, int angle, int end, int duration)

	{

		RotateTransition rt = new RotateTransition(Duration.seconds(duration), r);

		// rt.setAutoReverse(reverse);

		rt.setFromAngle(angle);
		rt.setToAngle(end);
		rt.setCycleCount(18);

		rt.play();

	}

	public void increasedifficulty(int c) {
		System.out.println("in increased difficulty");
		if (duration - c > 0) {
			duration = duration - c;
			setRotate(circle1, true, 0, 360, duration);

		}

	}

	@Override
	public int Collision(Shape player, String color) {
		// TODO Auto-generated method stub
		Shape intersect1 = Shape.intersect(player, pink1);
		Shape intersect2 = Shape.intersect(player, yellow1);
		Shape intersect3 = Shape.intersect(player, blue1);
		Shape intersect4 = Shape.intersect(player, purple1);
		Shape intersect5 = Shape.intersect(player, pink2);
		Shape intersect6 = Shape.intersect(player, yellow2);
		Shape intersect7 = Shape.intersect(player, blue2);
		Shape intersect8 = Shape.intersect(player, purple2);

		if (intersect1.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(pink1.getStroke().toString()))) {
				System.out.println("dead by pink1");
				// circle1.getChildren().remove(arc1);
				return 0;
			}

		}
		if (intersect2.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(yellow1.getStroke().toString()))) {
				System.out.println("dead by yellow1");
				return 0;
			}

		}
		if (intersect3.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(blue1.getStroke().toString()))) {
				System.out.println("dead by blue1" + player.getFill().toString() + " " + blue1.getStroke().toString());
				return 0;
			}

		}
		if (intersect4.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(purple1.getStroke().toString()))) {
				System.out.println("dead by purple1");
				return 0;
			}

		}
		if (intersect5.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(pink2.getStroke().toString()))) {
				System.out.println("dead by pink2");
				return 0;
			}

		}
		if (intersect6.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(yellow2.getStroke().toString()))) {
				System.out.println("dead by yellow2");
				return 0;
			}

		}
		if (intersect7.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(blue2.getStroke().toString()))) {
				System.out.println("dead by blue2");
				return 0;
			}

		}
		if (intersect8.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(purple2.getStroke().toString()))) {
				System.out.println("dead by purple2");
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

		/*
		 * if (intersect9.getBoundsInParent().getWidth()>0) {
		 * if(!(player.getFill().toString().contentEquals(pink3.getStroke().toString()))
		 * ) {System.out.println("dead by pink3"); }
		 * 
		 * } if (intersect10.getBoundsInParent().getWidth()>0) {
		 * if(!(player.getFill().toString().contentEquals(yellow3.getStroke().toString()
		 * ))) {System.out.println("dead by yellow3"); }
		 * 
		 * } if (intersect11.getBoundsInParent().getWidth()>0) {
		 * if(!(player.getFill().toString().contentEquals(blue3.getStroke().toString()))
		 * ) {System.out.println("dead by blue3"); }
		 * 
		 * } if (intersect12.getBoundsInParent().getWidth()>0) {
		 * if(!(player.getFill().toString().contentEquals(purple3.getStroke().toString()
		 * ))) {System.out.println("dead by purple3"); }
		 * 
		 * }
		 */

		return 2;
	}

}
