package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import objects.*;

import java.util.ArrayList;

public class Main extends Application {

    private Group group = new Group();
    private Scene scene = new Scene(group, 500, 500);
    private ArrayList<Object3D> objects = new ArrayList<>(4);
    private Camera camera = new Camera();


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Grafika Komputerowa - Kamera Wirtualna");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        initSomeLogic();
    }

    private void initSomeLogic() {
        objects.add(ObjectCreator.createStreet());
        updateTransformation(objects, camera);
        for (Object3D object : objects) {
            for (Face face : object.getFaces()) {
                for (Line3D line3d : face.getLines()) {
                    group.getChildren().add(line3d.getOnScreen());
                }
            }
        }
//        scene.setOnKeyTyped(key -> line.setEndX(line.getEndX() + 1));
    }


    private static void updateTransformation(ArrayList<Object3D> objects, Camera camera) {
        for (Object3D object : objects) {
            for (Face face : object.getFaces()) {
                for (Line3D line3d : face.getLines()) {
                    Transformer.updatePosition(line3d, camera);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}