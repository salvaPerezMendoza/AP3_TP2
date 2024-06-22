package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bonificador.AnuladorPuntajeDecorador;
import edu.fiuba.algo3.modelo.bonificador.Bonificador;
import edu.fiuba.algo3.modelo.bonificador.BonificadorConcreto;

import java.util.ArrayList;

public class Ronda {
    private ArrayList<Pregunta> preguntas;
    private ArrayList<Jugador> jugadores;
    private boolean seUsoExclusividad;
    public Ronda() {
        this.preguntas = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.seUsoExclusividad = false;
    }

    public void agregarPreguntas(Pregunta pregunta) {
        preguntas.add(pregunta);
    }
    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }
    public void usarAnulador(Jugador jugadorQueUsoAnulador) {
        for (Pregunta pregunta : preguntas) {
            pregunta.aplicarAnulador(jugadorQueUsoAnulador);
        }
    }
    public void usarExclusividad(){
        this.seUsoExclusividad = true;
    }
    private void aplicarExclusividad() {
        int cantidadIncorrectas = 0;
        for (Pregunta pregunta : preguntas) {
            if (!pregunta.ningunaIncorrecta()){
                cantidadIncorrectas += 1;
            }
        }
        //Si un solo jugador respondio bien se le aplicara un "multiplicadorX2 exclusivo"
        if (jugadores.size() - cantidadIncorrectas == 1){
            for (Jugador jugador: jugadores){
                for (Pregunta pregunta: preguntas) {
                    pregunta.aplicarMultiplicadorX2(jugador);
                }

            }
        }
    }
    public void terminarRonda() {
        //Aplico exclusividad si se activo en esta ronda
        if (seUsoExclusividad) {
            this.aplicarExclusividad();
        }
        // Evaluar respuestas con sus bonificadores
        for (Pregunta pregunta : preguntas) {
                // Suponiendo que Pregunta tiene un método evaluarRespuesta que actualiza el puntaje del jugador
                pregunta.validarRespuestas();
            }
        }

}
