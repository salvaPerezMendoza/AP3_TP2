package edu.fiuba.algo3.modelo.Penalidad;

import edu.fiuba.algo3.modelo.Jugador;

public class ConPenalidad implements Penalidad {
    @Override
    public void asignarPuntajeJugador(Jugador jugador, int cantidadCorrectas, int cantidadIncorrectas) {
        jugador.sumarPuntos(-cantidadIncorrectas);
        jugador.sumarPuntos(cantidadCorrectas);
    }
}
