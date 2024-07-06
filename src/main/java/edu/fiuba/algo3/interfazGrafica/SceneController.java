package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.interfazGrafica.PreguntasScene.*;
import edu.fiuba.algo3.interfazGrafica.componentes.BonificadorBoton;
import edu.fiuba.algo3.modelo.Bonificadores.BonificadorDecorador;
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

import java.util.ArrayList;

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

    public VBox MostrarBonificadores(Pregunta pregunta, Jugador jugador){
        ArrayList<BonificadorDecorador> bonificadores = pregunta.obtenerBonificadoresDisponibles(jugador);
        VBox botonesPenalidad = new VBox(10);
        for(BonificadorDecorador bonificador : bonificadores){
            BonificadorBoton boton = new BonificadorBoton(bonificador, "-fx-font-size: 14px; -fx-background-color: #000000; -fx-text-fill: White;");
            boton.setOnAction(e -> jugador.usarBonificador(bonificador, pregunta));
            botonesPenalidad.getChildren().add(boton);
        }
        botonesPenalidad.setAlignment(Pos.CENTER_LEFT);
        botonesPenalidad.setPadding(new Insets(10));
        return botonesPenalidad;
    }

}
