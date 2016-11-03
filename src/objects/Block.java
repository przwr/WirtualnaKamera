package objects;

import java.util.ArrayList;

/**
 * Created by przemek on 28.10.16.
 */
public class Block extends Object3D {

    public Block(Point4D p1, Point4D p2, Point4D p3, Point4D p4, Point4D p5, Point4D p6, Point4D p7, Point4D p8) {
        this.faces = new ArrayList<>(6);
        faces.add(ObjectCreator.createFaceFromPoints(p1, p2, p3, p4));
        faces.add(ObjectCreator.createFaceFromPoints(p1, p5, p8, p4));
        faces.add(ObjectCreator.createFaceFromPoints(p4, p8, p7, p3));
        faces.add(ObjectCreator.createFaceFromPoints(p3, p7, p6, p2));
        faces.add(ObjectCreator.createFaceFromPoints(p2, p6, p5, p1));
        faces.add(ObjectCreator.createFaceFromPoints(p5, p8, p7, p6));
    }

}
