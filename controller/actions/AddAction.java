package controller.actions;

import model.Drawing;
import model.shapes.Shape;

import java.awt.*;

/**
 * События добавления объекта на рисунов
 */
public class AddAction implements DrawAction,MoveUpdate {

	Drawing d;
	Shape s;

	/**
	 * Creates an AddAction that adds the given Shape to the given Drawing.
	 *
	 * @param dr
	 *            the drawing into which the shape should be added.
	 * @param sh
	 *            the shape to be added.
	 */
	public AddAction(Drawing dr, Shape sh) {

        this.d = dr;
		this.s = sh;
	}

	public void execute() {
		d.insertShape(s);
	}

	public String getDescription() {
		return null;
	}

	public void redo() {
		this.execute();
	}

	public void undo() {
		d.removeShape(s);
	}

	public AddAction moveUpdate(Point m) {
		s = s.updatePoint2(m);
		return this;
	}
}
