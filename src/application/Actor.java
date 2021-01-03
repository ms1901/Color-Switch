package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

public abstract class Actor {
	protected float xpos;
	protected float ypos;
	protected String color;

	protected float getXpos() {
		return xpos;
	}

	protected abstract void setXpos(float xpos);

	protected float getYpos() {
		return ypos;
	}

	protected abstract void setYpos(float ypos);

	protected String getColor() {
		return color;
	}

	protected abstract void setColor(Paint color);

	protected abstract boolean CollidesWith(Shape act, String color);

}
