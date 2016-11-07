package objects;


import java.util.ArrayList;

/**
 * Created by przemek on 10.10.16.
 */
public class ObjectCreator {


    public static Block createStreetBlock() {
        float zStart = 150;
        float zEnd = 1000;


        Point4D p1 = new Point4D(-100, 0, zStart);
        Point4D p2 = new Point4D(-100, 0, zEnd);
        Point4D p3 = new Point4D(100, 0, zEnd);
        Point4D p4 = new Point4D(100, 0, zStart);

        float height = 1; //Współrzędna Y-kowa

        Point4D p5= new Point4D(-100, height, zStart);
        Point4D p6 = new Point4D(-100, height, zEnd);
        Point4D p7 = new Point4D(100, height, zEnd);
        Point4D p8 = new Point4D(100, height, zStart);

        return new Block(p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public static Block createBlockOne() {
        Point4D p1 = new Point4D(-200, 0, 400);
        Point4D p2 = new Point4D(-300, 0, 500);
        Point4D p3 = new Point4D(-400, 0, 400);
        Point4D p4 = new Point4D(-300, 0, 300);

        float height = 300; //Współrzędna Y-kowa

        Point4D p5 = new Point4D(-200, height, 400);
        Point4D p6 = new Point4D(-300, height, 500);
        Point4D p7 = new Point4D(-400, height, 400);
        Point4D p8 = new Point4D(-300, height, 300);

        return new Block(p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public static Block createBlockTwo() {
        Point4D p1 = new Point4D(500, 0, 600);
        Point4D p2 = new Point4D(500, 0, 800);
        Point4D p3 = new Point4D(700, 0, 800);
        Point4D p4 = new Point4D(700, 0, 600);

        float height = 600; //Współrzędna Y-kowa

        Point4D p5 = new Point4D(500, height, 600);
        Point4D p6 = new Point4D(500, height, 800);
        Point4D p7 = new Point4D(700, height, 800);
        Point4D p8 = new Point4D(700, height, 600);

        return new Block(p1, p2, p3, p4, p5, p6, p7, p8);
    }


    public static Face createFaceFromPoints(Point4D p1, Point4D p2, Point4D p3, Point4D p4) {
        ArrayList<Line3D> lines = new ArrayList<>(4);
//        clockwise Order
        Line3D line1 = new Line3D(p1, p2);
        Line3D line2 = new Line3D(p2, p3);
        Line3D line3 = new Line3D(p3, p4);
        Line3D line4 = new Line3D(p4, p1);
        lines.add(line1);
        lines.add(line2);
        lines.add(line3);
        lines.add(line4);

        return new Face(lines);
    }
}
