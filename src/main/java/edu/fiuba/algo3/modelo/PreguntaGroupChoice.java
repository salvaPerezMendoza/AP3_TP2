package edu.fiuba.algo3.modelo;

public class PreguntaGroupChoice implements Pregunta{
    private String enunciado;
    private RespuestaGroupChoice respuestaCorrecta;

    public PreguntaGroupChoice(String enunciado, RespuestaGroupChoice respuestaCorrecta){
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
