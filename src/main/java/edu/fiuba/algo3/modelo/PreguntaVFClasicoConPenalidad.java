package edu.fiuba.algo3.modelo;

public class PreguntaVFClasicoConPenalidad implements Pregunta{
    private String enunciado;
    private Respuesta respuesta;

    public PreguntaVFClasicoConPenalidad(String enunciado, Respuesta respuesta) {
        this.respuesta = respuesta;
        this.enunciado = enunciado;
    }

    @Override
    public int validarRespuesta(Respuesta respuestaJugador) {
        if (respuesta.validarRespuesta(respuestaJugador)){
            return 1;
        }
        return -1;
    }
}
