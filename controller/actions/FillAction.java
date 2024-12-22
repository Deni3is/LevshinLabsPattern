package controller.actions;

import model.Selection;
import model.FillableShape;
import model.Shape;

/**
 * Заливка выбранных фигур
 */
public class FillAction implements DrawAction {

	private Selection selection;

	/**
	 * Конструктор
	 * @param selection - выбранные фигуры
	 */
	public FillAction(Selection selection) {
		this.selection = selection.clone();
	}

	public Boolean execute() {
		Boolean checkForExecution = selection != null && !selection.isEmpty();
		if (checkForExecution) {
			for (Shape s : selection) {
				if (s instanceof FillableShape fillableShape) {
                    fillableShape.setFilled(!(fillableShape).getFilled());
				}
			}
		}
		return checkForExecution;
	}

	public void redo() {
		execute();
	}

	public void undo() {
		execute();
	}

	public String getDescription() {
		return null;
	}

}
