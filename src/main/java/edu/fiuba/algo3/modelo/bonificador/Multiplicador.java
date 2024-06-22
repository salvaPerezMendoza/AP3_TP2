package edu.fiuba.algo3.modelo.bonificador;


import edu.fiuba.algo3.modelo.Jugador;

public class Multiplicador implements Bonificador{
    private Jugador jugador;
    private int factor;

    public Multiplicador(int factor, Jugador jugador){
        this.jugador = jugador;
        this.factor = factor;
    }

    @Override
    public Jugador getJugador() {
        return jugador;
    }

    @Override
    public boolean aplicaBonificador(Jugador jugador) {
        if(jugador == this.jugador){
            return true;
        }
        return false;
    }

    public int modificarPuntaje(int puntaje){
        return puntaje * factor;
    }
}