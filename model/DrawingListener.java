package model;

public interface DrawingListener {

public void shapeAppend(Shape shape);

public void shapeDeleted(Shape shape);

public void shapeUpdated(Shape shape);

public void shapeAppendToSelection(Shape shape);

public void shapeRemovedFromSelection(Shape shape);

}
