package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.modelo.Flujo;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.List;

public class MostrarPuntajesScene {

    private SceneController sceneController;
    private Flujo flujo;

    public MostrarPuntajesScene(SceneController sceneController, Flujo flujo) {
        this.sceneController = sceneController;
        this.flujo = flujo;
    }

    public Scene getScene() {
        // Crear el layout principal
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        // Crear la etiqueta del título
        Label tituloLabel = new Label("Puntajes de Jugadores");
        tituloLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333;");
        layout.getChildren().add(tituloLabel);

        // Obtener la lista de jugadores y mostrar sus puntajes
        List<Jugador> jugadores = flujo.devolverJugadores();
        for (Jugador jugador : jugadores) {
            Label puntajeLabel = new Label(jugador.getNombre() + ": " + jugador.getPuntajeTotal() + " puntos");
            puntajeLabel.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");
            layout.getChildren().add(puntajeLabel);
        }

        // Botón para volver al menú
        Button continuarButton = new Button("Continuar");
        continuarButton.setOnAction(e -> sceneController.switchToTurnosScene());
        continuarButton.setStyle("-fx-font-size: 18px; -fx-background-color: #f0ad4e; -fx-text-fill: white;");

       layout.getChildren().add(continuarButton);

        // Crear la escena y agregar el layout principal
        BorderPane root = new BorderPane();
        root.setCenter(layout);

        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        return scene;
    }
}
