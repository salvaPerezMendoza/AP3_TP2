package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
import edu.fiuba.algo3.modelo.TipoDePregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.bonificador.Bonificador;
import edu.fiuba.algo3.modelo.bonificador.BonificadorConcreto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadDePuntajeTest {
    @Test
    public void test01UnJugadorRespondeConExclusividadDePuntajeCorrectamenteYRecibeElDobleDePuntos(){
        Jugador jugador1 = new Jugador("Bob");
        Jugador jugador2 = new Jugador("Alice");

        TipoDePregunta consigna = new VerdaderoFalso(new OpcionSimple("V"));
        Penalidad penalidad = new SinPenalidad();
        Bonificador bonificador = new ExclusividadPuntajeDecorador(new BonificadorConcreto());

        //Jugador 1 aplica el bonificador de exclusividadPuntaje
        Pregunta preguntaJugador1 = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?", bonificador);

        //Jugador 2 no aplica ningun bonificador
        Pregunta preguntaJugador2 = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?", new BonificadorConcreto());

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        //Jugador 1 responde correctamente
        respuestaJugador1.agregarOpcion(new OpcionSimple("V"));

        //Jugador 2 responde Incorrectamente
        respuestaJugador1.agregarOpcion(new OpcionSimple("V"));

        jugador1.responder(preguntaJugador1, respuestaJugador1);
        jugador2.responder(preguntaJugador2, respuestaJugador2);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Ronda ronda = new Ronda(jugadores);
        ronda.validarRespuestasJugadores();
        preguntaJugador1.validarRespuestas();

        assertEquals(0, jugador1.getPuntajeTotal());
    }
}
