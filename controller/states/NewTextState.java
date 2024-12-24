package controller.states;

import controller.DrawingController;
import controller.actions.AddAction;
import controller.actions.DrawAction;
import model.objects.Text;
import model.shapes.ShapeType;

import java.awt.*;

public class NewTextState extends ActionState {
    public NewTextState(DrawingController c) {
        super(c);
    }

    public void processPress(Point p, boolean isAdditionalButtonPressed) {
        String text = controller.getStateAdapter().getTextInput("Text to be inserted:");

        Text newShape = (Text) controller.getDrawing().getShapePrototype(ShapeType.Text);
        newShape = (Text) newShape.setColor(controller.getColor());
        newShape = (Text) newShape.setPoint1(p);
        newShape = newShape.setText(text);
        newShape = newShape.setFont(controller.getFontSize());

        DrawAction add = new AddAction(controller.getDrawing(), newShape);
        controller.addAction(add);
    }
}
