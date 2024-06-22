package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
import edu.fiuba.algo3.modelo.bonificador.Bonificador;

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

    public Penalidad getPenalidad() {
        return penalidad;
    }

    public void agregarRespuesta(Respuesta respuestaJugador){
        respuestasJugadores.add(respuestaJugador);
    }

    private boolean verificarSiHayAlgunaIncorrecta(RespuestaCorregida respuestaCorregida){
        return respuestaCorregida.getCantidadIncorrectas() > 0;
    }

    public RespuestaCorregida validarRespuesta(Respuesta respuesta){
        RespuestaCorregida respuestaCorregida = tipo.corregirRespuesta(respuesta);
        return respuestaCorregida;
    }

    public void validarRespuestas(){
        for(Respuesta respuesta : respuestasJugadores){
            RespuestaCorregida respuestaCorregida = validarRespuesta(respuesta);
            respuestaCorregida.asignarPuntaje(penalidad,null);
        }
    }
}