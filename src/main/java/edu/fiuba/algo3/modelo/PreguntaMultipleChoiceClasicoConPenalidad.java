package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaMultipleChoiceClasicoConPenalidad implements Pregunta, Penalidad {
    private String enunciado;
    private Respuesta respuestas;
    private ArrayList<Opcion> opciones;
    private Multiplicador multiplicador;

    public PreguntaMultipleChoiceClasicoConPenalidad(Respuesta respuestas, String enunciado, ArrayList<Opcion> opciones) {
        this.respuestas = respuestas;
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.multiplicador = null;
    }
    @Override
    public void validarRespuesta(Respuesta respuestaJugador) {
        if(respuestas.validarRespuesta(respuestaJugador)){
            respuestaJugador.getJugador().sumarPuntos(1);
        }else {
            respuestaJugador.getJugador().sumarPuntos(-1);
        }
    }

    @Override
    public void validarRespuestas(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            validarRespuesta(respuesta);
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
