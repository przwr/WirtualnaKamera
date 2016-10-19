package objects;

import javafx.geometry.Point3D;
import main.Camera;
import net.jodk.lang.FastMath;

/**
 * Created by Przemek Wróbel on 10.10.16.
 */
public class Transformer {

//    TODO Matrix4f lwjgl

//    rzutowanie perspektywiczne
//    x' = ((x * d) / (z + d)) * s
//    y' = ((y * d) / (z + d)) * s
//
//    d - odległość od rzutni
//    s - skalowanie (standardowo 1.0)
//
//    rotacja
//    val newX = centerX + (point2x - centerX) * Math.cos(x) - (point2z - centerZ) * Math.sin(x)
//
//    val newZ = centerZ + (point2x - centerX) * Math.sin(x) + (point2z - centerZ) * Math.cos(x)
//
//    centerX i centerZ, to punkt wokół którego rotujemy
//    point2x i point2z to punkt, który totujemy

//    x - to kąt rotacji


    public static void updatePosition(Line3D line3d, Camera camera) {
        Point3D first = line3d.getFirst();
        Point3D second = line3d.getSecond();

        double x1 = first.getX();
        double y1 = first.getY();
        double z1 = first.getZ();
        double x2 = second.getX();
        double y2 = second.getY();
        double z2 = second.getZ();

        double distance = camera.getDistance();
        double scale = 1.0;

        double x1Screen = ((x1 * distance) / (z1 + distance)) * scale;
        double y1Screen = ((y1 * distance) / (z1 + distance)) * scale;
        double x2Screen = ((x2 * distance) / (z2 + distance)) * scale;
        double y2Screen = ((y2 * distance) / (z2 + distance)) * scale;

        line3d.setOnScreen(x1Screen, y1Screen, x2Screen, y2Screen);
    }

    public static void rotate(Camera camera, double angle) {
//        double newX = centerX + (point2x - centerX) * FastMath.cos(angle) - (point2z - centerZ) * FastMath.sin(angle);
//        double newZ = centerZ + (point2x - centerX) * FastMath.sin(angle) + (point2z - centerZ) * FastMath.cos(angle);
    }

    public static void move(Camera camera) {

    }

    public static void zoom(Camera camera) {

    }
}
