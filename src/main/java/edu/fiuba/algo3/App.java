package edu.fiuba.algo3;

import edu.fiuba.algo3.interfazGrafica.MenuScene;
import edu.fiuba.algo3.interfazGrafica.SceneController;
import edu.fiuba.algo3.modelo.Juego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        Juego juego = new Juego();
        SceneController sceneController = new SceneController(primaryStage);

        // Crear la primera escena
        MenuScene menuScene = new MenuScene(sceneController, juego);
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
