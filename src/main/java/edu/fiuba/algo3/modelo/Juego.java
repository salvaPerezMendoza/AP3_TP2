package edu.fiuba.algo3.modelo;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Juego {
    private List<Jugador> jugadores;
    private List<Pregunta> preguntas;
    private Pregunta preguntaActual;
    private int turnoActual;

    public Juego() {
        this.jugadores = new ArrayList<>();
        this.preguntas = new ArrayList<>();
        this.preguntaActual = null;
        this.turnoActual = 0;
    }

    public void iniciarJuego(){
        try {
            crearPreguntas();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearPreguntas() throws IOException, ParseException {
        preguntas = CreadorDePreguntas.leerArchivo();
        setearPreguntaActual();
    }

    public void setearPreguntaActual() {
        Pregunta preguntaNueva;
        if(preguntaActual == null) {
            preguntaNueva = preguntas.get(0);
        }
        else {
            preguntaNueva = preguntas.parallelStream().filter(pregunta -> !pregunta.getTema().equals(preguntaActual.getTema())).findAny().get();
            System.out.println(preguntaNueva);
        }
        preguntas.remove(preguntaActual);
        preguntaActual = preguntaNueva;
    }

    public Pregunta getPreguntaActual() {
        return preguntaActual;
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
