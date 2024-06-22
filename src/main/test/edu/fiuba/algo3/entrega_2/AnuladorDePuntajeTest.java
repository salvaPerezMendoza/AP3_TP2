package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.Penalidad.ConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;
import edu.fiuba.algo3.modelo.TipoDePregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
import edu.fiuba.algo3.modelo.TipoDePregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.bonificador.AnuladorPuntajeDecorador;
import edu.fiuba.algo3.modelo.bonificador.Bonificador;
import edu.fiuba.algo3.modelo.bonificador.BonificadorConcreto;
import edu.fiuba.algo3.modelo.bonificador.MultiplicadorX2Decorador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnuladorDePuntajeTest {

    @Test
    public void test01AnularPuntajeDeUnJugadorQueRespondioCorrectamenteLaPreguntaVF() {
        Jugador jugador1 = new Jugador("Bob");

        TipoDePregunta consigna = new VerdaderoFalso(new OpcionSimple("V"));
        Penalidad penalidad = new SinPenalidad();
        Bonificador bonificador = new AnuladorPuntajeDecorador(new BonificadorConcreto());

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?", bonificador);
        Respuesta respuesta = new Respuesta(jugador1);

        respuesta.agregarOpcion(new OpcionSimple("V"));

        jugador1.responder(pregunta, respuesta);

        pregunta.validarRespuestas();

        assertEquals(0, jugador1.getPuntajeTotal());
    }
    @Test
    public void test02AnularPuntajeDeUnJugadorQueRespondioInorrectamenteLaPreguntaVF() {
        Jugador jugador1 = new Jugador("Bob");

        TipoDePregunta consigna = new VerdaderoFalso(new OpcionSimple("V"));
        Penalidad penalidad = new ConPenalidad();
        Bonificador bonificador = new AnuladorPuntajeDecorador(new BonificadorConcreto());

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?", bonificador);
        Respuesta respuesta = new Respuesta(jugador1);

        respuesta.agregarOpcion(new OpcionSimple("F"));

        jugador1.responder(pregunta, respuesta);

        pregunta.validarRespuestas();

        assertEquals(0, jugador1.getPuntajeTotal());
    }
    @Test
    public void test04AnularPuntajeDeUnJugadorQueRespondioInorrectamenteLaPreguntaOrderedChoice(){
        Jugador jugador1 = new Jugador("Bob");
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

        Bonificador bonificador = new AnuladorPuntajeDecorador(new BonificadorConcreto());

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Ordenar los presidentes por anio en orden descendiente", bonificador);
        Respuesta respuesta = new Respuesta(jugador1);

        respuesta.agregarOpcion(new OpcionSimple("Alberto"));
        respuesta.agregarOpcion(new OpcionSimple("Macri"));
        respuesta.agregarOpcion(new OpcionSimple("Cristina"));
        respuesta.agregarOpcion(new OpcionSimple("Nestor"));
        respuesta.agregarOpcion(new OpcionSimple("Duhalde"));

        jugador1.responder(pregunta, respuesta);

        pregunta.validarRespuestas();

        assertEquals(0, jugador1.getPuntajeTotal());
    }
    @Test
    public void test05AnularPuntajeDelRivalParaElJugadorQueAplicoAnularPuntaje() {
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

        ronda.usarAnulador(jugador1);
        ronda.terminarRonda();

        assertEquals(1, jugador1.getPuntajeTotal());
        assertEquals(0, jugador2.getPuntajeTotal());
    }
}