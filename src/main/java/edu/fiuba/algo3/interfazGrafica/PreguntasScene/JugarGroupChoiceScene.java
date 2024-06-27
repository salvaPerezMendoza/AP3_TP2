package edu.fiuba.algo3.interfazGrafica.PreguntasScene;

import edu.fiuba.algo3.interfazGrafica.SceneController;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.OpcionGrupo;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashSet;

public class JugarGroupChoiceScene {

    private SceneController sceneController;
    private Juego juego;

    public JugarGroupChoiceScene(SceneController sceneController, Juego juego) {
        this.sceneController = sceneController;
        this.juego = juego;
    }

    public Scene getScene() {
        Jugador jugador = juego.getJugadorActual();
        Pregunta pregunta = juego.getPreguntaActual();
        ArrayList<OpcionSimple> opciones = pregunta.obtenerOpciones();
        Respuesta respuesta = new Respuesta(jugador);

        Label nombreJugadorLabel = new Label(jugador.getNombre());
        nombreJugadorLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #000;");
        nombreJugadorLabel.setPadding(new Insets(10));

        Label titleLabel = new Label("Jugar Group Choice");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TextArea preguntaArea = new TextArea(pregunta.getEnunciado());
        preguntaArea.setWrapText(true);
        preguntaArea.setEditable(false);
        preguntaArea.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333;");
        preguntaArea.setPrefHeight(100);
        preguntaArea.setPadding(new Insets(20));

        ObservableList<OpcionSimple> opcionesObservableList = FXCollections.observableArrayList();
        opcionesObservableList.addAll(opciones);

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
        opcionesListView.setPrefHeight(200);

        Button backButton = new Button("Continuar");

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
        grupoAListView.setPrefHeight(200);

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
        grupoBListView.setPrefHeight(200);

        Button agregarAGrupoAButton = new Button("Agregar a Deportes Grupales");
        agregarAGrupoAButton.setOnAction(e -> {
            OpcionSimple seleccionada = opcionesListView.getSelectionModel().getSelectedItem();
            if (seleccionada != null) {
                grupoAList.add(seleccionada);
                opcionesObservableList.remove(seleccionada);
            }
        });

        Button agregarAGrupoBButton = new Button("Agregar a Deportes Individuales");
        agregarAGrupoBButton.setOnAction(e -> {
            OpcionSimple seleccionada = opcionesListView.getSelectionModel().getSelectedItem();
            if (seleccionada != null) {
                grupoBList.add(seleccionada);
                opcionesObservableList.remove(seleccionada);
            }
        });

        Button enviarButton = new Button("Enviar");
        enviarButton.setOnAction(e -> {
            ArrayList<OpcionSimple> opcionesGrupoA = new ArrayList<>(grupoAList);
            ArrayList<OpcionSimple> opcionesGrupoB = new ArrayList<>(grupoBList);
            Jugador jugadorActual = juego.getJugadorActual();
            OpcionGrupo grupoA = new OpcionGrupo("Deportes Grupales", new HashSet<>(opcionesGrupoA));
            OpcionGrupo grupoB = new OpcionGrupo("Deportes Individuales", new HashSet<>(opcionesGrupoB));
            respuesta.agregarOpcion(grupoA);
            respuesta.agregarOpcion(grupoB);
            jugadorActual.responder(pregunta, respuesta);
            juego.siguienteTurno();
            sceneController.siguienteTurno();
        });

        enviarButton.setStyle("-fx-font-size: 18px; -fx-background-color: #4CAF50; -fx-text-fill: white;");

        VBox opcionesBox = new VBox(10, opcionesListView, agregarAGrupoAButton, agregarAGrupoBButton);
        opcionesBox.setPadding(new Insets(20));
        opcionesBox.setAlignment(Pos.CENTER_LEFT);

        HBox gruposBox = new HBox(20, grupoAListView, grupoBListView);
        gruposBox.setPadding(new Insets(20));
        gruposBox.setAlignment(Pos.CENTER);

        VBox buttonBox = new VBox(10, enviarButton, backButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20));

        VBox layout = new VBox(20, nombreJugadorLabel, titleLabel, preguntaArea, opcionesBox, gruposBox, buttonBox);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(layout);

        return new Scene(root, 1000, 650);
    }
}
