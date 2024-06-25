package edu.fiuba.algo3;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CreadorDePreguntasTest {

    private CreadorDePreguntas creadorDePreguntas;

    @BeforeEach
    public void setUp() throws IOException, ParseException {
        creadorDePreguntas = new CreadorDePreguntas();
        creadorDePreguntas.leerArchivo();
    }


    @Test
    public void testLeerArchivo() throws IOException, ParseException {
        ArrayList<Pregunta> preguntas = creadorDePreguntas.leerArchivo();
        for (Pregunta pregunta : preguntas) {
            String enunciado = pregunta.getEnunciado();
            System.out.println(enunciado);
        }
        assertFalse(preguntas.isEmpty(), "La lista de preguntas no debería estar vacía");
    }

}

