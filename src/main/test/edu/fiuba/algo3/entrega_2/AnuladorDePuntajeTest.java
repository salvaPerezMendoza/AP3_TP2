package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class AnuladorDePuntajeTest {

    @Test
    public void TestAnuladorDePuntajeUsado() {
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

        // Jugador 1 usa el anulador de puntaje
        jugador1.usarAnulador();

        // Evaluar respuestas y devolver puntajes
        flujoDeJuego.devolverPuntajes();

        // Verificar puntajes
        Assertions.assertEquals(1, jugador1.getPuntaje()); // Jugador 1 obtiene puntos porque usó el anulador y respondio bien
        Assertions.assertEquals(0, jugador2.getPuntaje()); // Jugador 2 no obtiene puntos porque repondio bien pero el anulador fue usado contra él
    }

    @Test
    public void TestAnuladorDePuntajeConCuatroJugadoresYUnAnulador() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");
        Jugador jugador3 = new Jugador("Charlie");
        Jugador jugador4 = new Jugador("Diana");

        // Crear flujo de juego
        Flujo flujoDeJuego = new Flujo();
        flujoDeJuego.agregarJugador(jugador1);
        flujoDeJuego.agregarJugador(jugador2);
        flujoDeJuego.agregarJugador(jugador3);
        flujoDeJuego.agregarJugador(jugador4);

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
        Respuesta respuestaJugador3 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A", "B"))); // Correcta
        Respuesta respuestaJugador4 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A", "D"))); // Incorrecta
        flujoDeJuego.agregarRespuesta(respuestaJugador1);
        flujoDeJuego.agregarRespuesta(respuestaJugador2);
        flujoDeJuego.agregarRespuesta(respuestaJugador3);
        flujoDeJuego.agregarRespuesta(respuestaJugador4);

        // Jugadores 1
        jugador1.usarAnulador();

        // Evaluar respuestas y devolver puntajes
        flujoDeJuego.devolverPuntajes();

        // Verificar puntajes
        Assertions.assertEquals(1, jugador1.getPuntaje()); // Jugador 1 obtiene puntos porque respondio bien
        Assertions.assertEquals(0, jugador2.getPuntaje()); // Jugador 2 no obtiene puntos porque el anulador fue usado contra él
        Assertions.assertEquals(0, jugador3.getPuntaje()); // Jugador 2 no obtiene puntos porque el anulador fue usado contra él
        Assertions.assertEquals(-1, jugador4.getPuntaje()); // Jugador 4 obtiene puntos negativos por respuesta incorrecta
    }

    @Test
    public void TestAnuladorDePuntajeConCuatroJugadoresYDosAnuladores() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");
        Jugador jugador3 = new Jugador("Charlie");
        Jugador jugador4 = new Jugador("Diana");

        // Crear flujo de juego
        Flujo flujoDeJuego = new Flujo();
        flujoDeJuego.agregarJugador(jugador1);
        flujoDeJuego.agregarJugador(jugador2);
        flujoDeJuego.agregarJugador(jugador3);
        flujoDeJuego.agregarJugador(jugador4);

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
        Respuesta respuestaJugador3 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A", "B"))); // Correcta
        Respuesta respuestaJugador4 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A", "D"))); // Incorrecta
        flujoDeJuego.agregarRespuesta(respuestaJugador1);
        flujoDeJuego.agregarRespuesta(respuestaJugador2);
        flujoDeJuego.agregarRespuesta(respuestaJugador3);
        flujoDeJuego.agregarRespuesta(respuestaJugador4);

        // Jugadores 1 y 3 usan el anulador de puntaje
        jugador1.usarAnulador();
        jugador3.usarAnulador();

        // Evaluar respuestas y devolver puntajes
        flujoDeJuego.devolverPuntajes();

        // Verificar puntajes
        Assertions.assertEquals(0, jugador1.getPuntaje()); // Jugador 1 no obtiene puntos porque respondio bien pero el j3 uso anulador
        Assertions.assertEquals(0, jugador2.getPuntaje()); // Jugador 2 no obtiene puntos porque el anulador fue usado contra él
        Assertions.assertEquals(0, jugador3.getPuntaje()); // Jugador 3 no obtiene puntos porque respondio bien pero el j1 uso anulador
        Assertions.assertEquals(-1, jugador4.getPuntaje()); // Jugador 4 obtiene puntos negativos por respuesta incorrecta
    }

    @Test
    public void TestAnuladorDePuntajeConCuatroJugadoresYUnAnuladorDeUnJugadorQueRespondioMal() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");
        Jugador jugador3 = new Jugador("Charlie");
        Jugador jugador4 = new Jugador("Diana");

        // Crear flujo de juego
        Flujo flujoDeJuego = new Flujo();
        flujoDeJuego.agregarJugador(jugador1);
        flujoDeJuego.agregarJugador(jugador2);
        flujoDeJuego.agregarJugador(jugador3);
        flujoDeJuego.agregarJugador(jugador4);

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
        Respuesta respuestaJugador3 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A", "B", "C"))); // Incorrecta
        Respuesta respuestaJugador4 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A", "D"))); // Incorrecta
        flujoDeJuego.agregarRespuesta(respuestaJugador1);
        flujoDeJuego.agregarRespuesta(respuestaJugador2);
        flujoDeJuego.agregarRespuesta(respuestaJugador3);
        flujoDeJuego.agregarRespuesta(respuestaJugador4);

        // Jugador 3 usa el anulador de puntaje
        jugador3.usarAnulador();

        // Evaluar respuestas y devolver puntajes
        flujoDeJuego.devolverPuntajes();

        // Verificar puntajes
        Assertions.assertEquals(0, jugador1.getPuntaje()); // Jugador 1 no obtiene puntos porque respondio bien pero el j3 uso anulador
        Assertions.assertEquals(0, jugador2.getPuntaje()); // Jugador 2 no obtiene puntos porque respondio bien pero el j3 uso anulador
        Assertions.assertEquals(-1, jugador3.getPuntaje()); // Jugador 3 obtiene puntos negativos por respuesta incorrecta
        Assertions.assertEquals(-1, jugador4.getPuntaje()); // Jugador 4 obtiene puntos negativos por respuesta incorrecta
    }
}
