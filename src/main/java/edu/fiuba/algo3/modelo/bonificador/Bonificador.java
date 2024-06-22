package edu.fiuba.algo3.modelo.bonificador;


import edu.fiuba.algo3.modelo.Jugador;

public interface Bonificador {
    int modificarPuntaje(int puntaje);

    Jugador getJugador();

    boolean aplicaBonificador(Jugador jugador);
}