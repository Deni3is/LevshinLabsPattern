package controller.states;

import java.awt.*;
import controller.DrawingController;
import controller.actions.DeleteAction;
import controller.actions.FillAction;
import controller.actions.ColorAction;
import controller.actions.DrawAction;
import model.shapes.Shape;

public abstract class ActionState {
    protected DrawingController controller;

    public ActionState(DrawingController c) {
        controller = c;
    }

    public void processPress(Point p, boolean isAdditionalButtonPressed) {}
    public void processDrag(int difX, int difY) {}
    public void processRelease() {}
    public void processDelete() {
        DrawAction del = new DeleteAction(controller.getDrawing(), controller.getDrawing().getSelection());
        controller.addAction(del);
    }
    public void processSelectAll() {
        controller.getDrawing().emptySelection();
        controller.getDrawing().addAllShapesToSelection();
    }
    public void clearSelection() {
        controller.getDrawing().emptySelection();
    }
    public void processUpdateColor(Color c) {
        for (Shape s : controller.getDrawing().getSelection()) {
            DrawAction col = new ColorAction(s, c, controller.getDrawing());
            controller.addAction(col);
        }
    }
    public void processUpdateIsFill() {
        DrawAction toggle = new FillAction(controller.getDrawing().getSelection(), controller.getDrawing());
        controller.addAction(toggle);
    }
    public void processUpdateFontSize() {}
    public void processStateChange() {}
}
