package edu.fiuba.algo3.modelo.Penalidad;

import edu.fiuba.algo3.modelo.Jugador;

public interface Penalidad {

    void asignarPuntajeJugador(Jugador jugador, int cantidadCorrectas, int cantidadIncorrectas);

}
