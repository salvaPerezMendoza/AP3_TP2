package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionGrupo;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.Penalidad.ConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;
import edu.fiuba.algo3.modelo.TipoDePregunta.*;
import edu.fiuba.algo3.modelo.bonificador.AnuladorPuntajeDecorador;
import edu.fiuba.algo3.modelo.bonificador.Bonificador;
import java.util.HashSet;
import edu.fiuba.algo3.modelo.bonificador.BonificadorConcreto;

import edu.fiuba.algo3.modelo.bonificador.MultiplicadorX2Decorador;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadoresTest {

    @Test
    public void test01AplicarMultiplicadorX2RespuestaCorrectaVF() {
        Jugador jugador1 = new Jugador("Bob");

        TipoDePregunta consigna = new VerdaderoFalso(new OpcionSimple("V"));
        Penalidad penalidad = new SinPenalidad();
        Bonificador bonificador = new MultiplicadorX2Decorador(new BonificadorConcreto());

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?", bonificador);
        Respuesta respuesta = new Respuesta(jugador1);

        respuesta.agregarOpcion(new OpcionSimple("V"));

        jugador1.responder(pregunta, respuesta);

        pregunta.validarRespuestas();

        assertEquals(2, jugador1.getPuntajeTotal());
    }
    @Test
    public void test02AplicarDosMultiplicadoresX2RespuestaCorrectaVF() {
        Jugador jugador1 = new Jugador("Bob");

        TipoDePregunta consigna = new VerdaderoFalso(new OpcionSimple("V"));
        Penalidad penalidad = new SinPenalidad();
        Bonificador bonificador = new MultiplicadorX2Decorador(new MultiplicadorX2Decorador(new BonificadorConcreto()));

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?", bonificador);
        Respuesta respuesta = new Respuesta(jugador1);

        respuesta.agregarOpcion(new OpcionSimple("V"));

        jugador1.responder(pregunta, respuesta);

        pregunta.validarRespuestas();

        assertEquals(4, jugador1.getPuntajeTotal());
    }
    @Test
    public void test03AplicarMultiplicadoresX2RespuestaCorrectaVFConPenalidad() {
        Jugador jugador1 = new Jugador("Bob");

        TipoDePregunta consigna = new VerdaderoFalso(new OpcionSimple("V"));
        Penalidad penalidad = new ConPenalidad();
        Bonificador bonificador = new MultiplicadorX2Decorador(new BonificadorConcreto());

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?", bonificador);
        Respuesta respuesta = new Respuesta(jugador1);

        respuesta.agregarOpcion(new OpcionSimple("V"));

        jugador1.responder(pregunta, respuesta);

        pregunta.validarRespuestas();

        assertEquals(2, jugador1.getPuntajeTotal());
    }

    @Test
    public void test04AplicarMultiplicadoresX2RespuestaIncorrectaVFConPenalidad() {
        Jugador jugador1 = new Jugador("Bob");

        TipoDePregunta consigna = new VerdaderoFalso(new OpcionSimple("V"));
        Penalidad penalidad = new ConPenalidad();
        Bonificador bonificador = new MultiplicadorX2Decorador(new BonificadorConcreto());

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?", bonificador);
        Respuesta respuesta = new Respuesta(jugador1);

        respuesta.agregarOpcion(new OpcionSimple("F"));

        jugador1.responder(pregunta, respuesta);

        pregunta.validarRespuestas();

        assertEquals(-2, jugador1.getPuntajeTotal());
    }




    @Test
    public void test05JugadorRespondeMultipleChoiceCorrectamenteYRecibePuntos() {
        Jugador jugador1 = new Jugador("Bob");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Neymar"));
        opciones.add(new OpcionSimple("Messi"));
        opciones.add(new OpcionSimple("Cristiano Ronaldo"));
        opciones.add(new OpcionSimple("Lewandowski"));

        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(new OpcionSimple("Neymar"));
        opcionesCorrectas.add(new OpcionSimple("Lewandowski"));

        Bonificador bonificador = new MultiplicadorX2Decorador(new BonificadorConcreto());

        TipoDePregunta consigna = new MultipleChoice(opciones, opcionesCorrectas);
        Penalidad penalidad = new SinPenalidad();

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Cual/es de estos jugadores nunca ganaron un Balon de Oro?", bonificador);
        Respuesta respuesta = new Respuesta(jugador1);

        respuesta.agregarOpcion(new OpcionSimple("Neymar"));
        respuesta.agregarOpcion(new OpcionSimple("Lewandowski"));

        jugador1.responder(pregunta, respuesta);

        pregunta.validarRespuestas();

        assertEquals(2, jugador1.getPuntajeTotal());
    }
    @Test
    public void test03JugadorRespondeOrderedChoiceCorrectamenteConMultiplicadorX2YRecibePuntos(){
        Jugador jugador1 = new Jugador("Bob");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Macri"));
        opciones.add(new OpcionSimple("Cristina"));
        opciones.add(new OpcionSimple("Alberto"));
        opciones.add(new OpcionSimple("Duhalde"));
        opciones.add(new OpcionSimple("Nestor"));


        ArrayList<OpcionSimple> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(new OpcionSimple("Alberto"));
        opcionesCorrectas.add(new OpcionSimple("Macri"));
        opcionesCorrectas.add(new OpcionSimple("Cristina"));
        opcionesCorrectas.add(new OpcionSimple("Nestor"));
        opcionesCorrectas.add(new OpcionSimple("Duhalde"));

        TipoDePregunta consigna = new OrderedChoice(opciones, opcionesCorrectas);
        Penalidad penalidad = new SinPenalidad();

        Bonificador bonificador = new AnuladorPuntajeDecorador(new BonificadorConcreto());

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Ordenar los presidentes por anio en orden descendiente", bonificador);
        Respuesta respuesta = new Respuesta(jugador1);

        respuesta.agregarOpcion(new OpcionSimple("Alberto"));
        respuesta.agregarOpcion(new OpcionSimple("Macri"));
        respuesta.agregarOpcion(new OpcionSimple("Cristina"));
        respuesta.agregarOpcion(new OpcionSimple("Nestor"));
        respuesta.agregarOpcion(new OpcionSimple("Duhalde"));

        jugador1.responder(pregunta, respuesta);

        pregunta.validarRespuestas();

        assertEquals(2, jugador1.getPuntajeTotal());
    }
    @Test
    public void test03JugadorRespondeOrderedChoiceIncorrectamenteConMultiplicadorX2ConPenalidad(){
        Jugador jugador1 = new Jugador("Bob");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Macri"));
        opciones.add(new OpcionSimple("Cristina"));
        opciones.add(new OpcionSimple("Alberto"));
        opciones.add(new OpcionSimple("Duhalde"));
        opciones.add(new OpcionSimple("Nestor"));


        ArrayList<OpcionSimple> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(new OpcionSimple("Alberto"));
        opcionesCorrectas.add(new OpcionSimple("Macri"));
        opcionesCorrectas.add(new OpcionSimple("Cristina"));
        opcionesCorrectas.add(new OpcionSimple("Nestor"));
        opcionesCorrectas.add(new OpcionSimple("Duhalde"));

        TipoDePregunta consigna = new OrderedChoice(opciones, opcionesCorrectas);
        Penalidad penalidad = new ConPenalidad();

        Bonificador bonificadorBase = new BonificadorConcreto();
        Bonificador bonificadorDecorado = new MultiplicadorX2Decorador(bonificadorBase);

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Ordenar los presidentes por anio en orden descendiente", bonificadorDecorado);
        Respuesta respuesta = new Respuesta(jugador1);

        respuesta.agregarOpcion(new OpcionSimple("Alberto"));
        respuesta.agregarOpcion(new OpcionSimple("Nestor"));
        respuesta.agregarOpcion(new OpcionSimple("Cristina"));
        respuesta.agregarOpcion(new OpcionSimple("Macri"));
        respuesta.agregarOpcion(new OpcionSimple("Duhalde"));

        jugador1.responder(pregunta, respuesta);

        pregunta.validarRespuestas();

        assertEquals(-2, jugador1.getPuntajeTotal());
    }

    @Test
    public void test04JugadorRespondeGroupChoiceCorrectamenteMultiplicadorX2YRecibePuntos(){
        Jugador jugador1 = new Jugador("Bob");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(new OpcionSimple("Tigre"));
        opciones.add(new OpcionSimple("Pato"));
        opciones.add(new OpcionSimple("Gallina"));
        opciones.add(new OpcionSimple("Perro"));
        opciones.add(new OpcionSimple("Pajaro"));
        opciones.add(new OpcionSimple("Gato"));

        HashSet<OpcionSimple> mamiferosCorrectos = new HashSet<>();
        mamiferosCorrectos.add(new OpcionSimple("Tigre"));
        mamiferosCorrectos.add(new OpcionSimple("Perro"));
        mamiferosCorrectos.add(new OpcionSimple("Gato"));
        HashSet<OpcionSimple> oviparosCorrectos = new HashSet<>();
        oviparosCorrectos.add(new OpcionSimple("Gallina"));
        oviparosCorrectos.add(new OpcionSimple("Pajaro"));
        oviparosCorrectos.add(new OpcionSimple("Pato"));

        OpcionGrupo grupo1 = new OpcionGrupo("Mamiferos", mamiferosCorrectos);
        OpcionGrupo grupo2 = new OpcionGrupo("Oviparos", oviparosCorrectos);

        ArrayList<OpcionGrupo> gruposCorrectos = new ArrayList<>();
        gruposCorrectos.add(grupo1);
        gruposCorrectos.add(grupo2);

        TipoDePregunta consigna = new GroupChoice(opciones, gruposCorrectos);
        Penalidad penalidad = new SinPenalidad();

        Bonificador bonificadorBase = new BonificadorConcreto();
        Bonificador bonificadorDecorado = new MultiplicadorX2Decorador(bonificadorBase);

        Pregunta pregunta = new Pregunta(consigna, penalidad, "Colocar los animales en la categoria correspondiente", bonificadorDecorado);

        OpcionGrupo mamiferosJugador = new OpcionGrupo("Mamiferos", new HashSet<>());
        OpcionGrupo oviparosJugador = new OpcionGrupo("Oviparos", new HashSet<>());

        Respuesta respuesta = new Respuesta(jugador1);

        oviparosJugador.agregarOpcion(new OpcionSimple("Gallina"));
        oviparosJugador.agregarOpcion(new OpcionSimple("Pato"));
        oviparosJugador.agregarOpcion(new OpcionSimple("Pajaro"));
        mamiferosJugador.agregarOpcion(new OpcionSimple("Tigre"));
        mamiferosJugador.agregarOpcion(new OpcionSimple("Perro"));
        mamiferosJugador.agregarOpcion(new OpcionSimple("Gato"));

        respuesta.agregarOpcion(oviparosJugador);
        respuesta.agregarOpcion(mamiferosJugador);

        jugador1.responder(pregunta, respuesta);

        pregunta.validarRespuestas();

        assertEquals(2, jugador1.getPuntajeTotal());
    }
}



