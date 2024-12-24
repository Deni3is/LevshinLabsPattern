package model.objects;

import model.shapes.FillableShape;
import model.shapes.ShapeType;

public class Rectangle extends FillableShape {

	public Rectangle(int x, int y, boolean filled) {
		super(x, y);
		this.filled = filled;
	}

	@Override
	public ShapeType getType() {
		return ShapeType.Rectangle;
	}

	public String toString() {
		return "rect;" + super.toString();
	}

	@Override
	public Rectangle clone() {
		return (Rectangle) super.clone();
	}
}