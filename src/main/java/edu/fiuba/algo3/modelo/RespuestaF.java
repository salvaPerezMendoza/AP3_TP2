package edu.fiuba.algo3.modelo;

public class RespuestaF implements Respuesta{
    private boolean respuesta;
    private Jugador jugador;

    public RespuestaF(Jugador jugador) {
        this.respuesta = false;
        this.jugador = jugador;
    }

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

    @Override
    public Jugador getJugador() {
        return jugador;
    }
}
