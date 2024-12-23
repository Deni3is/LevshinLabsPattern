package controller.actions;

import model.Selection;
import model.Shape;
import model.VectorDrawing;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Меняет цвет выбранных фигур
 */
public class ColorAction implements DrawAction {

	Shape shape;

	Color oldColor;
	Color newColor;

	VectorDrawing d;

	/**
	 * Creates an ColorAction that changes the color of a given Shape.
	 *
	 * @param s
	 *            the shape to be modified.
	 * @param newColor
	 *            the new color for the shape.
	 */
	public ColorAction(Shape s, Color newColor, VectorDrawing d) {
		shape = s;
		this.oldColor = s.getColor();
		this.newColor = newColor;
		this.d = d;
	}

	public void execute() { d.colorShape(shape, newColor); }

	public String getDescription() {
		return null;
	}

	public void redo() {
		this.execute();
	}

	public void undo() {
		d.colorShape(shape, oldColor);
	}

}
