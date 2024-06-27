package edu.fiuba.algo3.interfazGrafica.PreguntasScene;

import edu.fiuba.algo3.interfazGrafica.SceneController;
import edu.fiuba.algo3.interfazGrafica.componentes.OpcionMultipleChoiceBoton;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Penalidad.ConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Penalidad.PenalidadParcial;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.TipoDePregunta.MultipleChoice;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class JugarMultipleChoiceScene {

    private SceneController sceneController;
    private Juego juego;

    public JugarMultipleChoiceScene(SceneController sceneController, Juego juego) {
        this.sceneController = sceneController;
        this.juego = juego;
    }

    public Scene getScene() {
        Jugador jugador = juego.getJugadorActual();
        Pregunta pregunta = juego.getPreguntaActual();
        Penalidad penalidadDeLaPregunta = pregunta.getPenalidad();
        Respuesta respuesta = new Respuesta(jugador);
        ArrayList<OpcionSimple> opciones = pregunta.obtenerOpciones();

        Label nombreJugadorLabel = new Label("Turno De: " + jugador.getNombre());
        nombreJugadorLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #000;");
        nombreJugadorLabel.setPadding(new Insets(10));

        // Crear la etiqueta de la pregunta
        Label preguntaLabel = new Label(pregunta.getEnunciado());
        preguntaLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333;");
        preguntaLabel.setPadding(new Insets(20));

        Label penalidadAMostrar = new Label("Esta pregunta no tiene penalidad");
        if (penalidadDeLaPregunta instanceof ConPenalidad) {
            penalidadAMostrar = new Label("Esta pregunta no tiene penalidad");
        } else if (penalidadDeLaPregunta instanceof PenalidadParcial) {
            penalidadAMostrar = new Label("Esta pregunta tiene penalidad parcial");
        }
        penalidadAMostrar.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #000;");
        penalidadAMostrar.setPadding(new Insets(10));
        penalidadAMostrar.setAlignment(Pos.TOP_RIGHT);

        VBox opcionesBox = new VBox(10);

        for (OpcionSimple opcion : opciones) {
            OpcionMultipleChoiceBoton checkBox = new OpcionMultipleChoiceBoton(opcion);
            checkBox.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");
            opcionesBox.getChildren().add(checkBox);
        }
        opcionesBox.setPadding(new Insets(20));
        opcionesBox.setAlignment(Pos.CENTER_LEFT);

        // Botón para enviar la respuesta
        Button enviarButton = new Button("Enviar");
        enviarButton.setOnAction(e -> {
            ArrayList<Opcion> opcionesSeleccionadas = new ArrayList<>();
            for (javafx.scene.Node node : opcionesBox.getChildren()) {
                if (node instanceof OpcionMultipleChoiceBoton) {
                    OpcionMultipleChoiceBoton checkBox = (OpcionMultipleChoiceBoton) node;
                    if (checkBox.isSelected()) {
                        respuesta.agregarOpcion(checkBox.getOpcion());
                    }
                }
            }
            jugador.responder(pregunta, respuesta);
            juego.siguienteTurno();

            sceneController.siguienteTurno();

        });

        enviarButton.setStyle("-fx-font-size: 18px; -fx-background-color: #010101; -fx-text-fill: White; -fx-border-color: #010101; -fx-border-width: 10px;" );

        // Botón para volver al menú
        Button backButton = new Button("Volver al Menú");
        backButton.setOnAction(e -> sceneController.switchToMenuScene());
        backButton.setStyle("-fx-font-size: 18px; -fx-background-color: #010101; -fx-text-fill: White; -fx-border-color: #010101; -fx-border-width: 10px;" );

        VBox buttonBox = new VBox(10, enviarButton, backButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20));

        // Layout principal
        HBox arriba = new HBox(530, nombreJugadorLabel, penalidadAMostrar);
        VBox layout = new VBox(20, arriba, preguntaLabel, opcionesBox, buttonBox);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(layout);

        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        return scene;
    }
}
