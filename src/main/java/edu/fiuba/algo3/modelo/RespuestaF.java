package edu.fiuba.algo3.modelo;

public class RespuestaF implements Respuesta{
    private boolean respuesta;

    public RespuestaF() {
        this.respuesta = false;
    }
    @Override
    public boolean validarRespuesta(Respuesta respuestaJugador) {
        if(respuestaJugador instanceof RespuestaF){
            return true;
        }
        return false;
    }
}
