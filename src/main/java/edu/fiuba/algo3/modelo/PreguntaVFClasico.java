package edu.fiuba.algo3.modelo;


public class PreguntaVFClasico implements Pregunta {
    private String enunciado;
    private Respuesta respuesta;

    public PreguntaVFClasico(String enunciado, Respuesta respuesta) {
        this.enunciado = enunciado;
        this.respuesta = respuesta;
    }


    @Override
    public int validarRespuesta(Respuesta respuestaJugador) {
        if (respuesta.validarRespuesta(respuestaJugador)){
            return 1;
        }
        return 0;
    }
}
