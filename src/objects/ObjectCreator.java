package objects;

import javafx.geometry.Point3D;

/**
 * Created by przemek on 10.10.16.
 */
public class ObjectCreator {

    public static Street createStreet() {
        Point3D p1 = new Point3D(900, 0, 0);
        Point3D p2 = new Point3D(700, 0, 1000);
        Point3D p3 = new Point3D(800, 0, 1000);
        Point3D p4 = new Point3D(1000, 0, 0);
        return new Street(p1, p2, p3, p4);
    }
}
