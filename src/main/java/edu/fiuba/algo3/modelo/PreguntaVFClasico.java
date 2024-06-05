package edu.fiuba.algo3.modelo;


public class PreguntaVFClasico implements Pregunta {
    private String enunciado;
    private String respuesta;

    public PreguntaVFClasico(String enunciado, String respuesta) {
        this.enunciado = enunciado;
        this.respuesta = respuesta;
    }


    @Override
    public int validarRespuesta(String respuestaJugador) {
        if (respuesta.equals(respuestaJugador)){
            return 1;
        }
        return 0;
    }
}
