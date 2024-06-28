package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.interfazGrafica.PreguntasScene.*;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Penalidad.ConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Penalidad.PenalidadParcial;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.TipoDePregunta.GroupChoice;
import edu.fiuba.algo3.modelo.TipoDePregunta.MultipleChoice;
import edu.fiuba.algo3.modelo.TipoDePregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.TipoDePregunta.VerdaderoFalso;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneController {

    private Stage primaryStage;
    private Juego juego;
    private ObservableList<String> playerList;
    private int ID;

    public SceneController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.juego = juego;
        this.playerList = FXCollections.observableArrayList();
    }

    //Escenas de preguntas
    public void switchToJugarVerdaderoFalsoScene(int ID) {
        EscenaDePregunta jugarScene = new JugarVerdaderoFalsoScene(this, juego);
        Scene jScene = jugarScene.getScene();
        primaryStage.setScene(jScene);
    }

    public void switchToJugarGroupChociceScene(int ID) {
        JugarGroupChoiceScene jugarScene = new JugarGroupChoiceScene(this, juego);
        Scene jScene = jugarScene.getScene();
        primaryStage.setScene(jScene);
    }

    public void switchToJugarMultipleChoiceScene(int ID) {
        JugarMultipleChoiceScene jugarScene = new JugarMultipleChoiceScene(this, juego);
        Scene jScene = jugarScene.getScene();
        primaryStage.setScene(jScene);
    }

    public void switchToJugarOrderChoiceScene(int ID) {
        JugarOrderChoiceScene jugarScene = new JugarOrderChoiceScene(this, juego);
        Scene jScene = jugarScene.getScene();
        primaryStage.setScene(jScene);
    }

    public void switchToJugarPregunta(){
        if(juego.getPreguntaActual().getTipo() instanceof VerdaderoFalso){
            switchToJugarVerdaderoFalsoScene(3);
        }
        if(juego.getPreguntaActual().getTipo() instanceof GroupChoice){
            switchToJugarGroupChociceScene(3);
        }
        if(juego.getPreguntaActual().getTipo() instanceof MultipleChoice){
            switchToJugarMultipleChoiceScene(3);
        }
        if(juego.getPreguntaActual().getTipo() instanceof OrderedChoice){
            switchToJugarOrderChoiceScene(3);
        }
    }

    // Menu + Reglas + Añadir Jugadores
    public void switchToMenuScene() {
        MenuScene menuScene = new MenuScene(this, juego);
        Scene mScene = menuScene.getScene();
        primaryStage.setScene(mScene);
    }

    public void switchToReglasScene(Juego juego) {
        this.juego = juego;
        ReglasScene reglasScene = new ReglasScene(this);
        Scene rScene = reglasScene.getScene();
        primaryStage.setScene(rScene);
    }

    public void switchToAñadirJugadorScene(Juego juego) {
        this.juego = juego;
        AñadirJugadorScene añadirJugadorScene = new AñadirJugadorScene(this);
        Scene ajScene = añadirJugadorScene.getScene(juego);
        primaryStage.setScene(ajScene);
    }

    public void iniciarJuego(){
        juego.iniciarJuego();
        switchToTurnosScene();
    }


    // la idea seria, mandar una pregunta y que respondan los cuatro
    public void siguienteTurno(){
        Pregunta preguntaActual = juego.getPreguntaActual();
        if(preguntaActual.respondieronTodos(juego.devolverJugadores().size())){
            //juego.getJugadorActual().responder();
            preguntaActual.validarRespuestas();
            switchToMostrarPuntajesScene();
            juego.setearPreguntaActual();
        } else {
            switchToTurnosScene();
        }
    }

    // Turnos
    public void switchToTurnosScene() {
        TurnosScene turnosScene = new TurnosScene(this, juego);
        Scene scene = turnosScene.getScene();
        primaryStage.setScene(scene);
    }

    public void switchToMostrarPuntajesScene(){
        MostrarPuntajesScene mostrarPuntajesScene = new MostrarPuntajesScene(this, juego);
        Scene scene = mostrarPuntajesScene.getScene();
        primaryStage.setScene(scene);
    }

    public void addPlayer(String playerName) {
        Jugador jugador = new Jugador(playerName);
        juego.agregarJugador(jugador);
    }

    public VBox MostrarBonificadores(Penalidad penalidad){
        VBox botonesPenalidad = new VBox(10);
        if (penalidad instanceof ConPenalidad) {
            Button multiplicadorX2 = new Button("Multiplicador X2");
            Button multiplicadorX3 = new Button("Multiplicador X3");
            Button anuladorPuntaje = new Button("Anulador Puntaje");

            multiplicadorX2.setStyle("-fx-font-size: 14px; -fx-background-color: #010101; -fx-text-fill: White;");
            multiplicadorX2.setWrapText(true);
            multiplicadorX3.setStyle("-fx-font-size: 14px; -fx-background-color: #010101; -fx-text-fill: White;");
            multiplicadorX3.setWrapText(true);
            anuladorPuntaje.setStyle("-fx-font-size: 14px; -fx-background-color: #010101; -fx-text-fill: White;");
            anuladorPuntaje.setWrapText(true);

            botonesPenalidad.getChildren().addAll(multiplicadorX2, multiplicadorX3, anuladorPuntaje);
            botonesPenalidad.setAlignment(Pos.CENTER_LEFT);
            botonesPenalidad.setPadding(new Insets(10));
        } else if (penalidad instanceof PenalidadParcial) {
            Button anuladorPuntaje = new Button("Anulador Puntaje");
            anuladorPuntaje.setStyle("-fx-font-size: 14px; -fx-background-color: #010101; -fx-text-fill: White;");
            botonesPenalidad.getChildren().add(anuladorPuntaje);
            botonesPenalidad.setAlignment(Pos.CENTER_LEFT);
            botonesPenalidad.setPadding(new Insets(10));
            anuladorPuntaje.setWrapText(true);
        } else {
            Button exclusividadPuntaje = new Button("Usar Exclusividad ");
            Button anuladorPuntaje = new Button("Usar Anulador ");
            exclusividadPuntaje.setWrapText(true);
            anuladorPuntaje.setWrapText(true);

            exclusividadPuntaje.setStyle("-fx-font-size: 14px; -fx-background-color: #010101; -fx-text-fill: White;");
            anuladorPuntaje.setStyle("-fx-font-size: 14px; -fx-background-color: #010101; -fx-text-fill: White;");

            botonesPenalidad.getChildren().addAll(exclusividadPuntaje, anuladorPuntaje);
            botonesPenalidad.setAlignment(Pos.CENTER_LEFT);
            botonesPenalidad.setPadding(new Insets(10));
        }
        return botonesPenalidad;
    }

}
