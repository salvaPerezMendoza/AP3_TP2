package edu.fiuba.algo3.modelo;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Juego implements Observable {
    private List<Jugador> jugadores;
    private List<Pregunta> preguntas;
    private Pregunta preguntaActual;
    private int turnoActual;
    private int limiteRondas;
    private int puntajeGanador;
    private List<Observer> observers;
    public Juego() {
        this.jugadores = new ArrayList<>();
        this.preguntas = new ArrayList<>();
        this.preguntaActual = null;
        this.turnoActual = 0;
        this.limiteRondas = 0;
        this.puntajeGanador = 0;
        this.observers = new ArrayList<>();
    }

    public void iniciarJuego(int cantidadRondas, int puntajeGanador){
        try {
            crearPreguntas();
            limiteRondas = cantidadRondas;
            this.puntajeGanador = puntajeGanador;
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
        Random rand = new Random();
        Pregunta preguntaNueva;
        System.out.println("caca");
        System.out.println(hayGanador());
        if (hayGanador()) {
            terminarJuego();
            return;
        }
        if(preguntaActual == null) {
            preguntaNueva = preguntas.get(0);
        }
        else {
            do {
                int randomIndex = rand.nextInt(preguntas.size());
                preguntaNueva = preguntas.get(randomIndex);
            } while (preguntaNueva.getTema().equals(preguntaActual.getTema()));
        }
        preguntas.remove(preguntaActual);
        preguntaActual = preguntaNueva;
    }

    public Jugador devolverGanador() {
        Jugador ganador = jugadores.get(0);
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntajeTotal() > ganador.getPuntajeTotal()) {
                ganador = jugador;
            }
        }

        return ganador;
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

    private boolean hayGanador() {
        for (Jugador jugador : jugadores) {
            System.out.println("puntaje ganador");
            System.out.println(puntajeGanador);
            if (jugador.getPuntajeTotal() >= 3) {
                return true;
            }
        }
        return false;
    }
    public void terminarJuego() {
        System.out.println("Termino juego");
        notifyObservers(devolverGanador());
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(Object arg) {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
