package objects;

import javafx.geometry.Point3D;
import javafx.scene.shape.Line;

/**
 * Created by przemek on 06.10.16.
 */
public class Line3D {
    Point3D first;
    Point3D second;

    Line onScreen = new Line(0, 0, 25, 25);

    public Line3D(Point3D first, Point3D second) {
        this.first = first;
        this.second = second;
    }

    public Point3D getFirst() {
        return first;
    }

    public Point3D getSecond() {
        return second;
    }

    public Line getOnScreen() {
        return onScreen;
    }


    public void setOnScreen(double startX, double startY, double endX, double endY) {
        onScreen.setStartX(startX);
        onScreen.setStartY(startY);
        onScreen.setEndX(endX);
        onScreen.setEndY(endY);
    }
}
