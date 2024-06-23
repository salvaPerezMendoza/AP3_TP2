package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.modelo.Flujo;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionGrupo;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.TipoDePregunta.GroupChoice;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashSet;

public class JugarGroupChoiceScene {

    private SceneController sceneController;

    public JugarGroupChoiceScene(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    public Scene getScene(Flujo flujo) {
        // Obtener la pregunta actual (en este ejemplo se crea una pregunta ficticia)
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Tigre"));
        opciones.add(new OpcionSimple("Pato"));
        opciones.add(new OpcionSimple("Gallina"));
        opciones.add(new OpcionSimple("Perro"));
        opciones.add(new OpcionSimple("Pajaro"));
        opciones.add(new OpcionSimple("Gato"));

        HashSet<OpcionSimple> mamiferosCorrectos = new HashSet<>();
        mamiferosCorrectos.add(new OpcionSimple("Tigre"));
        mamiferosCorrectos.add(new OpcionSimple("Perro"));
        mamiferosCorrectos.add(new OpcionSimple("Gato"));
        HashSet<OpcionSimple> oviparosCorrectos = new HashSet<>();
        oviparosCorrectos.add(new OpcionSimple("Gallina"));
        oviparosCorrectos.add(new OpcionSimple("Pajaro"));
        oviparosCorrectos.add(new OpcionSimple("Pato"));

        OpcionGrupo grupo1 = new OpcionGrupo("Mamiferos", mamiferosCorrectos);
        OpcionGrupo grupo2 = new OpcionGrupo("Oviparos", oviparosCorrectos);

        ArrayList<OpcionGrupo> gruposCorrectos = new ArrayList<>();
        gruposCorrectos.add(grupo1);
        gruposCorrectos.add(grupo2);

        GroupChoice tipoPregunta = new GroupChoice(opciones, gruposCorrectos);
        Pregunta preguntaActual = new Pregunta(tipoPregunta, null, "Colocar los animales en la categoria correspondiente");

        // Crear la etiqueta de la pregunta
        Label preguntaLabel = new Label(preguntaActual.getEnunciado());
        preguntaLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333;");
        preguntaLabel.setPadding(new Insets(20));

        // Crear las opciones de respuesta
        VBox opcionesVBox = new VBox();
        opcionesVBox.setSpacing(10);
        opcionesVBox.setPadding(new Insets(20));

        for (Opcion opcion : opciones) {
            CheckBox checkBox = new CheckBox(opcion.getName());
            checkBox.setStyle("-fx-font-size: 18px;");
            opcionesVBox.getChildren().add(checkBox);
        }

        // Crear contenedores para los grupos
        VBox grupoMamiferosVBox = new VBox(new Label("Mamiferos"));
        grupoMamiferosVBox.setSpacing(10);
        grupoMamiferosVBox.setPadding(new Insets(10));
        grupoMamiferosVBox.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-padding: 10px;");

        VBox grupoOviparosVBox = new VBox(new Label("Oviparos"));
        grupoOviparosVBox.setSpacing(10);
        grupoOviparosVBox.setPadding(new Insets(10));
        grupoOviparosVBox.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-padding: 10px;");

        HBox gruposHBox = new HBox(20, grupoMamiferosVBox, grupoOviparosVBox);
        gruposHBox.setAlignment(Pos.CENTER);

        // Botón para enviar la respuesta
        Button enviarButton = new Button("Enviar");
        enviarButton.setOnAction(e -> {
            OpcionGrupo mamiferosJugador = new OpcionGrupo("Mamiferos", new HashSet<>());
            OpcionGrupo oviparosJugador = new OpcionGrupo("Oviparos", new HashSet<>());

            for (int i = 0; i < opcionesVBox.getChildren().size(); i++) {
                CheckBox checkBox = (CheckBox) opcionesVBox.getChildren().get(i);
                OpcionSimple opcionSimple = new OpcionSimple(checkBox.getText());

                if (checkBox.isSelected()) {
                    if (grupoMamiferosVBox.getChildren().contains(checkBox)) {
                        mamiferosJugador.agregarOpcion(opcionSimple);
                    } else if (grupoOviparosVBox.getChildren().contains(checkBox)) {
                        oviparosJugador.agregarOpcion(opcionSimple);
                    }
                }
            }

            Respuesta respuesta = new Respuesta(flujo.getJugadorActual());
            respuesta.agregarOpcion(mamiferosJugador);
            respuesta.agregarOpcion(oviparosJugador);

            flujo.getJugadorActual().responder(preguntaActual, respuesta);
            preguntaActual.validarRespuestas();

            // Cambiar al siguiente turno
            flujo.siguienteTurno();
            sceneController.switchToTurnoScene();
        });
        enviarButton.setStyle("-fx-font-size: 18px; -fx-background-color: #4CAF50; -fx-text-fill: white;");

        // Botón para volver al menú
        Button backButton = new Button("Volver al Menú");
        backButton.setOnAction(e -> sceneController.switchToMenuScene());
        backButton.setStyle("-fx-font-size: 18px; -fx-background-color: #f0ad4e; -fx-text-fill: white;");

        VBox buttonBox = new VBox(10, enviarButton, backButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20));

        // Layout principal
        VBox layout = new VBox(20, preguntaLabel, opcionesVBox, gruposHBox, buttonBox);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(layout);

        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        return scene;
    }
}
