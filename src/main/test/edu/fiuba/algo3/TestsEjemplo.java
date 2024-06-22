package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.OpcionGrupo;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.TipoDePregunta.*;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsEjemplo {

    @Test
    public void test01JugadorRespondeVoFCorrectamenteYRecibePuntos(){
        Jugador jugador1 = new Jugador("Bob");
        ArrayList<OpcionSimple> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Verdadero",1));
        opciones.add(new OpcionSimple("Falso",2));

        TipoDePregunta consigna = new VerdaderoFalso(opciones, new OpcionSimple("Verdadero", 1));
        Penalidad penalidad = new SinPenalidad();

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?");
        Respuesta respuesta = new Respuesta(jugador1);

        respuesta.agregarOpcion(new OpcionSimple("Verdadero", 1));

        jugador1.responder(pregunta, respuesta);

        pregunta.validarRespuestas();

        assertEquals(1, jugador1.getPuntajeTotal());
    }
    @Test
    public void test02JugadorRespondeMultipleChoiceCorrectamenteYRecibePuntos(){
        Jugador jugador1 = new Jugador("Bob");
        ArrayList<OpcionSimple> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Neymar",1));
        opciones.add(new OpcionSimple("Messi",2));
        opciones.add(new OpcionSimple("Cristiano Ronaldo",3));
        opciones.add(new OpcionSimple("Lewandowski",4));

        ArrayList<OpcionSimple> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(new OpcionSimple("Neymar",1));
        opcionesCorrectas.add(new OpcionSimple("Lewandowski",4));

        TipoDePregunta consigna = new MultipleChoice(opciones, opcionesCorrectas);
        Penalidad penalidad = new SinPenalidad();

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Cual/es de estos jugadores nunca ganaron un Balon de Oro?");
        Respuesta respuesta = new Respuesta(jugador1);

        respuesta.agregarOpcion(new OpcionSimple("Neymar",1));
        respuesta.agregarOpcion(new OpcionSimple("Lewandowski",4));

        jugador1.responder(pregunta, respuesta);

        pregunta.validarRespuestas();

        assertEquals(1, jugador1.getPuntajeTotal());
    }
    @Test
    public void test03JugadorRespondeOrderedChoiceCorrectamenteYRecibePuntos(){
        Jugador jugador1 = new Jugador("Bob");
        ArrayList<OpcionSimple> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Macri",1));
        opciones.add(new OpcionSimple("Cristina",2));
        opciones.add(new OpcionSimple("Alberto",3));
        opciones.add(new OpcionSimple("Duhalde",4));
        opciones.add(new OpcionSimple("Nestor",5));


        ArrayList<OpcionSimple> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(new OpcionSimple("Alberto",3));
        opcionesCorrectas.add(new OpcionSimple("Macri",1));
        opcionesCorrectas.add(new OpcionSimple("Cristina",2));
        opcionesCorrectas.add(new OpcionSimple("Nestor",5));
        opcionesCorrectas.add(new OpcionSimple("Duhalde",4));

        TipoDePregunta consigna = new OrderedChoice(opciones, opcionesCorrectas);
        Penalidad penalidad = new SinPenalidad();

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Ordenar los presidentes por anio en orden descendiente");
        Respuesta respuesta = new Respuesta(jugador1);

        respuesta.agregarOpcion(new OpcionSimple("Alberto",3));
        respuesta.agregarOpcion(new OpcionSimple("Macri",1));
        respuesta.agregarOpcion(new OpcionSimple("Cristina",2));
        respuesta.agregarOpcion(new OpcionSimple("Nestor",5));
        respuesta.agregarOpcion(new OpcionSimple("Duhalde",4));

        jugador1.responder(pregunta, respuesta);

        pregunta.validarRespuestas();

        assertEquals(1, jugador1.getPuntajeTotal());
    }
    @Test
    public void test04JugadorRespondeGroupChoiceCorrectamenteYRecibePuntos(){
        Jugador jugador1 = new Jugador("Bob");
        ArrayList<OpcionSimple> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Tigre",1));
        opciones.add(new OpcionSimple("Pato", 2));
        opciones.add(new OpcionSimple("Gallina",3));
        opciones.add(new OpcionSimple("Perro",4));
        opciones.add(new OpcionSimple("Pajaro",5));
        opciones.add(new OpcionSimple("Gato",6));

        HashSet<OpcionSimple> mamiferosCorrectos = new HashSet<>();
        mamiferosCorrectos.add(new OpcionSimple("Tigre",1));
        mamiferosCorrectos.add(new OpcionSimple("Perro",4));
        mamiferosCorrectos.add(new OpcionSimple("Gato",6));
        HashSet<OpcionSimple> oviparosCorrectos = new HashSet<>();
        oviparosCorrectos.add(new OpcionSimple("Gallina",3));
        oviparosCorrectos.add(new OpcionSimple("Pajaro",5));
        oviparosCorrectos.add(new OpcionSimple("Pato",2));

        OpcionGrupo grupo1 = new OpcionGrupo("Mamiferos", mamiferosCorrectos);
        OpcionGrupo grupo2 = new OpcionGrupo("Oviparos", oviparosCorrectos);

        ArrayList<OpcionGrupo> gruposCorrectos = new ArrayList<>();
        gruposCorrectos.add(grupo1);
        gruposCorrectos.add(grupo2);

        TipoDePregunta consigna = new GroupChoice(opciones, gruposCorrectos);
        Penalidad penalidad = new SinPenalidad();

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Colocar los animales en la categoria correspondiente");

        OpcionGrupo mamiferosJugador = new OpcionGrupo("Mamiferos", new HashSet<>());
        OpcionGrupo oviparosJugador = new OpcionGrupo("Oviparos", new HashSet<>());

        Respuesta respuesta = new Respuesta(jugador1);

        oviparosJugador.agregarOpcion(new OpcionSimple("Gallina", 3));
        oviparosJugador.agregarOpcion(new OpcionSimple("Pato",2));
        oviparosJugador.agregarOpcion(new OpcionSimple("Pajaro",5));
        mamiferosJugador.agregarOpcion(new OpcionSimple("Tigre",1));
        mamiferosJugador.agregarOpcion(new OpcionSimple("Perro",4));
        mamiferosJugador.agregarOpcion(new OpcionSimple("Gato",6));

        respuesta.agregarOpcion(oviparosJugador);
        respuesta.agregarOpcion(mamiferosJugador);

        jugador1.responder(pregunta, respuesta);

        pregunta.validarRespuestas();

        assertEquals(1, jugador1.getPuntajeTotal());
    }

    @Test
    public void test05CreaCorrectamentePreguntas() throws IOException, ParseException {
        CreadorDePreguntas creadorDePreguntas = new CreadorDePreguntas();

        creadorDePreguntas.leerArchivo();
    }
}
