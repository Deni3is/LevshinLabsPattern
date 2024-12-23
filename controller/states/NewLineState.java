package controller.states;

import controller.DrawingController;
import controller.actions.AddAction;
import controller.actions.DrawAction;
import model.Line;
import model.Shape;
import model.ShapeType;
import java.awt.*;

public class NewLineState extends DrawingState {
    public NewLineState(DrawingController c) {
        super(c);
    }

    Shape newShape;

    @Override
    public void processPress(Point p, boolean isAdditionalButtonPressed) {
        if (newShape != null) {
            controller.getStateAdapter().constructionEnd(newShape);
        }

        newShape = controller.getDrawing().getShapePrototype(ShapeType.Line);
        newShape = newShape.setPoint1(p);
        newShape = newShape.setPoint2(p);
        newShape = newShape.setColor(controller.getColor());

        controller.getStateAdapter().constructionStart(newShape);
    }

    @Override
    public void processDrag(int difX, int difY) {
        if (newShape != null) {
            Point newPoint2 = new Point(newShape.getPoint2().x + difX, newShape.getPoint2().y + difY);
            newShape = newShape.setPoint2(newPoint2);

            controller.getStateAdapter().constructionUpdate(newShape);
        }
    }

    @Override
    public void processRelease() {
        if (newShape != null) {
            controller.getStateAdapter().constructionEnd(newShape);

            DrawAction add = new AddAction(controller.getDrawing(), newShape);
            controller.addAction(add);
            newShape = null;
        }
    }

    @Override
    public void processStateChange() {
        if (newShape != null) {
            controller.getStateAdapter().constructionEnd(newShape);
            newShape = null;
        }
    }
}
