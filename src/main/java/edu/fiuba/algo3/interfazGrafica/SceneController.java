package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.interfazGrafica.PreguntasScene.*;
import edu.fiuba.algo3.modelo.Flujo;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {

    private Stage primaryStage;
    private Flujo flujo;
    private ObservableList<String> playerList;
    private int ID;

    public SceneController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.flujo = flujo;
        this.playerList = FXCollections.observableArrayList();
    }

    //Escenas de preguntas
    public void switchToJugarVerdaderoFalsoScene() {
        EscenaDePregunta jugarScene = new JugarVerdaderoFalsoScene(this, flujo);
        Scene jScene = jugarScene.getScene();
        primaryStage.setScene(jScene);
    }

    public void switchToJugarGroupChociceScene() {
        EscenaDePregunta jugarScene = new JugarGroupChoiceScene(this, flujo);
        Scene jScene = jugarScene.getScene();
        primaryStage.setScene(jScene);
    }

    public void switchToJugarMultipleChoiceScene() {
        EscenaDePregunta jugarScene = new JugarMultipleChoiceScene(this, flujo);
        Scene jScene = jugarScene.getScene();
        primaryStage.setScene(jScene);
    }

    public void switchToJugarOrderChoiceScene() {
        EscenaDePregunta jugarScene = new JugarOrderChoiceScene(this, flujo);
        Scene jScene = jugarScene.getScene();
        primaryStage.setScene(jScene);
    }

    // Menu + Reglas + Añadir Jugadores
    public void switchToMenuScene() {
        MenuScene menuScene = new MenuScene(this, flujo);
        Scene mScene = menuScene.getScene();
        primaryStage.setScene(mScene);
    }

    public void switchToReglasScene(Flujo flujo) {
        this.flujo = flujo;
        ReglasScene reglasScene = new ReglasScene(this);
        Scene rScene = reglasScene.getScene();
        primaryStage.setScene(rScene);
    }

    public void switchToAñadirJugadorScene(Flujo flujo) {
        this.flujo = flujo;
        AñadirJugadorScene añadirJugadorScene = new AñadirJugadorScene(this);
        Scene ajScene = añadirJugadorScene.getScene(flujo);
        primaryStage.setScene(ajScene);
    }

    // Turnos
    public void switchToTurnosScene() {
        TurnosScene turnosScene = new TurnosScene(this, flujo);
        Scene scene = turnosScene.getScene();
        primaryStage.setScene(scene);
    }

    public void switchToMostrarPuntajesScene(){
        MostrarPuntajesScene mostrarPuntajesScene = new MostrarPuntajesScene(this, flujo);
        Scene scene = mostrarPuntajesScene.getScene();
        primaryStage.setScene(scene);
    }

    public void addPlayer(String playerName) {
        Jugador jugador = new Jugador(playerName);
        flujo.agregarJugador(jugador);
    }

}
