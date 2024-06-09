package edu.fiuba.algo3.modelo;

public class Jugador {
    private String nombre;
    private int puntajeTotal;

    public Jugador(String nombreJugador) {
        nombre = nombreJugador;
    }

    public void responder(Pregunta pregunta, Respuesta respuestaJugador) {
        pregunta.validarRespuesta(respuestaJugador);
    }

    public void sumarPuntos(int puntaje) {
        puntajeTotal += puntaje;
    }

    public int getPuntaje() {
        return puntajeTotal;
    }
}
