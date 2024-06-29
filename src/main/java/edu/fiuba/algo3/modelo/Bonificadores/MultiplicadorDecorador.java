package edu.fiuba.algo3.modelo.Bonificadores;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.RespuestaPuntuada;

public class MultiplicadorDecorador extends BonificadorDecorador{
    private Jugador jugador;
    private int factor;
    private String nombreBonificador;

    public MultiplicadorDecorador(Bonificador wrapped,Jugador jugador, int factor){
        super(wrapped);
        this.factor = factor;
        this.jugador = jugador;
        this.nombreBonificador = "Multiplicador x" + factor;
    }

    public String getNombreBonificador() {
        return nombreBonificador;
    }

    @Override
    public RespuestaPuntuada modificarPuntaje(RespuestaPuntuada respuestaPuntuada){
        RespuestaPuntuada respuesta = super.modificarPuntaje(respuestaPuntuada);
        respuesta.setPuntos(respuesta.getPuntos() * factor);
        return respuesta;
    }

}