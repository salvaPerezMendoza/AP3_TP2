package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
import edu.fiuba.algo3.modelo.TipoDePregunta.VerdaderoFalso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Flujo {
    public TipoDePregunta queTipoDePreguntaToca;
    private List<Jugador> jugadores;
    private int turnoActual;
    private int idDePregunta;
    private List<Pregunta> preguntas;
    private Pregunta preguntaActual;

    CreadorDePreguntas creadorDePreguntas = new CreadorDePreguntas();

    public Flujo() {
        this.jugadores = new ArrayList<>();
        this.turnoActual = 0;
        this.idDePregunta = 0;
        this.preguntas = creadorDePreguntas.leerArchivo();
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

    public int getIDDePregunta() {
        siguientePregunta();
        return idDePregunta;
    }

    public void siguienteTurno() {
        turnoActual = (turnoActual + 1) % jugadores.size();
    }

    public void siguientePregunta(){
        if (turnoActual == 0) {
            Random random = new Random();
            int randomNumber = random.nextInt(27) + 1;
            idDePregunta = randomNumber;
            System.out.println(idDePregunta);
        }
        siguienteTurno();
    }

    public TipoDePregunta queTipoDePreguntaToca(){
        preguntaActual = preguntas.get(idDePregunta);
        return preguntaActual.getTipo();
    }
}
