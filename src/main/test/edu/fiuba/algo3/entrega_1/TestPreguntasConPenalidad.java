//package edu.fiuba.algo3.entrega_1;
//
//import edu.fiuba.algo3.modelo.Jugador;
//import edu.fiuba.algo3.modelo.Opcion.Opcion;
//import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
//import edu.fiuba.algo3.modelo.Penalidad.ConPenalidad;
//import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
//import edu.fiuba.algo3.modelo.Penalidad.PenalidadParcial;
//import edu.fiuba.algo3.modelo.Pregunta;
//import edu.fiuba.algo3.modelo.Respuesta;
//import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
//import edu.fiuba.algo3.modelo.TipoDePregunta.VerdaderoFalso;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class TestPreguntasConPenalidad {
//    @Test
//    public void test01PreguntaVoFConPenalidad(){
//        Jugador jugador1 = new Jugador("Bob");
//
//        TipoDePregunta consigna = new VerdaderoFalso(new OpcionSimple("V"));
//        Penalidad penalidad = new ConPenalidad();
//
//        Pregunta pregunta = new Pregunta(consigna, penalidad, "Messi es el mejor jugador de la historia?");
//        Respuesta respuesta = new Respuesta(jugador1);
//
//        respuesta.agregarOpcion(new OpcionSimple("F"));
//
//        jugador1.responder(pregunta, respuesta);
//
//        pregunta.validarRespuestas();
//
//        assertEquals(-1, jugador1.getPuntajeTotal());
//    }
//    @Test
//    public void test02PreguntaMultipleChoiceConPenalidad(){
//        Jugador jugador1 = new Jugador("Bob");
//        ArrayList<Opcion> opciones = new ArrayList<>();
//        opciones.add(new OpcionSimple("Neymar"));
//        opciones.add(new OpcionSimple("Messi"));
//        opciones.add(new OpcionSimple("Cristiano Ronaldo"));
//        opciones.add(new OpcionSimple("Lewandowski"));
//
//        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
//        opcionesCorrectas.add(new OpcionSimple("Neymar"));
//        opcionesCorrectas.add(new OpcionSimple("Lewandowski"));
//
//        TipoDePregunta consigna = new MultipleChoice(opciones, opcionesCorrectas);
//        Penalidad penalidad = new ConPenalidad();
//
//        Pregunta pregunta = new Pregunta(consigna, penalidad, "Cual/es de estos jugadores nunca ganaron un Balon de Oro?");
//        Respuesta respuesta = new Respuesta(jugador1);
//
//        respuesta.agregarOpcion(new OpcionSimple("Cristiano Ronaldo"));
//        respuesta.agregarOpcion(new OpcionSimple("Messi"));
//        respuesta.agregarOpcion(new OpcionSimple("Neymar"));
//
//        jugador1.responder(pregunta, respuesta);
//
//        pregunta.validarRespuestas();
//
//        assertEquals(-1, jugador1.getPuntajeTotal());
//    }
//    @Test
//    public void test03PreguntaMultipleChoiceConPenalidadParcial(){
//        Jugador jugador1 = new Jugador("Bob");
//        ArrayList<Opcion> opciones = new ArrayList<>();
//        opciones.add(new OpcionSimple("Neymar"));
//        opciones.add(new OpcionSimple("Messi"));
//        opciones.add(new OpcionSimple("Cristiano Ronaldo"));
//        opciones.add(new OpcionSimple("Lewandowski"));
//
//        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
//        opcionesCorrectas.add(new OpcionSimple("Neymar"));
//        opcionesCorrectas.add(new OpcionSimple("Lewandowski"));
//
//        TipoDePregunta consigna = new MultipleChoice(opciones, opcionesCorrectas);
//        Penalidad penalidad = new PenalidadParcial();
//
//        Pregunta pregunta = new Pregunta(consigna, penalidad, "Cual/es de estos jugadores nunca ganaron un Balon de Oro?");
//        Respuesta respuesta = new Respuesta(jugador1);
//
//        respuesta.agregarOpcion(new OpcionSimple("Lewandowski"));
//        respuesta.agregarOpcion(new OpcionSimple("Neymar"));
//
//        jugador1.responder(pregunta, respuesta);
//
//        pregunta.validarRespuestas();
//
//        assertEquals(2, jugador1.getPuntajeTotal());
//    }
//    @Test
//    public void test04PreguntaMultipleChoiceConPenalidadParcial(){
//        Jugador jugador1 = new Jugador("Bob");
//        ArrayList<Opcion> opciones = new ArrayList<>();
//        opciones.add(new OpcionSimple("Neymar"));
//        opciones.add(new OpcionSimple("Messi"));
//        opciones.add(new OpcionSimple("Cristiano Ronaldo"));
//        opciones.add(new OpcionSimple("Lewandowski"));
//
//        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
//        opcionesCorrectas.add(new OpcionSimple("Neymar"));
//        opcionesCorrectas.add(new OpcionSimple("Lewandowski"));
//
//        TipoDePregunta consigna = new MultipleChoice(opciones, opcionesCorrectas);
//        Penalidad penalidad = new PenalidadParcial();
//
//        Pregunta pregunta = new Pregunta(consigna, penalidad, "Cual/es de estos jugadores nunca ganaron un Balon de Oro?");
//        Respuesta respuesta = new Respuesta(jugador1);
//
//        respuesta.agregarOpcion(new OpcionSimple("Lewandowski"));
//        respuesta.agregarOpcion(new OpcionSimple("Neymar"));
//        respuesta.agregarOpcion(new OpcionSimple("Messi"));
//
//        jugador1.responder(pregunta, respuesta);
//
//        pregunta.validarRespuestas();
//
//        assertEquals(0, jugador1.getPuntajeTotal());
//    }
//}
