package edu.fiuba.algo3.modelo;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Flujo {
    private List<Jugador> jugadores;
    private List<Pregunta> preguntas;
    private Pregunta preguntaActual;
    private int turnoActual;

    public Flujo() {
        this.jugadores = new ArrayList<>();
        this.preguntas = new ArrayList<>();
        this.preguntaActual = null;
        this.turnoActual = 0;
    }

    public void crearPreguntas() throws IOException, ParseException {
        CreadorDePreguntas creadorDePreguntas = new CreadorDePreguntas();
        preguntas = creadorDePreguntas.leerArchivo();
        preguntaActual = setearPreguntaActual();
    }

    private Pregunta setearPreguntaActual() {
        if(preguntaActual == null) {
            return preguntas.get(0);
        }
        return preguntas.stream().filter(pregunta -> pregunta.getTema().equals(preguntaActual.getTema())).findFirst().get();
    }

    public Pregunta getPreguntaActual() {
        return preguntaActual;
    }

    public List<String> getJugadoresNombres() {
        return jugadores.stream()
                .map(Jugador::getNombre)
                .collect(Collectors.toList());
    }


    public void agregarJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public List<Jugador> devolverJugadores() {
        return jugadores;
    }

    public Jugador getJugadorActual() {
        return jugadores.get(turnoActual);
    }

    public void siguienteTurno() {
        turnoActual = (turnoActual + 1) % jugadores.size();
    }
}
