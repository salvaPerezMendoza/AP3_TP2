package edu.fiuba.algo3.modelo;

public class RespuestaPuntuada {
    private Jugador jugador;
    private int cantidadRespuestasCorrectas;
    private int puntos;

    public RespuestaPuntuada(Jugador jugador, int puntos) {
        this.jugador = jugador;
        this.puntos = puntos;
        this.cantidadRespuestasCorrectas = 0;
    }

    public RespuestaPuntuada(Jugador jugador, int puntos, int cantidadRespuestasCorrectas) {
        this.jugador = jugador;
        this.puntos = puntos;
        this.cantidadRespuestasCorrectas = cantidadRespuestasCorrectas;
    }

    public void setCantidadRespuestasCorrectas(int cantidadRespuestasCorrectas) {
        this.cantidadRespuestasCorrectas = cantidadRespuestasCorrectas;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getCantidadRespuestasCorrectas(){
        return cantidadRespuestasCorrectas;
    }

    public boolean esCorrecta(){
        return puntos > 0;
    }

    public void asignarPuntos() {
        jugador.sumarPuntos(puntos);
    }
}
