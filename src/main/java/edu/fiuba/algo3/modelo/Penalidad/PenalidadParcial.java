package edu.fiuba.algo3.modelo.Penalidad;

import edu.fiuba.algo3.modelo.Jugador;

public class PenalidadParcial implements Penalidad {
    @Override
    public void asignarPuntajeJugador(Jugador jugador, int cantidadCorrectas, int cantidadIncorrectas) {
        if(cantidadIncorrectas == 0){
            jugador.sumarPuntos(cantidadCorrectas);
        }
    }
}
