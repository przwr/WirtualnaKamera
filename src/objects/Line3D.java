package objects;

import javafx.geometry.Point3D;
import javafx.scene.shape.Line;
import main.Main;

/**
 * Created by przemek on 06.10.16.
 */
public class Line3D {

    Point4D first;
    Point4D second;

    Line onScreen = new Line(0, 0, 25, 25);

    public Line3D(Point4D first, Point4D second) {
        this.first = first;
        this.second = second;
    }

    public Point4D getFirst() {
        return first;
    }

    public Point4D getSecond() {
        return second;
    }

    public Line getOnScreen() {
        return onScreen;
    }


    public void setOnScreen(double startX, double startY, double endX, double endY) {
        onScreen.setStartX(startX + Main.screenX / 2);
        onScreen.setStartY(-startY + Main.screenY / 2);
        onScreen.setEndX(endX + Main.screenX / 2);
        onScreen.setEndY(-endY + Main.screenY / 2);
    }
}
