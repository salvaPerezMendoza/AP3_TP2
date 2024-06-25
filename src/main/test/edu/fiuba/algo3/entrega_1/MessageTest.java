/*package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Jugador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {
    @Test
    public void Test01PreguntaVFClasicoBienRespondida() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");

        Flujo flujoDeJuego = new Flujo();
        flujoDeJuego.agregarJugador(jugador1);
        flujoDeJuego.agregarJugador(jugador2);
        Respuesta respuesta = new RespuestaV();
        flujoDeJuego.setPreguntaActual(new PreguntaVFClasico("La tierra es redonda", respuesta));

        // Crear lista de respuestas (jugador1 responde correctamente, jugador2 incorrectamente)
        Respuesta repsuestaJugador1 = new RespuestaV();
        flujoDeJuego.agregarRespuesta(repsuestaJugador1);
        Respuesta repsuestaJugador2 = new RespuestaF();
        flujoDeJuego.agregarRespuesta(repsuestaJugador2);

        // Evaluar respuestas
        flujoDeJuego.devolverPuntajes();

        // Verificar puntajes
        Assertions.assertEquals(1, jugador1.getPuntaje());
        Assertions.assertEquals(0, jugador2.getPuntaje());
    }

    @Test
    public void Test02PreguntaVFClasicoMalRespondida() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");

        Flujo flujoDeJuego = new Flujo();
        flujoDeJuego.agregarJugador(jugador1);
        flujoDeJuego.agregarJugador(jugador2);

        // Crear pregunta de Verdadero/Falso clásico con la respuesta correcta "Falso"
        Respuesta respuesta = new RespuestaF();
        flujoDeJuego.setPreguntaActual(new PreguntaVFClasico("La tierra es redonda", respuesta));

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)
        Respuesta respuestaJugador1 = new RespuestaV();
        flujoDeJuego.agregarRespuesta(respuestaJugador1);
        Respuesta respuestaJugador2 = new RespuestaF();
        flujoDeJuego.agregarRespuesta(respuestaJugador2);

        // Evaluar respuestas
        flujoDeJuego.devolverPuntajes();

        // Verificar puntajes
        Assertions.assertEquals(0, jugador1.getPuntaje()); // Jugador que respondió incorrectamente no obtiene puntos
        Assertions.assertEquals(1, jugador2.getPuntaje()); // Jugador que respondió correctamente obtiene 1 punto
    }

    @Test
    public void Test03PreguntaMultipleChiceBienRespondida() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");

        Flujo flujoDeJuego = new Flujo();
        flujoDeJuego.agregarJugador(jugador1);
        flujoDeJuego.agregarJugador(jugador2);

        ArrayList<String> respuestas = new ArrayList<>();
        respuestas.add("A");
        respuestas.add("B");

        Respuesta respuesta = new RespuestaMultipleChoice(respuestas);

        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("A");
        opciones.add("B");
        opciones.add("C");
        opciones.add("D");

        flujoDeJuego.setPreguntaActual(new PreguntaMultipleChoiceClasico(respuesta, "Seleccione las opciones correctas",opciones));

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)}
        Respuesta respuestaJugador1 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A", "B")));
        Respuesta respuestaJugador2 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("B", "A")));

        flujoDeJuego.agregarRespuesta(respuestaJugador1);
        flujoDeJuego.agregarRespuesta(respuestaJugador2);

        flujoDeJuego.devolverPuntajes();

        // Verificar puntajes
        assertEquals(1, jugador1.getPuntaje()); // Jugador que respondió correctamente obtiene 1 punto
        assertEquals(1, jugador2.getPuntaje()); // Jugador que respondió correctamente obtiene 1 punto
    }
    @Test
    public void Test04PreguntaMultipleChiceMalRespondida() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");

        Flujo flujoDeJuego = new Flujo();
        flujoDeJuego.agregarJugador(jugador1);
        flujoDeJuego.agregarJugador(jugador2);

        ArrayList<String> respuestas = new ArrayList<>();
        respuestas.add("A");
        respuestas.add("B");

        Respuesta respuesta = new RespuestaMultipleChoice(respuestas);

        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("A");
        opciones.add("B");
        opciones.add("C");
        opciones.add("D");

        flujoDeJuego.setPreguntaActual(new PreguntaMultipleChoiceClasico(respuesta, "Seleccione las opciones correctas",opciones));

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)}
        Respuesta respuestaJugador1 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A", "C")));
        Respuesta respuestaJugador2 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A", "B","C")));

        flujoDeJuego.agregarRespuesta(respuestaJugador1);
        flujoDeJuego.agregarRespuesta(respuestaJugador2);

        flujoDeJuego.devolverPuntajes();

        // Verificar puntajes
        assertEquals(0, jugador1.getPuntaje()); // Jugador que respondió incorrectamente no obtiene puntos
        assertEquals(0, jugador2.getPuntaje()); // Jugador que respondió incorrectamente no obtiene puntos
    }

    @Test
    public void Test05PreguntaVFClasicoConPenalidadBienRespondida() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");

        Flujo flujoDeJuego = new Flujo();
        flujoDeJuego.agregarJugador(jugador1);
        flujoDeJuego.agregarJugador(jugador2);

        Respuesta respuesta = new RespuestaV();
        // Crear pregunta de Verdadero/Falso clásico con la respuesta correcta "Falso"
        flujoDeJuego.setPreguntaActual(new PreguntaVFClasicoConPenalidad("La tierra es redonda", respuesta));

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)
        Respuesta respuestaJugador1 = new RespuestaV();
        flujoDeJuego.agregarRespuesta(respuestaJugador1);
        Respuesta respuestaJugador2 = new RespuestaV();
        flujoDeJuego.agregarRespuesta(respuestaJugador2);

        // Evaluar respuestas
        flujoDeJuego.devolverPuntajes();

        // Verificar puntajes
        Assertions.assertEquals(1, jugador1.getPuntaje()); // Jugador que respondió correctamente obtiene 1 punto
        Assertions.assertEquals(1, jugador2.getPuntaje()); // Jugador que respondió correctamente obtiene 1 punto
    }
    @Test
    public void Test06PreguntaVFClasicoConPenalidadMalRespondida() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");

        Flujo flujoDeJuego = new Flujo();
        flujoDeJuego.agregarJugador(jugador1);
        flujoDeJuego.agregarJugador(jugador2);

        Respuesta respuesta = new RespuestaV();
        // Crear pregunta de Verdadero/Falso clásico con la respuesta correcta "Falso"
        flujoDeJuego.setPreguntaActual(new PreguntaVFClasicoConPenalidad("La tierra es redonda", respuesta));

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)
        Respuesta respuestaJugador1 = new RespuestaF();
        flujoDeJuego.agregarRespuesta(respuestaJugador1);
        Respuesta respuestaJugador2 = new RespuestaF();
        flujoDeJuego.agregarRespuesta(respuestaJugador2);

        // Evaluar respuestas
        flujoDeJuego.devolverPuntajes();

        // Verificar puntajes
        Assertions.assertEquals(-1, jugador1.getPuntaje()); // Jugador que respondió incorrectamente obtiene -1 puntos
        Assertions.assertEquals(-1, jugador2.getPuntaje()); // Jugador que respondió iccorrectamente obtiene -1 puntos
    }

    @Test
    public void Test07PreguntaMultipleChoiceClasicoConPenalidadBienRespondida() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");

        Flujo flujoDeJuego = new Flujo();
        flujoDeJuego.agregarJugador(jugador1);
        flujoDeJuego.agregarJugador(jugador2);

        ArrayList<String> respuestas = new ArrayList<>();
        respuestas.add("A");
        respuestas.add("B");

        Respuesta respuesta = new RespuestaMultipleChoice(respuestas);

        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("A");
        opciones.add("B");
        opciones.add("C");
        opciones.add("D");

        flujoDeJuego.setPreguntaActual(new PreguntaMultipleChoiceClasicoConPenalidad(respuesta, "Seleccione las opciones correctas",opciones));

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)}
        Respuesta respuestaJugador1 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A", "B")));
        Respuesta respuestaJugador2 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("B", "A")));

        flujoDeJuego.agregarRespuesta(respuestaJugador1);
        flujoDeJuego.agregarRespuesta(respuestaJugador2);

        flujoDeJuego.devolverPuntajes();

        // Verificar puntajes
        assertEquals(1, jugador1.getPuntaje()); // Jugador que respondió correctamente obtiene 1 punto
        assertEquals(1, jugador2.getPuntaje()); // Jugador que respondió correctamente obtiene 1 punto
    }
    @Test
    public void Test08PreguntaMultipleChoiceClasicoConPenalidadMalRespondida() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");

        Flujo flujoDeJuego = new Flujo();
        flujoDeJuego.agregarJugador(jugador1);
        flujoDeJuego.agregarJugador(jugador2);

        ArrayList<String> respuestas = new ArrayList<>();
        respuestas.add("A");
        respuestas.add("B");

        Respuesta respuesta = new RespuestaMultipleChoice(respuestas);

        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("A");
        opciones.add("B");
        opciones.add("C");
        opciones.add("D");

        flujoDeJuego.setPreguntaActual(new PreguntaMultipleChoiceClasicoConPenalidad(respuesta, "Seleccione las opciones correctas",opciones));

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)}
        Respuesta respuestaJugador1 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A","B","C")));
        Respuesta respuestaJugador2 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList("A","B")));

        flujoDeJuego.agregarRespuesta(respuestaJugador1);
        flujoDeJuego.agregarRespuesta(respuestaJugador2);

        flujoDeJuego.devolverPuntajes();

        // Verificar puntajes
        assertEquals(-1, jugador1.getPuntaje()); // Jugador que respondió incorrectamente obtiene -1 puntos
        assertEquals(1, jugador2.getPuntaje()); // Jugador que respondió correctamente obtiene 1 puntos
    }
}*/
