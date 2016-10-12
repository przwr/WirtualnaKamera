package objects;

import javafx.geometry.Point3D;

import java.util.ArrayList;

/**
 * Created by przemek on 06.10.16.
 */
public class Street extends Object3D {

    public Street(Point3D p1, Point3D p2, Point3D p3, Point3D p4) {
        this.faces = new ArrayList<>(1);
        ArrayList<Line3D> lines = new ArrayList<>(4);

//        clockwise order
        Line3D line1 = new Line3D(p1, p2);
        Line3D line2 = new Line3D(p2, p3);
        Line3D line3 = new Line3D(p3, p4);
        Line3D line4 = new Line3D(p4, p1);
        lines.add(line1);
        lines.add(line2);
        lines.add(line3);
        lines.add(line4);

        faces.add(new Face(lines));
    }
}