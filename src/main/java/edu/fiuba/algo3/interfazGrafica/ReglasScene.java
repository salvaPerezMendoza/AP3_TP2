package edu.fiuba.algo3.interfazGrafica;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class ReglasScene {

    private SceneController sceneController;

    public ReglasScene(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    public Scene getScene(){

        VBox layout = new VBox(20);

        return new Scene(layout, 1000, 650);

    };

}
