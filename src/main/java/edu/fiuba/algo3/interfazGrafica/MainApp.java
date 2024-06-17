package edu.fiuba.algo3.interfazGrafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        SceneController sceneController = new SceneController(primaryStage);

        // Crear la primera escena
        MenuScene menuScene = new MenuScene(sceneController);
        Scene scene1 = menuScene.getScene();

        // Mostrar la primera escena
        primaryStage.setScene(scene1);
        primaryStage.setTitle("AlgoHoot");
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
