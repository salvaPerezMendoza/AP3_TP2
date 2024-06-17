package edu.fiuba.algo3.interfazGrafica;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {

    private Stage primaryStage;

    public SceneController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void switchToAñadirJugadorScene() {
        AñadirJugadorScene añadirJugadorScene = new AñadirJugadorScene(this);
        Scene scene2 = añadirJugadorScene.getScene();
        primaryStage.setScene(scene2);
    }

    public void switchToMenuScene() {
        MenuScene menuScene = new MenuScene(this);
        Scene scene1 = menuScene.getScene();
        primaryStage.setScene(scene1);
    }

    public void addPlayer(String playerName) {

    }

}
