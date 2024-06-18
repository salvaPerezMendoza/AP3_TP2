package edu.fiuba.algo3.modelo;


import java.util.ArrayList;

public interface Pregunta {
    void validarRespuesta(Respuesta respuestaJugador);

    void validarRespuestas(ArrayList<Respuesta> respuestas);
}