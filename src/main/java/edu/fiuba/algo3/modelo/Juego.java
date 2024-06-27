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
    private static Ronda ronda;
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
            crearRonda();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearPreguntas() throws IOException, ParseException {
        CreadorDePreguntas creadorDePreguntas = new CreadorDePreguntas();
        preguntas = creadorDePreguntas.leerArchivo();
        setearPreguntaActual();
    }

    public void crearRonda(){
        Ronda ronda = obtenerRonda(); // obtengo instancia unica
        for (Jugador jugador : jugadores) {
            ronda.agregarJugador(jugador);
        }
        for (Pregunta pregunta : preguntas) {
            ronda.agregarPreguntas(pregunta);
        }
    }

    public static Ronda obtenerRonda() {
        if (ronda == null) {
            ronda = new Ronda();
        }
        return ronda;
    }

    public void setearPreguntaActual() {
        Pregunta preguntaNueva;
        if(preguntaActual == null) {
            preguntaNueva = preguntas.get(2);
        }
        else {
            preguntaNueva = preguntas.stream().filter(pregunta -> !pregunta.getTema().equals(preguntaActual.getTema())).findFirst().get();
            System.out.println(preguntaNueva);
        }
        preguntas.remove(preguntaActual);
        preguntaActual = preguntaNueva;
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
