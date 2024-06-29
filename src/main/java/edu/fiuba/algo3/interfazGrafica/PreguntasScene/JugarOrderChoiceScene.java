package edu.fiuba.algo3.interfazGrafica.PreguntasScene;

import edu.fiuba.algo3.interfazGrafica.SceneController;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class JugarOrderChoiceScene {

    private SceneController sceneController;
    private Juego juego;

    public JugarOrderChoiceScene(SceneController sceneController, Juego juego) {
        this.sceneController = sceneController;
        this.juego = juego;
    }

    public Scene getScene() {
        Jugador jugador = juego.getJugadorActual();
        Pregunta pregunta = juego.getPreguntaActual();
        ArrayList<OpcionSimple> opciones = pregunta.obtenerOpciones();
        Respuesta respuesta = new Respuesta(jugador);
        Penalidad penalidadDeLaPregunta = pregunta.getPenalidad();

        // Crear la etiqueta para el enunciado de la pregunta
        Label preguntaLabel = new Label(pregunta.getEnunciado());
        preguntaLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333;");
        preguntaLabel.setPadding(new Insets(20));
        preguntaLabel.setWrapText(true); // Permite que el texto se ajuste y se muestre en múltiples líneas si es necesario

        // Ajustar el tamaño preferido del Label para que se expanda según el contenido
        preguntaLabel.setMaxWidth(Double.MAX_VALUE);
        preguntaLabel.setMaxHeight(Double.MAX_VALUE);

        // Crear la lista de opciones con el ListView
        ObservableList<OpcionSimple> opcionesObservableList = FXCollections.observableArrayList(opciones);
        ListView<OpcionSimple> opcionesListView = new ListView<>(opcionesObservableList);
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

        opcionesListView.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");
        opcionesListView.setPrefWidth(400);

        // Configurar el comportamiento al hacer clic en la lista de opciones
        opcionesListView.setOnMouseClicked((MouseEvent event) -> {
            OpcionSimple selectedItem = opcionesListView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                opcionesObservableList.remove(selectedItem);
                opcionesObservableList.add(selectedItem);
            }
        });

        VBox opcionesBox = new VBox(10, opcionesListView);
        opcionesBox.setPadding(new Insets(20));
        opcionesBox.setAlignment(Pos.CENTER);

        // Botón para enviar la respuesta
        Button enviarButton = new Button("Enviar");
        enviarButton.setOnAction(e -> {
            ArrayList<OpcionSimple> opcionesSeleccionadas = new ArrayList<>(opcionesListView.getItems());

            for (Opcion opcion : opcionesSeleccionadas) {
                respuesta.agregarOpcion(opcion);
            }

            jugador.responder(pregunta, respuesta);

            juego.siguienteTurno();
            sceneController.siguienteTurno();
        });

        enviarButton.setStyle("-fx-font-size: 18px; -fx-background-color: #010101; -fx-text-fill: White; -fx-border-color: #010101; -fx-border-width: 10px;");

        // Mostrar las penalidades si las hay
        VBox botonesPenalidad = sceneController.MostrarBonificadores(pregunta,jugador);
        botonesPenalidad.setAlignment(Pos.CENTER_RIGHT);
        botonesPenalidad.setPadding(new Insets(20));

        // Botón para volver al menú principal
        Button backButton = new Button("Volver al Menú");
        backButton.setOnAction(e -> sceneController.switchToMenuScene());
        backButton.setStyle("-fx-font-size: 18px; -fx-background-color: #010101; -fx-text-fill: White; -fx-border-color: #010101; -fx-border-width: 10px;");

        VBox buttonBox = new VBox(10, enviarButton, backButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20));

        // Organizar la disposición de la interfaz
        HBox mainLayout = new HBox(20, opcionesBox, botonesPenalidad);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.CENTER);

        VBox layout = new VBox(20, preguntaLabel, mainLayout, buttonBox);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(layout);

        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        return scene;
    }

}
