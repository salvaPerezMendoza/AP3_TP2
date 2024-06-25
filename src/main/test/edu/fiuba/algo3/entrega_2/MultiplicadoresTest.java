/*package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MultiplicadoresTest {

    @Test
    public void TestAplicarMultiplicadorX2RespuestaCorrecta() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");

        // Crear flujo de juego
        Flujo flujoDeJuego = new Flujo();
        flujoDeJuego.agregarJugador(jugador1);
        flujoDeJuego.agregarJugador(jugador2);

        // Crear respuestas y pregunta
        ArrayList<String> respuestas = new ArrayList<>(Arrays.asList("A", "B"));
        Respuesta respuesta = new RespuestaMultipleChoice(respuestas);
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        PreguntaMultipleChoiceClasicoConPenalidad pregunta = new PreguntaMultipleChoiceClasicoConPenalidad(respuesta, "Seleccione las opciones correctas", opciones);

        // Asignar pregunta al flujo
        flujoDeJuego.setPreguntaActual(pregunta);

        // Crear respuestas de los jugadores
        Respuesta respuestaJugador1 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A", "B", "C"))); // Incorrecta
        Respuesta respuestaJugador2 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A", "B"))); // Correcta
        flujoDeJuego.agregarRespuesta(respuestaJugador1);
        flujoDeJuego.agregarRespuesta(respuestaJugador2);

        // Asignar multiplicador x2 a jugador 2
        flujoDeJuego.asignarMultiplicador(1, new MultiplicadorX2());

        // Evaluar respuestas y devolver puntajes
        flujoDeJuego.devolverPuntajes();

        // Verificar puntajes
        Assertions.assertEquals(-1, jugador1.getPuntaje()); // Jugador 1 responde incorrectamente y obtiene -1 puntos
        Assertions.assertEquals(2, jugador2.getPuntaje()); // Jugador 2 responde correctamente con multiplicador x2 y obtiene 2 puntos
    }

    @Test
    public void TestAplicarMultiplicadorX2RespuestaIncorrecta() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");

        // Crear flujo de juego
        Flujo flujoDeJuego = new Flujo();
        flujoDeJuego.agregarJugador(jugador1);
        flujoDeJuego.agregarJugador(jugador2);

        // Crear respuestas y pregunta
        ArrayList<String> respuestas = new ArrayList<>(Arrays.asList("A", "B"));
        Respuesta respuesta = new RespuestaMultipleChoice(respuestas);
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        PreguntaMultipleChoiceClasicoConPenalidad pregunta = new PreguntaMultipleChoiceClasicoConPenalidad(respuesta, "Seleccione las opciones correctas", opciones);

        // Asignar pregunta al flujo
        flujoDeJuego.setPreguntaActual(pregunta);

        // Crear respuestas de los jugadores
        Respuesta respuestaJugador1 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A", "B", "C"))); // Incorrecta
        Respuesta respuestaJugador2 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A", "C"))); // Incorrecta
        flujoDeJuego.agregarRespuesta(respuestaJugador1);
        flujoDeJuego.agregarRespuesta(respuestaJugador2);

        // Asignar multiplicador x2 a jugador 2
        flujoDeJuego.asignarMultiplicador(1, new MultiplicadorX2());

        // Evaluar respuestas y devolver puntajes
        flujoDeJuego.devolverPuntajes();

        // Verificar puntajes
        Assertions.assertEquals(-1, jugador1.getPuntaje()); // Jugador 1 responde incorrectamente y obtiene -1 puntos
        Assertions.assertEquals(-2, jugador2.getPuntaje()); // Jugador 2 responde incorrectamente con multiplicador x2 y obtiene -2 puntos
    }

    @Test
    public void TestAplicarMultiplicadorX3RespuestaCorrecta() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");

        // Crear flujo de juego
        Flujo flujoDeJuego = new Flujo();
        flujoDeJuego.agregarJugador(jugador1);
        flujoDeJuego.agregarJugador(jugador2);

        // Crear respuestas y pregunta
        ArrayList<String> respuestas = new ArrayList<>(Arrays.asList("A", "B"));
        Respuesta respuesta = new RespuestaMultipleChoice(respuestas);
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        PreguntaMultipleChoiceClasicoConPenalidad pregunta = new PreguntaMultipleChoiceClasicoConPenalidad(respuesta, "Seleccione las opciones correctas", opciones);

        // Asignar pregunta al flujo
        flujoDeJuego.setPreguntaActual(pregunta);

        // Crear respuestas de los jugadores
        Respuesta respuestaJugador1 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A", "B"))); // Correcta
        Respuesta respuestaJugador2 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A", "B"))); // Correcta
        flujoDeJuego.agregarRespuesta(respuestaJugador1);
        flujoDeJuego.agregarRespuesta(respuestaJugador2);

        // Asignar multiplicador x3 a jugador 1
        flujoDeJuego.asignarMultiplicador(0, new MultiplicadorX3());

        // Evaluar respuestas y devolver puntajes
        flujoDeJuego.devolverPuntajes();

        // Verificar puntajes
        Assertions.assertEquals(3, jugador1.getPuntaje()); // Jugador 1 responde correctamente con multiplicador x3 y obtiene 3 puntos
        Assertions.assertEquals(1, jugador2.getPuntaje()); // Jugador 2 responde correctamente sin multiplicador y obtiene 1 punto
    }

    @Test
    public void TestAplicarMultiplicadorX3RespuestaIncorrecta() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");

        // Crear flujo de juego
        Flujo flujoDeJuego = new Flujo();
        flujoDeJuego.agregarJugador(jugador1);
        flujoDeJuego.agregarJugador(jugador2);

        // Crear respuestas y pregunta
        ArrayList<String> respuestas = new ArrayList<>(Arrays.asList("A", "B"));
        Respuesta respuesta = new RespuestaMultipleChoice(respuestas);
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        PreguntaMultipleChoiceClasicoConPenalidad pregunta = new PreguntaMultipleChoiceClasicoConPenalidad(respuesta, "Seleccione las opciones correctas", opciones);

        // Asignar pregunta al flujo
        flujoDeJuego.setPreguntaActual(pregunta);

        // Crear respuestas de los jugadores
        Respuesta respuestaJugador1 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A", "C"))); // Incorrecta
        Respuesta respuestaJugador2 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A", "B", "C"))); // Incorrecta
        flujoDeJuego.agregarRespuesta(respuestaJugador1);
        flujoDeJuego.agregarRespuesta(respuestaJugador2);

        // Asignar multiplicador x3 a jugador 2
        flujoDeJuego.asignarMultiplicador(1, new MultiplicadorX3());

        // Evaluar respuestas y devolver puntajes
        flujoDeJuego.devolverPuntajes();

        // Verificar puntajes
        Assertions.assertEquals(-1, jugador1.getPuntaje()); // Jugador 1 responde incorrectamente y obtiene -1 puntos
        Assertions.assertEquals(-3, jugador2.getPuntaje()); // Jugador 2 responde incorrectamente con multiplicador x3 y obtiene -3 puntos
    }


}*/
