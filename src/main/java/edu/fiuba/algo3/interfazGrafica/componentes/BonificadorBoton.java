package edu.fiuba.algo3.interfazGrafica.componentes;

import edu.fiuba.algo3.modelo.Bonificadores.BonificadorDecorador;
import javafx.scene.control.Button;

public class BonificadorBoton extends Button {
    private BonificadorDecorador bonificador;

    public BonificadorBoton(BonificadorDecorador bonificador, String styles){
        super(bonificador.getNombreBonificador());
        this.bonificador = bonificador;
        this.setStyle(styles);
    }

    public BonificadorDecorador getBonificador() {
        return bonificador;
    }
}
