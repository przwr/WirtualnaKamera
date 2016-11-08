package objects;


import Jama.Matrix;

/**
 * Created by Przemek Wróbel on 10.10.16.
 */
public class Transformer {

    public static float distance = 150f;
    private static float distanceStep = 1;

    public static Matrix translationMatrix;
    public static Matrix rotationMatrix;


    public static void setTranslationMatrix(double dx, double dy, double dz) {
        double[][] array = {
                {1, 0, 0, dx},
                {0, 1, 0, dy,},
                {0, 0, 1, dz},
                {0, 0, 0, 1},
        };
        translationMatrix = new Matrix(array);
    }

    public static void setRotationMatrix(double angle) {
        double radAngle = Math.toRadians(angle);
        double sinA = Math.sin(radAngle);
        double cosA = Math.cos(radAngle);
        double[][] array = {
                {cosA, 0, sinA, 0},
                {0, 1, 0, 0,},
                {-sinA, 0, cosA, 0},
                {0, 0, 0, 1},
        };
        rotationMatrix = new Matrix(array);
    }

    public static void translatePosition(Line3D line3d) {
        Point4D first = line3d.getFirst();
        Point4D second = line3d.getSecond();

        first.multiply(translationMatrix);
        second.multiply(translationMatrix);
    }

    public static void rotatePosition(Line3D line3d) {
        Point4D first = line3d.getFirst();
        Point4D second = line3d.getSecond();

        first.multiply(rotationMatrix);
        second.multiply(rotationMatrix);
    }


    public static void zoomIn() {
        distance += distanceStep;
        if (distance > 300f) {
            distance = 300f;
        }
    }

    public static void zoomOut() {
        distance -= distanceStep;
        if (distance < 50f) {
            distance = 50f;
        }
    }

    public static void updatePosition(Line3D line3d) {
        Point4D first = line3d.getFirst();
        Point4D second = line3d.getSecond();

        double x1 = first.getX();
        double y1 = first.getY();
        double z1 = first.getZ();
        double x2 = second.getX();
        double y2 = second.getY();
        double z2 = second.getZ();

        double x1Screen = ((x1 * distance) / (z1 + distance));
        double y1Screen = ((y1 * distance) / (z1 + distance));
        double x2Screen = ((x2 * distance) / (z2 + distance));
        double y2Screen = ((y2 * distance) / (z2 + distance));

        line3d.setOnScreen(x1Screen, y1Screen, x2Screen, y2Screen);
    }
}
