package edu.fiuba.algo3.entrega_1;

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

        Respuesta respuesta = new RespuestaV();
        Pregunta pregunta = new PreguntaVFClasico("La tierra es redonda", respuesta);

        // Crear lista de respuestas (jugador1 responde correctamente, jugador2 incorrectamente)
        Respuesta repsuestaJugador1 = new RespuestaV(jugador1);
        Respuesta repsuestaJugador2 = new RespuestaV(jugador2);

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(repsuestaJugador1);
        respuestas.add(repsuestaJugador2);

        // Evaluar respuestas
        pregunta.validarRespuestas(respuestas);

        // Verificar puntajes
        Assertions.assertEquals(1, jugador1.getPuntaje());
        Assertions.assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void Test02PreguntaVFClasicoMalRespondida() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");

        // Crear pregunta de Verdadero/Falso clásico con la respuesta correcta "Falso"
        Respuesta respuesta = new RespuestaF();
        Pregunta pregunta = new PreguntaVFClasico("La tierra es redonda", respuesta);

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)
        Respuesta repsuestaJugador1 = new RespuestaF(jugador1);
        Respuesta repsuestaJugador2 = new RespuestaF(jugador2);

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(repsuestaJugador1);
        respuestas.add(repsuestaJugador2);

        // Evaluar respuestas
        pregunta.validarRespuestas(respuestas);

        // Verificar puntajes
        Assertions.assertEquals(0, jugador1.getPuntaje()); // Jugador que respondió incorrectamente no obtiene puntos
        Assertions.assertEquals(0, jugador2.getPuntaje()); // Jugador que respondió correctamente obtiene 1 punto
    }

    @Test
    public void Test03PreguntaMultipleChiceBienRespondida() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");

        ArrayList<Opcion> respuestasCorrectas = new ArrayList<>();
        Opcion opcion1 = new Opcion("A");
        Opcion opcion2 = new Opcion("B");
        Opcion opcion3 = new Opcion("C");
        Opcion opcion4 = new Opcion("D");

        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(respuestasCorrectas);
        respuesta.agregarOpcion(opcion1);
        respuesta.agregarOpcion(opcion2);

        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta pregunta = new PreguntaMultipleChoiceClasico(respuesta, "Seleccione las opciones correctas",opciones);

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)}
        Respuesta respuestaJugador1 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList(opcion1, opcion2)),jugador1);
        Respuesta respuestaJugador2 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList(opcion2, opcion1)),jugador2);

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.validarRespuestas(respuestas);

        // Verificar puntajes
        assertEquals(1, jugador1.getPuntaje()); // Jugador que respondió correctamente obtiene 1 punto
        assertEquals(1, jugador2.getPuntaje()); // Jugador que respondió correctamente obtiene 1 punto
    }
    @Test
    public void Test04PreguntaMultipleChiceMalRespondida() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");

        ArrayList<Opcion> respuestasCorrectas = new ArrayList<>();
        Opcion opcion1 = new Opcion("A");
        Opcion opcion2 = new Opcion("B");
        Opcion opcion3 = new Opcion("C");
        Opcion opcion4 = new Opcion("D");

        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(respuestasCorrectas);
        respuesta.agregarOpcion(opcion1);
        respuesta.agregarOpcion(opcion2);

        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta pregunta = new PreguntaMultipleChoiceClasico(respuesta, "Seleccione las opciones correctas",opciones);

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)}
        Respuesta respuestaJugador1 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList(opcion1, opcion3)));
        Respuesta respuestaJugador2 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList(opcion4, opcion2, opcion1)));

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.validarRespuestas(respuestas);

        // Verificar puntajes
        assertEquals(0, jugador1.getPuntaje()); // Jugador que respondió incorrectamente obtiene 0 puntos
        assertEquals(0, jugador2.getPuntaje()); // Jugador que respondió incorrectamente obtiene 0 puntos
    }

    @Test
    public void Test05PreguntaVFClasicoConPenalidadBienRespondida() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");

        Respuesta respuesta = new RespuestaV();
        Pregunta pregunta = new PreguntaVFClasicoConPenalidad("La tierra es redonda", respuesta);

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)
        Respuesta respuestaJugador1 = new RespuestaV(jugador1);
        Respuesta respuestaJugador2 = new RespuestaV(jugador2);

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        // Evaluar respuestas
        pregunta.validarRespuestas(respuestas);

        // Verificar puntajes
        Assertions.assertEquals(1, jugador1.getPuntaje()); // Jugador que respondió correctamente obtiene 1 punto
        Assertions.assertEquals(1, jugador2.getPuntaje()); // Jugador que respondió correctamente obtiene 1 punto
    }
    @Test
    public void Test06PreguntaVFClasicoConPenalidadMalRespondida() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");

        Respuesta respuesta = new RespuestaV();
        // Crear pregunta de Verdadero/Falso clásico con la respuesta correcta "Falso"
        Pregunta pregunta = new PreguntaVFClasicoConPenalidad("La tierra es redonda", respuesta);

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)
        Respuesta respuestaJugador1 = new RespuestaF(jugador1);
        Respuesta respuestaJugador2 = new RespuestaF(jugador2);

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        // Evaluar respuestas
        pregunta.validarRespuestas(respuestas);

        // Verificar puntajes
        Assertions.assertEquals(-1, jugador1.getPuntaje()); // Jugador que respondió incorrectamente obtiene -1 puntos
        Assertions.assertEquals(-1, jugador2.getPuntaje()); // Jugador que respondió iccorrectamente obtiene -1 puntos
    }

    @Test
    public void Test07PreguntaMultipleChoiceClasicoConPenalidadBienRespondida() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");

        ArrayList<Opcion> respuestasCorrectas = new ArrayList<>();
        Opcion opcion1 = new Opcion("A");
        Opcion opcion2 = new Opcion("B");
        Opcion opcion3 = new Opcion("C");
        Opcion opcion4 = new Opcion("D");

        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(respuestasCorrectas);
        respuesta.agregarOpcion(opcion1);
        respuesta.agregarOpcion(opcion2);

        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta pregunta = new PreguntaMultipleChoiceClasicoConPenalidad(respuesta, "Seleccione las opciones correctas",opciones);

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)}
        Respuesta respuestaJugador1 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList(opcion1, opcion2)));
        Respuesta respuestaJugador2 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList(opcion2, opcion1)));

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.validarRespuestas(respuestas);

        // Verificar puntajes
        assertEquals(1, jugador1.getPuntaje()); // Jugador que respondió correctamente obtiene 1 punto
        assertEquals(1, jugador2.getPuntaje()); // Jugador que respondió correctamente obtiene 1 punto
    }
    @Test
    public void Test08PreguntaMultipleChoiceClasicoConPenalidadMalRespondida() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Alice");
        Jugador jugador2 = new Jugador("Bob");

        ArrayList<Opcion> respuestasCorrectas = new ArrayList<>();
        Opcion opcion1 = new Opcion("A");
        Opcion opcion2 = new Opcion("B");
        Opcion opcion3 = new Opcion("C");
        Opcion opcion4 = new Opcion("D");

        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(respuestasCorrectas);
        respuesta.agregarOpcion(opcion1);
        respuesta.agregarOpcion(opcion2);

        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta pregunta = new PreguntaMultipleChoiceClasicoConPenalidad(respuesta, "Seleccione las opciones correctas",opciones);

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)}
        Respuesta respuestaJugador1 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList(opcion1, opcion4, opcion2)));
        Respuesta respuestaJugador2 = new RespuestaMultipleChoice(new ArrayList<>(Arrays.asList(opcion2, opcion3)));

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.validarRespuestas(respuestas);

        // Verificar puntajes
        assertEquals(-1, jugador1.getPuntaje()); // Jugador que respondió incorrectamente obtiene -1 puntos
        assertEquals(-1, jugador2.getPuntaje()); // Jugador que respondió incorrectamente obtiene -1 puntos
    }
}
