package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVFClasicoConPenalidad implements Pregunta, Penalidad{
    private String enunciado;
    private Respuesta respuesta;
    private Multiplicador multiplicador;

    public PreguntaVFClasicoConPenalidad(String enunciado, Respuesta respuesta) {
        this.respuesta = respuesta;
        this.enunciado = enunciado;
        this.multiplicador = null;
    }

    @Override
    public void validarRespuesta(Respuesta respuestaJugador) {
        if (respuesta.validarRespuesta(respuestaJugador)){
            respuestaJugador.getJugador().sumarPuntos(1);
        }else {
            respuestaJugador.getJugador().sumarPuntos(-1);
        }
    }

    @Override
    public void validarRespuestas(ArrayList<Respuesta> respuestas) {
        for(Respuesta respuestaJugador: respuestas){
            validarRespuesta(respuestaJugador);
        }
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
