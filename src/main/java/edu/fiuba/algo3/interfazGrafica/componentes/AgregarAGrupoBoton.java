package edu.fiuba.algo3.interfazGrafica.componentes;

import edu.fiuba.algo3.modelo.Opcion.OpcionGrupo;
import javafx.scene.control.Button;

public class AgregarAGrupoBoton extends Button {

    public AgregarAGrupoBoton(String nombreGrupo) {
        super("Agregar a: " + nombreGrupo);
        this.setStyle("-fx-font-size: 15px; -fx-background-color: #010101; -fx-text-fill: White;");
        this.setMaxWidth(Double.MAX_VALUE);
    }

}
