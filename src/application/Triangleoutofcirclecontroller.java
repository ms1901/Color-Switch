package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Triangleoutofcirclecontroller implements Initializable, Controller {

	@FXML
	private Pane outsidepane;

	@FXML
	private Line yellowtri;

	@FXML
	private Line pinktri;

	@FXML
	private Line purpletri;

	@FXML
	private Pane insidepane1;

	@FXML
	private Arc purplecir;

	@FXML
	private Arc pinkcir;

	@FXML
	private Arc yellowcir;

	@FXML
	private Arc bluecir;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		setRotate(outsidepane, true, 0, 360, 10);
		setRotate(insidepane1, true, 360, 0, 10);
	}

	public void increasedifficulty(int c) {
		/*
		 * System.out.println("in increased difficulty"); if(duration -c>0) {
		 * duration=duration -c; setRotate(obstaclepane,true,360,duration);
		 * 
		 * }
		 */

	}

	private void setRotate(Pane r, boolean reverse, int angle, int end, int duration)

	{

		RotateTransition rt = new RotateTransition(Duration.seconds(3), r);

		// rt.setAutoReverse(reverse);

		rt.setFromAngle(angle);
		rt.setToAngle(end);
		rt.setCycleCount(100);

		rt.play();

	}

	@Override
	public int Collision(Shape player, String color) {
		Shape intersect1 = Shape.intersect(player, pinktri);
		Shape intersect2 = Shape.intersect(player, yellowtri);
		Shape intersect3 = Shape.intersect(player, purpletri);
		Shape intersect4 = Shape.intersect(player, pinkcir);
		Shape intersect5 = Shape.intersect(player, yellowcir);
		Shape intersect6 = Shape.intersect(player, bluecir);
		Shape intersect7 = Shape.intersect(player, purplecir);

		if (intersect1.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(pinktri.getStroke().toString()))) {
				System.out.println("dead by pinkbig");
				// circle1.getChildren().remove(arc1);
				return 0;
			}

		}
		if (intersect2.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(yellowtri.getStroke().toString()))) {
				System.out.println("dead by yellowbig");
				return 0;
			}

		}
		if (intersect3.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(purpletri.getStroke().toString()))) {
				System.out.println("dead by purpletri");
				return 0;

			}

		}
		if (intersect4.getBoundsInParent().getWidth() > 0) {
			if (!(player.getFill().toString().contentEquals(pinkcir.getStroke().toString()))) {
				System.out.println("dead by pink circle");
				return 0;
			}

		}
		/*
		 * if (intersect5.getBoundsInParent().getWidth()>0) {
		 * if(!(player.getFill().toString().contentEquals(yellowcir.getStroke().toString
		 * ()))) {System.out.println("dead by yellow"); }
		 * 
		 * }
		 * 
		 * if (intersect6.getBoundsInParent().getWidth()>0) {
		 * if(!(player.getFill().toString().contentEquals(bluecir.getStroke().toString()
		 * ))) {System.out.println("dead by blue"); }
		 * 
		 * } if (intersect7.getBoundsInParent().getWidth()>0) {
		 * if(!(player.getFill().toString().contentEquals(purplecir.getStroke().toString
		 * ()))) {System.out.println("dead by purple circle"); }
		 * 
		 * }
		 */

		return 2;

	}
}
