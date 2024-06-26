package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bonificadores.Bonificador;

import java.util.ArrayList;
import java.util.HashMap;

public class Ronda {
    private ArrayList<Pregunta> preguntas;
    private ArrayList<Jugador> jugadores;
    private HashMap<Jugador, ArrayList<Bonificador>> bonificadores; //Se usa un hashmap para mantener la refernecia al jugador

    public Ronda() {
        this.preguntas = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.bonificadores = new HashMap<>();
    }

    public void agregarPreguntas(Pregunta pregunta) {
        preguntas.add(pregunta);
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public ArrayList<Jugador> getJugadores(){return this.jugadores;}

    public ArrayList<Pregunta> getPreguntas(){return this.preguntas;}

    public void agregarBonificador(Jugador jugador,Bonificador bonificador){
        // Verificar si el jugador ya tiene una lista de bonificadores
        if (!bonificadores.containsKey(jugador)) {
            // Si no, crear una nueva lista de bonificadores
            bonificadores.put(jugador, new ArrayList<Bonificador>());
        }
        // Agregar el bonificador a la lista del jugador
        bonificadores.get(jugador).add(bonificador);
    }

    public void terminarRonda() {
        //Aplico bonificadores a cada jugador al terminar la ronda
        this.aplicarBonificadores();

        // Asigno los puntajes correspondientes
        for (Pregunta pregunta : preguntas) {
            // Suponiendo que Pregunta tiene un método evaluarRespuesta que actualiza el puntaje del jugador
            pregunta.validarRespuestas();
        }
    }

    private void aplicarBonificadores(){
        for (HashMap.Entry<Jugador, ArrayList<Bonificador>> entry : bonificadores.entrySet()) {
            Jugador jugador = entry.getKey();
            ArrayList<Bonificador> bonificadores = entry.getValue();
            for (Bonificador bonificador : bonificadores) {
                for (Pregunta pregunta: preguntas) {
                    pregunta.agregarBonificador(jugador, bonificador);
                }
            }
        }
    }

}
