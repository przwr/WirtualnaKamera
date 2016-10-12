package objects;

import javafx.scene.shape.Line;

import java.util.ArrayList;

/**
 * Created by przemek on 06.10.16.
 */
public class Face {


    ArrayList<Line3D> lines;

    public Face(ArrayList<Line3D> lines) {
        this.lines = lines;
    }

    public ArrayList<Line3D> getLines() {
        return lines;
    }
}
