package edu.fiuba.algo3.modelo;

public class Jugador {
    private String nombre;
    private int puntajeTotal;
    private int usoMultiplicador;
    private int usoExclusividad;

    public Jugador(String nombreJugador) {
        this.nombre = nombreJugador;
        this.puntajeTotal = 0;
        this.usoMultiplicador = 2;
        this.usoExclusividad = 2;
    }

    public void responder(Pregunta pregunta, Respuesta respuestaJugador) {
        pregunta.agregarRespuesta(respuestaJugador);
    }

    public void sumarPuntos(int puntaje) {
        puntajeTotal += puntaje;
    }

    public int getPuntajeTotal(){
        return puntajeTotal;
    }

    public boolean usarMultiplicador(){
        if(usoMultiplicador == 0){
            return false;
        }
        usoMultiplicador--;
        return true;
    }

    public boolean usarExclusividad(){
        if(usoExclusividad == 0){
            return false;
        }
        usoExclusividad--;
        return true;
    }
}
