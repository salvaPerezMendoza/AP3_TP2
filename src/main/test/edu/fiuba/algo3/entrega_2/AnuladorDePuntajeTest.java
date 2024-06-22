package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.Penalidad.ConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.modelo.TipoDePregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
import edu.fiuba.algo3.modelo.TipoDePregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.bonificador.AnuladorDePuntaje;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnuladorDePuntajeTest {

    @Test
    public void test01AnularPuntajeDeUnJugadorQueRespondioCorrectamenteLaPreguntaVF() {
        Jugador jugador1 = new Jugador("Bob");
        Jugador jugador2 = new Jugador("Alice");

        TipoDePregunta consigna = new VerdaderoFalso(new OpcionSimple("V"));
        Penalidad penalidad = new SinPenalidad();

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?");
        Respuesta respuesta = new Respuesta(jugador1);
        Respuesta respuesta1 = new Respuesta(jugador2);

        respuesta.agregarOpcion(new OpcionSimple("V"));
        respuesta1.agregarOpcion(new OpcionSimple("V"));

        jugador1.responder(pregunta, respuesta);
        jugador2.responder(pregunta, respuesta1);

        Ronda ronda = new Ronda(pregunta);
        ronda.agregarJugador(jugador1);
        ronda.agregarJugador(jugador2);
        ronda.agregarBonificador(new AnuladorDePuntaje(jugador1));

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        respuestas.add(respuesta1);

        ronda.procesarJugada(respuestas);

        assertEquals(1, jugador1.getPuntajeTotal());
        assertEquals(0, jugador2.getPuntajeTotal());
    }

    @Test
    public void test02AnularPuntajeDeUnJugadorQueRespondioInorrectamenteLaPreguntaVF() {
        Jugador jugador1 = new Jugador("Bob");
        Jugador jugador2 = new Jugador("Alice");

        TipoDePregunta consigna = new VerdaderoFalso(new OpcionSimple("V"));
        Penalidad penalidad = new ConPenalidad();

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?");
        Respuesta respuesta = new Respuesta(jugador1);
        Respuesta respuesta1 = new Respuesta(jugador2);

        respuesta.agregarOpcion(new OpcionSimple("F"));
        respuesta1.agregarOpcion(new OpcionSimple("F"));

        jugador1.responder(pregunta, respuesta);
        jugador2.responder(pregunta, respuesta1);

        Ronda ronda = new Ronda(pregunta);
        ronda.agregarJugador(jugador1);
        ronda.agregarJugador(jugador2);
        ronda.agregarBonificador(new AnuladorDePuntaje(jugador1));

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        respuestas.add(respuesta1);

        ronda.procesarJugada(respuestas);


        assertEquals(-1, jugador1.getPuntajeTotal());
        assertEquals(0, jugador2.getPuntajeTotal());
    }

    @Test
    public void test04AnularPuntajeDeUnJugadorQueRespondioInorrectamenteLaPreguntaOrderedChoice(){
        Jugador jugador1 = new Jugador("Bob");
        Jugador jugador2 = new Jugador("Alice");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Macri"));
        opciones.add(new OpcionSimple("Cristina"));
        opciones.add(new OpcionSimple("Alberto"));
        opciones.add(new OpcionSimple("Duhalde"));
        opciones.add(new OpcionSimple("Nestor"));


        ArrayList<OpcionSimple> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(new OpcionSimple("Alberto"));
        opcionesCorrectas.add(new OpcionSimple("Macri"));
        opcionesCorrectas.add(new OpcionSimple("Cristina"));
        opcionesCorrectas.add(new OpcionSimple("Nestor"));
        opcionesCorrectas.add(new OpcionSimple("Duhalde"));

        TipoDePregunta consigna = new OrderedChoice(opciones, opcionesCorrectas);
        Penalidad penalidad = new SinPenalidad();

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Ordenar los presidentes por anio en orden descendiente");
        Respuesta respuesta = new Respuesta(jugador1);
        Respuesta respuesta1 = new Respuesta(jugador2);

        respuesta.agregarOpcion(new OpcionSimple("Alberto"));
        respuesta.agregarOpcion(new OpcionSimple("Macri"));
        respuesta.agregarOpcion(new OpcionSimple("Cristina"));
        respuesta.agregarOpcion(new OpcionSimple("Nestor"));
        respuesta.agregarOpcion(new OpcionSimple("Duhalde"));

        respuesta1.agregarOpcion(new OpcionSimple("Alberto"));
        respuesta1.agregarOpcion(new OpcionSimple("Macri"));
        respuesta1.agregarOpcion(new OpcionSimple("Cristina"));
        respuesta1.agregarOpcion(new OpcionSimple("Nestor"));
        respuesta1.agregarOpcion(new OpcionSimple("Duhalde"));

        jugador1.responder(pregunta, respuesta);
        jugador2.responder(pregunta, respuesta1);

        Ronda ronda = new Ronda(pregunta);
        ronda.agregarJugador(jugador1);
        ronda.agregarJugador(jugador2);
        ronda.agregarBonificador(new AnuladorDePuntaje(jugador1));

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        respuestas.add(respuesta1);

        ronda.procesarJugada(respuestas);

        assertEquals(1, jugador1.getPuntajeTotal());
        assertEquals(0, jugador2.getPuntajeTotal());
    }
}