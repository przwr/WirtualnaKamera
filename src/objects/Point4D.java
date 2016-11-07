package objects;

import Jama.Matrix;

/**
 * Created by przemek on 28.10.16.
 */
public class Point4D {
    Matrix vector;


    public Point4D(double x, double y, double z) {
        double[][] array = {{x, y, z, 1}};
        vector = new Matrix(array);
        vector = vector.transpose();
    }

    public void multiply(Matrix transformationMatrix) {
        vector = transformationMatrix.times(vector);
    }


    public double getX() {
        return vector.get(0, 0);
    }

    public double getY() {
        return vector.get(1, 0);
    }

    public double getZ() {
        return vector.get(2, 0);
    }
}
