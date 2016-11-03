package objects;

import javafx.geometry.Point3D;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector;
import org.lwjgl.util.vector.Vector4f;

/**
 * Created by przemek on 28.10.16.
 */
public class Point4D {
    Matrix4f vector = new Matrix4f();
    {
        vector.setZero();
    }


    public Point4D(float x, float y, float z) {
        vector.m00 = x;
        vector.m10 = y;
        vector.m20 = z;
        vector.m30 = 1;
    }

    public void multiply(Matrix4f transformationMatrix) {
        Matrix4f dest = new Matrix4f();
        dest.setZero();
        Matrix4f.mul(transformationMatrix, vector, dest);
        vector = dest;
    }

    public float getX() {
        return vector.m00;
    }

    public float getY() {
        return vector.m10;
    }

    public float getZ() {
        return vector.m20;
    }
}
