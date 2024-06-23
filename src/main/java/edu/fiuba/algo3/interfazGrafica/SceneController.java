package edu.fiuba.algo3.interfazGrafica;

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

    public SceneController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.flujo = flujo;
        this.playerList = FXCollections.observableArrayList();
    }

    public void switchToMenuScene() {
        MenuScene menuScene = new MenuScene(this, flujo);
        Scene mScene = menuScene.getScene();
        primaryStage.setScene(mScene);
    }

    public void switchToJugarVerdaderoFalosScene() {
        JugarVerdaderoFalsoScene jugarScene = new JugarVerdaderoFalsoScene(this);
        Scene jScene = jugarScene.getScene(flujo);
        primaryStage.setScene(jScene);
    }

    public void switchToJugarGroupChociceScene() {
        JugarGroupChoiceScene jugarScene = new JugarGroupChoiceScene(this);
        Scene jScene = jugarScene.getScene(flujo);
        primaryStage.setScene(jScene);
    }

    public void switchToJugarMultipleChoiceScene() {
        JugarMultipleChoiceScene jugarScene = new JugarMultipleChoiceScene(this);
        Scene jScene = jugarScene.getScene(flujo);
        primaryStage.setScene(jScene);
    }

    public void switchToJugarOrderChoiceScene() {
        JugarOrderChoiceScene jugarScene = new JugarOrderChoiceScene(this);
        Scene jScene = jugarScene.getScene(flujo);
        primaryStage.setScene(jScene);
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

    public void switchToTurnoScene() {
        TurnosScene turnosScene = new TurnosScene(this, flujo);
        Scene scene = turnosScene.getScene();
        primaryStage.setScene(scene);
    }


    public void addPlayer(String playerName) {
        Jugador jugador = new Jugador(playerName);
        flujo.agregarJugador(jugador);
    }

}
