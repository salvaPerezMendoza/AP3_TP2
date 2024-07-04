package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Bonificadores.BonificadorDecorador;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.Penalidad.ConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
import edu.fiuba.algo3.modelo.TipoDePregunta.VerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMultiplicadores {
    @Test
    public void test01jugador1AplicaMultiplicadorYRecibePuntosX2() {
        //Bob aplicara el anulador y a Alice no le contara los puntos por mas de que respondio correctamente
        Jugador jugador1 = new Jugador("Bob");
        Jugador jugador2 = new Jugador("Alice");

        ArrayList<OpcionSimple> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Verdadero",1));
        opciones.add(new OpcionSimple("Falso",2));

        TipoDePregunta consigna = new VerdaderoFalso(opciones, new OpcionSimple("Verdadero", 1));
        Penalidad penalidad = new ConPenalidad();

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?","deporte");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion(new OpcionSimple("Verdadero", 1));

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion(new OpcionSimple("Verdadero", 1));

        jugador1.responder(pregunta, respuestaJugador1);
        jugador2.responder(pregunta, respuestaJugador2);

        ArrayList<BonificadorDecorador> bonificadores = pregunta.obtenerBonificadoresDisponibles(jugador1);
        BonificadorDecorador bonificadorDecorador = bonificadores.get(0);
        jugador1.usarBonificador(bonificadorDecorador,pregunta);

        pregunta.validarRespuestas();

        assertEquals(2, jugador1.getPuntajeTotal());
        assertEquals(1, jugador2.getPuntajeTotal());
    }

    @Test
    public void test02jugador1AplicaMultiplicadorYRecibePuntosX3() {
        //Bob aplicara el anulador y a Alice no le contara los puntos por mas de que respondio correctamente
        Jugador jugador1 = new Jugador("Bob");
        Jugador jugador2 = new Jugador("Alice");

        ArrayList<OpcionSimple> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Verdadero",1));
        opciones.add(new OpcionSimple("Falso",2));

        TipoDePregunta consigna = new VerdaderoFalso(opciones, new OpcionSimple("Verdadero", 1));
        Penalidad penalidad = new ConPenalidad();

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?","deporte");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion(new OpcionSimple("Verdadero", 1));

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion(new OpcionSimple("Verdadero", 1));

        jugador1.responder(pregunta, respuestaJugador1);
        jugador2.responder(pregunta, respuestaJugador2);

        ArrayList<BonificadorDecorador> bonificadores = pregunta.obtenerBonificadoresDisponibles(jugador1);
        BonificadorDecorador bonificadorDecorador = bonificadores.get(1);
        jugador1.usarBonificador(bonificadorDecorador,pregunta);

        pregunta.validarRespuestas();

        assertEquals(3, jugador1.getPuntajeTotal());
        assertEquals(1, jugador2.getPuntajeTotal());
    }

    @Test
    public void test03jugador1y2AplicanMultiplicadorYRecibePuntosX2() {
        //Bob aplicara el anulador y a Alice no le contara los puntos por mas de que respondio correctamente
        Jugador jugador1 = new Jugador("Bob");
        Jugador jugador2 = new Jugador("Alice");

        ArrayList<OpcionSimple> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Verdadero",1));
        opciones.add(new OpcionSimple("Falso",2));

        TipoDePregunta consigna = new VerdaderoFalso(opciones, new OpcionSimple("Verdadero", 1));
        Penalidad penalidad = new ConPenalidad();

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?","deporte");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion(new OpcionSimple("Verdadero", 1));

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion(new OpcionSimple("Verdadero", 1));

        jugador1.responder(pregunta, respuestaJugador1);
        jugador2.responder(pregunta, respuestaJugador2);

        ArrayList<BonificadorDecorador> bonificadores = pregunta.obtenerBonificadoresDisponibles(jugador1);
        BonificadorDecorador bonificadorDecorador = bonificadores.get(0);
        ArrayList<BonificadorDecorador> bonificadores2 = pregunta.obtenerBonificadoresDisponibles(jugador2);
        BonificadorDecorador bonificadorDecorador2 = bonificadores2.get(0);
        jugador1.usarBonificador(bonificadorDecorador,pregunta);
        jugador2.usarBonificador(bonificadorDecorador2,pregunta);

        pregunta.validarRespuestas();

        assertEquals(2, jugador1.getPuntajeTotal());
        assertEquals(2, jugador2.getPuntajeTotal());
    }
}
