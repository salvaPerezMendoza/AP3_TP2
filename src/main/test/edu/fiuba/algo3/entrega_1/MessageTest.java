package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Jugador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        flujoDeJuego.setPreguntaActual(new PreguntaVFClasico("La tierra es redonda", "V"));

        // Crear lista de respuestas (jugador1 responde correctamente, jugador2 incorrectamente)
        String respuestaJugador1 = jugador1.responder("V");
        flujoDeJuego.agregarRespuesta(respuestaJugador1);
        String respuestaJugador2 = jugador2.responder("F");
        flujoDeJuego.agregarRespuesta(respuestaJugador2);

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
        flujoDeJuego.setPreguntaActual(new PreguntaVFClasico("La tierra es redonda", "F"));

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)
        String respuestaJugador1 = jugador1.responder("V");
        flujoDeJuego.agregarRespuesta(respuestaJugador1);
        String respuestaJugador2 = jugador2.responder("F");
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

        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("A");
        opciones.add("B");
        opciones.add("C");
        opciones.add("D");

        flujoDeJuego.setPreguntaActual(new PreguntaMultipleChoiceClasico(respuestas, "Seleccione las opciones correctas",opciones));

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)}
        String respuestaJugador1 = jugador1.responder("A,B");
        String respuestaJugador2 = jugador2.responder("A,B");

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

        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("A");
        opciones.add("B");
        opciones.add("C");
        opciones.add("D");

        flujoDeJuego.setPreguntaActual(new PreguntaMultipleChoiceClasico(respuestas, "Seleccione las opciones correctas",opciones));

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)}
        String respuestaJugador1 = jugador1.responder("A,D");
        String respuestaJugador2 = jugador2.responder("A,C");

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

        // Crear pregunta de Verdadero/Falso clásico con la respuesta correcta "Falso"
        flujoDeJuego.setPreguntaActual(new PreguntaVFClasicoConPenalidad("La tierra es redonda", "F"));

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)
        String respuestaJugador1 = jugador1.responder("F");
        flujoDeJuego.agregarRespuesta(respuestaJugador1);
        String respuestaJugador2 = jugador2.responder("F");
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

        // Crear pregunta de Verdadero/Falso clásico con la respuesta correcta "Falso"
        flujoDeJuego.setPreguntaActual(new PreguntaVFClasicoConPenalidad("La tierra es redonda", "F"));

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)
        String respuestaJugador1 = jugador1.responder("V");
        flujoDeJuego.agregarRespuesta(respuestaJugador1);
        String respuestaJugador2 = jugador2.responder("V");
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

        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("A");
        opciones.add("B");
        opciones.add("C");
        opciones.add("D");

        flujoDeJuego.setPreguntaActual(new PreguntaMultipleChoiceClasicoConPenalidad(respuestas, "Seleccione las opciones correctas",opciones));

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)}
        String respuestaJugador1 = jugador1.responder("A,B");
        String respuestaJugador2 = jugador2.responder("A,B");

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

        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("A");
        opciones.add("B");
        opciones.add("C");
        opciones.add("D");

        flujoDeJuego.setPreguntaActual(new PreguntaMultipleChoiceClasicoConPenalidad(respuestas, "Seleccione las opciones correctas",opciones));

        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)}
        String respuestaJugador1 = jugador1.responder("A,D");
        String respuestaJugador2 = jugador2.responder("A,C");

        flujoDeJuego.agregarRespuesta(respuestaJugador1);
        flujoDeJuego.agregarRespuesta(respuestaJugador2);

        flujoDeJuego.devolverPuntajes();

        // Verificar puntajes
        assertEquals(-1, jugador1.getPuntaje()); // Jugador que respondió incorrectamente obtiene -1 puntos
        assertEquals(-1, jugador2.getPuntaje()); // Jugador que respondió incorrectamente obtiene -1 puntos
    }
}
