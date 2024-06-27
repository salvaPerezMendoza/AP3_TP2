package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.TipoDePregunta.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class TurnosScene {

    private SceneController sceneController;
    private Juego juego;

    public TurnosScene(SceneController sceneController, Juego juego) {
        this.sceneController = sceneController;
        this.juego = juego;
    }

    public Scene getScene() {
        Jugador jugadorActual = juego.getJugadorActual();

        // Crear etiqueta para mostrar el nombre del jugador actual
        Label turnoLabel = new Label("Turno de: " + jugadorActual.getNombre());
        turnoLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333;");
        turnoLabel.setPadding(new Insets(20));

        // Botón para continuar
        Button continuarButton = new Button("Continuar");
        continuarButton.setOnAction(e -> sceneController.switchToJugarPregunta());

        continuarButton.setStyle("-fx-font-size: 18px; -fx-background-color: #4CAF50; -fx-text-fill: white;");
        continuarButton.setMaxWidth(Double.MAX_VALUE);

        VBox layout = new VBox(20, turnoLabel, continuarButton);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(layout);

        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        return scene;
    }
}
