package edu.fiuba.algo3.modelo.Penalidad;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.bonificadores.Bonificador;

import java.util.ArrayList;

public interface Penalidad {

    void asignarPuntajeJugador(Jugador jugador, int cantidadCorrectas, int cantidadIncorrectas,Bonificador bonificador);

}
