package model.objects;


import model.shapes.FillableShape;
import model.shapes.ShapeType;

public class Circle extends FillableShape {

	public Circle(int x, int y, boolean filled) {
		super(x, y);
		this.filled = filled;
	}

	@Override
	public ShapeType getType() {
		return ShapeType.Circle;
	}

	public String toString() {
		return "circ;" + super.toString();
	}

	@Override
	public Circle clone() {
		return (Circle) super.clone();
	}
}
