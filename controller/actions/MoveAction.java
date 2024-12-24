package controller.actions;

import model.shapes.Shape;
import model.Drawing;

import java.awt.*;

/**
 * Перемещение выбранных фигур
 */
public class MoveAction implements DrawAction,MoveUpdate {

	Iterable<Shape>  selected;
	Point movement;

	Drawing d;

	/**
	 * Creates a MoveAction that moves all Shapes in the given Selection in the
	 * direction given by the point. The movement is relative to the shapes
	 * original position.
	 *
	 * @param s
	 *            a selection which contains the shapes to be moved
	 * @param m
	 *            the amount the shapes should be moved, relative to the
	 *            original position
	 */
	public MoveAction(Iterable<Shape>  s, Point m, Drawing d) {
		this.selected = s;
		this.movement = m;
		this.d = d;
	}

	public void execute() {
		for (Shape s : selected) {
			d.moveShape(s, movement);
		}
	}

	public String getDescription() {
		return null;
	}

	public void redo() {
		execute();
	}

	public void undo() {
		Point reverseMovement = new Point(-movement.x, -movement.y);

		for (Shape s : selected) {
			d.moveShape(s, reverseMovement);
		}
	}

	public MoveAction moveUpdate(Point m) {
		Point newPoint = new Point(this.movement.x + m.x, this.movement.y + m.y);
		return new MoveAction(this.selected, newPoint, d);
	}
}
