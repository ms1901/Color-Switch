package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

public class Player extends Actor {
	Boolean first = true;
	protected Shape shape;
	protected float acceleration;

	protected float getAcceleration() {
		return acceleration;
	}

	protected void setAcceleration(float acceleration) {
		this.acceleration = acceleration;
	}

	Player(Shape shape, String color) {
		this.shape = shape;
		this.color = color;

	}

	protected Shape getshape() {
		return this.shape;
	}

	@Override
	protected void setXpos(float xpos) {
		// TODO Auto-generated method stub
		// not really needed

	}

	@Override
	protected void setYpos(float ypos) {
		// TODO Auto-generated method stub
		this.shape.setLayoutY(this.shape.getLayoutY() + ypos);

	}

	@Override
	protected void setColor(Paint color) {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean CollidesWith(Shape act, String color) {
		// TODO Auto-generated method stub

		Shape intersect = Shape.intersect(act, this.getshape());
		if (first && intersect.getBoundsInParent().getWidth() > 0) {
			// System.out.println("manasvi");
			first = false;
			// collisionDetected = true;
			if (act.getId().contentEquals("colorswitch")) {
				int a = (int) (Math.random() * (Main.colorlist().size() - 1));
				this.shape.setFill(Color.web(Main.colorlist().get(a), 1));
				return true;
			}

		}

		return false;
	}

}
