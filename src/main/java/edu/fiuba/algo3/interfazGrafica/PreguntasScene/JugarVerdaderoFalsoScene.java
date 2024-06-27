package edu.fiuba.algo3.interfazGrafica.PreguntasScene;

import edu.fiuba.algo3.interfazGrafica.SceneController;
import edu.fiuba.algo3.interfazGrafica.componentes.OpcionVFBoton;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class JugarVerdaderoFalsoScene implements EscenaDePregunta {

    private SceneController sceneController;
    private Juego juego;

    public JugarVerdaderoFalsoScene(SceneController sceneController, Juego juego) {
        this.sceneController = sceneController;
        this.juego = juego;
    }

    @Override
    public Scene getScene() {
        Jugador jugador = juego.getJugadorActual();
        Pregunta pregunta = juego.getPreguntaActual();
        ArrayList<OpcionSimple> opciones = pregunta.obtenerOpciones();

        Label nombreJugadorLabel = new Label(jugador.getNombre());
        nombreJugadorLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #000;");
        nombreJugadorLabel.setPadding(new Insets(10));

        // //INTERFAZ -> Crear la etiqueta de la pregunta
        Label preguntaLabel = new Label(pregunta.getEnunciado());
        preguntaLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333;");
        preguntaLabel.setPadding(new Insets(20));

        // Crear las opciones de respuesta
        ToggleGroup respuestasGroup = new ToggleGroup();

        OpcionVFBoton opcion0 = new OpcionVFBoton(respuestasGroup, opciones.get(0));
        OpcionVFBoton opcion1 = new OpcionVFBoton(respuestasGroup, opciones.get(1));

        //INTERFAZ -> se guardan las opciones
        VBox respuestasBox = new VBox(10, opcion0, opcion1);
        respuestasBox.setPadding(new Insets(20));
        respuestasBox.setAlignment(Pos.CENTER_LEFT);

        // Botón para enviar y comprobar la respuesta

        Button enviarButton = new Button("Enviar");
        enviarButton.setOnAction(e -> {

        // selectedRadioButton = opcion selecionada
        OpcionVFBoton selectedRadioButton = (OpcionVFBoton) respuestasGroup.getSelectedToggle();

        if (selectedRadioButton != null) {
            // respuestaSeleccionada = texto en la opcion
            Respuesta respuesta = new Respuesta(jugador);
            respuesta.agregarOpcion(selectedRadioButton.getOpcion());

            // le agrego la respuesta a la lista respuestasJugadores
            jugador.responder(pregunta, respuesta);
            juego.siguienteTurno();

            sceneController.siguienteTurno();
        }
        });


        // INTERFAZ
        enviarButton.setStyle("-fx-font-size: 18px; -fx-background-color: #010101; -fx-text-fill: White; -fx-border-color: #010101; -fx-border-width: 10px;" );


        // Botón para volver al menú
        Button backButton = new Button("Volver al Menú");
        backButton.setOnAction(e -> sceneController.switchToMenuScene());
        backButton.setStyle("-fx-font-size: 18px; -fx-background-color: #010101; -fx-text-fill: White; -fx-border-color: #010101; -fx-border-width: 10px;" );

        VBox buttonBox = new VBox(10, enviarButton, backButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20));

        // Layout principal
        VBox layout = new VBox(20, nombreJugadorLabel, preguntaLabel, respuestasBox, buttonBox);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(layout);

        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        return scene;
    }
}
