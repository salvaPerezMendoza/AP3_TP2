package edu.fiuba.algo3.modelo;

public class Jugador {
    private String nombre;
    private int puntajeTotal;
    private boolean anuladorUsado;

    public Jugador(String nombreJugador) {
        nombre = nombreJugador;
        this.anuladorUsado = false;
    }

    public void responder(Pregunta pregunta, Respuesta respuestaJugador) {
        pregunta.validarRespuesta(respuestaJugador);
    }

    public void sumarPuntos(int puntaje) {
        puntajeTotal += puntaje;
    }

    public int getPuntaje() {
        return puntajeTotal;
    }

    public boolean haUsadoAnulador() {
        return anuladorUsado;
    }

    public void usarAnulador() {
        this.anuladorUsado = true;
    }
}
