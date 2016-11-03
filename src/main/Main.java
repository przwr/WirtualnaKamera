package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import objects.*;

import java.util.ArrayList;

public class Main extends Application {

    private Group group = new Group();
    public static int screenX = 500;
    public static int screenY = 500;

    private Scene scene = new Scene(group, screenX, screenY);
    private ArrayList<Object3D> objects = new ArrayList<>(4);


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
        objects.add(ObjectCreator.createBlockOne());
        objects.add(ObjectCreator.createBlockTwo());

        updateTransformation(objects);
        for (Object3D object : objects) {
            for (Face face : object.getFaces()) {
                for (Line3D line3d : face.getLines()) {
                    group.getChildren().add(line3d.getOnScreen());
                }
            }
        }
//        scene.setOnKeyTyped(key -> line.setEndX(line.getEndX() + 1));
    }


    private static void updateTransformation(ArrayList<Object3D> objects) {
        Transformer.setTranslationMatrix(500, 250, 0);

        for (Object3D object : objects) {
            for (Face face : object.getFaces()) {
                for (Line3D line3d : face.getLines()) {
                    Transformer.translatePosition(line3d);
                    Transformer.updatePosition(line3d);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}