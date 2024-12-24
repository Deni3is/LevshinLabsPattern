package controller.actions;

import model.*;
import model.shapes.Shape;

/**
 * Заливка выбранных фигур
 */
public class FillAction implements DrawAction {

	Iterable<Shape> selected;
	Drawing d;

	/**
	 * Creates a FillAction that filps the fill status of all FillableShape
	 * instances in the given selection.
	 *
	 * @param s
	 *            a selection which contains the shapes to be modified
	 */
	public FillAction(Iterable<Shape> s, Drawing d) {
		this.selected = s;
		this.d = d;
	}

	public void execute() {
		for (Shape s : selected) {
			d.fillShape(s);
		}
	}

	public String getDescription() {
		return null;
	}

	public void redo() {
		execute();
	}

	public void undo() {
		execute();
	}

}
