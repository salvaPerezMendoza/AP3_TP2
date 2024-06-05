package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Flujo {
    ArrayList<Jugador> jugadores;
    Pregunta preguntaActual;
    ArrayList<String> respuestasPreguntaActual;

    public Flujo() {
        this.jugadores = new ArrayList<>();
        this.respuestasPreguntaActual = new ArrayList<>();
    }

    public void setPreguntaActual(Pregunta preguntaActual) {
        this.preguntaActual = preguntaActual;
    }

    public void agregarJugador(Jugador jugador){
        this.jugadores.add(jugador);
    }

    public void agregarRespuesta(String respuestaJugador){
        respuestasPreguntaActual.add(respuestaJugador);
    }

    public void devolverPuntajes(){
        int puntajePregunta;
        for(int i = 0; i < jugadores.size(); i++){
            Jugador jugador = jugadores.get(i);
            String respuestaJugador = respuestasPreguntaActual.get(i);
            puntajePregunta = preguntaActual.validarRespuesta(respuestaJugador);
            jugador.sumarPuntos(puntajePregunta);
        }
    }
}
