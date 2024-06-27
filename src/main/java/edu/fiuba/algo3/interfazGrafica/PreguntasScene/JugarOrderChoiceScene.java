package edu.fiuba.algo3.interfazGrafica.PreguntasScene;

import edu.fiuba.algo3.interfazGrafica.SceneController;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.TipoDePregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class JugarOrderChoiceScene {

    private SceneController sceneController;
    private Juego juego;
    private Pregunta pregunta;

    public JugarOrderChoiceScene(SceneController sceneController, Juego juego) {
        this.sceneController = sceneController;
        this.juego = juego;
        this.pregunta = getPregunta(); // Instanciar la pregunta aquí mismo
    }

    private Pregunta getPregunta() {
        // Crear opciones
        ArrayList<OpcionSimple> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Televisor de tubo CRT", 1));
        opciones.add(new OpcionSimple("Microondas", 2));
        opciones.add(new OpcionSimple("Imanes del delivery", 3));
        opciones.add(new OpcionSimple("Heladera", 4));

        // Crear opciones correctas (ordenadas de mayor a menor radiación)
        ArrayList<OpcionSimple> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(new OpcionSimple("Microondas", 2));
        opcionesCorrectas.add(new OpcionSimple("Televisor de tubo CRT", 1));
        opcionesCorrectas.add(new OpcionSimple("Heladera", 4));
        opcionesCorrectas.add(new OpcionSimple("Imanes del delivery", 3));

        // Crear el tipo de pregunta
        TipoDePregunta orderedChoice = new OrderedChoice(opciones, opcionesCorrectas);
        Penalidad sinPenalidad = new SinPenalidad();

        String enunciado = "Ordene de MAYOR A MENOR los siguientes objetos hogareños según su nivel de radiación electromagnética emitido (el máximo recomendado es 100 microTeslas)";

        // Crear la pregunta
        return new Pregunta(orderedChoice, sinPenalidad, enunciado, "Ciencia");
    }

    public Scene getScene() {
        // Crear la etiqueta de la pregunta
        Label preguntaLabel = new Label(pregunta.getEnunciado());
        preguntaLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333;");
        preguntaLabel.setPadding(new Insets(20));

        // Obtener opciones de la pregunta
        //ObservableList<OpcionSimple> opciones = FXCollections.observableArrayList(pregunta.getOpciones());

        ObservableList<OpcionSimple> opciones = FXCollections.observableArrayList();
        opciones.add(new OpcionSimple("Televisor de tubo CRT", 1));
        opciones.add(new OpcionSimple("Microondas", 2));
        opciones.add(new OpcionSimple("Imanes del delivery", 3));
        opciones.add(new OpcionSimple("Heladera", 4));

        ListView<OpcionSimple> opcionesListView = new ListView<>(opciones);
        opcionesListView.setCellFactory(param -> new ListCell<OpcionSimple>() {
            @Override
            protected void updateItem(OpcionSimple item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getTexto());
                }
            }
        });

        opcionesListView.setOnMouseClicked((MouseEvent event) -> {
            OpcionSimple selectedItem = opcionesListView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                opciones.remove(selectedItem);
                opciones.add(selectedItem);
            }
        });

        opcionesListView.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");

        VBox opcionesBox = new VBox(10, opcionesListView);
        opcionesBox.setPadding(new Insets(20));
        opcionesBox.setAlignment(Pos.CENTER_LEFT);

        // Botón para enviar y comprobar la respuesta
        Button enviarButton = new Button("Enviar");
        enviarButton.setOnAction(e -> {
            ArrayList<Opcion> opcionesSeleccionadas = new ArrayList<>(opcionesListView.getItems());
            Jugador jugadorActual = juego.getJugadorActual();
            Respuesta respuesta = new Respuesta(jugadorActual);

            for (Opcion opcion : opcionesSeleccionadas) {
                respuesta.agregarOpcion(opcion);
            }

            jugadorActual.responder(pregunta, respuesta);
            System.out.println("Opciones seleccionadas: " + opcionesSeleccionadas);

            // Cambiar la escena del proximo turno

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
}
