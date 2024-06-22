package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionGrupo;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.Penalidad.ConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;
import edu.fiuba.algo3.modelo.TipoDePregunta.*;
import edu.fiuba.algo3.modelo.bonificador.AnuladorPuntajeDecorador;
import edu.fiuba.algo3.modelo.bonificador.Bonificador;
import java.util.HashSet;
import edu.fiuba.algo3.modelo.bonificador.BonificadorConcreto;

import edu.fiuba.algo3.modelo.bonificador.MultiplicadorX2Decorador;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadoresTest {

    @Test
    public void test01jugador1AplicaMultiplicadorYRecibePuntosX2() {
        //Bob aplicara el anulador y a Alice no le contara los puntos por mas de que respondio correctamente
        Jugador jugador1 = new Jugador("Bob");
        Jugador jugador2 = new Jugador("Alice");

        TipoDePregunta consigna = new VerdaderoFalso(new OpcionSimple("V"));
        Penalidad penalidad = new SinPenalidad();

        Pregunta pregunta1 = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?",new BonificadorConcreto());
        Pregunta pregunta2 = new Pregunta(consigna, penalidad, "Messi es el GOAT?",new BonificadorConcreto());
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion(new OpcionSimple("V"));

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion(new OpcionSimple("V"));

        jugador1.responder(pregunta1, respuestaJugador1);
        jugador2.responder(pregunta2, respuestaJugador2);

        Ronda ronda = new Ronda();
        ronda.agregarJugador(jugador1);
        ronda.agregarJugador(jugador2);

        ronda.agregarPreguntas(pregunta1);
        ronda.agregarPreguntas(pregunta2);

        ronda.usarMultiplicadorX2(jugador1);
        ronda.terminarRonda();

        assertEquals(2, jugador1.getPuntajeTotal());
        assertEquals(1, jugador2.getPuntajeTotal());
    }
    @Test
    public void test02jugador1AplicaMultiplicadorX2PeroYaNoTieneYRecibePuntosSinEfectos() {
        //Bob aplicara el anulador y a Alice no le contara los puntos por mas de que respondio correctamente
        Jugador jugador1 = new Jugador("Bob");
        Jugador jugador2 = new Jugador("Alice");

        TipoDePregunta consigna = new VerdaderoFalso(new OpcionSimple("V"));
        Penalidad penalidad = new SinPenalidad();

        Pregunta pregunta1 = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?",new BonificadorConcreto());
        Pregunta pregunta2 = new Pregunta(consigna, penalidad, "Messi es el GOAT?",new BonificadorConcreto());
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion(new OpcionSimple("V"));

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion(new OpcionSimple("V"));

        jugador1.responder(pregunta1, respuestaJugador1);
        jugador2.responder(pregunta2, respuestaJugador2);

        //la falsa ronda se crea para gastar todos los MultiplicadoresX2
        Ronda falsaRonda = new Ronda();
        falsaRonda.agregarJugador(jugador1);
        falsaRonda.usarMultiplicadorX2(jugador1);
        falsaRonda.usarMultiplicadorX2(jugador1);

        Ronda ronda = new Ronda();
        ronda.agregarJugador(jugador1);
        ronda.agregarJugador(jugador2);

        ronda.agregarPreguntas(pregunta1);
        ronda.agregarPreguntas(pregunta2);

        ronda.usarMultiplicadorX2(jugador1);
        ronda.terminarRonda();

        assertEquals(1, jugador1.getPuntajeTotal());
        assertEquals(1, jugador2.getPuntajeTotal());
    }





}



