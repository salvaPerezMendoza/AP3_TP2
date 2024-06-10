package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PreguntaMultipleChoiceClasico implements Pregunta{
        private String enunciado;
        private Respuesta respuestas;
        private ArrayList<String> opciones;
        private Multiplicador multiplicador;

    public PreguntaMultipleChoiceClasico(Respuesta respuestas, String enunciado, ArrayList<String> opciones) {
        this.respuestas = respuestas;
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.multiplicador = null;
    }

    @Override
    public int validarRespuesta(Respuesta respuestaJugador) {
        if(respuestas.validarRespuesta(respuestaJugador)){
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
