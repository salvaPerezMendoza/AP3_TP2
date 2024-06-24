package edu.fiuba.algo3.modelo.Penalidad;

import edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.bonificadores.Bonificador;


public class PenalidadParcial implements Penalidad {
    @Override
    public void asignarPuntajeJugador(Jugador jugador, int cantidadCorrectas, int cantidadIncorrectas, Bonificador bonificador) {
        if(cantidadIncorrectas == 0){
            jugador.sumarPuntos(bonificador.modificarPuntaje(cantidadCorrectas));
        }
    }
}
