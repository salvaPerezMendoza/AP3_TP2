package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.modelo.Flujo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;

public class TurnosScene {

    private SceneController sceneController;
    private Flujo flujo;

    public TurnosScene(SceneController sceneController, Flujo flujo) {
        this.sceneController = sceneController;
        this.flujo = flujo;
    }

    public Scene getScene() {
        // Crear la etiqueta para el turno del jugador actual
        Label turnoLabel = new Label("Turno de: " + flujo.getJugadorActual().getNombre());
        turnoLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333;");
        turnoLabel.setPadding(new Insets(20));

        // Botón para continuar a la pregunta
        Button continuarButton = new Button("Continuar");
        continuarButton.setOnAction(e -> sceneController.switchToJugarVerdaderoFalsoScene());
        continuarButton.setStyle("-fx-font-size: 18px; -fx-background-color: #4CAF50; -fx-text-fill: white;");

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
