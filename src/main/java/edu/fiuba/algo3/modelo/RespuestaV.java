package edu.fiuba.algo3.modelo;

public class RespuestaV implements Respuesta {
    private boolean respuesta;

    public RespuestaV() {
        this.respuesta = true;
    }
    @Override
    public boolean validarRespuesta(Respuesta respuestaJugador) {
        if(respuestaJugador instanceof RespuestaV){
            return true;
        }
        return false;
    }
}
