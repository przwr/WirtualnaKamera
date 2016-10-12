package main;

import javafx.geometry.Point3D;


public class Camera {
    Point3D position = new Point3D(0, 0, 0);
    double distance = 100; // ogniskowa

    public Point3D getPosition() {
        return position;
    }

    public double getDistance() {
        return distance;
    }
}
