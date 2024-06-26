package edu.fiuba.algo3;

import edu.fiuba.algo3.interfazGrafica.MenuScene;
import edu.fiuba.algo3.interfazGrafica.SceneController;
//import edu.fiuba.algo3.modelo.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.Flujo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException, ParseException {
        Flujo flujo = new Flujo();
        flujo.crearPreguntas();
        SceneController sceneController = new SceneController(primaryStage, flujo);

        // Crear la primera escena
        ListView<String> participantes = new ListView<>();
        MenuScene menuScene = new MenuScene(sceneController, participantes);
        Scene scene1 = menuScene.getScene();

        // Mostrar la primera escena
        primaryStage.setScene(scene1);
        primaryStage.setTitle("AlgoHoot");
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
