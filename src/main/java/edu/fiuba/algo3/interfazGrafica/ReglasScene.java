package edu.fiuba.algo3.interfazGrafica;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ReglasScene {

    private SceneController sceneController;

    public ReglasScene(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    public Scene getScene() {
        // Título
        Label titleLabel = new Label("Reglas del Juego");
        titleLabel.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: #333;");
        titleLabel.setPadding(new Insets(20, 0, 20, 0));
        titleLabel.setAlignment(Pos.CENTER);

        // Texto de las reglas
        TextArea reglasText = new TextArea();
        reglasText.setText(getReglas());
        reglasText.setWrapText(true);
        reglasText.setEditable(false);
        reglasText.setStyle("-fx-font-size: 16px; -fx-padding: 10px;");

        // Botón para volver al menú
        Button backButton = new Button("Volver al Menú");
        backButton.setOnAction(e -> sceneController.switchToMenuScene());
        backButton.setStyle("-fx-font-size: 18px; -fx-background-color: #f0ad4e; -fx-text-fill: white;");
        backButton.setMaxWidth(Double.MAX_VALUE);

        VBox layout = new VBox(20, titleLabel, reglasText, backButton);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(layout);

        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        return scene;
    }

    private String getReglas() {
        // Aquí puedes añadir las reglas del juego
        return "1. Regla uno: Descripción de la regla uno.\n" +
                "2. Regla dos: Descripción de la regla dos.\n" +
                "3. Regla tres: Descripción de la regla tres.\n" +
                "4. Regla cuatro: Descripción de la regla cuatro.\n" +
                "5. Regla cinco: Descripción de la regla cinco.";
    }
}
