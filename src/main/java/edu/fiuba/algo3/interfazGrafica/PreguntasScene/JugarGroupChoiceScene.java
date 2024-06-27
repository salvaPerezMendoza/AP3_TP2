package edu.fiuba.algo3.interfazGrafica.PreguntasScene;

import edu.fiuba.algo3.interfazGrafica.SceneController;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionGrupo;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;
import edu.fiuba.algo3.modelo.TipoDePregunta.GroupChoice;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class JugarGroupChoiceScene implements EscenaDePregunta {

    private SceneController sceneController;
    private Flujo flujo;
    private Pregunta pregunta;

    public JugarGroupChoiceScene(SceneController sceneController, Flujo flujo) {
        this.sceneController = sceneController;
        this.flujo = flujo;
        this.pregunta = getPregunta(); // Instanciar la pregunta aquí mismo, en realidad me llega por parametro
    }

    private Pregunta getPregunta() {

        ArrayList<OpcionSimple> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Lio Messi", 1));
        opciones.add(new OpcionSimple("Manu Ginóbili", 2));
        opciones.add(new OpcionSimple("Juan Martín del Potro", 3));
        opciones.add(new OpcionSimple("Miguel Najdorf", 4));
        opciones.add(new OpcionSimple("Hugo Conte", 5));
        opciones.add(new OpcionSimple("José Meolans", 6));

        HashSet<OpcionSimple> deportesGrupales = new HashSet<>();
        deportesGrupales.add(new OpcionSimple("Lio Messi", 1));
        deportesGrupales.add(new OpcionSimple("Manu Ginóbili", 2));
        deportesGrupales.add(new OpcionSimple("Hugo Conte", 5));

        HashSet<OpcionSimple> deportesIndividuales = new HashSet<>();
        deportesIndividuales.add(new OpcionSimple("Juan Martín del Potro", 3));
        deportesIndividuales.add(new OpcionSimple("Miguel Najdorf", 4));
        deportesIndividuales.add(new OpcionSimple("José Meolans", 6));

        OpcionGrupo grupoA = new OpcionGrupo("Deportes Grupales", deportesGrupales);
        OpcionGrupo grupoB = new OpcionGrupo("Deportes Individuales", deportesIndividuales);

        ArrayList<OpcionGrupo> gruposCorrectos = new ArrayList<>();
        gruposCorrectos.add(grupoA);
        gruposCorrectos.add(grupoB);

        TipoDePregunta groupChoice = new GroupChoice(opciones, gruposCorrectos);
        Penalidad sinPenalidad = new SinPenalidad();

        String enunciado = "Asigne las siguientes leyendas del deporte nacional a disciplina grupales (Fútbol, Básquet, Voley, Rugby,) o individuales (atletismo, tenis, artes marciales, ajedrez, etc):";
        String tema = "MISCELANEAS";
        return new Pregunta(groupChoice, sinPenalidad, enunciado, tema);
    }

    @Override
    public Scene getScene() {

        Label preguntaLabel = new Label(pregunta.getEnunciado());
        preguntaLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333;");
        preguntaLabel.setPadding(new Insets(20));

        //  esta lista se la deveria pedir a pregunta
        ObservableList<OpcionSimple> opciones = FXCollections.observableArrayList();

        opciones.add(new OpcionSimple("Lio Messi", 1));
        opciones.add(new OpcionSimple("Manu Ginóbili", 2));
        opciones.add(new OpcionSimple("Juan Martín del Potro", 3));
        opciones.add(new OpcionSimple("Miguel Najdorf", 4));
        opciones.add(new OpcionSimple("Hugo Conte", 5));
        opciones.add(new OpcionSimple("José Meolans", 6));

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

        // Crear listas para los grupos
        ObservableList<OpcionSimple> grupoAList = FXCollections.observableArrayList();
        ListView<OpcionSimple> grupoAListView = new ListView<>(grupoAList);
        grupoAListView.setCellFactory(param -> new ListCell<OpcionSimple>() {
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
        grupoAListView.setStyle("-fx-font-size: 9px; -fx-padding: 10px;");

        ObservableList<OpcionSimple> grupoBList = FXCollections.observableArrayList();
        ListView<OpcionSimple> grupoBListView = new ListView<>(grupoBList);
        grupoBListView.setCellFactory(param -> new ListCell<OpcionSimple>() {
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
        grupoBListView.setStyle("-fx-font-size: 9px; -fx-padding: 10px;");

        // agregar a grupo A
        Button agregarAGrupoAButton = new Button("Agregar a Deportes Grupales");
        agregarAGrupoAButton.setOnAction(e -> {
            OpcionSimple seleccionada = opcionesListView.getSelectionModel().getSelectedItem();
            if (seleccionada != null) {
                grupoAList.add(seleccionada);
                opciones.remove(seleccionada);
            }
        });

        // agregar a grupo B
        Button agregarAGrupoBButton = new Button("Agregar a Deportes Individuales");
        agregarAGrupoBButton.setOnAction(e -> {
            OpcionSimple seleccionada = opcionesListView.getSelectionModel().getSelectedItem();
            if (seleccionada != null) {
                grupoBList.add(seleccionada);
                opciones.remove(seleccionada);
            }
        });

        // Botón para enviar y comprobar la respuesta
        Button enviarButton = new Button("Enviar");
        enviarButton.setOnAction(e -> {
            ArrayList<OpcionSimple> opcionesGrupoA = new ArrayList<>(grupoAList);
            ArrayList<OpcionSimple> opcionesGrupoB = new ArrayList<>(grupoBList);

            Jugador jugadorActual = flujo.getJugadorActual();
            Respuesta respuesta = new Respuesta(jugadorActual);

            OpcionGrupo grupoA = new OpcionGrupo("Deportes Grupales", new HashSet<>(opcionesGrupoA));
            OpcionGrupo grupoB = new OpcionGrupo("Deportes Individuales", new HashSet<>(opcionesGrupoB));

            respuesta.agregarOpcion(grupoA);
            respuesta.agregarOpcion(grupoB);

            jugadorActual.responder(pregunta, respuesta);

            // Cambiar al siguiente turno
            sceneController.switchToTurnosScene();
        });

        enviarButton.setStyle("-fx-font-size: 18px; -fx-background-color: #4CAF50; -fx-text-fill: white;");

        // Botón para volver al menú
        Button backButton = new Button("Volver al Menú");
        backButton.setOnAction(e -> sceneController.switchToMenuScene());
        backButton.setStyle("-fx-font-size: 18px; -fx-background-color: #f0ad4e; -fx-text-fill: white;");

        // Layout principal
        VBox buttonBox = new VBox(10, enviarButton, backButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20));

        VBox opcionesBox = new VBox(10, opcionesListView, agregarAGrupoAButton, agregarAGrupoBButton);
        opcionesBox.setPadding(new Insets(20));
        opcionesBox.setAlignment(Pos.CENTER_LEFT);

        HBox gruposBox = new HBox(20, grupoAListView, grupoBListView);
        gruposBox.setPadding(new Insets(20));
        gruposBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(20, preguntaLabel, opcionesBox, gruposBox, buttonBox);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(layout);

        Scene scene = new Scene(root, 1000, 650);

        return scene;
    }
}
