package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.modelo.Flujo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class JugarScene {

    private SceneController sceneController;

    public JugarScene(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    public Scene getScene(Flujo flujo) {
        // Crear la etiqueta de la pregunta
        Label preguntaLabel = new Label("¿Cuál es la capital de Francia?");
        preguntaLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333;");
        preguntaLabel.setPadding(new Insets(20));

        // Crear las opciones de respuesta
        ToggleGroup respuestasGroup = new ToggleGroup();

        RadioButton opcion1 = new RadioButton("Madrid");
        opcion1.setToggleGroup(respuestasGroup);
        opcion1.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");

        RadioButton opcion2 = new RadioButton("Berlín");
        opcion2.setToggleGroup(respuestasGroup);
        opcion2.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");

        RadioButton opcion3 = new RadioButton("París");
        opcion3.setToggleGroup(respuestasGroup);
        opcion3.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");

        RadioButton opcion4 = new RadioButton("Roma");
        opcion4.setToggleGroup(respuestasGroup);
        opcion4.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");

        VBox respuestasBox = new VBox(10, opcion1, opcion2, opcion3, opcion4);
        respuestasBox.setPadding(new Insets(20));
        respuestasBox.setAlignment(Pos.CENTER_LEFT);

        // Botón para enviar la respuesta
        Button enviarButton = new Button("Enviar");
        enviarButton.setOnAction(e -> {
            RadioButton selectedRadioButton = (RadioButton) respuestasGroup.getSelectedToggle();
            if (selectedRadioButton != null) {
                String respuestaSeleccionada = selectedRadioButton.getText();
                // Aquí puedes manejar la lógica para verificar la respuesta
                System.out.println("Respuesta seleccionada: " + respuestaSeleccionada);
            }
        });
        enviarButton.setStyle("-fx-font-size: 18px; -fx-background-color: #4CAF50; -fx-text-fill: white;");

        // Botón para volver al menú
        Button backButton = new Button("Volver al Menú");
        backButton.setOnAction(e -> sceneController.switchToMenuScene());
        backButton.setStyle("-fx-font-size: 18px; -fx-background-color: #f0ad4e; -fx-text-fill: white;");

        VBox buttonBox = new VBox(10, enviarButton, backButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20));

        // Layout principal
        VBox layout = new VBox(20, preguntaLabel, respuestasBox, buttonBox);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(layout);

        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        return scene;
    }
}
