package edu.fiuba.algo3.interfazGrafica.PreguntasScene;

import edu.fiuba.algo3.interfazGrafica.SceneController;
import edu.fiuba.algo3.interfazGrafica.componentes.AgregarAGrupoBoton;
import edu.fiuba.algo3.interfazGrafica.componentes.GrupoVista;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.OpcionGrupo;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.TipoDePregunta.GroupChoice;
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
        GroupChoice grupos = (GroupChoice) pregunta.getTipo();
        Respuesta respuesta = new Respuesta(jugador);

        Text preguntaText = new Text(pregunta.getEnunciado());
        TextFlow titleLabel = new TextFlow(preguntaText);
        titleLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: #333;");
        titleLabel.setPadding(new Insets(20));
        titleLabel.setMaxWidth(600);

        ObservableList<OpcionSimple> opcionesObservableList = FXCollections.observableArrayList(opciones);
        ObservableList<OpcionSimple> grupo1List = FXCollections.observableArrayList();
        ObservableList<OpcionSimple> grupo2List = FXCollections.observableArrayList();

        GrupoVista opcionesListView = new GrupoVista(opcionesObservableList);
        GrupoVista grupoAListView = new GrupoVista(grupo1List);
        GrupoVista grupoBListView = new GrupoVista(grupo2List);

        AgregarAGrupoBoton agregarAGrupo1Button = new AgregarAGrupoBoton(grupos.getNombreGrupo(0));
        AgregarAGrupoBoton agregarAGrupo2Button = new AgregarAGrupoBoton(grupos.getNombreGrupo(1));

        agregarAGrupo1Button.setOnAction(e -> {
            OpcionSimple seleccionada = opcionesListView.getSelectionModel().getSelectedItem();
            if (seleccionada != null) {
                grupo1List.add(seleccionada);
                opcionesObservableList.remove(seleccionada);
            }
        });

        agregarAGrupo2Button.setOnAction(e -> {
            OpcionSimple seleccionada = opcionesListView.getSelectionModel().getSelectedItem();
            if (seleccionada != null) {
                grupo2List.add(seleccionada);
                opcionesObservableList.remove(seleccionada);
            }
        });

        Button enviarButton = new Button("Enviar");
        enviarButton.setOnAction(e -> {
            OpcionGrupo grupoA = new OpcionGrupo(grupos.getNombreGrupo(0), new HashSet<>(grupo1List));
            OpcionGrupo grupoB = new OpcionGrupo(grupos.getNombreGrupo(1), new HashSet<>(grupo2List));
            respuesta.agregarOpcion(grupoA);
            respuesta.agregarOpcion(grupoB);
            jugador.responder(pregunta, respuesta);
            juego.siguienteTurno();
            sceneController.siguienteTurno();
        });

        enviarButton.setStyle("-fx-font-size: 18px; -fx-background-color: #010101; -fx-text-fill: White; -fx-border-color: #010101; -fx-border-width: 10px;");

        VBox botonesPenalidad = sceneController.MostrarBonificadores(pregunta, jugador);
        botonesPenalidad.setAlignment(Pos.CENTER_RIGHT);
        botonesPenalidad.setPadding(new Insets(20));

        HBox agregarAGruposBox = new HBox(10, agregarAGrupo1Button, agregarAGrupo2Button);
        agregarAGruposBox.setAlignment(Pos.CENTER);

        VBox opcionesBox = new VBox(10, new Label("Opciones"), opcionesListView, agregarAGruposBox);
        opcionesBox.setPadding(new Insets(20));
        opcionesBox.setAlignment(Pos.CENTER_LEFT);

        VBox gruposBox = new VBox(10, new Label(grupos.getNombreGrupo(0)), grupoAListView, new Label(grupos.getNombreGrupo(1)), grupoBListView);
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
