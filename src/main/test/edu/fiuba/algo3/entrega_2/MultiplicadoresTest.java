package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.Penalidad.ConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.TipoDePregunta.*;

import edu.fiuba.algo3.modelo.bonificador.Multiplicador;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadoresTest {

    @Test
    public void test01AplicarMultiplicadorX2RespuestaCorrectaVF() {
        Jugador jugador1 = new Jugador("Bob");
        Jugador jugador2 = new Jugador("Alice");

        TipoDePregunta consigna = new VerdaderoFalso(new OpcionSimple("V"));
        Penalidad penalidad = new ConPenalidad();

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?");


        Respuesta respuesta = new Respuesta(jugador1);
        respuesta.agregarOpcion(new OpcionSimple("V"));
        Respuesta respuesta1 = new Respuesta(jugador2);
        respuesta1.agregarOpcion((new OpcionSimple("V")));

        jugador1.responder(pregunta, respuesta);
        jugador2.responder(pregunta,respuesta1);

        Ronda ronda = new Ronda(pregunta);
        ronda.agregarJugador(jugador1);
        ronda.agregarJugador(jugador2);
        ronda.agregarBonificador(new Multiplicador(2,jugador1));

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        respuestas.add(respuesta1);

        ronda.procesarJugada(respuestas);

        assertEquals(2, jugador1.getPuntajeTotal());
        assertEquals(1, jugador2.getPuntajeTotal());
    }

    @Test
    public void test02AplicarDosMultiplicadoresX2RespuestaCorrectaVF() {
        Jugador jugador1 = new Jugador("Bob");
        Jugador jugador2 = new Jugador("Alice");

        TipoDePregunta consigna = new VerdaderoFalso(new OpcionSimple("V"));
        Penalidad penalidad = new ConPenalidad();

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?");


        Respuesta respuesta = new Respuesta(jugador1);
        respuesta.agregarOpcion(new OpcionSimple("F"));
        Respuesta respuesta1 = new Respuesta(jugador2);
        respuesta1.agregarOpcion((new OpcionSimple("F")));

        jugador1.responder(pregunta, respuesta);
        jugador2.responder(pregunta,respuesta1);

        Ronda ronda = new Ronda(pregunta);
        ronda.agregarJugador(jugador1);
        ronda.agregarJugador(jugador2);
        ronda.agregarBonificador(new Multiplicador(3,jugador1));

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        respuestas.add(respuesta1);

        ronda.procesarJugada(respuestas);

        assertEquals(-3, jugador1.getPuntajeTotal());
        assertEquals(-1, jugador2.getPuntajeTotal());
    }

    @Test
    public void test03JugadorRespondeMultipleChoiceCorrectamenteYRecibePuntos() {
        Jugador jugador1 = new Jugador("Bob");
        Jugador jugador2 = new Jugador("Alice");

        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Neymar"));
        opciones.add(new OpcionSimple("Messi"));
        opciones.add(new OpcionSimple("Cristiano Ronaldo"));
        opciones.add(new OpcionSimple("Lewandowski"));

        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(new OpcionSimple("Neymar"));
        opcionesCorrectas.add(new OpcionSimple("Lewandowski"));

        TipoDePregunta consigna = new MultipleChoice(opciones, opcionesCorrectas);
        Penalidad penalidad = new ConPenalidad();

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Cual/es de estos jugadores nunca ganaron un Balon de Oro?");
        Respuesta respuesta = new Respuesta(jugador1);
        Respuesta respuesta1 = new Respuesta(jugador2);

        respuesta.agregarOpcion(new OpcionSimple("Neymar"));
        respuesta.agregarOpcion(new OpcionSimple("Lewandowski"));

        respuesta1.agregarOpcion(new OpcionSimple("Cristiano Ronaldo"));
        respuesta1.agregarOpcion(new OpcionSimple("Messi"));

        jugador1.responder(pregunta, respuesta);
        jugador2.responder(pregunta, respuesta1);

        Ronda ronda = new Ronda(pregunta);
        ronda.agregarJugador(jugador1);
        ronda.agregarJugador(jugador2);
        ronda.agregarBonificador(new Multiplicador(3,jugador1));

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        respuestas.add(respuesta1);

        ronda.procesarJugada(respuestas);

        assertEquals(6, jugador1.getPuntajeTotal());
        assertEquals(-2, jugador2.getPuntajeTotal());
    }
}



