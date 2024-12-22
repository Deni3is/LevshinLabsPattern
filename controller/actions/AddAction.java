package controller.actions;

import model.Drawing;
import model.Shape;

/**
 * События добавления объекта на рисунов
 */
public class AddAction implements DrawAction {

	Shape shape;
	Drawing drawing;
	/**
	 * Конструктор
	 * @param drawing - полотно
	 * @param shape - фигура
	 */
	public AddAction(Drawing drawing, Shape shape) {
		this.drawing = drawing;
		this.shape = shape;
	}

	public Boolean execute() {
		Boolean checkForExecution = shape != null && drawing != null;
		if (checkForExecution) {
			drawing.insertShape(shape);
		}
		return checkForExecution;
	}

	public void redo() {
		this.execute();
	}

	public void undo() {
		drawing.removeShape(shape);
	}

	public String getDescription() {
		return null;
	}

}
