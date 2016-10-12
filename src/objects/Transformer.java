package objects;

import javafx.geometry.Point3D;
import main.Camera;
import net.jodk.lang.FastMath;

/**
 * Created by przemek on 10.10.16.
 */
public class Transformer {

//    TODO Matrix4f lwjgl


    public static void updatePosition(Line3D line3d, Camera camera) {
        Point3D first = line3d.getFirst();
        Point3D second = line3d.getSecond();
        double X1 = first.getX();
        double Y1 = first.getY();
        double Z1 = first.getZ();

        double X2 = second.getX();
        double Y2 = second.getY();
        double Z2 = second.getZ();


//        FastMath.tan();
//      TODO :D


        line3d.setOnScreen(10, 10, 20, 20);
    }
}
