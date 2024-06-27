package edu.fiuba.algo3.interfazGrafica.PreguntasScene;

import edu.fiuba.algo3.interfazGrafica.SceneController;
import edu.fiuba.algo3.interfazGrafica.componentes.OpcionVFBoton;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.Penalidad.ConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Penalidad.PenalidadParcial;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
        Penalidad penalidadDeLaPregunta = pregunta.getPenalidad();
        ArrayList<OpcionSimple> opciones = pregunta.obtenerOpciones();

        Label preguntaLabel = new Label(pregunta.getEnunciado());
        preguntaLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333;");
        preguntaLabel.setPadding(new Insets(20));
        preguntaLabel.setWrapText(true); // Permitir que el texto se ajuste y se muestre en múltiples líneas si es necesario

        VBox botonesPenalidad = sceneController.MostrarBonificadores(penalidadDeLaPregunta);
        botonesPenalidad.setAlignment(Pos.CENTER_RIGHT);
        botonesPenalidad.setPadding(new Insets(20));

        // Crear las opciones de respuesta
        ToggleGroup respuestasGroup = new ToggleGroup();

        OpcionVFBoton opcion0 = new OpcionVFBoton(respuestasGroup, opciones.get(0));
        OpcionVFBoton opcion1 = new OpcionVFBoton(respuestasGroup, opciones.get(1));

        // INTERFAZ -> se guardan las opciones
        VBox respuestasBox = new VBox(10, opcion0, opcion1);
        respuestasBox.setPadding(new Insets(20));
        respuestasBox.setAlignment(Pos.CENTER_LEFT);

        // Botón para enviar y comprobar la respuesta
        Button enviarButton = new Button("Enviar");
        enviarButton.setOnAction(e -> {
            OpcionVFBoton selectedRadioButton = (OpcionVFBoton) respuestasGroup.getSelectedToggle();

            if (selectedRadioButton != null) {
                Respuesta respuesta = new Respuesta(jugador);
                respuesta.agregarOpcion(selectedRadioButton.getOpcion());

                jugador.responder(pregunta, respuesta);
                juego.siguienteTurno();
                sceneController.siguienteTurno();
            }
        });
        enviarButton.setStyle("-fx-font-size: 18px; -fx-background-color: #010101; -fx-text-fill: White; -fx-border-color: #010101; -fx-border-width: 10px;");

        // Botón para volver al menú
        Button backButton = new Button("Volver al Menú");
        backButton.setOnAction(e -> sceneController.switchToMenuScene());
        backButton.setStyle("-fx-font-size: 18px; -fx-background-color: #010101; -fx-text-fill: White; -fx-border-color: #010101; -fx-border-width: 10px;");

        VBox buttonBox = new VBox(10, enviarButton, backButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20));

        // Layout principal
        VBox izquierda = new VBox(20, preguntaLabel, respuestasBox, buttonBox);
        izquierda.setAlignment(Pos.CENTER_LEFT);

        HBox layout = new HBox(20, izquierda, botonesPenalidad);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER_LEFT);

        BorderPane root = new BorderPane();
        root.setCenter(layout);

        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        return scene;
    }

}
