package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Flujo;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlujoTest {

    private Flujo flujo;

    @BeforeEach
    public void setUp() {
        flujo = new Flujo();
        flujo.agregarJugador(new Jugador("Jugador 1"));
        flujo.agregarJugador(new Jugador("Jugador 2"));
    }

    @Test
    public void testAgregarJugador() {
        assertEquals(2, flujo.devolverJugadores().size(), "Debe haber dos jugadores");
    }

    @Test
    public void testTurnos() {
        Jugador jugadorActual = flujo.getJugadorActual();
        assertEquals("Jugador 1", jugadorActual.getNombre());

        flujo.siguienteTurno();
        jugadorActual = flujo.getJugadorActual();
        assertEquals("Jugador 2", jugadorActual.getNombre());

        flujo.siguienteTurno();
        jugadorActual = flujo.getJugadorActual();
        assertEquals("Jugador 1", jugadorActual.getNombre());
    }

    @Test
    public void queTipoDePreguntaToca() {
        TipoDePregunta tipo;

        tipo = flujo.queTipoDePreguntaToca();
        System.out.println(tipo);
        flujo.siguienteTurno();

        tipo = flujo.queTipoDePreguntaToca();
        System.out.println(tipo);
        flujo.siguienteTurno();

        tipo = flujo.queTipoDePreguntaToca();
        System.out.println(tipo);
        flujo.siguienteTurno();

        tipo = flujo.queTipoDePreguntaToca();
        System.out.println(tipo);
        flujo.siguienteTurno();
    }
}
