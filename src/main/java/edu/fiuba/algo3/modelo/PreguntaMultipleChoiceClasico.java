package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PreguntaMultipleChoiceClasico implements Pregunta{
        private String enunciado;
        private Respuesta respuestas;
        private ArrayList<Opcion> opciones;

    public PreguntaMultipleChoiceClasico(Respuesta respuestas, String enunciado, ArrayList<Opcion> opciones) {
        this.respuestas = respuestas;
        this.enunciado = enunciado;
        this.opciones = opciones;
    }

    @Override
    public void validarRespuesta(Respuesta respuestaJugador) {
        if(respuestas.validarRespuesta(respuestaJugador)){
            respuestaJugador.getJugador().sumarPuntos(1);
        }
    }

    @Override
    public void validarRespuestas(ArrayList<Respuesta> respuestas) {
        for(Respuesta respuesta : respuestas){
            validarRespuesta(respuesta);
        }
    }
}
