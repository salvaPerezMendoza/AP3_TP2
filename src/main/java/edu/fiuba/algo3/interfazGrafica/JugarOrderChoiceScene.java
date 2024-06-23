package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.modelo.Flujo;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.TipoDePregunta.OrderedChoice;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JugarOrderChoiceScene {

    private SceneController sceneController;

    public JugarOrderChoiceScene(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    public Scene getScene(Flujo flujo) {
        // Obtener la pregunta actual (en este ejemplo se crea una pregunta ficticia)
        ArrayList<OpcionSimple> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Macri"));
        opciones.add(new OpcionSimple("Cristina"));
        opciones.add(new OpcionSimple("Alberto"));
        opciones.add(new OpcionSimple("Duhalde"));
        opciones.add(new OpcionSimple("Nestor"));

        ArrayList<OpcionSimple> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(new OpcionSimple("Alberto"));
        opcionesCorrectas.add(new OpcionSimple("Macri"));
        opcionesCorrectas.add(new OpcionSimple("Cristina"));
        opcionesCorrectas.add(new OpcionSimple("Nestor"));
        opcionesCorrectas.add(new OpcionSimple("Duhalde"));

        OrderedChoice tipoPregunta = new OrderedChoice(opciones, opcionesCorrectas);
        Pregunta preguntaActual = new Pregunta(tipoPregunta, null, "Ordenar los presidentes por año en orden descendiente");

        // Crear la etiqueta de la pregunta
        Label preguntaLabel = new Label(preguntaActual.getEnunciado());
        preguntaLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333;");
        preguntaLabel.setPadding(new Insets(20));

        // Crear la lista de opciones de respuesta
        ListView<OpcionSimple> opcionesListView = new ListView<>();
        opcionesListView.getItems().addAll(opciones);
        opcionesListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        opcionesListView.setStyle("-fx-font-size: 18px;");
        opcionesListView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2) {
                OpcionSimple selectedItem = opcionesListView.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    opcionesListView.getItems().remove(selectedItem);
                    opcionesListView.getItems().add(selectedItem);
                }
            }
        });

        // Botón para enviar la respuesta
        Button enviarButton = new Button("Enviar");
        enviarButton.setOnAction(e -> {
            Respuesta respuesta = new Respuesta(flujo.getJugadorActual());
            for (OpcionSimple opcion : opcionesListView.getItems()) {
                respuesta.agregarOpcion(opcion);
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
        VBox layout = new VBox(20, preguntaLabel, opcionesListView, buttonBox);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(layout);

        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        return scene;
    }
}
