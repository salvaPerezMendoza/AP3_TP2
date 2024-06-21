package edu.fiuba.algo3.modelo.Penalidad;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.bonificador.Bonificador;

public class ConPenalidad implements Penalidad {
    @Override
    public void asignarPuntajeJugador(Jugador jugador, int cantidadCorrectas, int cantidadIncorrectas, Bonificador bonificador) {
        jugador.sumarPuntos(-cantidadIncorrectas);
        jugador.sumarPuntos(cantidadCorrectas);
    }
}
