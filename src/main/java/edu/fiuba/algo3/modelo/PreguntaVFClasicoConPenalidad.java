package edu.fiuba.algo3.modelo;

public class PreguntaVFClasicoConPenalidad implements Pregunta, Penalidad{
    private String enunciado;
    private Respuesta respuesta;
    private Multiplicador multiplicador;

    public PreguntaVFClasicoConPenalidad(String enunciado, Respuesta respuesta) {
        this.respuesta = respuesta;
        this.enunciado = enunciado;
        this.multiplicador = null;
    }

    @Override
    public int validarRespuesta(Respuesta respuestaJugador) {
        if (respuesta.validarRespuesta(respuestaJugador)){
            return 1;
        }
        return -1;
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
