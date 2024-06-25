package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.TipoDePregunta.VerdaderoFalso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaTest {

    private Pregunta pregunta;
    private Jugador jugador;

    @BeforeEach
    public void setUp() {
        ArrayList<OpcionSimple> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Verdadero", 1));
        opciones.add(new OpcionSimple("Falso", 2));

        VerdaderoFalso verdaderoFalso = new VerdaderoFalso(opciones, opciones.get(0));
        pregunta = new Pregunta(verdaderoFalso, new SinPenalidad(), "El cielo es azul.");
        jugador = new Jugador("Jugador 1");
    }

    @Test
    public void testValidarRespuestaCorrecta() {
        Respuesta respuesta = new Respuesta(jugador);
        respuesta.agregarOpcion(new OpcionSimple("Verdadero", 1));
        jugador.responder(pregunta, respuesta);

        pregunta.validarRespuestas();
        assertEquals(1, jugador.getPuntajeTotal(), "El jugador debería tener 1 punto");
    }

    @Test
    public void testValidarRespuestaIncorrecta() {
        Respuesta respuesta = new Respuesta(jugador);
        respuesta.agregarOpcion(new OpcionSimple("Falso", 2));
        jugador.responder(pregunta, respuesta);

        pregunta.validarRespuestas();
        assertEquals(0, jugador.getPuntajeTotal(), "El jugador debería tener 0 puntos");
    }
}
