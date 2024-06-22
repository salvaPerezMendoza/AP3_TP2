package edu.fiuba.algo3.modelo.bonificador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.RespuestaCorregida;

import java.util.ArrayList;

public class AnuladorDePuntaje implements Bonificador{

    private Jugador jugador;

    public AnuladorDePuntaje(Jugador jugador){
        this.jugador = jugador;
    }

    @Override
    public int modificarPuntaje(int puntaje){
        return puntaje;
    }

    @Override
    public Jugador getJugador() {
        return jugador;
    }

    @Override
    public boolean aplicaBonificador(Jugador jugador) {
        return false;
    }

    public void anularPuntajes(ArrayList<RespuestaCorregida> respuestasCorregidas, Penalidad penalidad){
        for (RespuestaCorregida respuestaCorregida : respuestasCorregidas){
            if(respuestaCorregida.getJugador() != this.jugador){
                respuestaCorregida.getJugador().sumarPuntos(0);
            } else {
                penalidad.asignarPuntajeJugador(respuestaCorregida.getJugador(), respuestaCorregida.getCantidadCorrectas(),
                        respuestaCorregida.getCantidadIncorrectas(), this);
            }
        }
    }
}
