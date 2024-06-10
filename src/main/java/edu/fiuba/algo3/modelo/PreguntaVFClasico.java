package edu.fiuba.algo3.modelo;


public class PreguntaVFClasico implements Pregunta {
    private String enunciado;
    private Respuesta respuesta;
    private Multiplicador multiplicador;

    public PreguntaVFClasico(String enunciado, Respuesta respuesta) {
        this.enunciado = enunciado;
        this.respuesta = respuesta;
        this.multiplicador = null;
    }


    @Override
    public int validarRespuesta(Respuesta respuestaJugador) {
        if (respuesta.validarRespuesta(respuestaJugador)){
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
