package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Flujo {
    private ArrayList<Jugador> jugadores;
    private Pregunta preguntaActual;
    private ArrayList<Respuesta> respuestasPreguntaActual;
    private ArrayList<Multiplicador> multiplicadores; // Nueva lista para los multiplicadores

    public Flujo() {
        this.jugadores = new ArrayList<>();
        this.respuestasPreguntaActual = new ArrayList<>();
        this.multiplicadores = new ArrayList<>(); // Inicializa la lista de multiplicadores
    }

    public void setPreguntaActual(Pregunta preguntaActual) {
        this.preguntaActual = preguntaActual;
    }

    public void agregarJugador(Jugador jugador) {
        this.jugadores.add(jugador);
        this.multiplicadores.add(null); // Inicialmente, ningún multiplicador aplicado
    }

    public void agregarRespuesta(Respuesta respuestaJugador) {
        respuestasPreguntaActual.add(respuestaJugador);
    }

    public void asignarMultiplicador(int indiceJugador, Multiplicador multiplicador) {
        this.multiplicadores.set(indiceJugador, multiplicador);
    }

    public void devolverPuntajes() {
        int puntajePregunta;
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            Respuesta respuestaJugador = respuestasPreguntaActual.get(i);
            puntajePregunta = preguntaActual.validarRespuesta(respuestaJugador);

            // Aplica el multiplicador si existe
            Multiplicador multiplicador = multiplicadores.get(i);
            if (multiplicador != null) {
                puntajePregunta = multiplicador.aplicarMultiplicador(puntajePregunta);
            }

            jugador.sumarPuntos(puntajePregunta);
        }

        respuestasPreguntaActual.clear();
        for (int i = 0; i < multiplicadores.size(); i++) {
            multiplicadores.set(i, null);
        }
    }
}
