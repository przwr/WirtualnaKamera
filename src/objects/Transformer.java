package objects;

import org.lwjgl.util.vector.Matrix4f;

/**
 * Created by Przemek Wróbel on 10.10.16.
 */
public class Transformer {


    public static Matrix4f transformationMatrix = new Matrix4f();


    public static void translatePosition(Line3D line3d) {
        Point4D first = line3d.getFirst();
        Point4D second = line3d.getSecond();

        first.multiply(transformationMatrix);
        second.multiply(transformationMatrix);
    }


    public static void setTranslationMatrix(float dx, float dy, float dz) {
        transformationMatrix.setZero();
        transformationMatrix.m00 = transformationMatrix.m11 = transformationMatrix.m22 = 1;
        transformationMatrix.m03 = dx;
        transformationMatrix.m13 = dy;
        transformationMatrix.m23 = dz;
    }

    public static void updatePosition(Line3D line3d) {
        Point4D first = line3d.getFirst();
        Point4D second = line3d.getSecond();

        float x1 = first.getX();
        float y1 = first.getY();
        float z1 = first.getZ();
        float x2 = second.getX();
        float y2 = second.getY();
        float z2 = second.getZ();

        float distance = 200;
        float scale = 1.0f;

        float x1Screen = ((x1 * distance) / (z1 + distance)) * scale;
        float y1Screen = ((y1 * distance) / (z1 + distance)) * scale;
        float x2Screen = ((x2 * distance) / (z2 + distance)) * scale;
        float y2Screen = ((y2 * distance) / (z2 + distance)) * scale;

        line3d.setOnScreen(x1Screen, y1Screen, x2Screen, y2Screen);
    }


//    Kąt w radianach
//    http://www.dimmension3.spine.pl/modules.php?name=Tutorials&wtd=show_tutorial&nr=19


//
//
//
//    public static void rotateLine(Camera camera, double angle, Line3D line3d) {
//        double point1x = line3d.getOnScreen().getStartX();
//        double point1y = line3d.getOnScreen().getStartY();
//        double point2x = line3d.getOnScreen().getEndX();
//        double point2y = line3d.getOnScreen().getEndY();
//        Point3D cameraPosition = camera.getPosition();
//        double newX1 = cameraPosition.getX() + (point1x - cameraPosition.getX()) * FastMath.cos(angle) - (point1y - cameraPosition.getY()) * FastMath.sin(angle);
//        double newY1 = cameraPosition.getY() + (point1x - cameraPosition.getX()) * FastMath.sin(angle) + (point1y - cameraPosition.getY()) * FastMath.cos(angle);
//        double newX2 = cameraPosition.getX() + (point2x - cameraPosition.getX()) * FastMath.cos(angle) - (point2y - cameraPosition.getY()) * FastMath.sin(angle);
//        double newY2 = cameraPosition.getY() + (point2x - cameraPosition.getX()) * FastMath.sin(angle) + (point2y - cameraPosition.getY()) * FastMath.cos(angle);
//        line3d.setOnScreen(point1x, point1y, point2x, point2y);
//    }
//
//    public static void move(Camera camera) {
//
//    }
//
//    public static void zoom(Camera camera) {
//
//    }
}
