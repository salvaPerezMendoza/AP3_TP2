package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
import edu.fiuba.algo3.modelo.TipoDePregunta.VerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadPuntajeTest {
    @Test
    public void test01Jugador1AplicaExclusividadALaRondaParaPreguntaVFSinPenalidad() {
        //Bob aplicara el anulador y a Alice no le contara los puntos por mas de que respondio correctamente
        Jugador jugador1 = new Jugador("Bob");
        Jugador jugador2 = new Jugador("Alice");

        ArrayList<OpcionSimple> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Verdadero", 1));
        opciones.add(new OpcionSimple("Falso", 2));
        TipoDePregunta consigna = new VerdaderoFalso(opciones, new OpcionSimple("Verdadero", 1));
        Penalidad penalidad = new SinPenalidad();

        Pregunta pregunta1 = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?","deporte");
        Pregunta pregunta2 = new Pregunta(consigna, penalidad, "Messi es el GOAT?","deporte");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion(new OpcionSimple("Verdadero", 1));

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion(new OpcionSimple("Falso", 2));

        jugador1.responder(pregunta1, respuestaJugador1);
        jugador2.responder(pregunta2, respuestaJugador2);

        Ronda ronda = Juego.obtenerRonda();
        ronda.agregarJugador(jugador1);
        ronda.agregarJugador(jugador2);

        ronda.agregarPreguntas(pregunta1);
        ronda.agregarPreguntas(pregunta2);

        jugador1.usarExclusividad(ronda);
        ronda.terminarRonda();

        assertEquals(2, jugador1.getPuntajeTotal());
        assertEquals(0, jugador2.getPuntajeTotal());
    }
    @Test
    public void test02AmbosJugadoresAplicanExclusividadALaRondaYJugador2RespondeMalParaPreguntaVF() {
        //Bob aplicara el anulador y a Alice no le contara los puntos por mas de que respondio correctamente
        Jugador jugador1 = new Jugador("Bob");
        Jugador jugador2 = new Jugador("Alice");

        ArrayList<OpcionSimple> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Verdadero", 1));
        opciones.add(new OpcionSimple("Falso", 2));
        TipoDePregunta consigna = new VerdaderoFalso(opciones, new OpcionSimple("Verdadero", 1));
        Penalidad penalidad = new SinPenalidad();

        Pregunta pregunta1 = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?","deporte");
        Pregunta pregunta2 = new Pregunta(consigna, penalidad, "Messi es el GOAT?","deporte");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion(new OpcionSimple("Verdadero", 1));

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion(new OpcionSimple("Falso", 2));

        jugador1.responder(pregunta1, respuestaJugador1);
        jugador2.responder(pregunta2, respuestaJugador2);

        Ronda ronda = Juego.obtenerRonda();
        ronda.agregarJugador(jugador1);
        ronda.agregarJugador(jugador2);

        ronda.agregarPreguntas(pregunta1);
        ronda.agregarPreguntas(pregunta2);

        jugador1.usarExclusividad(ronda);
        jugador2.usarExclusividad(ronda);
        ronda.terminarRonda();

        assertEquals(4, jugador1.getPuntajeTotal());
        assertEquals(0, jugador2.getPuntajeTotal());
    }
    @Test
    public void test03AmbosJugadoresAplicanExclusividadALaRondaYAmbosRespondenCorrectamentePreguntaVF() {
        //Bob aplicara el anulador y a Alice no le contara los puntos por mas de que respondio correctamente
        Jugador jugador1 = new Jugador("Bob");
        Jugador jugador2 = new Jugador("Alice");

        ArrayList<OpcionSimple> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Verdadero", 1));
        opciones.add(new OpcionSimple("Falso", 2));
        TipoDePregunta consigna = new VerdaderoFalso(opciones, new OpcionSimple("Verdadero", 1));
        Penalidad penalidad = new SinPenalidad();

        Pregunta pregunta1 = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?","deporte");
        Pregunta pregunta2 = new Pregunta(consigna, penalidad, "Messi es el GOAT?","deporte");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion(new OpcionSimple("Verdadero", 1));

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion(new OpcionSimple("Verdadero", 1));

        jugador1.responder(pregunta1, respuestaJugador1);
        jugador2.responder(pregunta2, respuestaJugador2);

        Ronda ronda = Juego.obtenerRonda();
        ronda.agregarJugador(jugador1);
        ronda.agregarJugador(jugador2);

        ronda.agregarPreguntas(pregunta1);
        ronda.agregarPreguntas(pregunta2);

        jugador1.usarExclusividad(ronda);
        jugador2.usarExclusividad(ronda);
        ronda.terminarRonda();

        assertEquals(1, jugador1.getPuntajeTotal());
        assertEquals(1, jugador2.getPuntajeTotal());
    }
}