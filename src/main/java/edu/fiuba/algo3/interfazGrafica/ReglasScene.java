package edu.fiuba.algo3.interfazGrafica;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ReglasScene {

    private SceneController sceneController;

    public ReglasScene(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    public Scene getScene() {
        // Título
        Label titleLabel = new Label("Reglas");
        titleLabel.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: #010101;");

        // Texto de las reglas
        Label reglasLabel = new Label("Aquí van las reglas del juego...");
        reglasLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: #010101;");
        reglasLabel.setPadding(new Insets(20));

        // Botón para volver al menú
        Button backButton = new Button("Volver al Menú");
        backButton.setOnAction(e -> sceneController.switchToMenuScene());
        backButton.setStyle("-fx-font-size: 18px; -fx-background-color: #010101; -fx-text-fill: White; -fx-border-color: #010101; -fx-border-width: 10px;");

        VBox layout = new VBox(20, titleLabel, reglasLabel, backButton);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(layout);

        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        return scene;
    }
}
