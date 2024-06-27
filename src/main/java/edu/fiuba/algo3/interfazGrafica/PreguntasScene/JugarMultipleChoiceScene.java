package edu.fiuba.algo3.interfazGrafica.PreguntasScene;

import edu.fiuba.algo3.interfazGrafica.SceneController;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.TipoDePregunta.MultipleChoice;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class JugarMultipleChoiceScene {

    private SceneController sceneController;
    private Juego juego;
    private Pregunta pregunta;

    public JugarMultipleChoiceScene(SceneController sceneController, Juego juego) {
        this.sceneController = sceneController;
        this.juego = juego;
        this.pregunta = getPregunta(); //esta pregunta me deveria llegar por parametro
    }

    //Esto es lo que se envia por parametro
    public Pregunta getPregunta() {
        // Crear opciones
        ArrayList<OpcionSimple> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Neymar", 1));
        opciones.add(new OpcionSimple("Messi", 2));
        opciones.add(new OpcionSimple("Cristiano Ronaldo", 3));
        opciones.add(new OpcionSimple("Lewandowski", 4));

        // Crear opciones correctas
        ArrayList<OpcionSimple> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(new OpcionSimple("Neymar", 1));
        opcionesCorrectas.add(new OpcionSimple("Lewandowski", 4));

        // Crear el tipo de pregunta
        TipoDePregunta multipleChoice = new MultipleChoice(opciones, opcionesCorrectas);
        Penalidad sinPenalidad = new SinPenalidad();

        // Crear la pregunta
        Pregunta pregunta = new Pregunta(multipleChoice, sinPenalidad, "¿Cuáles de estos jugadores nunca ganaron un Balón de Oro?", "Deporte");

        return pregunta;
    }

    public Scene getScene() {
        // Crear la etiqueta de la pregunta
        Label preguntaLabel = new Label(pregunta.getEnunciado());
        preguntaLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333;");
        preguntaLabel.setPadding(new Insets(20));

        // Crear las casillas de verificación
        VBox opcionesBox = new VBox(10);

        // Todas estas opciones se las deveria poder pedir a pregunta
        ArrayList<OpcionSimple> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Neymar", 1));
        opciones.add(new OpcionSimple("Messi", 2));
        opciones.add(new OpcionSimple("Cristiano Ronaldo", 3));
        opciones.add(new OpcionSimple("Lewandowski", 4));
        //Todas estas opciones se las deveria poder pedir a pregunta

        for (Opcion opcion : opciones) {
            CheckBox checkBox = new CheckBox(opcion.getTexto());
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
                if (node instanceof CheckBox) {
                    CheckBox checkBox = (CheckBox) node;
                    if (checkBox.isSelected()) {
                        String texto = checkBox.getText();
                        for (Opcion opcion : opciones) {
                            if (opcion.getTexto().equals(texto)) {
                                opcionesSeleccionadas.add(opcion);
                                break;
                            }
                        }
                    }
                }
            }
            // Aquí puedes procesar las opciones seleccionadas
            // Por ejemplo, podrías validar la respuesta y cambiar de escena
            procesarRespuesta(opcionesSeleccionadas);
            sceneController.siguientePregunta();
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
        VBox layout = new VBox(20, preguntaLabel, opcionesBox, buttonBox);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(layout);

        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        return scene;
    }

    private void procesarRespuesta(ArrayList<Opcion> opcionesSeleccionadas) {
        // Procesa las opciones seleccionadas
        // Puedes validar la respuesta y cambiar de escena aquí
        System.out.println("Opciones seleccionadas: " + opcionesSeleccionadas);
        // Aquí podrías cambiar a la escena de resultados o a la siguiente pregunta
    }
}
