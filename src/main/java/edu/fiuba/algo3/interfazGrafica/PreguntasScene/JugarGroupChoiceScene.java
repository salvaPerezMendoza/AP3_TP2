package edu.fiuba.algo3.interfazGrafica.PreguntasScene;

import edu.fiuba.algo3.interfazGrafica.SceneController;
import edu.fiuba.algo3.modelo.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class JugarGroupChoiceScene implements EscenaDePregunta {

    private SceneController sceneController;
    private Juego juego;

    public JugarGroupChoiceScene(SceneController sceneController, Juego juego, int ID) {
        this.sceneController = sceneController;
    }
    @Override
    public Scene getScene() {
        this.juego = juego;

        Label titleLabel = new Label("Jugar Group Choice");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Aquí agregarías los componentes específicos para Group Choice

        Button backButton = new Button("Continuar");
        backButton.setOnAction(e -> sceneController.siguienteTurno());
        backButton.setStyle("-fx-font-size: 18px; -fx-background-color: #f0ad4e; -fx-text-fill: white;");

        VBox layout = new VBox(20, titleLabel, backButton);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(layout);

        return new Scene(root, 1000, 650);
    }
}
