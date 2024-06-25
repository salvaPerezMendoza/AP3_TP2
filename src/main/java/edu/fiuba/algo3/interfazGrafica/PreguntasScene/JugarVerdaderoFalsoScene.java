package edu.fiuba.algo3.interfazGrafica.PreguntasScene;

import edu.fiuba.algo3.interfazGrafica.SceneController;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
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

import java.util.ArrayList;

public class JugarVerdaderoFalsoScene implements EscenaDePregunta {

    private SceneController sceneController;
    private Flujo flujo;
    int ID;

    public JugarVerdaderoFalsoScene(SceneController sceneController, Flujo flujo, int ID) {
        this.sceneController = sceneController;
        this.flujo = flujo;
        this.ID = ID;
    }

    @Override
    public Scene getScene() {

        //esto se no se crea aca, sino que directamente le deveria llegar pregunta
            ArrayList<OpcionSimple> opciones = new ArrayList<>();
            opciones.add(new OpcionSimple("Verdadero",1));
            opciones.add(new OpcionSimple("Falso",2));
            OpcionSimple opcionIncorrecta = new OpcionSimple("Verdadero", 1);
            OpcionSimple opcionCorrecta = new OpcionSimple("Falso", 2);
            TipoDePregunta tipoDePregunta = new VerdaderoFalso(opciones, opcionCorrecta);
            String enunciado = "Messi juega al Volley";
            Pregunta pregunta = new Pregunta(tipoDePregunta, null, enunciado);
        // llega la pregunta

        // //INTERFAZ -> Crear la etiqueta de la pregunta
        Label preguntaLabel = new Label(pregunta.getEnunciado());
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

        //INTERFAZ -> se guardan las opciones
        VBox respuestasBox = new VBox(10, opcionVerdadero, opcionFalso);
        respuestasBox.setPadding(new Insets(20));
        respuestasBox.setAlignment(Pos.CENTER_LEFT);

        // Botón para enviar y comprobar la respuesta

        Button enviarButton = new Button("Enviar");
        enviarButton.setOnAction(e -> {

            // selectedRadioButton = opcion selecionada
            RadioButton selectedRadioButton = (RadioButton) respuestasGroup.getSelectedToggle();

            if (selectedRadioButton != null) {
                // respuestaSeleccionada = texto en la opcion
                String respuestaSeleccionada = selectedRadioButton.getText();

                // IMPORTANTE el jugador actual me deveria llegar por parametro, no lo tengo que pedir
                Jugador jugadorActual = flujo.getJugadorActual();
                Respuesta respuesta = new Respuesta(jugadorActual);

                if (respuestaSeleccionada.equals("Verdadero")) {
                    respuesta.agregarOpcion(new OpcionSimple("Verdadero", 1));
                } else {
                    respuesta.agregarOpcion(new OpcionSimple("Falso", 2));
                }

                // le agrego la respuesta a la lista respuestasJugadores
                jugadorActual.responder(pregunta, respuesta);

                // Cambiar al siguiente turno
                System.out.println("Opciones seleccionadas: " + respuestaSeleccionada);
                sceneController.siguientePregunta();
            }
        });


        // INTERFAZ
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
