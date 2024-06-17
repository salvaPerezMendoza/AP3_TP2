package edu.fiuba.algo3.interfazGrafica;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AñadirJugadorScene {

    private SceneController sceneController;

    public AñadirJugadorScene(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    public Scene getScene() {
        Label instructionLabel = new Label("Ingrese el nombre del nuevo jugador:");
        TextField nameInput = new TextField();
        Button addButton = new Button("Añadir Jugador");
        Button backButton = new Button("Volver");

        addButton.setOnAction(e -> {
            String playerName = nameInput.getText();
            if (!playerName.isEmpty()) {
                // Lógica para añadir el jugador a la lista (puede ser un método en SceneController o en otra clase)
                sceneController.addPlayer(playerName);
                sceneController.switchToMenuScene();
            }
        });

        backButton.setOnAction(e -> sceneController.switchToMenuScene());

        VBox layout = new VBox(20); // 20 píxeles de espaciado
        layout.getChildren().addAll(instructionLabel, nameInput, addButton, backButton);

        return new Scene(layout, 300, 200);
    }
}
