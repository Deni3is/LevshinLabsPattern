package model.objects;

import model.shapes.Shape;
import model.shapes.ShapeType;

import java.awt.Point;

public class Line extends Shape {

	public Line(int x, int y) {
		super(new Point(x, y));
	}

	@Override
	public ShapeType getType() {
		return ShapeType.Line;
	}

	@Override
	public String toString() {
		return "line;" + super.toString();
	}

	@Override
	public Line clone() {
		return (Line) super.clone();
	}
}
