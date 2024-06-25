package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.modelo.Flujo;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class SceneController {
    private Stage primaryStage;
    private Flujo flujo;

    public SceneController(Stage primaryStage, Flujo flujo) {
        this.primaryStage = primaryStage;
        this.flujo = flujo;
    }

    public Flujo getFlujo() {
        return flujo;
    }

    public void switchToMenuScene() {
        ListView<String> participantes = new ListView<>();
        MenuScene menuScene = new MenuScene(this, participantes);
        primaryStage.setScene(menuScene.getScene());
    }

    public void switchToJugarVerdaderoFalsoScene() {
        JugarVerdaderoFalsoScene jugarVFScene = new JugarVerdaderoFalsoScene(this, flujo);
        primaryStage.setScene(jugarVFScene.getScene());
    }

    public void switchToAñadirJugadorScene() {
        AñadirJugadorScene añadirJugadorScene = new AñadirJugadorScene(this);
        primaryStage.setScene(añadirJugadorScene.getScene(flujo));
    }

    public void switchToReglasScene() {
        ReglasScene reglasScene = new ReglasScene(this);
        primaryStage.setScene(reglasScene.getScene());
    }

    public void switchToTurnosScene() {
        TurnosScene turnosScene = new TurnosScene(this, flujo);
        primaryStage.setScene(turnosScene.getScene());
    }
}
