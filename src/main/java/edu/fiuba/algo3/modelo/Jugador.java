package edu.fiuba.algo3.modelo;

public class Jugador {
    private String nombre;
    private int puntajeTotal;

    public Jugador(String nombreJugador) {
        nombre = nombreJugador;
    }

    public String responder(String respuesta) {
        return respuesta;
    }

    public void sumarPuntos(int puntaje) {
        puntajeTotal += puntaje;
    }

    public int getPuntaje() {
        return puntajeTotal;
    }
}
