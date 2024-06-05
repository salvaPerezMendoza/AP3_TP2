package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PreguntaMultipleChoiceClasico implements Pregunta{
        private String enunciado;
        private ArrayList<String> respuestas;
        private ArrayList<String> opciones;

    public PreguntaMultipleChoiceClasico(ArrayList<String> respuestas, String enunciado, ArrayList<String> opciones) {
        this.respuestas = respuestas;
        this.enunciado = enunciado;
        this.opciones = opciones;
    }

    @Override
    public int validarRespuesta(String respuestaJugador) {
        if(respuestaJugador.equals(respuestas.stream().collect(Collectors.joining(",")))){
            return 1;
        }
        return 0;
    }
}
