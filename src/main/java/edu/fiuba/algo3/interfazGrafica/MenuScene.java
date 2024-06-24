package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.modelo.Flujo;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class MenuScene {

    private SceneController sceneController;

    public MenuScene(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    public Scene getScene() {
        Label titleLabel = new Label("AlgoHoot");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Sección de participantes
        Label participantsLabel = new Label("Participantes");
        participantsLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        ListView<String> participantsList = new ListView<>();
        participantsList.getItems().addAll("Jugador 1", "Jugador 2");

        VBox participantsBox = new VBox(participantsLabel, participantsList);
        participantsBox.setPadding(new Insets(20));
        participantsBox.setSpacing(10);

        // Botones
        Button playButton = new Button("JUGAR");
        playButton.setOnAction(e -> sceneController.switchToTurnosScene());

        Button rulesButton = new Button("Reglas");
        rulesButton.setOnAction(e -> sceneController.switchToReglasScene());

        Button addPlayerButton = new Button("Agregar Jugador");
        addPlayerButton.setOnAction(e -> sceneController.switchToAñadirJugadorScene());

        playButton.setMaxWidth(Double.MAX_VALUE);
        rulesButton.setMaxWidth(Double.MAX_VALUE);
        addPlayerButton.setMaxWidth(Double.MAX_VALUE);

        VBox buttonsBox = new VBox(playButton, rulesButton, addPlayerButton);
        buttonsBox.setPadding(new Insets(20));
        buttonsBox.setSpacing(20);

        // Layout principal
        BorderPane root = new BorderPane();
        root.setTop(titleLabel);
        root.setLeft(participantsBox);
        root.setRight(buttonsBox);

        BorderPane.setMargin(titleLabel, new Insets(20));
        BorderPane.setMargin(participantsBox, new Insets(20));
        BorderPane.setMargin(buttonsBox, new Insets(20));

        Scene scene = new Scene(root, 1000, 650);

        return scene;
    }
}
