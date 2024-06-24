package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bonificadores.Bonificador;

import java.util.ArrayList;
import java.util.HashMap;

public class Ronda {
    private ArrayList<Pregunta> preguntas;
    private ArrayList<Jugador> jugadores;
    private HashMap<Jugador, ArrayList<String>> bonificadores; //Se usa un hashmap para manterner la referencia al jugador
    private int contadorExclusividad;
    public Ronda() {
        this.preguntas = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.bonificadores = new HashMap<>();
        this.contadorExclusividad = 0;
    }

    public void agregarPreguntas(Pregunta pregunta) {
        preguntas.add(pregunta);
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void incrementarContadorExclusividad() {
        this.contadorExclusividad++;
    }
    private void aplicarExclusividad() {
        for (int i = 0; i < contadorExclusividad; i++) {
            int cantidadIncorrectas = 0;
            for (Pregunta pregunta : preguntas) {
                if (!pregunta.ningunaIncorrecta()) {
                    cantidadIncorrectas++;
                }
            }
            // Si un solo jugador respondio bien se le aplica un "multiplicadorX2 exclusivo"
            if (jugadores.size() - cantidadIncorrectas == 1) {
                for (Jugador jugador : jugadores) {
                    for (Pregunta pregunta : preguntas) {
                        pregunta.agregarBonificador(jugador, "MultiplicadorX2");
                    }
                }
            }
        }
    }
    private void aplicarBonificadores(){
        for (HashMap.Entry<Jugador, ArrayList<String>> entry : bonificadores.entrySet()) {
            Jugador jugador = entry.getKey();
            ArrayList<String> bonificadores = entry.getValue();
            for (String bonificador : bonificadores) {
                for (Pregunta pregunta: preguntas) {
                    pregunta.agregarBonificador(jugador, bonificador);
                }
            }
        }
    }
    public void agregarBonificador(Jugador jugador,String bonificador){
        // Verificar si el jugador ya tiene una lista de bonificadores
        if (!bonificadores.containsKey(jugador)) {
            // Si no, crear una nueva lista de bonificadores
            bonificadores.put(jugador, new ArrayList<String>());
        }
        // Agregar el bonificador a la lista del jugador
        bonificadores.get(jugador).add(bonificador);
    }
    public void terminarRonda() {
        //Aplico bonificadores a cada jugador al terminar la ronda
        this.aplicarBonificadores();
        //Aplico exclusividad si es que la hay
        this.aplicarExclusividad();
        // Asigno los puntajes correspondientes
        for (Pregunta pregunta : preguntas) {
            // Suponiendo que Pregunta tiene un método evaluarRespuesta que actualiza el puntaje del jugador
            pregunta.validarRespuestas();
        }
    }

}
