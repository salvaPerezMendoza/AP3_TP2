package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.modelo.Flujo;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

import java.util.ArrayList;
import java.util.List;

public class MenuScene {

    private Flujo flujo;
    private SceneController sceneController;

    public MenuScene(SceneController sceneController, Flujo flujo) {
        this.sceneController = sceneController;
        this.flujo = flujo;
    }

    public Scene getScene() {

        Label titleLabel = new Label("AlgoHoot");
        titleLabel.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: #333;");

        // Sección de participantes
        Label participantsLabel = new Label("Participantes");
        participantsLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333;");

        List<Jugador> jugadores = new ArrayList<>();
        jugadores = flujo.devolverJugadores();

        List<String> nombres = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            nombres.add(jugador.getNombre());
        }

        ListView<String> participantsList = new ListView<>();
        participantsList.getItems().addAll(nombres);
        participantsList.setStyle("-fx-font-size: 18px; -fx-background-color: #f0f0f0;");


        VBox participantsBox = new VBox(participantsLabel, participantsList);
        participantsBox.setPadding(new Insets(20));
        participantsBox.setSpacing(10);
        participantsBox.setStyle("-fx-background-color: #ffffff; -fx-border-color: #cccccc; -fx-border-width: 1px;");

        // Botones
        Button playButton = new Button("JUGAR");
        playButton.setOnAction(e -> sceneController.switchToJugarScene());
        playButton.setStyle("-fx-font-size: 18px; -fx-background-color: #4CAF50; -fx-text-fill: white;");

        Button rulesButton = new Button("Reglas");
        rulesButton.setOnAction(e -> sceneController.switchToReglasScene());
        rulesButton.setStyle("-fx-font-size: 18px; -fx-background-color: #2196F3; -fx-text-fill: white;");

        Button addPlayerButton = new Button("Agregar Jugador");
        addPlayerButton.setOnAction(e -> sceneController.switchToAñadirJugadorScene(flujo));
        addPlayerButton.setStyle("-fx-font-size: 18px; -fx-background-color: #f0ad4e; -fx-text-fill: white;");

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
        BorderPane.setMargin(titleLabel, new Insets(20, 20, 0, 20));
        BorderPane.setMargin(participantsBox, new Insets(20));
        BorderPane.setMargin(buttonsBox, new Insets(20));

        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        return scene;
    }

}
