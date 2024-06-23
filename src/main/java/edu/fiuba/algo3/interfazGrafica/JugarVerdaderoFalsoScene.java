package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.modelo.Flujo;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.TipoDePregunta.VerdaderoFalso;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class JugarVerdaderoFalsoScene {

    private SceneController sceneController;

    public JugarVerdaderoFalsoScene(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    public Scene getScene(Flujo flujo) {
        // Obtener la pregunta actual (en este ejemplo se crea una pregunta ficticia)
        Pregunta preguntaActual = new Pregunta(new VerdaderoFalso(new OpcionSimple("V")), null, "¿El cielo es azul?");

        // Crear la etiqueta de la pregunta
        Label preguntaLabel = new Label(preguntaActual.getEnunciado());
        preguntaLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333;");
        preguntaLabel.setPadding(new Insets(20));

        // Crear las opciones de respuesta
        ToggleGroup respuestasGroup = new ToggleGroup();

        RadioButton opcionVerdadero = new RadioButton("Verdadero");
        opcionVerdadero.setToggleGroup(respuestasGroup);
        opcionVerdadero.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");

        RadioButton opcionFalso = new RadioButton("Falso");
        opcionFalso.setToggleGroup(respuestasGroup);
        opcionFalso.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");

        VBox respuestasBox = new VBox(10, opcionVerdadero, opcionFalso);
        respuestasBox.setPadding(new Insets(20));
        respuestasBox.setAlignment(Pos.CENTER_LEFT);

        // Botón para enviar la respuesta
        Button enviarButton = new Button("Enviar");
        enviarButton.setOnAction(e -> {
            RadioButton selectedRadioButton = (RadioButton) respuestasGroup.getSelectedToggle();
            if (selectedRadioButton != null) {
                String respuestaSeleccionada = selectedRadioButton.getText();
                Jugador jugadorActual = flujo.getJugadorActual();
                Respuesta respuesta = new Respuesta(jugadorActual);

                if (respuestaSeleccionada.equals("Verdadero")) {
                    respuesta.agregarOpcion(new OpcionSimple("V"));
                } else {
                    respuesta.agregarOpcion(new OpcionSimple("F"));
                }

                jugadorActual.responder(preguntaActual, respuesta);
                preguntaActual.validarRespuestas();

                // Cambiar al siguiente turno
                flujo.siguienteTurno();
                sceneController.switchToTurnoScene();
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
