package edu.fiuba.algo3.modelo;

public class RespuestaV implements Respuesta {
    private boolean respuesta;
    private Jugador jugador;

    public RespuestaV(Jugador jugador) {
        this.respuesta = true;
        this.jugador = jugador;
    }

    public RespuestaV() {
        this.respuesta = true;
    }

    @Override
    public Jugador getJugador() {
        return jugador;
    }

    @Override
    public boolean validarRespuesta(Respuesta respuestaJugador) {
        if(respuestaJugador instanceof RespuestaV){
            return true;
        }
        return false;
    }
}
