package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.modelo.Flujo;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AñadirJugadorScene {

    private SceneController sceneController;

    public AñadirJugadorScene(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    public Scene getScene(Flujo flujo) {
        // Título
        Label titleLabel = new Label("Añadir Jugador");
        titleLabel.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: #333;");

        // Etiqueta y campo de texto para el nombre del jugador
        Label instructionLabel = new Label("Ingrese el nombre del nuevo jugador:");
        instructionLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: #333;");

        TextField nameInput = new TextField();
        nameInput.setPromptText("Nombre del jugador");
        nameInput.setStyle("-fx-font-size: 16px;");

        // Botón para añadir jugador
        Button addButton = new Button("Añadir Jugador");
        addButton.setOnAction(e -> {
            String playerName = nameInput.getText();
            if (!playerName.isEmpty()) {
                flujo.agregarJugador(new Jugador(playerName));
                sceneController.switchToMenuScene();
            }
        });
        addButton.setStyle("-fx-font-size: 18px; -fx-background-color: #4CAF50; -fx-text-fill: white;");

        // Botón para volver al menú
        Button backButton = new Button("Volver al Menú");
        backButton.setOnAction(e -> sceneController.switchToMenuScene());
        backButton.setStyle("-fx-font-size: 18px; -fx-background-color: #f0ad4e; -fx-text-fill: white;");

        HBox buttonBox = new HBox(10, addButton, backButton);
        buttonBox.setAlignment(Pos.CENTER);

        // Layout principal
        VBox layout = new VBox(20, titleLabel, instructionLabel, nameInput, buttonBox);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(layout);

        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        return scene;
    }
}
