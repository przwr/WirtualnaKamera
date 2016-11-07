package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import objects.*;

import java.util.ArrayList;

public class Main extends Application {

    private Group group = new Group();
    public static int screenX = 500;
    public static int screenY = 500;
    private static boolean keyBlock = false;
    private static long lastKey = System.nanoTime();
    private static long KEY_DELAY = 5 * 10000000;
    private static int moveStep = 2;
    private static double rotateStep = 0.25;


    private Scene scene = new Scene(group, screenX, screenY);
    private static ArrayList<Object3D> objects = new ArrayList<>(4);


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Grafika Komputerowa - Kamera Wirtualna");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        initSomeLogic();
    }

    private void initSomeLogic() {
        objects.add(ObjectCreator.createStreetBlock());
        objects.add(ObjectCreator.createBlockOne());
        objects.add(ObjectCreator.createBlockTwo());

        double xStart = -25;
        double yStart = -50;
        double zStart = 0;
        Transformer.setTranslationMatrix(xStart, yStart, zStart);
        updateTranslation(objects);
        for (Object3D object : objects) {
            for (Face face : object.getFaces()) {
                for (Line3D line3d : face.getLines()) {
                    group.getChildren().add(line3d.getOnScreen());
                }
            }
        }

        updateAllPositions(objects);
        scene.setOnKeyTyped(key -> updateScene(key));
    }


    private static void updateScene(KeyEvent key) {
        long currentTime = System.nanoTime();
        if (currentTime - lastKey > KEY_DELAY) {
            keyBlock = false;
        }
        if (!keyBlock) {
            lastKey = currentTime;
            keyBlock = true;
            switch (key.getCharacter()) {
                case "w":
                    Transformer.setTranslationMatrix(0, 0, -moveStep);
                    updateTranslation(objects);
                    break;
                case "s":
                    Transformer.setTranslationMatrix(0, 0, moveStep);
                    updateTranslation(objects);
                    break;
                case "a":
                    Transformer.setTranslationMatrix(moveStep, 0, 0);
                    updateTranslation(objects);
                    break;
                case "d":
                    Transformer.setTranslationMatrix(-moveStep, 0, 0);
                    updateTranslation(objects);
                    break;
                case "r":
                    Transformer.setTranslationMatrix(0, -moveStep, 0);
                    updateTranslation(objects);
                    break;
                case "f":
                    Transformer.setTranslationMatrix(0, moveStep, 0);
                    updateTranslation(objects);
                    break;
                case "q":
                    Transformer.setRotationMatrix(-rotateStep);
                    updateRotation(objects);
                    break;
                case "e":
                    Transformer.setRotationMatrix(rotateStep);
                    updateRotation(objects);
                    break;
                case "z":
                    Transformer.zoomIn();
                    updateAllPositions(objects);
                    break;
                case "x":
                    Transformer.zoomOut();
                    updateAllPositions(objects);
                    break;
            }
            Transformer.setTranslationMatrix(0, 0, 0);
            updateTranslation(objects);
        }
    }

    private static void updateTranslation(ArrayList<Object3D> objects) {
        for (Object3D object : objects) {
            for (Face face : object.getFaces()) {
                for (Line3D line3d : face.getLines()) {
                    Transformer.translatePosition(line3d);
                    Transformer.updatePosition(line3d);
                }
            }
        }
    }

    private static void updateRotation(ArrayList<Object3D> objects) {
        for (Object3D object : objects) {
            for (Face face : object.getFaces()) {
                for (Line3D line3d : face.getLines()) {
                    Transformer.rotatePosition(line3d);
                    Transformer.updatePosition(line3d);
                }
            }
        }
    }

    private static void updateAllPositions(ArrayList<Object3D> objects) {
        for (Object3D object : objects) {
            for (Face face : object.getFaces()) {
                for (Line3D line3d : face.getLines()) {
                    Transformer.updatePosition(line3d);
                }
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}