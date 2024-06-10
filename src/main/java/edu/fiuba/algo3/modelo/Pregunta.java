package edu.fiuba.algo3.modelo;


public interface Pregunta {
    int validarRespuesta(Respuesta respuestaJugador);
    void setMultiplicador(Multiplicador multiplicador);
    int aplicarMultiplicador(int puntaje);
}