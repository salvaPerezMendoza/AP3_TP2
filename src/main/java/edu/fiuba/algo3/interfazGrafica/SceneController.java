package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.modelo.Flujo;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {

    private Stage primaryStage;
    private Flujo flujo;

    public SceneController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void switchToMenuScene() {
        MenuScene menuScene = new MenuScene(this, flujo);
        Scene mScene = menuScene.getScene();
        primaryStage.setScene(mScene);
    }

    public void switchToJugarScene() {
        JugarScene jugarScene = new JugarScene(this);
        Scene jScene = jugarScene.getScene();
        primaryStage.setScene(jScene);
    }

    public void switchToReglasScene() {
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

    public void addPlayer(String playerName) {
        Jugador jugador = new Jugador(playerName);
        flujo.agregarJugador(jugador);
    }

}
