package edu.fiuba.algo3.modelo;

public class PreguntaOrderedChoice implements Pregunta {
    String enunciado;
    Respuesta respuestaCorrecta;
    private Multiplicador multiplicador;

    public PreguntaOrderedChoice(String enunciado, Respuesta respuestaCorrecta){
        this.enunciado = enunciado;
        this.respuestaCorrecta = respuestaCorrecta;
        this.multiplicador = null;
    }

    @Override
    public int validarRespuesta(Respuesta respuestaJugador) {
        if (respuestaCorrecta.validarRespuesta(respuestaJugador)){
            return 1;
        }
        return 0;
    }

    @Override
    public void setMultiplicador(Multiplicador multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public int aplicarMultiplicador(int puntaje) {
        if (multiplicador != null) {
            return multiplicador.aplicarMultiplicador(puntaje);
        }
        return puntaje;
    }
}
