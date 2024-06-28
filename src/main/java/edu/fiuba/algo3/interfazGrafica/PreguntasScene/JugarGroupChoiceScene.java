package edu.fiuba.algo3.interfazGrafica.PreguntasScene;

import edu.fiuba.algo3.interfazGrafica.SceneController;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.OpcionGrupo;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

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
        Penalidad penalidadDeLaPregunta = pregunta.getPenalidad();

        Text preguntaText = new Text(pregunta.getEnunciado());
        TextFlow titleLabel = new TextFlow(preguntaText);
        titleLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: #333;");
        titleLabel.setPadding(new Insets(20));
        titleLabel.setMaxWidth(600);

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
        opcionesListView.setPrefHeight(200);

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

        Button agregarAGrupoAButton = new Button("Agregar a: Deportes Grupales");
        agregarAGrupoAButton.setStyle("-fx-font-size: 15px; -fx-background-color: #010101; -fx-text-fill: White;");
        agregarAGrupoAButton.setMaxWidth(Double.MAX_VALUE);
        agregarAGrupoAButton.setWrapText(true);

        agregarAGrupoAButton.setOnAction(e -> {
            OpcionSimple seleccionada = opcionesListView.getSelectionModel().getSelectedItem();
            if (seleccionada != null) {
                grupoAList.add(seleccionada);
                opcionesObservableList.remove(seleccionada);
            }
        });

        Button agregarAGrupoBButton = new Button("Agregar a: Deportes Individuales");
        agregarAGrupoBButton.setStyle("-fx-font-size: 15px; -fx-background-color: #010101; -fx-text-fill: White;");
        agregarAGrupoBButton.setMaxWidth(Double.MAX_VALUE);
        agregarAGrupoBButton.setWrapText(true);

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

        enviarButton.setStyle("-fx-font-size: 18px; -fx-background-color: #010101; -fx-text-fill: White; -fx-border-color: #010101; -fx-border-width: 10px;");

        VBox botonesPenalidad = sceneController.MostrarBonificadores(penalidadDeLaPregunta);
        botonesPenalidad.setAlignment(Pos.CENTER_RIGHT);
        botonesPenalidad.setPadding(new Insets(20));

        HBox agregarAGruposBox = new HBox(10, agregarAGrupoAButton, agregarAGrupoBButton);
        agregarAGruposBox.setAlignment(Pos.CENTER);

        VBox opcionesBox = new VBox(10, new Label("Opciones"), opcionesListView, agregarAGruposBox);
        opcionesBox.setPadding(new Insets(20));
        opcionesBox.setAlignment(Pos.CENTER_LEFT);

        VBox gruposBox = new VBox(10, new Label("Deportes Grupales"), grupoAListView, new Label("Deportes Individuales"), grupoBListView);
        gruposBox.setPadding(new Insets(20));
        gruposBox.setAlignment(Pos.CENTER_LEFT);

        VBox buttonBox = new VBox(10, enviarButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20));

        HBox layout = new HBox(20, opcionesBox, gruposBox, botonesPenalidad);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER_LEFT);

        BorderPane root = new BorderPane();
        root.setTop(titleLabel);
        root.setCenter(layout);
        root.setBottom(buttonBox);

        return new Scene(root, 1000, 650);
    }
}
