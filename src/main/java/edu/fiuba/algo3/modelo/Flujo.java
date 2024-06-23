package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Flujo {
    private List<Jugador> jugadores;
    private int turnoActual;

    public Flujo() {
        this.jugadores = new ArrayList<>();
        this.turnoActual = 0;
    }

    public void agregarJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public List<Jugador> devolverJugadores() {
        return jugadores;
    }

    public Jugador getJugadorActual() {
        return jugadores.get(turnoActual);
    }

    public void siguienteTurno() {
        turnoActual = (turnoActual + 1) % jugadores.size();
    }
}
