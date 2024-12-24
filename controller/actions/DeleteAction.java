package controller.actions;

import model.Drawing;
import model.shapes.Shape;

/**
 * Удаление выбранных фигур с рисунка
 */
public class DeleteAction implements DrawAction {

	Drawing d;
	Iterable<Shape> selection;

	int position;

	/**
	 * Creates an DeleteAction that removes all shapes in the given Selection
	 * from the given Drawing.
	 *
	 * @param drawing
	 *            the drawing into which the shape should be added.
	 * @param selection
	 *            the shape to be added.
	 */
	public DeleteAction(Drawing drawing, Iterable<Shape>  selection) {
		this.selection = selection;
		this.d = drawing;
	}

	public void execute() {
		for (Shape s : selection) {
			d.removeShape(s);
		}
	}

	public String getDescription() {
		return null;
	}

	public void redo() {
		execute();
	}

	public void undo() {
		for (Shape s : selection) {
			d.insertShape(s);
		}
	}

}
