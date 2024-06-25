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

    public Pregunta(TipoDePregunta tipo, Penalidad penalidad, String enunciado){
        this.tipo = tipo;
        this.penalidad = penalidad;
        this.enunciado = enunciado;
        this.respuestasJugadores = new ArrayList<>();
    }

    public void agregarRespuesta(Respuesta respuestaJugador){
        respuestasJugadores.add(respuestaJugador);
    }

    public String getEnunciado(){
        return enunciado;
    }

    private void validarRespuesta(Respuesta respuesta){
        RespuestaCorregida respuestaCorregida = tipo.corregirRespuesta(respuesta);
        respuestaCorregida.asignarPuntaje(penalidad);
    }

    public void validarRespuestas(){
        for(Respuesta respuesta : respuestasJugadores){
            validarRespuesta(respuesta);
        }
    }

    public TipoDePregunta getTipo(){
        return tipo;
    }
}