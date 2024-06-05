package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Flujo;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.PreguntaVFClasico;
import edu.fiuba.algo3.modelo.Jugador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

//    @Test
//    public void Test03PreguntaMultipleChiceBienRespondida() {
//        // Crear jugadores
//        Jugador jugador1 = new Jugador("Alice");
//        Jugador jugador2 = new Jugador("Bob");
//
//        ArrayList<Jugador> jugadores = new ArrayList<>();
//        jugadores.add(jugador1);
//        jugadores.add(jugador2);
//
//        // Crear pregunta de Multiple Choice clásico con las opciones correctas "A" y "B"
//        ArrayList<String> opcionesCorrectas = new ArrayList<>();
//        opcionesCorrectas.add("A");
//        opcionesCorrectas.add("B");
//        PreguntaMultipleChoiceClasico pregunta = new PreguntaMultipleChoiceClasico("Selecciona las opciones A y B", opcionesCorrectas);
//
//        // Simular respuestas de los jugadores (jugador1 responde incorrectamente, jugador2 correctamente)
//        ArrayList<String> respuestasJugador1 = new ArrayList<>();
//        respuestasJugador1.add("A"); // Opción incorrecta
//        respuestasJugador1.add("C"); // Opción incorrecta
//        ArrayList<String> respuestasJugador2 = new ArrayList<>();
//        respuestasJugador2.add("A"); // Opción correcta
//        respuestasJugador2.add("B"); // Opción correcta
//
//        // Evaluar respuestas
//        pregunta.evaluarRespuestas(jugadores, respuestasJugador1);
//        pregunta.evaluarRespuestas(jugadores, respuestasJugador2);
//
//        // Verificar puntajes
//        assertEquals(0, jugador1.getPuntaje()); // Jugador que respondió incorrectamente no obtiene puntos
//        assertEquals(1, jugador2.getPuntaje()); // Jugador que respondió correctamente obtiene 1 punto
//    }
}
