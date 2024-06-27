package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
import edu.fiuba.algo3.modelo.TipoDePregunta.VerdaderoFalso;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
public class TestGeneral {

    private CreadorDePreguntas creadorDePreguntas;
    private Juego juego;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugador3;
    private List<Pregunta> preguntas;
    private Pregunta preguntaActual;

    @BeforeEach
    public void setUp() throws IOException, ParseException {
        // Agrego Jugadores
        juego = new Juego();
        jugador1 = new Jugador("Jugador1");
        jugador2 = new Jugador("Jugador2");
        jugador3 = new Jugador("Jugador3");
        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);
        juego.agregarJugador(jugador3);

    }

    @Test
    public void test1(){

        ArrayList<OpcionSimple> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Verdadero",1));
        opciones.add(new OpcionSimple("Falso",2));

        // llegan las opciones y se muestran por pantalla
        OpcionSimple opcionIncorrecta = new OpcionSimple("Verdadero", 1);
        OpcionSimple opcionCorrecta = new OpcionSimple("Falso", 2);
        TipoDePregunta tipoDePregunta = new VerdaderoFalso(opciones, opcionCorrecta);
        String enunciado = "Messi juega al Volley";
        Pregunta preguntaVF = new Pregunta(tipoDePregunta, null, enunciado);

        // es el turno del jugador 1 -> Turno de jugador 1 -> continuar
        // llega la pregunta a la interfaz
        // se muestra el enunciado "Messi juega al Volley"
        // se muestran las opciones "Verdadero" y "Falso"

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion(opcionIncorrecta);
        jugador1.responder(preguntaVF, respuestaJugador1);

        // el jugador 1 respondio y se manda esto

        Respuesta respuestaJugador2 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion(opcionCorrecta);
        jugador1.responder(preguntaVF, respuestaJugador2);

        Respuesta respuestaJugador3 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion(opcionCorrecta);
        jugador1.responder(preguntaVF, respuestaJugador3);


    }

}
*/