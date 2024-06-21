package edu.fiuba.algo3.modelo.Penalidad;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.bonificador.Bonificador;

public interface Penalidad {

    void asignarPuntajeJugador(Jugador jugador, int cantidadCorrectas, int cantidadIncorrectas, Bonificador bonificador);

}
