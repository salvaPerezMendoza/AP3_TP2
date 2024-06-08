package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PreguntaMultipleChoiceClasicoConPenalidad implements Pregunta{
    private String enunciado;
    private Respuesta respuestas;
    private ArrayList<String> opciones;

    public PreguntaMultipleChoiceClasicoConPenalidad(Respuesta respuestas, String enunciado, ArrayList<String> opciones) {
        this.respuestas = respuestas;
        this.enunciado = enunciado;
        this.opciones = opciones;
    }
    @Override
    public int validarRespuesta(Respuesta respuestaJugador) {
        if(respuestas.validarRespuesta(respuestaJugador)){
            return 1;
        }
        return -1;
    }
}