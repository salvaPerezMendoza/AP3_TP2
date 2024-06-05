package edu.fiuba.algo3.modelo;

public class PreguntaVFClasicoConPenalidad implements Pregunta{
    private String enunciado;
    private String respuesta;

    public PreguntaVFClasicoConPenalidad(String enunciado, String respuesta) {
        this.respuesta = respuesta;
        this.enunciado = enunciado;
    }

    @Override
    public int validarRespuesta(String respuestaJugador) {
        if (respuesta.equals(respuestaJugador)){
            return 1;
        }
        return -1;
    }
}
