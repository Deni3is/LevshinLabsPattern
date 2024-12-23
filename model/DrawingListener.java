package model;
import java.util.ArrayList;

public interface DrawingListener {

public void shapeAppended(Shape shape);

public void shapeDeleted(Shape shape);

public void shapeUpdated(Shape shape);

public void shapeAppendedToSelection(Shape shape);

public void selectionCleared(ArrayList<Shape> shapes);

}
