package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.bonificador.Bonificador;

public class RespuestaCorregida {
    private Jugador jugador;
    private int cantidadCorrectas;
    private int cantidadIncorrectas;

    public RespuestaCorregida(Jugador jugador, int cantidadCorrectas, int cantidadIncorrectas){
        this.jugador = jugador;
        this.cantidadCorrectas = cantidadCorrectas;
        this.cantidadIncorrectas = cantidadIncorrectas;
    }
    public void asignarPuntaje(Penalidad penalidad, Bonificador bonificador) {
        penalidad.asignarPuntajeJugador(jugador, cantidadCorrectas, cantidadIncorrectas, bonificador);
    }
}
