package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;

import java.util.ArrayList;

public class Pregunta {
    private String enunciado;
    private TipoDePregunta tipo;
    private Penalidad penalidad;
    private ArrayList<Respuesta> respuestasJugadores;

    public Pregunta(TipoDePregunta tipo, Penalidad penalidad, String enunciado, ArrayList<Opcion> respuestaCorrecta){
        this.tipo = tipo;
        this.penalidad = penalidad;
        this.enunciado = enunciado;
    }

    public void agregarRespuesta(Respuesta respuestaJugador){
        respuestasJugadores.add(respuestaJugador);
    }

    private void validarRespuesta(Respuesta respuesta){
        RespuestaCorregida respuestaCorregida = tipo.corregirRespuesta(respuesta);
        respuestaCorregida.asignarPuntaje(penalidad);
    }

    public void validarRespuestas(ArrayList<Respuesta> respuestasJugadores){
        for(Respuesta respuesta : respuestasJugadores){
            validarRespuesta(respuesta);
        }
    }
}