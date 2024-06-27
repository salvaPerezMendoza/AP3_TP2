package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.interfazGrafica.PreguntasScene.*;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.TipoDePregunta.GroupChoice;
import edu.fiuba.algo3.modelo.TipoDePregunta.MultipleChoice;
import edu.fiuba.algo3.modelo.TipoDePregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.TipoDePregunta.VerdaderoFalso;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
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
        EscenaDePregunta jugarScene = new JugarVerdaderoFalsoScene(this, juego,ID);
        Scene jScene = jugarScene.getScene();
        primaryStage.setScene(jScene);
    }

    public void switchToJugarGroupChociceScene(int ID) {
        EscenaDePregunta jugarScene = new JugarGroupChoiceScene(this, juego, ID);
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
            switchToJugarVerdaderoFalsoScene(2);
        }
        if(juego.getPreguntaActual().getTipo() instanceof GroupChoice){
            switchToJugarGroupChociceScene(2);
        }
        if(juego.getPreguntaActual().getTipo() instanceof MultipleChoice){
            switchToJugarMultipleChoiceScene(2);
        }
        if(juego.getPreguntaActual().getTipo() instanceof OrderedChoice){
            switchToJugarOrderChoiceScene(2);
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
    public void siguientePregunta(){
        Pregunta preguntaActual = juego.getPreguntaActual();
        if(preguntaActual.respondieronTodos(juego.devolverJugadores().size())){
            //juego.getJugadorActual().responder();
            preguntaActual.validarRespuestas();
            switchToMostrarPuntajesScene();
        } else {
            switchToJugarPregunta();
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

}
