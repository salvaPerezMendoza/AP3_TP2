package edu.fiuba.algo3.modelo;

public interface Respuesta {
    boolean validarRespuesta(Respuesta respuestaJugador);

    Jugador getJugador();
}
