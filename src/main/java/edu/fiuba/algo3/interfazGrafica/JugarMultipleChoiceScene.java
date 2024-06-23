package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.modelo.Flujo;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.TipoDePregunta.MultipleChoice;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class JugarMultipleChoiceScene {

    private SceneController sceneController;

    public JugarMultipleChoiceScene(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    public Scene getScene(Flujo flujo) {
        // Obtener la pregunta actual (en este ejemplo se crea una pregunta ficticia)
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Neymar"));
        opciones.add(new OpcionSimple("Messi"));
        opciones.add(new OpcionSimple("Cristiano Ronaldo"));
        opciones.add(new OpcionSimple("Lewandowski"));

        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(new OpcionSimple("Neymar"));
        opcionesCorrectas.add(new OpcionSimple("Lewandowski"));

        MultipleChoice tipoPregunta = new MultipleChoice(opciones, opcionesCorrectas);
        Pregunta preguntaActual = new Pregunta(tipoPregunta, null, "¿Cuál/es de estos jugadores nunca ganaron un Balón de Oro?");

        // Crear la etiqueta de la pregunta
        Label preguntaLabel = new Label(preguntaActual.getEnunciado());
        preguntaLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333;");
        preguntaLabel.setPadding(new Insets(20));

        // Crear las opciones de respuesta
        VBox opcionesVBox = new VBox();
        opcionesVBox.setSpacing(10);
        opcionesVBox.setPadding(new Insets(20));

        List<CheckBox> checkBoxes = new ArrayList<>();
        for (Opcion opcion : opciones) {
            CheckBox checkBox = new CheckBox(opcion.getTexto());
            checkBox.setStyle("-fx-font-size: 18px;");
            checkBoxes.add(checkBox);
            opcionesVBox.getChildren().add(checkBox);
        }

        // Botón para enviar la respuesta
        Button enviarButton = new Button("Enviar");
        enviarButton.setOnAction(e -> {
            Respuesta respuesta = new Respuesta(flujo.getJugadorActual());
            for (CheckBox checkBox : checkBoxes) {
                if (checkBox.isSelected()) {
                    respuesta.agregarOpcion(new OpcionSimple(checkBox.getText()));
                }
            }

            flujo.getJugadorActual().responder(preguntaActual, respuesta);
            preguntaActual.validarRespuestas();

            // Cambiar al siguiente turno
            flujo.siguienteTurno();
            sceneController.switchToTurnoScene();
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
        VBox layout = new VBox(20, preguntaLabel, opcionesVBox, buttonBox);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(layout);

        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        return scene;
    }
}
