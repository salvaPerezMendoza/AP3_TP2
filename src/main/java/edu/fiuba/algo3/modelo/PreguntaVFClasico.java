package edu.fiuba.algo3.modelo;


import java.util.ArrayList;

public class PreguntaVFClasico implements Pregunta {
    private String enunciado;
    private Respuesta respuesta;

    public PreguntaVFClasico(String enunciado, Respuesta respuesta) {
        this.enunciado = enunciado;
        this.respuesta = respuesta;
    }


    @Override
    public void validarRespuesta(Respuesta respuestaJugador) {
        if(respuesta.validarRespuesta(respuestaJugador)){
            respuesta.getJugador().sumarPuntos(1);
        }
    }

    @Override
    public void validarRespuestas(ArrayList<Respuesta> respuestas) {
        for(Respuesta respuestaJugador: respuestas){
            validarRespuesta(respuestaJugador);
        }
    }

}
