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

public class StarController implements Initializable, Controller {
	boolean first = true;

	@FXML
    private AnchorPane Base;

    @FXML
    private Pane starobs;

    @FXML
    private Circle starcircle1;

    @FXML
    private ImageView star1;

    @FXML
    private ImageView star3;

    @FXML
    private Circle starcircle3;

    @FXML
    private Circle starcircle2;

    @FXML
    private ImageView star2;

    @FXML
    private ImageView star4;

    @FXML
    private Circle starcircle4;

    @FXML
    private Circle starcircle5;

    @FXML
    private ImageView star5;

    @FXML
    private Circle starcircle6;

    @FXML
    private ImageView star6;

    @FXML
    private Circle starcircle7;

    @FXML
    private ImageView star7;

    @FXML
    private ImageView star8;

    @FXML
    private Circle starcircle8;

    @FXML
    private ImageView star9;

    @FXML
    private Circle starcircle9;

	float velocity = 1f;
	float acceleration = 1f;
	boolean once = false;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setRotate(starobs, true, 360, 5);
	}
	private void setRotate(Pane r, boolean reverse, int angle, int duration)

	{

		RotateTransition rt = new RotateTransition(Duration.seconds(duration), r);
		rt.setFromAngle(0);
		rt.setToAngle(360);
		rt.setCycleCount(1000);

		rt.play();

	}
	public void increasedifficulty(int c) {
		System.out.println("in increased difficulty");
		/*
		 * if(duration -c>0) { duration=duration -c;
		 * setRotate(obstaclepane,true,360,duration);
		 * 
		 * }
		 */

	}

	public int Collision(Shape player, String color) {

		if (starcircle1 != null) {

			Shape intersect = Shape.intersect(starcircle1, player);
			if (starcircle1 != null && intersect.getBoundsInParent().getWidth() > 0) {

				starcircle1 = null;

				star1.setVisible(false);
				return 1;
			}
		}

		if (starcircle2 != null) {

			Shape intersect = Shape.intersect(starcircle2, player);
			if (starcircle2 != null && intersect.getBoundsInParent().getWidth() > 0) {

				starcircle2 = null;

				star2.setVisible(false);
				return 1;
			}
		}

		if (starcircle3 != null) {

			Shape intersect = Shape.intersect(starcircle3, player);
			if (starcircle3 != null && intersect.getBoundsInParent().getWidth() > 0) {

				starcircle3 = null;

				star3.setVisible(false);
				return 1;
			}
		}
		if (starcircle4 != null) {

			Shape intersect = Shape.intersect(starcircle4, player);
			if (starcircle4 != null && intersect.getBoundsInParent().getWidth() > 0) {

				starcircle4 = null;

				star4.setVisible(false);
				return 1;
			}
		}
		if (starcircle5 != null) {

			Shape intersect = Shape.intersect(starcircle5, player);
			if (starcircle5 != null && intersect.getBoundsInParent().getWidth() > 0) {

				starcircle5 = null;

				star5.setVisible(false);
				return 1;
			}
		}
		//return 2;

	
	if (starcircle6 != null) {

		Shape intersect = Shape.intersect(starcircle6, player);
		if (starcircle6 != null && intersect.getBoundsInParent().getWidth() > 0) {

			starcircle6 = null;

			star6.setVisible(false);
			return 1;
		}
	}
	//return 2;


if (starcircle7 != null) {

	Shape intersect = Shape.intersect(starcircle7, player);
	if (starcircle7 != null && intersect.getBoundsInParent().getWidth() > 0) {

		starcircle7 = null;

		star7.setVisible(false);
		return 1;
	}
}
//return 2;


if (starcircle8 != null) {

	Shape intersect = Shape.intersect(starcircle8, player);
	if (starcircle8 != null && intersect.getBoundsInParent().getWidth() > 0) {

		starcircle8 = null;

		star8.setVisible(false);
		return 1;
	}



}
if (starcircle9 != null) {

	Shape intersect = Shape.intersect(starcircle9, player);
	if (starcircle9 != null && intersect.getBoundsInParent().getWidth() > 0) {

		starcircle9 = null;

		star9.setVisible(false);
		return 1;
	}
}
return 2;

}

}
