package edu.fiuba.algo3.modelo;

public class PreguntaOrderedChoice implements Pregunta {
    String enunciado;
    Respuesta respuestaCorrecta;

    public PreguntaOrderedChoice(String enunciado, Respuesta respuestaCorrecta){
        this.enunciado = enunciado;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public int validarRespuesta(Respuesta respuestaJugador) {
        if (respuestaCorrecta.validarRespuesta(respuestaJugador)){
            return 1;
        }
        return 0;
    }
}
